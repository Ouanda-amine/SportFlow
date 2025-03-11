package org.example.sportflow.bean;

import java.util.Date;

public class Membre {

    private int id;
    private String nom;
    private String sportpratique ;
    private Date datenaissance;
    private String role ;

    public Membre( String nom, String sportpratique, Date datenaissance , String role ) {

        this.nom = nom;
        this.sportpratique = sportpratique;
        this.datenaissance = datenaissance;
        this.role = role;
    }

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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;

    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
