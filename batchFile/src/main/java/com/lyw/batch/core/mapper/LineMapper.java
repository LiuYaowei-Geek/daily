package com.lyw.batch.core.mapper;

import java.util.List;

public interface LineMapper<T, H> {
    String DEFAULT_SPLITTER = "\\|";

    List<T> mapper(List<String> lines);

    H mapperHeader(List<String> lines);
}
