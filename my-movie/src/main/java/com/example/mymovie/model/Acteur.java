package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Acteur {

    @ApiModelProperty(notes = "Name of the actor",name="nom",required=true,value="test name")

    String nom;
    @ApiModelProperty(notes = "Prenom of the actor",name="prenom",required=true,value="test prenom")

String prenom;

    @ApiModelProperty(notes = "Prenom of the actor",name="dateNaissance",required=true,value="test dateNaissance")

    String dateNaissance;



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }



    public Acteur(String nom, String prenom, String dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }
}
