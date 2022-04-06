package it.devlec.ApplicazioneRestSpring.avviso;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RispostaNonTrovata {
    @ResponseBody
    @ExceptionHandler(UtenteNonTrovato.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String RispostaNonTrovata(UtenteNonTrovato ex) {
        return ex.getMessage();
    }
}
