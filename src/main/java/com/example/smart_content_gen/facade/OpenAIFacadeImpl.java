package com.example.smart_content_gen.facade;

import com.example.smart_content_gen.mapper.GenerateContentMapper;
import com.example.smart_content_gen.models.GenerateContentRequest;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OpenAIFacadeImpl implements OpenAIFacade{

    private GenerateContentMapper generateContentMapper;

    public static final Dotenv dotenv = Dotenv.load();
    public static final String apiKey = dotenv.get("API_KEY");
    public static  String apiUrl = dotenv.get("BASE_URL");

    @Override
    public String generateCompletion(String prompt){

        HttpHeaders headers = generateContentMapper.mapOpenAIHeaders(apiKey);

        GenerateContentRequest generateContentRequest = generateContentMapper.mapOpenAIReqBody(prompt);

        HttpEntity<GenerateContentRequest> entity = new HttpEntity<>(generateContentRequest, headers);

        RestTemplate restTemplate = new RestTemplate();
        String urlWithKey = apiUrl + "?key=" + apiKey;
        ResponseEntity<String> response = restTemplate.postForEntity(urlWithKey, entity, String.class);
        return response.getBody();
    }

}
