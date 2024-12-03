package br.com.booklub.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AuthorDTO(@NotNull @NotBlank String name) {
}
