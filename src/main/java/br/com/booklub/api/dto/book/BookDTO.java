package br.com.booklub.api.dto.book;

import br.com.booklub.api.domain.book.BookGenre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record BookDTO(@NotNull @NotEmpty String title,
                      UUID authorId,
                      @NotNull BookGenre genre,
                      @NotNull Integer pages,
                      @NotNull Integer price,
                      @NotNull Integer quantity) {
}
