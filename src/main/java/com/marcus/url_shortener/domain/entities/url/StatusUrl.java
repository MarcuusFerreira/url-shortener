package com.marcus.url_shortener.domain.entities.url;

public enum StatusUrl {

    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE");

    private String value;

    StatusUrl(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
