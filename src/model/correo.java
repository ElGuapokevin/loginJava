package model;

public class correo  {
    int correoID;
    int perfilID;
    String correo;
    String contracena;

    public correo(int correoID, int perfilID, String correo, String contracena) {
        this.correoID = correoID;
        this.perfilID = perfilID;
        this.correo = correo;
        this.contracena = contracena;
    }

    public correo() {
    }

    public int getCorreoID() {
        return correoID;
    }

    public void setCorreoID(int correoID) {
        this.correoID = correoID;
    }

    public int getPerfilID() {
        return perfilID;
    }

    public void setPerfilID(int perfilID) {
        this.perfilID = perfilID;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContracena() {
        return contracena;
    }

    public void setContracena(String contracena) {
        this.contracena = contracena;
    }
    
    
}
