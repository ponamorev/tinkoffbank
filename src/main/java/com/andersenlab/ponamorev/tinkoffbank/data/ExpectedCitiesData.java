package com.andersenlab.ponamorev.tinkoffbank.data;

public enum ExpectedCitiesData {
    MOSCOW("г. Москва", "Москве"),
    SAINT_PETERBURG("г. Санкт-Петербург", "Санкт-Петербурге");

    private String city;
    private String ofCity;

    ExpectedCitiesData(String city, String ofCity) {
        this.city = city;
        this.ofCity = ofCity;
    }

    public String getCity() {
        return city;
    }

    public String getOfCity() {
        return ofCity;
    }
}