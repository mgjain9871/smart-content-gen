package com.example.smart_content_gen.models;

import com.example.smart_content_gen.dto.Candidate;
import com.example.smart_content_gen.dto.UsageMetadata;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class GenerateContentResponse {

    private List<Candidate> candidates;
    private UsageMetadata usageMetadata;
    private String modelVersion;
}
