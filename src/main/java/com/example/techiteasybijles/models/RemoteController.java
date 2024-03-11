package com.example.techiteasybijles.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "remote controllers")
public class RemoteController {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String compatibleWIth;
    private String batteryType;

    public RemoteController(Long id, String compatibleWIth, String batteryType) {
        this.id = id;
        this.compatibleWIth = compatibleWIth;
        this.batteryType = batteryType;
    }

    public RemoteController() {

    }
}

