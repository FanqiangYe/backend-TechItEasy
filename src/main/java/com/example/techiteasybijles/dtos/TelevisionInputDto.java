package com.example.techiteasybijles.dtos;

// filtert data
// invoer van de data

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TelevisionInputDto {
    private String brand;
    private String name;
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


    public TelevisionInputDto(String brand, String name, Double price,
                         Double availableSize, Double refreshRate, String screenType,
                         String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl,
                         Boolean hdr, Boolean bluetooth, Boolean ambiLight)
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
    }
}

