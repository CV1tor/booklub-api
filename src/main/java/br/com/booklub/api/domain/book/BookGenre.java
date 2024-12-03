package br.com.booklub.api.domain.book;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum BookGenre {
    ACTION("action"),
    ADVENTURE("adventure"),
    FANTASY("fantasy"),
    SCI_FI("sci-fi"),
    BIOGRAPHY("biography"),
    ROMANCE("romance"),
    MYSTERY("mystery");

    private final String descricao;

}
