package com.redhash.conference.service.validation.validator;

import com.redhash.apifirst.dto.ConferenceName;
import com.redhash.conference.adaptors.persistence.ConferenceRepository;
import com.redhash.conference.service.validation.UniqueConference;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniqueConferenceValidator implements ConstraintValidator<UniqueConference, ConferenceName> {

    private final ConferenceRepository conferenceRepository;

    @Override
    public boolean isValid(ConferenceName name, ConstraintValidatorContext constraintValidatorContext) {
        return !conferenceRepository.existsByName(name.getName());
    }
}
