package org.example.tp2.Enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum accountType {
    @JsonProperty("SAVING")
    SAVING,
    @JsonProperty("CURRENT")
    CURRENT
}
