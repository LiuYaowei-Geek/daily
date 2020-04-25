package com.lyw.batch.core.processor;

import java.util.List;

public interface Processor<T> {
    List<T> process(List<T> item);
}
