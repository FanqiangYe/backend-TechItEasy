package com.example.techiteasybijles.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "televisions")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private Integer originalStock;
    private Integer sold;

    public Television(String brand, String name, Double price,
                      Double availableSize, Double refreshRate, String screenType,
                      String screenQuality, Boolean smartTv, Boolean wifi, Boolean voiceControl,
                      Boolean hdr, Boolean bluetooth, Boolean ambiLight, Integer originalStock,
                      Integer sold) {
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
    }

    public Television() {

    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBrand() {
//        return brand;
//    }
//
//    public void setBrand(String brand) {
//        this.brand = brand;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public Double getAvailableSize() {
//        return availableSize;
//    }
//
//    public void setAvailableSize(Double availableSize) {
//        this.availableSize = availableSize;
//    }
//
//    public Double getRefreshRate() {
//        return refreshRate;
//    }
//
//    public void setRefreshRate(Double refreshRate) {
//        this.refreshRate = refreshRate;
//    }
//
//    public String getScreenType() {
//        return screenType;
//    }
//
//    public void setScreenType(String screenType) {
//        this.screenType = screenType;
//    }
//
//    public String getScreenQuality() {
//        return screenQuality;
//    }
//
//    public void setScreenQuality(String screenQuality) {
//        this.screenQuality = screenQuality;
//    }
//
//    public Boolean getSmartTv() {
//        return smartTv;
//    }
//
//    public void setSmartTv(Boolean smartTv) {
//        this.smartTv = smartTv;
//    }
//
//    public Boolean getWifi() {
//        return wifi;
//    }
//
//    public void setWifi(Boolean wifi) {
//        this.wifi = wifi;
//    }
//
//    public Boolean getVoiceControl() {
//        return voiceControl;
//    }
//
//    public void setVoiceControl(Boolean voiceControl) {
//        this.voiceControl = voiceControl;
//    }
//
//    public Boolean getHdr() {
//        return hdr;
//    }
//
//    public void setHdr(Boolean hdr) {
//        this.hdr = hdr;
//    }
//
//    public Boolean getBluetooth() {
//        return bluetooth;
//    }
//
//    public void setBluetooth(Boolean bluetooth) {
//        this.bluetooth = bluetooth;
//    }
//
//    public Boolean getAmbiLight() {
//        return ambiLight;
//    }
//
//    public void setAmbiLight(Boolean ambiLight) {
//        this.ambiLight = ambiLight;
//    }
//
//    public Integer getOriginalStock() {
//        return originalStock;
//    }
//
//    public void setOriginalStock(Integer originalStock) {
//        this.originalStock = originalStock;
//    }
//
//    public Integer getSold() {
//        return sold;
//    }
//
//    public void setSold(Integer sold) {
//        this.sold = sold;
//    }
}


