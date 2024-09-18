
package Logica_Operaciones_BD;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public final class OperacionesCRUD 
{
    private static OperacionesCRUD lainstance = new OperacionesCRUD();
    private Connection conexion;

    private OperacionesCRUD() 
    {         
    }
    
    public static OperacionesCRUD getInstance()
    {
        return lainstance;
    }
    
    private void iniciarConexionBD()//INICIAR LA CONEXIONA LA BD
    {
        this.conexion = ConexionBD.iniciarConexion();
    }
    
    private void cerrarConexionBD() throws SQLException  //CERRAR LA CONEXION A LA BD
    {
        if (this.conexion != null && this.conexion.isClosed() == false) //valida si aun está habierta la conexion BD
        {
            this.conexion.close();
        }
    }    
    //inciso 1.
    public int obtenerCantCarreras() throws SQLException
    {
        //1. Conectar a la base de datos
            this.iniciarConexionBD();
        //2. Variable para almacenar el total de carreras almacenadas en la base de datos.
             int cantidad_carreras = 0;   
        //3. definir espacio de trabajo para la declaración y ejecución de la consulta sql
        Statement obj_hoja_sql = this.conexion.createStatement();

        //4. Definir el texto String de la consulta SQL.
            
        String sql = "select count(*)as total_carreras from carreras";
    
        //5. Ejecutar la consulta y almacenar en el objeto ResultSet
        ResultSet tabla = obj_hoja_sql.executeQuery(sql);
        //6. Recorrer el objeto ResultSet mediante un while y para cada iteración resolver:
        
        while (tabla.next()){
            cantidad_carreras = tabla.getInt("total_carreras");
        }
        

       //7. Cerrar la conexion a la base de datos    
               this.cerrarConexionBD();
        //8. Retornar el total de carreras que está almancenado en la base de datos
        return cantidad_carreras;
    }
    //inciso 2.
    public ArrayList<String> obtenerListadoCarreras() throws SQLException
    {
        //1. Conectar a la base de datos
               this.iniciarConexionBD();
        //2. Crear un objeto de ArrayList para almacenar la lista de nombres de carreras resultante de la consulta SQL.
         ArrayList<String> listadoCarreras = new ArrayList<>();
        //complete la lógica del bloque de código que resuelve: 
        //3. definir espacio de trabajo para la declaración y ejecución de la consulta sql
        Statement obj_hoja_sql = this.conexion.createStatement();
        //4. Definir el texto String de la consulta SQL.
         String sql = "select nombre as nombre_carrera from carreras";
        //5. Ejecutar la consulta y almacenar en el objeto ResultSet
        ResultSet tabla = obj_hoja_sql.executeQuery(sql);
        //6. Recorrer el objeto ResultSet mediante un while y para cada iteración resolver:
        while (tabla.next()){
            listadoCarreras.add(tabla.getString("nombre_carrera"));
        }
        //7. Cerrar la conexion a la base de datos       
         this.cerrarConexionBD();
        //8. Retornar el objeto de ArrayList con la lista de nombres de carreras almacenados en la base de datos
          return listadoCarreras;
    }
    
}
