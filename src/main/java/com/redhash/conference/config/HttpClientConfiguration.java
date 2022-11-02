package com.redhash.conference.config;

import com.redhash.conference.ConferenceException;
import com.redhash.conference.adaptors.httpclient.TestHttpClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Slf4j
@Configuration
public class HttpClientConfiguration {

    @Bean
    public TestHttpClient chuckNorrisClient(@Value("${conference-system.jokes-url}") String jokesUrl) {
        var webClient = WebClient.builder()
                .defaultStatusHandler(HttpStatusCode::isError, response -> {
                    throw ConferenceException.builder()
                            .statusCode(response.statusCode())
                            .type("http://example.com/bad-request")
                            .detail(response.toString())
                            .title("Jokes request has failed")
                            .build();
                })
                .baseUrl(jokesUrl)
                .build();

        var factory = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(webClient))
                .build();
        return factory.createClient(TestHttpClient.class);
    }
}
