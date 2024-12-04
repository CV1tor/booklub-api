package br.com.booklub.api.exception;

import java.io.Serial;

public class ClubNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ClubNotFoundException() {super("Club not found.");}

    public ClubNotFoundException(String message) {super(message);}

}
