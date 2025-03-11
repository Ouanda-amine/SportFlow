package org.example.sportflow.bean;

public class Entraineur {
    private int ident;
    private String name;
    private String specialite;
    private String roole ;

    public Entraineur(String name, String specialite, String roole) {
        this.name = name;
        this.specialite = specialite;
        this.roole = roole;
    }

    public int getIdent() {
        return ident;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getRoole() {
        return roole;
    }

    public void setRoole(String roole) {
        this.roole = roole;
    }
}
