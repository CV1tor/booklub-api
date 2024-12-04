package br.com.booklub.api.controller;

import br.com.booklub.api.domain.author.Author;
import br.com.booklub.api.dto.author.AuthorDTO;
import br.com.booklub.api.service.AuthorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/author")
@AllArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors(@RequestParam(value = "name", required = false) String name) {
        List<Author> authors;
        if(name != null && !name.isEmpty()) {
            authors = authorService.findByName(name);
        }
        else {
            authors = authorService.findAll();
        }

        return ResponseEntity.ok(authors);
    }

    @PostMapping
    public ResponseEntity<Void> createAuthor(@RequestBody @Valid AuthorDTO authorDTO) {
        authorService.save(authorDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> editAuthor(@PathVariable UUID id, @RequestBody @Valid AuthorDTO authorDTO) throws Exception {
        authorService.update(id, authorDTO);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}/delete")
    public ResponseEntity<Void> deleteAuthor(@PathVariable UUID id) throws Exception {
        authorService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
