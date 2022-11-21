package contactos.Modelo;

public class contacto {
    private String id_Contactos;
    private String Nombres;
    private String Apellidos;
    private int Edad;
    
    public contacto(){
        
    }

    public contacto(String id_Contactos, String Nombres, String Apellidos, int Edad) {
        this.id_Contactos = id_Contactos;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Edad = Edad;
    }

    public String getId_Contactos() {
        return id_Contactos;
    }

    public void setId_Contactos(String id_Contactos) {
        this.id_Contactos = id_Contactos;
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
    
}
