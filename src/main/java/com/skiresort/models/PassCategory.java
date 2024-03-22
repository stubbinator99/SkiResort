package com.skiresort.models;

public enum PassCategory {
    ADULT ("Ages 12 to 64"),
    CHILD ("Ages 6 and under"),
    MILITARY ("Veterans or active military"),
    SENIOR ("Ages 65 and up"),
    YOUTH ("Ages 7 to 11");

    private String description;

    PassCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
