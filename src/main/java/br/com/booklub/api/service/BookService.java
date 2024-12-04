package br.com.booklub.api.service;

import br.com.booklub.api.domain.author.Author;
import br.com.booklub.api.domain.book.Book;
import br.com.booklub.api.domain.book.BookGenre;
import br.com.booklub.api.dto.book.BookDTO;
import br.com.booklub.api.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BookService {
    final BookRepository bookRepository;
    final AuthorService authorService;

    public void save(BookDTO bookDTO) throws Exception {
        Book book = new Book();
        if(bookDTO.authorId() != null) {
            Author author = authorService.findById(bookDTO.authorId());
            book.setAuthor(author);
        }
        book.setTitle(bookDTO.title());
        book.setGenre(bookDTO.genre());
        book.setPages(bookDTO.pages());
        book.setQuantity(bookDTO.quantity());
        book.setPrice(bookDTO.price());

        bookRepository.save(book);
    }

    public Book get(UUID id) throws Exception {
        Book book = findById(id);

        return book;
    }

    public void delete(UUID id) throws Exception {
        Book book = findById(id);

        bookRepository.delete(book);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> findByAuthorNameAndTitleAndGenre(String name, String title, BookGenre genre) {
        return bookRepository.findByAuthorNameAndTitleAndGenre(name, title, genre);
    }

    public Book findById(UUID id) throws Exception {
        return bookRepository.findById(id).orElseThrow(() -> new Exception("Book not found."));
    }

}
