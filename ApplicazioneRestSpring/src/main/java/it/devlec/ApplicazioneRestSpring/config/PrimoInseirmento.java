package it.devlec.ApplicazioneRestSpring.config;

import it.devlec.ApplicazioneRestSpring.model.Utente;
import it.devlec.ApplicazioneRestSpring.persistence.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInseirmento {

    private static final Logger logger = LoggerFactory.getLogger(PrimoInseirmento.class);
    @Bean
    CommandLineRunner ineserisciUtenti(UtenteRepository repository) {
        return args -> {
            Utente u1 = new Utente("Mario","Rossi");
            Utente u2 = new Utente("Luca","Verdi");
            Utente u3 = new Utente("Errico","Pizzi");

            List<Utente> utenti = new ArrayList<>();

            utenti.add(u2);
            utenti.add(u3);

            repository.save(u1);
            repository.saveAll(utenti);

            List<Utente> utentiDB = repository.findAll();
            Utente utente1DB = new Utente();
            int indice =0;
            for (Utente u: utentiDB) {
                if(indice == 0) {
                    logger.warn("Prende il primo elemento del DB");
                    utente1DB = u;
                    indice++;
                }
                logger.warn(u.toString());
            }

            Utente utenteConID1 = repository.findById(1L).get();
            logger.info("Utente 1: "+utenteConID1.toString());
            utente1DB.setCognome("Nuovo cognome");
            repository.save(utente1DB);

            logger.error("Sto per fare una delete");
            repository.delete(u2);
            logger.warn("Dopo l'eliminazione");

            utentiDB = repository.findAll();
            for (Utente u: utentiDB) {
                 logger.warn(u.toString());
            }
            SimpleDateFormat dataNascita = new SimpleDateFormat("yyyy-MM-dd");
            Date dataLuca = dataNascita.parse("2005-05-22");
            Utente utenteConTuttiGliAttributi = new Utente("Luca","Foggia",dataLuca,
            new Date(),2.3f);
            repository.save(utenteConTuttiGliAttributi);

        };
    }


}
