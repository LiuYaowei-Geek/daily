package com.lyw.batch.core.writer;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.reader.FileResource;

import java.io.IOException;
import java.util.List;

public class FlatFileWriter implements FileWriter<String> {

    @Override
    public void writeHeader(FileResource resource, String header) throws IOException {
        resource.getWriter().write(header);
    }

    @Override
    public void open(FileResource resource) throws IOException, ResourceIsMissionException {
        resource.openWriter();
    }

    @Override
    public void close(FileResource resource) throws IOException {
        resource.closeWriter();
    }

    @Override
    public void write(List<String> items, FileResource resource) throws IOException {
        for (String item : items) {
            resource.getWriter().write(item);
        }
    }

    @Override
    public void write(List<String> items, ExecutionContext context) throws IOException {
        for (String item : items) {
            context.getFileResource().getWriter().write(item);
        }
    }
}
