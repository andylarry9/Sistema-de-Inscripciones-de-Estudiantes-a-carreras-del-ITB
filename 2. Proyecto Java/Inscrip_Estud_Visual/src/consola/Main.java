package consola;

import Logica_Operaciones_BD.OperacionesCRUD;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        
        // Crear una instancia de OperacionesCRUD
        OperacionesCRUD operaciones = OperacionesCRUD.getInstance();
        Scanner scanner = new Scanner(System.in);
        int opcion;
// Bucle del menú principal
        do {
            opcion = menuOpciones();
            switch (opcion) {
                case 1:
                    try {
                        int totalCarreras = operaciones.obtenerCantCarreras();
                        System.out.println("Total de carreras que oferta el ITB: " + totalCarreras);
                    } catch (SQLException e) {
                        System.err.println("Error al obtener el total de carreras: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Listado de carreras del ITB:");
                        for (String carrera : operaciones.obtenerListadoCarreras()) {
                            System.out.println(carrera);
                        }
                    } catch (SQLException e) {
                        System.err.println("Error al obtener el listado de carreras: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);
        
        scanner.close();
    }
        
    
    
    public static int menuOpciones(){
Scanner scanner = new Scanner(System.in);
        int opcion = 0;
       
        // Mostrar las opciones del menú
        System.out.println("\nMENU");
        System.out.println("1. Ver el total de carreras que oferta el ITB");
        System.out.println("2. Ver listado de carreras del ITB");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        
        // Leer la opción seleccionada por el usuario
        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
        } else {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next(); // Limpiar entrada no válida
        }
        
        return opcion;
    }
    
}
