package com.lyw.batch.core.writer;

import com.lyw.batch.core.ExecutionContext;

import java.io.IOException;
import java.util.List;

public interface Writer<T> {
    void write(List<T> items, ExecutionContext context) throws IOException;
}
