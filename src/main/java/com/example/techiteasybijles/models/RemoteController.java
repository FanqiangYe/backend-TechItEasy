package com.example.techiteasybijles.models;

import jakarta.persistence.*;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompatibleWIth() {
        return compatibleWIth;
    }

    public void setCompatibleWIth(String compatibleWIth) {
        this.compatibleWIth = compatibleWIth;
    }

    public String getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(String batteryType) {
        this.batteryType = batteryType;
    }
}

