package com.example.myfirsttest;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Users {
    String nom;
    String prenom;
    @Generated(hash = 1738545225)
    public Users(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
    @Generated(hash = 2146996206)
    public Users() {
    }
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

}
