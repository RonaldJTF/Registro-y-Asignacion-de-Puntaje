package co.edu.unipamplona.ciadti.rap.services.exception.handler;

import co.edu.unipamplona.ciadti.rap.services.exception.RapException;
import co.edu.unipamplona.ciadti.rap.services.util.Methods;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Log4j2
@ControllerAdvice
public class DataIntegrityViolationExceptionGlobalHandler {
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<?> handleException(DataIntegrityViolationException ex) {
        log.error("[" + 500 + "] " + ex.getMessage());
        ex.printStackTrace();
        return Methods.handleRapException(new RapException(ex.getMessage(), 500));
    }
}