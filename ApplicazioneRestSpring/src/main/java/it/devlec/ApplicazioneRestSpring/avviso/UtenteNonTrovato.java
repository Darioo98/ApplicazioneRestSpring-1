package it.devlec.ApplicazioneRestSpring.avviso;

public class UtenteNonTrovato extends RuntimeException {

    public UtenteNonTrovato(Long id){
        super("Eccezione : Utente non trovato " + id);
    }

}
