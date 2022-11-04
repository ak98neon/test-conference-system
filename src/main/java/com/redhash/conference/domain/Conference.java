package com.redhash.conference.domain;

import com.redhash.apifirst.dto.ConferenceDto;
import com.redhash.apifirst.dto.NewConference;
import com.redhash.apifirst.dto.UpdateConference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity(name = "conference")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Conference {

    @Id
    private String id;
    private String name;
    private String description;

    public Conference create(NewConference newConference) {
        return new Conference(
                UUID.randomUUID().toString(),
                newConference.getName(),
                newConference.getDescription(

                ));
    }

    public Conference update(UpdateConference newConference) {
        setName(newConference.getName());
        setDescription(newConference.getDescription());
        return this;
    }

    public ConferenceDto toDto() {
        return new ConferenceDto(id, name, description);
    }
}
