package contactos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion2 {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/Listado";
    private static final String user = "root";
    private static final String pass = "";
    
    public static Connection conectar(){
        Connection conex = null;
        
        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException ex){
            System.out.println("No existe la Base de Datos");
            System.out.println(System.getProperties());
        }catch(SQLException sqlex){
//            sqlex.printStackTrace();
            System.out.println("Error de entrada de datos " + sqlex);
        }
        return conex;
    }
    
}
