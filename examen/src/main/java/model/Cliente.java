package model;

public class Cliente {
private static int id;
private String nombre;
private String Apaterno;
private String Amaterno;
private String curp;
private String fec_nac;

    public Cliente(String s, String elivar, String largo) {
    }

    public Cliente(int id, String nombre, String Apaterno, String Amaterno, String curp, String fec_nac) {
        this.id = id;
        this.nombre = nombre;
        this.Apaterno = Apaterno;
        this.Amaterno = Amaterno;
    }

    public static int getid() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return Apaterno;
    }

    public void setApaterno(String apaterno) {
        this.Apaterno = Apaterno;
    }

    public String getAmaterno() {
        return Amaterno;
    }

    public void setAmaterno(String Amaterno) {
        this.Amaterno = Amaterno;
    }
    public String getCurp() {
        return curp;
    }
    public void setCurp(String curp) {
    this.curp=curp;
    }
    public String getFec_nac() {
        return fec_nac;
    }
    public void setFec_nac(String fec_nac) {
        this.fec_nac = fec_nac;
    }
        @Override
    public String toString() {
        return this.id+", "+this.nombre+", "+this.Apaterno+", "+this.Amaterno+", "+this.curp+", "
                +", "+this.fec_nac;
    }
}



