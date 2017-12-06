package com.github.coyclab.discounthunter.http;

import java.io.InputStream;

public interface IHttpClient {

    InputStream request(String url);
}
