package com.snippets.snippets.repository;

import com.snippets.snippets.model.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface SnippetRepository extends JpaRepository<Snippet, Long> {
    List<Snippet> findByUserid(long userid);
}