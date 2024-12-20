package com.example.smart_content_gen.service;

import com.example.smart_content_gen.models.Quiz;
import com.example.smart_content_gen.repositories.GeneratedQuizRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class QuizParserService {

    private GeneratedQuizRepository quizRepository;

    public List<Quiz> parseQuizResponse(String text) {
        List<Quiz> quizzes = new ArrayList<>();

        // Split text into individual questions
        String[] questionBlocks = text.split("\\*\\*\\d+\\.\\s"); // Splits on '**1.', '**2.', etc.

        for (String questionBlock : questionBlocks) {
            if (!questionBlock.trim().isEmpty()) {
                Quiz quiz = parseQuestionBlock(questionBlock.trim());
                if (quiz != null) {
                    quizzes.add(quiz);
                }
            }
        }
        quizRepository.saveAll(quizzes);
        return quizzes;
    }

    private Quiz parseQuestionBlock(String questionBlock) {
        try {
            // Split the question block into question and answer
            String[] parts = questionBlock.split("\\*\\*Answer:\\*\\*", 2);
            if (parts.length < 2) {
                return null; // If both question and answer not present, skip it
            }

            String question = parts[0].trim(); // Extract the question
            String answer = parts[1].trim();   // Extract the answer

            // Create and return a Quiz object
            Quiz quiz = new Quiz();
            quiz.setQuestion(question);
            quiz.setAnswer(answer);
            return quiz;
        } catch (Exception e) {
            // Handle any parsing errors gracefully
            e.printStackTrace();
            return null;
        }
    }
}
