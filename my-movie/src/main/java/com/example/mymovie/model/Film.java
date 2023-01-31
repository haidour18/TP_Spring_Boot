package com.example.mymovie.model;

import java.util.Date;

public class Film {
    // un titre, réalisateur, acteur principal et date de sortie.
     String titre;
     String realisateur;
  String  date;

  Acteur acteur;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public Film(String titre, String realisateur, String datecreation, Acteur acteurPrincipal) {
        this.titre = titre;
        this.realisateur = realisateur;
        this.date = datecreation;
        this.acteur=acteurPrincipal;
    }
}
