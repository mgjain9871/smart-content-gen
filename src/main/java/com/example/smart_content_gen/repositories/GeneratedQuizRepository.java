package com.example.smart_content_gen.repositories;

import com.example.smart_content_gen.models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratedQuizRepository extends JpaRepository<Quiz, Long> {
}
