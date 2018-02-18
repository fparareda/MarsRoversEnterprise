package com.fparareda.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name="position")
public class Position {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @NotNull(message = "The latitude can not be null!")
    private float latitude;

    @NotNull(message = "The longitude can not be null!")
    private float longitude;

    public Position(Long id, float latitude, float longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
