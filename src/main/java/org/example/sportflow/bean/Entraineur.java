package org.example.sportflow.bean;

public class Entraineur {
    private int ident;
    private String name;
    private String specialite;
    private String roole ;
    private String usrname ;
    private  String psw ;

    public Entraineur(String name, String specialite, String roole , String usrname , String psw) {
        this.name = name;
        this.specialite = specialite;
        this.roole = roole;
        this.usrname = usrname;
        this.psw = psw;

    }
    public Entraineur() {}

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
    public String getUsrname() {
        return usrname;
    }
    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }
    public String getPsw() {
        return psw;
    }
    public void setPsw(String psw) {
        this.psw = psw;
    }
}
