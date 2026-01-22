package bettapcq.exceptions;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(long id) {
        super("L'id " + id + " non esiste");
    }
}
