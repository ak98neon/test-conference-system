package com.redhash.conference.adaptors.httpclient;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("/jokes")
public interface TestHttpClient {

    @GetExchange("/random")
    String getRandomJokes();
}
