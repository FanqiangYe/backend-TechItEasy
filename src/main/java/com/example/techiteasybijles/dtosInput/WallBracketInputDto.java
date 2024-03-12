package com.example.techiteasybijles.dtosInput;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WallBracketInputDto {
    @NotNull
    private String size;
    private Boolean adjustable;
    @NotNull
    private String name;
    @Positive
    private Double price;
}
