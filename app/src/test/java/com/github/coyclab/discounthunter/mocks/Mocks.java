package com.github.coyclab.discounthunter.mocks;

import junit.framework.Assert;

import java.io.InputStream;

public class Mocks {

    private static final String JSON_NOT_FOUND = "Resource not found. Add json file";

    public static InputStream stream(final String pName) {
        final InputStream result = Mocks.class.getClassLoader().getResourceAsStream(pName);
        Assert.assertNotNull(JSON_NOT_FOUND, result);
        return result;
    }
}
