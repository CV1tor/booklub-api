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



    List<Book> findByGenre(BookGenre genre);

    @Query("SELECT b from Book b WHERE " +
            "(:name IS NULL OR b.author.name LIKE %:name%) " +
            "AND (:title IS NULL OR b.title LIKE %:title%) " +
            "AND (:genre IS NULL OR b.genre = :genre)")
    List<Book> findByAuthorNameAndTitleAndGenre(String name, String title, BookGenre genre);
}
