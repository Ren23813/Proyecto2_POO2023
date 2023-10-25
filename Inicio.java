import java.util.ArrayList;
import java.util.List;

public class Inicio {
    public static void main(String[] args) {



        System.out.println("Bienvenido al programa de consultas");
        List<Consulta> consultas = new ArrayList<>();

        while (true) {
            //llamar a la clase Menu para mostrar al usuario las opciones del menu
            int opcion = Vista.mostrarmenu();

            //opciones del menú
            switch (opcion) {
                case 1:
                  //registrar nuevo paciente
                    PanControl.NuevaConsulta(consultas);
                    break;

                case 2:
                  // agregar registro de paciente csv
                    String ruta = Vista.pedirCadena("Ingrese la ruta o nombre del archivo");
                    PanControl.read_csv(ruta, consultas);
                    
                    break;

                case 3:
                  //consultar paciente sin guardar
                    int dpi = Vista.pedirEntero("Ingrese el numero de DPI del paciente que deseea consultar");
                    PanControl.buscarDPI(dpi, consultas);
                    break;

                case 4:
                  //consultar por fecha
                    
                    break;

                case 5:
                  //exportar
                    
                    break;
                
                case 0:
                    //Cierra el programa
                    System.out.print("Fin del programa");
                    System.exit(0);
                    break;

                default:
                    //PRogramación por si e ingresa un numero que no pertenece a ninguna opcion predefinida
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
