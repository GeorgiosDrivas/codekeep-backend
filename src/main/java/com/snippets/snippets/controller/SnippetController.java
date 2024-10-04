package com.snippets.snippets.controller;

import com.snippets.snippets.model.Snippet;
import com.snippets.snippets.service.SnippetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SnippetController {

    private final SnippetService snippetService;

    public SnippetController(SnippetService snippetService) {
        this.snippetService = snippetService;
    }

    @GetMapping("/snippets/all/{userid}")
    public List<Snippet> getSnippetsByUserId(@PathVariable Long userid) {
        return snippetService.getSnippets(userid);
    }

    @RequestMapping(value = "/snippets/add-snippet", method = RequestMethod.POST)
    public ResponseEntity<Snippet> createSnippet(@RequestBody Snippet snippet){
        Snippet createdSnippet = snippetService.createSnippet(snippet);
        return new ResponseEntity<>(createdSnippet, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/snippets/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSnippet(@PathVariable("id") Long id) throws Exception {
        boolean snippetExist = snippetService.snippetExist(id);
        if (snippetExist)
        {
            snippetService.deleteSnippet(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
        {
            throw new Exception("Snippet not found");

        }
    }

    @PutMapping("/snippets/update/{id}")
    public ResponseEntity<Snippet> updateSnippet(@PathVariable Long id, @RequestBody Snippet updatedSnippet) {
        try {
            Snippet snippet = snippetService.updateSnippet(id, updatedSnippet);
            return new ResponseEntity<>(snippet, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
