package br.com.booklub.api.dto.error;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatusCode;

public record ErrorTreatmentDTO(@NotNull HttpStatusCode statusCode, @NotNull @NotBlank String message) {
}
