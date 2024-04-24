package com.example.oblig3;

public class Billetter {
    private String film;
    private int antall;
    private String fornavn;
    private String etternavn;
    private String epost;
    private String telefon;
    private int id;

    public Billetter() {
    }

    public Billetter(String film, int antall, String fornavn, String etternavn, String epost, String telefon, int id) {
        this.film = film;
        this.antall = antall;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.epost = epost;
        this.telefon = telefon;
        this.id = id;
    }

    public String getFilm() {
        return this.film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public int getAntall() {
        return this.antall;
    }

    public void setAntall(int antall) {
        this.antall = antall;
    }

    public String getFornavn() {
        return this.fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return this.etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getEpost() {
        return this.epost;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public String getTelefon() {
        return this.telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
