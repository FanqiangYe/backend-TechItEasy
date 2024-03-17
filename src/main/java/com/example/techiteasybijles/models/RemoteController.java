package com.example.techiteasybijles.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;
    // Verwijs naar de property van RemoteController -> remoteController <-
    // Maakt de class waarin de property staat de "owner" van de relation
    @JsonBackReference
    @OneToOne(mappedBy = "remoteController")
    private Television television;

    public RemoteController(Long id, String compatibleWIth, String batteryType) {
        this.id = id;
        this.compatibleWith = compatibleWIth;
        this.batteryType = batteryType;
    }

    public RemoteController() {

    }
}

