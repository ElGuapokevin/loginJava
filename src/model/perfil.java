package model;

public class perfil {
    int perfilCod;
    String nombre;
    String apellido;
    int telefono;

    public perfil(int perfilCod, String nombre, String apellido, int telefono) {
        this.perfilCod = perfilCod;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public perfil() {
    }

    public int getPerfilCod() {
        return perfilCod;
    }

    public void setPerfilCod(int perfilCod) {
        this.perfilCod = perfilCod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
    
    
}
