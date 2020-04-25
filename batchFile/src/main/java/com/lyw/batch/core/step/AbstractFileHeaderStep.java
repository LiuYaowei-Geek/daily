package com.lyw.batch.core.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ComponentIsNullException;
import com.lyw.batch.core.exception.HeaderDataIsNotMatchException;
import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.exception.StepExecuteException;
import com.lyw.batch.core.listener.Listener;
import com.lyw.batch.core.mapper.LineMapper;
import com.lyw.batch.core.reader.FileReader;
import com.lyw.batch.core.reader.FileResource;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

@Slf4j
public abstract class AbstractFileHeaderStep<T extends DefaultItem, H extends DefaultHeader> implements Step {
    private FileReader reader;

    private LineMapper<T, H> lineMapper;

    private int headLineNumber;

    private Listener listener;

    @Override
    public void execute(ExecutionContext context) throws ComponentIsNullException,
            HeaderDataIsNotMatchException, StepExecuteException {
        if (null != listener) {
            listener.preExecute(context);
        }
        if (null == reader || null == lineMapper) {
            log.error("file head step component is missing, please check it carefully");
            throw new ComponentIsNullException("component is missing");
        }
        int totalCount = 0;
        BigDecimal totalAmount = BigDecimal.ZERO;
        H header;
        FileResource resource = context.getFileResource();
        int pageSize = getPageSize();
        try {
            reader.open(resource);
            List<String> sourceHeader = reader.readHeader(resource, headLineNumber);
            header = lineMapper.mapperHeader(sourceHeader);
            preAdditional(header);
            log.info("read file header, header = {}", header);
            List<String> sourceItems;
            List<T> items;
            if (null == header) {
                throw new HeaderDataIsNotMatchException("header is null");
            }
            if (header.isNeedCount() || header.isNeedAmount()) {
                do {
                    sourceItems = reader.read(resource, pageSize);
                    items = lineMapper.mapper(sourceItems);
                    if (header.isNeedAmount()) {
                        totalAmount = totalAmount.add(items.stream().map(T::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
                    }
                    if (header.isNeedCount()) {
                        totalCount += sourceItems.size();
                    }
                } while (sourceItems.size() == pageSize);
            }
        } catch (Exception e) {
            log.error("file header handel step error", e);
            throw new StepExecuteException(e);
        } finally {
            if (null != resource) {
                try {
                    reader.close(resource);
                } catch (IOException e) {
                    log.error("resource close error", e);
                }
            }
        }
        context.addData("headerCount", header.getTotalCount());
        context.addData("headerAmount", header.getTotalAmount());
        if (header.isNeedAmount()) {
            if (header.getTotalAmount().compareTo(totalAmount) != 0) {
                throw new HeaderDataIsNotMatchException("header data does not match the detail count");
            }
        }
        if (header.isNeedCount()) {
            if (header.getTotalCount() != totalCount) {
                throw new HeaderDataIsNotMatchException("header data does not match the detail count");
            }
        }
        afterAdditional(header);

        if (null != listener) {
            listener.afterExecute(context);
        }
    }

    public AbstractFileHeaderStep<T, H> reader(FileReader reader) {
        this.reader = reader;
        return this;
    }

    public AbstractFileHeaderStep<T, H> lineMapper(LineMapper<T, H> lineMapper) {
        this.lineMapper = lineMapper;
        return this;
    }


    public AbstractFileHeaderStep<T, H> headLineNumber(int headLineNumber) {
        this.headLineNumber = headLineNumber;
        return this;
    }

    public AbstractFileHeaderStep<T, H> listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    protected abstract int getPageSize();

    protected abstract void preAdditional(H header);

    protected abstract void afterAdditional(H header);
}
