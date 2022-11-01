package com.example.recyclerview;

public class Contact {

    private String nom;
    private String num;

    public Contact(String nom, String num) {
        this.nom = nom;
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
