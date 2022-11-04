package com.redhash.conference.service.impl;

import com.redhash.apifirst.dto.ConferenceDto;
import com.redhash.apifirst.dto.NewConference;
import com.redhash.apifirst.dto.UpdateConference;
import com.redhash.conference.ConferenceException;
import com.redhash.conference.adaptors.persistence.ConferenceRepository;
import com.redhash.conference.domain.Conference;
import com.redhash.conference.service.ConferenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class ConferenceServiceImpl implements ConferenceService {

    private final ConferenceRepository conferenceRepository;

    @Override
    public ConferenceDto createConference(NewConference conference) {
        var entity = new Conference().create(conference);
        return conferenceRepository
                .save(entity)
                .toDto();
    }

    @Override
    public ConferenceDto updateConference(String conferenceId, UpdateConference conference) {
        var persistedConference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ConferenceException(
                        "",
                        "Conference with id " + conferenceId + " not found", "Entity not found",
                        HttpStatusCode.valueOf(404)
                ));
        return conferenceRepository.save(persistedConference.update(conference))
                .toDto();
    }

    @Override
    public ConferenceDto getConference(String conferenceId) {
        return conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new ConferenceException(
                        "",
                        "Conference with id " + conferenceId + " not found", "Entity not found",
                        HttpStatusCode.valueOf(404)
                ))
                .toDto();
    }

    @Override
    public void deleteConference(String conferenceId) {
        conferenceRepository.deleteById(conferenceId);
    }
}
