package br.com.booklub.api.service;

import br.com.booklub.api.domain.book.Book;
import br.com.booklub.api.domain.club.Club;
import br.com.booklub.api.dto.club.ClubDTO;
import br.com.booklub.api.dto.club.ClubEditDTO;
import br.com.booklub.api.exception.ClubNotFoundException;
import br.com.booklub.api.repository.ClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClubService {
    final ClubRepository clubRepository;
    final BookService bookService;

    public void save(ClubDTO clubDTO)  {
        Club club = new Club();
        club.setName(clubDTO.name());
        Book book = bookService.findById(clubDTO.bookId());
        club.setBook(book);

        clubRepository.save(club);
    }

    public void delete(UUID id) {
        Club club = findById(id);

        clubRepository.delete(club);
    }

    public void update(UUID id, ClubEditDTO clubDTO)  {
        Club club = findById(id);
        club.setName(clubDTO.name());

        clubRepository.save(club);
    }

    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    public List<Club> findByNameAndBookTitle(String name, String title) {
        return clubRepository.findByNameAndBookTitle(name, title);
    }

    public Club findById(UUID id)  {
        return clubRepository.findById(id).orElseThrow(ClubNotFoundException::new);
    }
}
