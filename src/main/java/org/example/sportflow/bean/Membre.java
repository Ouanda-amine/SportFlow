package org.example.sportflow.bean;

import java.util.Date;

public class Membre {

    private int id;
    private String nom;
    private String sportpratique ;
    private String datenaissance;
    private String role ;
    private String username;
    private String password;

    public Membre( String nom,  String datenaissance ,String sportpratique, String role , String username, String password ) {

        this.nom = nom;
        this.sportpratique = sportpratique;
        this.datenaissance = datenaissance;
        this.role = role;
        this.username = username;
        this.password = password;
    }
    public Membre() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSportpratique() {
        return sportpratique;
    }

    public void setSportpratique(String sportpratique) {
        this.sportpratique = sportpratique;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;

    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getUsername() {

        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
