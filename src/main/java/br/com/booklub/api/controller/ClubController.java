package br.com.booklub.api.controller;

import br.com.booklub.api.domain.club.Club;
import br.com.booklub.api.dto.club.ClubDTO;
import br.com.booklub.api.dto.club.ClubEditDTO;
import br.com.booklub.api.service.ClubService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/club")
@AllArgsConstructor
public class ClubController {
    private final ClubService clubService;

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs(@RequestParam(required = false) String name, @RequestParam(required = false) String title) {
        List<Club> clubs;
        if(name != null && !name.isEmpty() || title != null && !title.isEmpty()) {
            clubs = clubService.findByNameAndBookTitle(name, title);
        }
        else {
            clubs = clubService.findAll();
        }

        return ResponseEntity.ok(clubs);
    }

    @PostMapping
    public ResponseEntity<Void> createClub(@RequestBody @Valid ClubDTO clubDTO) throws Exception {
        clubService.save(clubDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<Void> editClub(@PathVariable UUID id, @RequestBody @Valid ClubEditDTO clubDTO) throws Exception {
        clubService.update(id, clubDTO);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Void> deleteClub(@PathVariable UUID id) throws Exception {
        clubService.delete(id);

        return ResponseEntity.ok().build();
    }
}
