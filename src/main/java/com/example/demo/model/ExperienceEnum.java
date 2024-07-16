package com.example.demo.model;

import lombok.Getter;


@Getter
public enum ExperienceEnum {
    WALLET("WALLET"),
    STAY("STAY");
    private final String experiencetype;

    ExperienceEnum(String experiencetype) {
        this.experiencetype = experiencetype;
    }
}
