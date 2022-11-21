
package contactos.Modelo;

public class Contacto {
    private String IdContactos;
    private String Nombres;      
    private String Apellidos;
    private int Edad;
    
    public Contacto(){
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

    public String getNombres() {
        return Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public int getEdad() {
        return Edad;
    }

    public void setIdContactos(String IdContactos) {
        this.IdContactos = IdContactos;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    } 
}
