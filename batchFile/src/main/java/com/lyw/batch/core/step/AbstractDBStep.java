package com.lyw.batch.core.step;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ComponentIsNullException;
import com.lyw.batch.core.exception.HeaderDataIsNotMatchException;
import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.exception.StepExecuteException;
import com.lyw.batch.core.listener.Listener;
import com.lyw.batch.core.mapper.MapperLine;
import com.lyw.batch.core.processor.Processor;
import com.lyw.batch.core.reader.DBReader;
import com.lyw.batch.core.writer.FileWriter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;


@Slf4j
public abstract class AbstractDBStep<T, H extends DefaultHeader> implements Step {
    private DBReader<T, H> reader;
    private Processor<T> processor;
    private FileWriter<String> writer;
    private MapperLine<T, H> mapperLine;
    private Listener listener;
    private H header;

    @Override
    public void execute(ExecutionContext context) throws ComponentIsNullException, HeaderDataIsNotMatchException, StepExecuteException {
        if (null != listener) {
            listener.preExecute(context);
        }
        if (reader == null || writer == null) {
            log.error("dbReader component is missing");
            throw new ComponentIsNullException("component is missing");
        }
        header = reader.readHeader(context);
        int currentPage = 0;
        List<T> items;
        int pageSize = getPageSize();
        try {
            writer.open(context.getFileResource());
            writer.writeHeader(context.getFileResource(), mapperLine.mapperHeader(header));
            do {
                items = reader.read(currentPage, pageSize);
                if (null != processor) {
                    items = processor.process(items);
                }
                writer.write(mapperLine.mapper(items), context.getFileResource());
                currentPage++;
            } while (items.size() == pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close(context.getFileResource());
            } catch (IOException e) {
                log.error("resource close error", e);
            }
        }
        if (null != listener) {
            listener.afterExecute(context);
        }
    }

    protected abstract int getPageSize();
}
