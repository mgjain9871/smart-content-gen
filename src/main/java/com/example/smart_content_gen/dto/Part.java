package com.example.smart_content_gen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Part {

    @JsonProperty("text")
    private String text;
}
