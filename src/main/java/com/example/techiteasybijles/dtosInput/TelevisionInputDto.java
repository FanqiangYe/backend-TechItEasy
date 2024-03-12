package com.example.techiteasybijles.dtosInput;

// filtert data
// invoer van de data

import com.example.techiteasybijles.models.RemoteController;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelevisionInputDto {
    @NotNull
    private String brand;
    @NotNull
    private String name;
    @Positive
    private Double price;
    private Double availableSize;
    private Double refreshRate;
    private String screenType;
    private String screenQuality;
    private Boolean smartTv;
    private Boolean wifi;
    private Boolean voiceControl;
    private Boolean hdr;
    private Boolean bluetooth;
    private Boolean ambiLight;
    private Integer originalStock;
    private Integer sold;
    private RemoteController remoteController;


    public TelevisionInputDto(String brand, String name, Double price,
                         Double availableSize, Double refreshRate, String screenType,
                         String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl,
                         Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock,
                              Integer sold, RemoteController remoteController)
    {
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.remoteController = remoteController;
    }
}

