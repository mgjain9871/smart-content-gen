package com.example.smart_content_gen.facade;

import com.example.smart_content_gen.models.GenerateContentResponse;

public interface OpenAIFacade {

    String generateCompletion(String prompt);
}
