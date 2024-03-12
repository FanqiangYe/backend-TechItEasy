package com.example.techiteasybijles.dtosInput;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoteControllerInputDto {
    private String compatibleWith;
    private String batteryType;
    @NotNull
    private String name;
    @NotNull
    private String brand;
    @Positive
    private Double price;
    private Integer originalStock;
}
