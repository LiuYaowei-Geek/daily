package com.lyw.batch.core.reader;

import com.lyw.batch.core.exception.ResourceIsMissionException;
import com.lyw.batch.core.resource.Resource;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FlatFileReader implements FileReader {
    @Override
    public List<String> read(FileResource resource, int readNumber) {
        return null;
    }

    @Override
    public List<String> readHeader(FileResource resource, int readerNumber) {
        return readLines(resource.getReader(), readerNumber);
    }

    @Override
    public void open(FileResource resource) throws FileNotFoundException, ResourceIsMissionException, UnsupportedEncodingException {
        resource.openReader();
    }

    @Override
    public void close(FileResource resource) throws IOException {
        resource.closeReader();
    }

    @Override
    public void skip(Resource resource, int skipNumber) throws IOException {
        FileResource source = (FileResource) resource;
        for (int i = 0; i < skipNumber; i++) {
            String line = source.getReader().readLine();
            log.info("skip:{}", line);
        }
    }

    private List<String> readLines(BufferedReader reader, int readNumber) {
        List<String> lines = new ArrayList<>();
        try {
            String line;
            int count = 0;
            while (count < readNumber && (line = reader.readLine()) != null) {
                count++;
                lines.add(line);
            }
        } catch (IOException e) {
            log.error("readLines occurred error", e);
        }
        return lines;
    }
}
