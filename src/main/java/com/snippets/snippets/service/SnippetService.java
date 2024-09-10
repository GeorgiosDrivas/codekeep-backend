package com.snippets.snippets.service;

import com.snippets.snippets.model.Snippet;
import com.snippets.snippets.repository.SnippetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnippetService {

    private final SnippetRepository snippetRepository;

    public SnippetService(SnippetRepository snippetRepository) {
        this.snippetRepository = snippetRepository;
    }

    public List<Snippet> getSnippets(long userid){
        return snippetRepository.findByUserid(userid);
    }

    public Snippet createSnippet(Snippet snippet){
        return snippetRepository.save(snippet);
    };

    public boolean snippetExist(Long id){ // Helps with deleteSnippet
        return snippetRepository.existsById(id);
    };

    public void deleteSnippet(Long id){
        snippetRepository.deleteById(id);
    };

    public Snippet updateSnippet(Long id, Snippet updatedSnippet) throws Exception {
        Optional<Snippet> snippetOptional = snippetRepository.findById(id);

        if (snippetOptional.isPresent()) {
            Snippet existingSnippet = snippetOptional.get();

            // Update the snippet fields
            existingSnippet.setTitle(updatedSnippet.getTitle());
            existingSnippet.setLanguage(updatedSnippet.getLanguage());
            existingSnippet.setContent(updatedSnippet.getContent());

            return snippetRepository.save(existingSnippet);
        } else {
            throw new Exception("Snippet not found");
        }
    }
}
