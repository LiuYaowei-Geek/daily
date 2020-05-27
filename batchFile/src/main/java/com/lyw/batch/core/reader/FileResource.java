package com.lyw.batch.core.reader;

import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.resource.Resource;
import lombok.Data;

import java.io.*;
import java.io.Reader;

@Data
public class FileResource implements Resource {
    private String resource;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String charset;

    public FileResource(String resource, String charset) {
        this.resource = resource;
        this.charset = charset;
    }

    public Reader openReader() throws ResourceIsMissionException, FileNotFoundException, UnsupportedEncodingException {
        if (null == resource) {
            throw new ResourceIsMissionException("resource is missing");
        }
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(resource), charset));
        return reader;
    }

    public void closeReader() throws IOException {
        if (null != reader) {
            reader.close();
        }
    }

    public Writer openWriter() throws ResourceIsMissionException,
            FileNotFoundException,
            UnsupportedEncodingException {
        if (null == reader) {
            throw new FileNotFoundException("resource is missing");
        }
        writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(resource), charset));
        return writer;
    }

    public void closeWriter() throws IOException {
        if (null != writer) {
            writer.close();
        }
    }
}
