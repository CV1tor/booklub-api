package br.com.booklub.api.conf;

import br.com.booklub.api.domain.club.Club;
import br.com.booklub.api.dto.error.ErrorTreatmentDTO;
import br.com.booklub.api.exception.AuthorNotFoundException;
import br.com.booklub.api.exception.BookNotFoundException;
import br.com.booklub.api.exception.ClubNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(BookNotFoundException.class)
    private ResponseEntity<ErrorTreatmentDTO> bookNotFoundHandler(BookNotFoundException exception) {
        ErrorTreatmentDTO errorResponse = new ErrorTreatmentDTO(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ClubNotFoundException.class)
    private ResponseEntity<ErrorTreatmentDTO> bookNotFoundHandler(ClubNotFoundException exception) {
        ErrorTreatmentDTO errorResponse = new ErrorTreatmentDTO(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthorNotFoundException.class)
    private ResponseEntity<ErrorTreatmentDTO> bookNotFoundHandler(AuthorNotFoundException exception) {
        ErrorTreatmentDTO errorResponse = new ErrorTreatmentDTO(HttpStatus.NOT_FOUND, exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
