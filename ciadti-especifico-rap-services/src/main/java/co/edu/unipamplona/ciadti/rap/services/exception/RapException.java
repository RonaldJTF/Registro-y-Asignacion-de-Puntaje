package co.edu.unipamplona.ciadti.rap.services.exception;

public class RapException extends Exception{
    private Integer code = 500;

    public RapException(String message) {
        super(message);
    }

    public RapException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }
}
