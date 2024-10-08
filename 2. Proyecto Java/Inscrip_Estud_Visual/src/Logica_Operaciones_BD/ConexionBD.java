
package Logica_Operaciones_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD 
{
    //jdbc:oracle:thin:@//<host>:<port>:<SID>
    private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
    private static final String DB_USER = "USER_INSCRIPCIONES";
    private static final String DB_PASSWORD = "itb";
    
    public static Connection iniciarConexion()
    {
        Connection conexion = null;
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexion = (Connection) DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            if (conexion != null)
            {
                System.out.println("Estado de conexión a la BD: Correcto.");
            }
        }
        catch(ClassNotFoundException err)
        {
            System.out.println("No se localiza la clase del manejador de la BD (OracleDriver).");
            err.printStackTrace();
        }
        catch(SQLException err)
        {
            System.out.println("Estado de conexión a la BD: Incorrecto.");
            err.printStackTrace();
        }        
        return conexion;  
    }    
}
