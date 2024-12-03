package br.com.booklub.api.repository;

import br.com.booklub.api.domain.author.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    Optional<Author> findById(String id);

    @Query("SELECT a FROM Author a WHERE a.name like '%:name%'")
    List<Author> findByName(String name);

}
