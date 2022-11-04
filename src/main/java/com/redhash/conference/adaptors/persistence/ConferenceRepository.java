package com.redhash.conference.adaptors.persistence;

import com.redhash.conference.domain.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRepository extends JpaRepository<Conference, String> {

    boolean existsByName(String name);
}
