package com.redhash.conference.service;

import com.redhash.apifirst.dto.ConferenceDto;
import com.redhash.apifirst.dto.NewConference;
import com.redhash.apifirst.dto.UpdateConference;
import com.redhash.conference.service.validation.UniqueConference;

public interface ConferenceService {

    ConferenceDto createConference(@UniqueConference NewConference conference);

    ConferenceDto updateConference(String conferenceId, @UniqueConference UpdateConference conference);

    ConferenceDto getConference(String conferenceId);

    void deleteConference(String conferenceId);

}
