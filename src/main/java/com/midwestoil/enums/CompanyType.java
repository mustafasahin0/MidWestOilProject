package com.midwestoil.enums;

public enum CompanyType {
    VENDOR("Vendor"), CLIENT("Client");

    private final String value;

    CompanyType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
