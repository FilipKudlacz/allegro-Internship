package com.example.allegrointern.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "updated_at"
})
public class Repo {

    private String name;

    @JsonProperty("updated_at")
    private String updated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("updated_at")
    public String getUpdated() {
        return updated;
    }

    @JsonProperty("updated_at")
    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
