package com.example.smart_content_gen.service;

import com.example.smart_content_gen.facade.OpenAIFacade;
import com.example.smart_content_gen.models.Content;
import com.example.smart_content_gen.repositories.ContentRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ContentService {

    private ContentRepository contentRepository;
    private OpenAIFacade restFacade;

    private Tika tika = new Tika();

    static {
        Dotenv dotenv = Dotenv.load(); // Load .env file
    }

    public ContentService(ContentRepository contentRepository, OpenAIFacade restFacade) {
        this.contentRepository = contentRepository;
        this.restFacade = restFacade;
    }

    public Content saveContent(MultipartFile file, String title, String uploadedBy) throws IOException, TikaException {
        Content content = new Content();
        content.setTitle(title);
        content.setFileType(file.getContentType());
        content.setUploadedBy(uploadedBy);

        String extractedText = tika.parseToString(file.getInputStream());
        content.setExtractedText(extractedText);

        return contentRepository.save(content);
    }

    public Content getContentById(Long id) {
        Optional<Content> contentOptional = contentRepository.findById(id);
        return contentOptional.orElseThrow(() -> new RuntimeException("Content not found for ID: " + id));
    }

    public String generateQuiz(String extractedText) {
        String prompt = "Create 5 quiz questions (with answers) based on the following text:\n\n" + extractedText;
        return restFacade.generateCompletion(prompt);
    }

    public String generateSummary(String extractedText) {
        String prompt = "Summarize the following text:\n\n" + extractedText;
        return restFacade.generateCompletion(prompt);
    }
}
