package br.com.booklub.api.dto.club;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClubDTO(@NotNull @NotBlank String name, @NotNull UUID bookId) {
}
