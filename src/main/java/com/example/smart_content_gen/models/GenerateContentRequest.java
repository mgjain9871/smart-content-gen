package com.example.smart_content_gen.models;

import com.example.smart_content_gen.dto.AIReqContent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class GenerateContentRequest {

    @JsonProperty("contents")
    private List<AIReqContent> contents;
}
