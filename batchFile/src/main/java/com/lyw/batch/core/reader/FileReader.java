package com.lyw.batch.core.reader;

import com.lyw.batch.core.exception.ResourceIsMissionException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface FileReader extends Reader {
    List<String> read(FileResource resource, int readNumber);

    List<String> readHeader(FileResource resource, int readerNumber);

    void open(FileResource resource) throws FileNotFoundException,
            ResourceIsMissionException, UnsupportedEncodingException;

    void close(FileResource resource) throws IOException;
}
