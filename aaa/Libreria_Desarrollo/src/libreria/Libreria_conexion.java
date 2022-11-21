package libreria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Libreria_conexion {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/libreria";
    private static final String user = "root";
    private static final String pass = "";
    
    Connection conex;
    
    public static Connection conectar(){
        Connection conex = null;
        try{
            Class.forName(driver);
            conex = DriverManager.getConnection(url,user,pass);
            System.out.println("Conexion exitosa");
        }catch(ClassNotFoundException ex){
            System.out.println("No existe la Base de Datos");
            System.out.println( System.getProperties());
        }catch(SQLException sqlex){
            //sqlex.printStackTrace();
            System.out.println("Error de entrada de datos" + sqlex);
        }
        return conex;
    }
    
    public Connection getConnection() {
        return conex;
	}
    
    public void setConnection(Connection connection) {
        this.conex = connection;
	}
    
    public void establecerConexion() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conex = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
    
    public void cerrarConexion(){
		try {
			conex.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}