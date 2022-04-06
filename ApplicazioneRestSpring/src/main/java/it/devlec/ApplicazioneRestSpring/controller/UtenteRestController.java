package it.devlec.ApplicazioneRestSpring.controller;

import it.devlec.ApplicazioneRestSpring.avviso.UtenteNonTrovato;
import it.devlec.ApplicazioneRestSpring.model.Utente;
import it.devlec.ApplicazioneRestSpring.persistence.UtenteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class UtenteRestController {
    private static final Logger logger =
            LoggerFactory.getLogger(UtenteRestController.class);

    private UtenteRepository repository;

    UtenteRestController(UtenteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/utenti")
    public List<Utente> leggiTuttiGLiUtenti() {
        logger.info("Prendo tutti gli utenti");
        return repository.findAll();
    }

    @GetMapping("/utente/{id}")
    public Utente trovaUtenteConID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new UtenteNonTrovato(id));
    }

    @PostMapping("/utente")
    public Utente inserisciNuovoUtente(@RequestBody Utente newUte) {
        return repository.save(newUte);
    }

    @PutMapping("/utente/{id}")
        public Utente aggiornaUtenti(@PathVariable Long id, @RequestBody Utente utente)
        {
            return repository.save(utente);

        }

    @DeleteMapping("/utente/{id}")
    void eliminaUtente(@PathVariable Long id){
        repository.deleteById(id);
    }

    @GetMapping("/utente/ricercadata")
    public List<Utente> ricercaPerData(@RequestParam(name="datada") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                                   Date datada,
                                       @RequestParam(name="dataa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                               Date dataa){
        return repository.findByDatadinascitaBetween(datada,dataa);
    }

    @GetMapping("/utente/ricercadataregistrazione")
    public List<Utente> ricercaPerDataDiRegistrazione(@RequestParam(name="datada") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                               Date datada,
                                       @RequestParam(name="dataa") @DateTimeFormat(pattern= "dd-MM-yyyy")
                                               Date dataa){
        return repository.findByDatadiregistrazioneBetween(datada,dataa);
    }

    @GetMapping("/utente/ranking")
    public List<Utente> ricercaPeRanking(@RequestParam(name="min") float min,
                                         @RequestParam(name="max") float max){
        return repository.findByRankingBetween(min,max);
    }

    @GetMapping("/utente/rankingmax")
    public List<Utente> ricercaLessRanking(@RequestParam(name="max") float max){
        return repository.findByRankingLessThan(max);
    }

    //Upload documento

    @PostMapping("/caricafile")
    public String caricaFile(@RequestParam("file") MultipartFile file){

        String infoFile = file.getOriginalFilename()+" "+file.getContentType();
        String conFormat =String.format("%s-%s",file.getOriginalFilename(),file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);

        return conFormat;
    }





}
