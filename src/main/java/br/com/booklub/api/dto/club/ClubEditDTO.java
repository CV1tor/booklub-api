package br.com.booklub.api.dto.club;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClubEditDTO(@NotBlank @NotNull String name) {
}
