package com.lyw.batch.core.writer;


import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.reader.FileResource;

import java.io.IOException;
import java.util.List;

public interface FileWriter<T> extends Writer<T> {
    void writeHeader(FileResource resource, String header) throws IOException;

    void open(FileResource resource) throws IOException, ResourceIsMissionException;

    void close(FileResource resource) throws IOException;

    void write(List<T> items, FileResource resource) throws IOException;
}
