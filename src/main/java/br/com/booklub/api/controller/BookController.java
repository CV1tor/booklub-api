package br.com.booklub.api.controller;

import br.com.booklub.api.domain.book.Book;
import br.com.booklub.api.domain.book.BookGenre;
import br.com.booklub.api.dto.book.BookDTO;
import br.com.booklub.api.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/book")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) String author,
                                                  @RequestParam(required = false) BookGenre genre) {
        List<Book> books;
        if(title != null && !title.isEmpty() || author != null && !author.isEmpty() || genre != null) {
            books = bookService.findByAuthorNameAndTitleAndGenre(author, title, genre);
        }
        else {
            books = bookService.findAll();
        }

        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<Void> createBook(@RequestBody @Valid BookDTO bookDTO) throws Exception {
        bookService.save(bookDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) throws Exception {
        bookService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
