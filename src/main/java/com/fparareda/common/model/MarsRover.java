package com.fparareda.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Table(name="mars_rover")
@NoArgsConstructor
public class MarsRover {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @NotNull(message = "Position can not be null!")
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;

    @Column(nullable = false)
    @NotNull(message = "Charging can not be null!")
    private Boolean charging;

    public MarsRover(Long id, Position position, Boolean charging) {
        this.id = id;
        this.position = position;
        this.charging = charging;
    }

    public void move(Position position) {
        this.position = position;
    }

    public void chargeBateries(Boolean chargeBateries) {
        this.charging = chargeBateries;
    }
}
