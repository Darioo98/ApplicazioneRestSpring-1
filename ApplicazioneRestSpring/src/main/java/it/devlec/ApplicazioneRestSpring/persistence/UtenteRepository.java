package it.devlec.ApplicazioneRestSpring.persistence;

import it.devlec.ApplicazioneRestSpring.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {


}
