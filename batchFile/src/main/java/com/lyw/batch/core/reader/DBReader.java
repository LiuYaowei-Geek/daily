package com.lyw.batch.core.reader;

import com.lyw.batch.core.ExecutionContext;
import com.lyw.batch.core.step.DefaultHeader;

import java.util.List;


public interface DBReader<T, H extends DefaultHeader> extends Reader {
    List<T> read(int currentPage, int pageSize);

    H readHeader(ExecutionContext context);
}
