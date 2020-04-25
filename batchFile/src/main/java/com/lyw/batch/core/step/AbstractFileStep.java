package com.lyw.batch.core.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ComponentIsNullException;
import com.lyw.batch.core.exception.HeaderDataIsNotMatchException;
import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.exception.StepExecuteException;
import com.lyw.batch.core.listener.Listener;
import com.lyw.batch.core.mapper.LineMapper;
import com.lyw.batch.core.processor.Processor;
import com.lyw.batch.core.reader.FileReader;
import com.lyw.batch.core.reader.FileResource;
import com.lyw.batch.core.writer.Writer;
import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Slf4j
public abstract class AbstractFileStep<T, H> implements Step {

    private FileReader reader;

    private LineMapper<T, H> mapper;

    private Processor<T> processor;

    private Writer<T> writer;

    private int headLineNumber;

    private Listener listener;

    @Override
    public void execute(ExecutionContext context) throws ComponentIsNullException, HeaderDataIsNotMatchException, StepExecuteException {
        if (null != listener) {
            listener.preExecute(context);
        }

        if (null == reader || null == writer || null == mapper) {
            log.error("fileReader component is missing");
            throw new ComponentIsNullException("component is missing");
        }
        int checkPoint = checkPoint(context);
        List<String> sourceItems;
        List<T> items;
        FileResource resource = context.getFileResource();
        int pageSize = getPageSize();
        try {
            reader.open(resource);
            reader.readHeader(resource, headLineNumber);
            if (0 != checkPoint) {
                reader.skip(resource, checkPoint);
            }
            do {
                sourceItems = reader.read(resource, pageSize);
                items = mapper.mapper(sourceItems);
                if (null != processor) {
                    items = processor.process(items);
                }
                writer.write(items, context);
            } while (sourceItems.size() == getPageSize());
        } catch (Exception e) {
            log.error("step execute occurred error", e);
            throw new StepExecuteException(e);
        } finally {
            try {
                reader.close(resource);
            } catch (IOException e) {
                log.error("resource close error", e);
            }
        }
        if (null != listener) {
            listener.afterExecute(context);
        }
    }

    public AbstractFileStep<T, H> reader(FileReader reader) {
        this.reader = reader;
        return this;
    }

    public AbstractFileStep<T, H> mapper(LineMapper<T, H> mapper) {
        this.mapper = mapper;
        return this;
    }

    public AbstractFileStep<T, H> processor(Processor<T> processor) {
        this.processor = processor;
        return this;
    }

    public AbstractFileStep<T, H> writer(Writer<T> writer) {
        this.writer = writer;
        return this;
    }

    public AbstractFileStep<T, H> headLineNumber(int headLineNumber) {
        this.headLineNumber = headLineNumber;
        return this;
    }

    public AbstractFileStep<T, H> listener(Listener listener) {
        this.listener = listener;
        return this;
    }

    protected abstract int checkPoint(ExecutionContext context);
    protected abstract int getPageSize();
}
