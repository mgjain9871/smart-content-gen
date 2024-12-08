package com.example.smart_content_gen.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsageMetadata {

    private int promptTokenCount;
    private int candidatesTokenCount;
    private int totalTokenCount;
}
