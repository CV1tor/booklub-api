package br.com.booklub.api.repository;

import br.com.booklub.api.domain.book.Book;
import br.com.booklub.api.domain.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClubRepository extends JpaRepository<Club, UUID> {
    Optional<Club> findById(String id);

    @Query("SELECT c from Club c WHERE c.book.title LIKE %:book%")
    List<Club> findByBookTitle(String book);
}
