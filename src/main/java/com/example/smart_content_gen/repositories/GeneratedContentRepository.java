package com.example.smart_content_gen.repositories;

import com.example.smart_content_gen.models.GeneratedContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneratedContentRepository extends JpaRepository<GeneratedContent, Long> {

    List<GeneratedContentRepository> findByContentIdAndType(Long contentId, String type);
}
