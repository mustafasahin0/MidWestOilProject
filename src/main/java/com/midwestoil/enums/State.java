package com.midwestoil.enums;

public enum State {
    ALABAMA("Alabama", "ALABAMA"),
    ALASKA("Alaska", "ALASKA"),
    ARIZONA("Arizona", "ARIZONA"),
    ARKANSAS("Arkansas", "ARKANSAS"),
    CALIFORNIA("California", "CALIFORNIA"),
    COLORADO("Colorado", "COLORADO"),
    CONNECTICUT("Connecticut", "CONNECTICUT"),
    DELAWARE("Delaware", "DELAWARE"),
    FLORIDA("Florida", "FLORIDA"),
    GEORGIA("Georgia", "GEORGIA"),
    HAWAII("Hawaii", "HAWAII"),
    IDAHO("Idaho", "IDAHO"),
    ILLINOIS("Illinois", "ILLINOIS"),
    INDIANA("Indiana", "INDIANA"),
    IOWA("Iowa", "IOWA"),
    KANSAS("Kansas", "KANSAS"),
    KENTUCKY("Kentucky", "KENTUCKY"),
    LOUISIANA("Louisiana", "LOUISIANA"),
    MAINE("Maine", "MAINE"),
    MARYLAND("Maryland", "MARYLAND"),
    MASSACHUSETTS("Massachusetts", "MASSACHUSETTS"),
    MICHIGAN("Michigan", "MICHIGAN"),
    MINNESOTA("Minnesota", "MINNESOTA"),
    MISSISSIPPI("Mississippi", "MISSISSIPPI"),
    MISSOURI("Missouri", "MISSOURI"),
    MONTANA("Montana", "MONTANA"),
    NEBRASKA("Nebraska", "NEBRASKA"),
    NEVADA("Nevada", "NEVADA"),
    NEW_HAMPSHIRE("New Hampshire", "NEW_HAMPSHIRE"),
    NEW_JERSEY("New Jersey", "NEW_JERSEY"),
    NEW_MEXICO("New Mexico", "NEW_MEXICO"),
    NEW_YORK("New York", "NEW_YORK"),
    NORTH_CAROLINA("North Carolina", "NORTH_CAROLINA"),
    NORTH_DAKOTA("North Dakota", "NORTH_DAKOTA"),
    OHIO("Ohio", "OHIO"),
    OKLAHOMA("Oklahoma", "OKLAHOMA"),
    OREGON("Oregon", "OREGON"),
    PENNSYLVANIA("Pennsylvania", "PENNSYLVANIA"),
    RHODE_ISLAND("Rhode Island", "RHODE_ISLAND"),
    SOUTH_CAROLINA("South Carolina", "SOUTH_CAROLINA"),
    SOUTH_DAKOTA("South Dakota", "SOUTH_DAKOTA"),
    TENNESSEE("Tennessee", "TENNESSEE"),
    TEXAS("Texas", "TEXAS"),
    UTAH("Utah", "UTAH"),
    VERMONT("Vermont", "VERMONT"),
    VIRGINIA("Virginia", "VIRGINIA"),
    WASHINGTON("Washington", "WASHINGTON"),
    WEST_VIRGINIA("West Virginia", "WEST_VIRGINIA"),
    WISCONSIN("Wisconsin", "WISCONSIN"),
    WYOMING("Wyoming", "WYOMING");

    private final String fullName;
    private final String abbreviation;

    State(String fullName, String abbreviation) {
        this.fullName = fullName;
        this.abbreviation = abbreviation;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}