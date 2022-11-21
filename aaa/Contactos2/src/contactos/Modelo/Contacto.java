package contactos.Modelo;

import java.util.Objects;

public class Contacto {
    private String IdContactos;
    private String Nombres;
    private String Apellidos;
    private int Edad;

    public Contacto() {
    }
    
   public Contacto(String IdContactos, String Nombres, String Apellidos, int Edad) {
        this.IdContactos = IdContactos;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
    }

    public String getIdContactos() {
        return IdContactos;
    }

    public void setIdContactos(String IdContactos) {
        this.IdContactos = IdContactos;
    }
   
    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }
    
    @Override
    public String toString(){
        return Nombres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (this.Edad != other.Edad) {
            return false;
        }
        if (!Objects.equals(this.Nombres, other.Nombres)) {
            return false;
        }
        if (!Objects.equals(this.Apellidos, other.Apellidos)) {
            return false;
        }
        return true;
    }
}