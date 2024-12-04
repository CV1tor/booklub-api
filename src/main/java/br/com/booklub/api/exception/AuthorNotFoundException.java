package br.com.booklub.api.exception;

import java.io.Serial;

public class AuthorNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public AuthorNotFoundException() {super("Author not found.");}

    public AuthorNotFoundException(String message) {super(message);}

}
