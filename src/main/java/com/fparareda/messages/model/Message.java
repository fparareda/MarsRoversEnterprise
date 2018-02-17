package com.fparareda.messages.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fparareda.common.model.MarsRover;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "message")
public class Message {

    @Id
    @JsonIgnore
    @GeneratedValue
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mars_rover_id", nullable = false)
    private MarsRover marsRover;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(nullable = false)
    @NotNull(message = "The message can not be null!")
    private String message;

    public Message() {
        this.date = new Date();
    }

    public void assignMarsRover(MarsRover marsRover) {
        this.marsRover = marsRover;
    }
}
