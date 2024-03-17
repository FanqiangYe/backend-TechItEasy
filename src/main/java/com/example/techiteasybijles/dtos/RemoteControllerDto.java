package com.example.techiteasybijles.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerDto {

    private Long id;
    private String compatibleWith;
    private String batteryType;
    private String name;
    private String brand;
    private Double price;
    private Integer originalStock;
}
