package com.redhash.conference.adaptors.api;

import com.redhash.conference.ConferenceException;
import com.redhash.conference.adaptors.httpclient.TestHttpClient;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "conferences")
@Slf4j
@RestController
@RequestMapping("/api/v1/conferences")
@RequiredArgsConstructor
public class ConferenceRestController {

    private final TestHttpClient testHttpClient;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public String getRandomJokes() {
        return testHttpClient.getRandomJokes();
    }

    @ExceptionHandler(ConferenceException.class)
    public ProblemDetail handleException(ConferenceException e) {
        log.error("Exception occurred: ", e);
        return e.toProblem();
    }
}
