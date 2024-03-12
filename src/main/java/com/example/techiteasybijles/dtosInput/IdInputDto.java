package com.example.techiteasybijles.dtosInput;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class IdInputDto {
    @NotNull
    private Long id;
}
