package com.lyw.batch.core.mapper;

import java.util.List;

public interface MapperLine<T, H> {
    String DEFAULT_SEPARATOR = "|";

    List<String> mapper(List<T> items);

    String mapperHeader(H header);
}
