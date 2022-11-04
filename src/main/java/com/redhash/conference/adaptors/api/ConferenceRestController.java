package com.redhash.conference.adaptors.api;

import com.redhash.apifirst.ConferenceApi;
import com.redhash.apifirst.dto.ConferenceDto;
import com.redhash.apifirst.dto.NewConference;
import com.redhash.apifirst.dto.UpdateConference;
import com.redhash.conference.ConferenceException;
import com.redhash.conference.adaptors.httpclient.TestHttpClient;
import com.redhash.conference.service.ConferenceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Tag(name = "conferences")
@Slf4j
@RestController
@RequestMapping
@RequiredArgsConstructor
public class ConferenceRestController implements ConferenceApi {

    private final TestHttpClient testHttpClient;
    private final ConferenceService conferenceService;

    @GetMapping(value = "/jokes", produces = APPLICATION_JSON_VALUE)
    public String getRandomJokes() {
        return testHttpClient.getRandomJokes();
    }

    @Override
    public ResponseEntity<ConferenceDto> getConferenceById(String conferenceId) {
        return ResponseEntity.ok(
                conferenceService.getConference(conferenceId)
        );
    }

    @Override
    public ResponseEntity<ConferenceDto> updateConference(String conferenceId, UpdateConference updateConference) {
        return ResponseEntity.ok(
                conferenceService.updateConference(conferenceId, updateConference)
        );
    }

    @Override
    public ResponseEntity<ConferenceDto> createConference(NewConference newConference) {
        return ResponseEntity.ok(
                conferenceService.createConference(newConference)
        );
    }

    @Override
    public ResponseEntity<Void> deleteConferenceById(String conferenceId) {
        conferenceService.deleteConference(conferenceId);
        return ResponseEntity.ok()
                .build();
    }

    @ExceptionHandler(ConferenceException.class)
    public ProblemDetail handleException(ConferenceException e) {
        log.error("Exception occurred: ", e);
        return e.toProblem();
    }
}
