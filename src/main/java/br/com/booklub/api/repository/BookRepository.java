package br.com.booklub.api.repository;

import br.com.booklub.api.domain.author.Author;
import br.com.booklub.api.domain.book.Book;
import br.com.booklub.api.domain.book.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {


    Optional<Book> findById(String id);

    List<Book> findByGenre(BookGenre genre);

    @Query("SELECT b from Book b where b.author.name like %:author%")
    List<Book> findByAuthorName(String name);

    @Query("SELECT b from Book b where b.title like %:title%")
    List<Book> findByTitle(String title);
}
