package com.andersenlab.ponamorev.tinkoffbank.data;

public enum HousingsData {
    HOUSING_MOSCOW("ЖКУ-Москва");

    private String housing;

    HousingsData(String housing) {
        this.housing = housing;
    }

    public String getHousing() {
        return housing;
    }
}