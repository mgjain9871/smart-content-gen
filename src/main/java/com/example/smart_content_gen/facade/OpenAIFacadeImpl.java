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
//    private RestTemplate restTemplate ;

    public static final Dotenv dotenv = Dotenv.load(); // Load the .env file
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
//        GenerateContentResponse response = callGenerateContent(urlWithKey, ApplicationUtil.createRequest(generateContentRequest, headers),GenerateContentResponse.class);
//        return generateContentMapper.mapGenerateContentResponse(response);
        return response.getBody();
    }

//    public GenerateContentResponse callGenerateContent(String url, HttpEntity<Object> createRequest, Class<GenerateContentResponse> responseClass){
//
//        GenerateContentResponse response = null;
//
//        try {
//            response = restTemplate.postForObject(url, createRequest, responseClass);
//        }
//        catch (HttpStatusCodeException e){
//            throw new RuntimeException("HTTP error: " + e.getStatusCode());
//        }
//        catch (Exception e){
//            throw new RuntimeException("Error calling API: " + e.getMessage());
//        }
//
//        return response;
//    }

}
