package it.devlec.ApplicazioneRestSpring.persistence;

import it.devlec.ApplicazioneRestSpring.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    List<Utente> findByDatadinascitaBetween(Date datada, Date dataa);
    List<Utente> findByDatadiregistrazioneBetween(Date datada, Date dataa);


    List<Utente> findByRankingBetween(float minimo,float max);
    List<Utente> findByRankingLessThan(float max);

}
