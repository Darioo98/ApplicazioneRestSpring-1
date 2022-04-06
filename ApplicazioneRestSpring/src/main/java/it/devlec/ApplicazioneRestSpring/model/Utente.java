package it.devlec.ApplicazioneRestSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Utente {
    @Id
    @GeneratedValue
    private Long id;

    private String nome;
    private String cognome;

    private Date datadinascita;
    private Date datadiregistrazione;

    private float ranking;

    public Utente() {
    }

    public Utente(String nome, String cognome, Date dataNascita, Date dataDiRegistazione, float ranking) {
        this.nome = nome;
        this.cognome = cognome;
        this.datadinascita = dataNascita;
        this.datadiregistrazione = dataDiRegistazione;
        this.ranking = ranking;
    }

    public Utente(String nome, String cognome, Date dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.datadinascita = dataNascita;
    }

    public Utente(Long id, String nome, String cognome, Date dataNascita) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.datadinascita = dataNascita;
    }

    public Utente(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return datadinascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.datadinascita = dataNascita;
    }

    public Date getDataDiRegistazione() {
        return datadiregistrazione;
    }

    public void setDataDiRegistazione(Date dataDiRegistazione) {
        this.datadiregistrazione = dataDiRegistazione;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                '}';
    }
}
