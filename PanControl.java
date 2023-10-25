import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanControl {

    public static void read_csv(String archivoCSV, List<Consulta> consultas){
        try(BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null){
                String[] campos = linea.split(",");

                long DPI = Long.parseLong(campos[0]);
                String nombrePaciente = campos[1];
                int edad = Integer.parseInt(campos[2]);
                int dia = Integer.parseInt(campos[3]);
                String mes = campos[4];
                int año = Integer.parseInt(campos[5]);
                String nombreDoctor = campos[6];
                String sintomasPaciente = campos[7];
                String diagnostico = campos[8];
                String descripcion = campos[9];

                Consulta agregarConsulta = new Consulta(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion);
                consultas.add(agregarConsulta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void NuevaConsulta(List<Consulta> consultas){
        int cantidad = Vista.pedirEntero("Ingrese la cantidad de consultas que deseea ingresar");

        for (int i = 0; i < cantidad; i++) {
            int num = i + 1;
            System.out.println("");
            System.out.println("-+ Ingrese los datos de paciente " + num + " +-");
            long DPI = Vista.pedirLong("Ingrese el DPI del paciente");
            String nombrePaciente = Vista.pedirCadena("Ingrese el nombre del paciente");
            int edad = Vista.pedirEntero("Ingrese la edad del paciente");
            int dia = Vista.pedirEntero("Ingrese el dia de la consulta (ejemplo: 19)");
            String mes = Vista.pedirCadena("Ingrese el mes (ejemplo: noviembre)"); 
            int año = Vista.pedirEntero("Ingrese el año de la consulta (2023)");
            String nombreDoctor = Vista.pedirCadena("Ingrese el nombre del medico");
            String sintomasPaciente = Vista.pedirCadena("Ingrese los sintomas presentados por el paciente");
            String diagnostico = Vista.pedirCadena("Ingrese el diagnostico del paciente");
            String descripcion = Vista.pedirCadena("Ingrese una descripción" );

            Consulta agregarConsulta = new Consulta(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion);
            consultas.add(agregarConsulta);

        }
    }

    public static void buscarDPI(int DPI, List<Consulta> consultas){
        long DPIespacio = 0;
        String estado = "";
        for (Consulta consulta : consultas){
            DPIespacio = consulta.getDPI();
            if (DPIespacio == DPI){
                estado = consulta.toString();
                System.out.println(estado);
                return;
            }
        }
        System.out.println();
    }


    
}
