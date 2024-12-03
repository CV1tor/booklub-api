package br.com.booklub.api.service;

import br.com.booklub.api.domain.author.Author;
import br.com.booklub.api.dto.AuthorDTO;
import br.com.booklub.api.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    final AuthorRepository authorRepository;

    public void save(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.name());

        authorRepository.save(author);
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public List<Author> findByName(String name) {
        return authorRepository.findByName(name);
    }

    public void delete(String id) throws Exception {
        Author author = findById(id);

        authorRepository.delete(author);
    }


    public Author findById(String id) throws Exception {
        return authorRepository.findById(id).orElseThrow(() -> new Exception("Author not found."));
    }




}
