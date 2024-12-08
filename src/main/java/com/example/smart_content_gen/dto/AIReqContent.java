package com.example.smart_content_gen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class AIReqContent {

    @JsonProperty("parts")
    private List<Part> parts;
}
