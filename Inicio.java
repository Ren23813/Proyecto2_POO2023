import java.util.List;
import java.util.ArrayList; 

public class Inicio {
    public static void main(String[] args) {



        System.out.println("Bienvenido al programa de consultas");
        List<Consulta> consultas = new ArrayList<>();
        List<Sangre> sangres = new ArrayList<>();
        List<Glucosa> glucosas = new ArrayList<>();
        List<Lab> labs = new ArrayList<>();

        while (true) {
            //llamar a la clase Menu para mostrar al usuario las opciones del menu
            int opcion = Vista.mostrarmenu();

            //opciones del menú
            switch (opcion) {
                case 1:
                  //registrar nuevo paciente
                    PanControl.NuevaConsulta(consultas, sangres, glucosas, labs);
                    break;

                case 2:
                  // agregar registro de paciente csv
                    String ruta = Vista.pedirCadena("Ingrese la ruta o nombre del archivo");
                    PanControl.read_csv(ruta, consultas, sangres, glucosas, labs);
                    
                    break;

                case 3:
                  //consultar paciente sin guardar
                    int dpi = Vista.pedirEntero("Ingrese el numero de DPI del paciente que deseea consultar");

                    PanControl.buscarDPI(dpi, consultas);
                    break;

                case 4:
                  //consultar por fecha
                  String mes = Vista.pedirCadena("Ingrese el mes a filtrar (Ejemplo: enero, febrero, marzo, ...)");
                  List<Consulta> consultasFiltradas = PanControl.ordenarPorMes(mes, consultas);
                  for (Consulta consulta : consultasFiltradas) {
                      System.out.println(consulta);
                  }
                  break;

                case 5:
                  //exportar
                  String dpiExport = Vista.pedirCadena("Ingrese el DPI del paciente cuyos datos desea exportar");
                  PanControl.nuevoCSV(dpiExport, consultas, sangres, glucosas, labs);
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
