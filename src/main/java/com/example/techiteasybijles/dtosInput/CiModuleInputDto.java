package com.example.techiteasybijles.dtosInput;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CiModuleInputDto {
   @NotNull
    private String name;
   @NotNull
    private String type;
   @Positive
    private Double price;
}
