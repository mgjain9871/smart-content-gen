package com.example.smart_content_gen.mapper;

import com.example.smart_content_gen.dto.AIReqContent;
import com.example.smart_content_gen.dto.Candidate;
import com.example.smart_content_gen.dto.Part;
import com.example.smart_content_gen.models.GenerateContentRequest;
import com.example.smart_content_gen.models.GenerateContentResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class GenerateContentMapper {

    public HttpHeaders mapOpenAIHeaders(String apiKey) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        return headers;
    }

    public GenerateContentRequest mapOpenAIReqBody(String prompt) {

        Part part = new Part();
        part.setText(prompt);
        AIReqContent content = new AIReqContent();
        content.setParts(Collections.singletonList(part));
        GenerateContentRequest generateContentRequest = new GenerateContentRequest();
        generateContentRequest.setContents(Collections.singletonList(content));
        return generateContentRequest;
    }

    public String mapGenerateContentResponse(GenerateContentResponse response) {

        String text = "";
        for (Candidate candidate : response.getCandidates()) {
            AIReqContent content = candidate.getContent();

            for (Part part : content.getParts()) {
                text = part.getText();
            }
        }
        return text;
    }

}
