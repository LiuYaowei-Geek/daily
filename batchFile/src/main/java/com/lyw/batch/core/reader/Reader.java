package com.lyw.batch.core.reader;

import com.lyw.batch.core.resource.Resource;

import java.io.IOException;

public interface Reader {
    void skip(Resource resource, int skipNumber) throws IOException;
}
