package com.example.smart_content_gen.controller;

import com.example.smart_content_gen.models.Content;
import com.example.smart_content_gen.service.ContentService;
import org.apache.tika.exception.TikaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/upload")
    public ResponseEntity<Content> uploadContent(@RequestParam("file") MultipartFile file, @RequestParam("title")String title, @RequestParam("uploadedBy")String uploadedBy) throws TikaException, IOException {

        Content content = null;
        try {
            content = contentService.saveContent(file, title, uploadedBy);
        } catch (TikaException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(content);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getContentById(@PathVariable Long id) {
        try {
            Content content = contentService.getContentById(id);
            return ResponseEntity.ok(content);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/quiz")
    public ResponseEntity<String> generateQuiz(@PathVariable Long id) {
        String extractedText = contentService.getContentById(id).getExtractedText();
        String quiz = contentService.generateQuiz(extractedText);
        return ResponseEntity.ok(quiz);
    }

    @GetMapping("/{id}/summary")
    public ResponseEntity<String> generateSummary(@PathVariable Long id) {
        String extractedText = contentService.getContentById(id).getExtractedText();
        String summary = contentService.generateSummary(extractedText);
        return ResponseEntity.ok(summary);
    }
}
