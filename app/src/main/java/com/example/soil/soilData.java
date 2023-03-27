package com.example.soil;

public class soilData {

    String state,district,soilType;

    public soilData() {
    }

    public soilData(String state, String district, String soilType) {
        this.state = state;
        this.district = district;
        this.soilType = soilType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getSoilType() {
        return soilType;
    }

    public void setSoilType(String soilType) {
        this.soilType = soilType;
    }
}
