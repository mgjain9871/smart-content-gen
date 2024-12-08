package com.example.smart_content_gen.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Candidate {

    private AIReqContent content;
    private String role;
    private String finishReason;
    private double avgLogprobs;
}
