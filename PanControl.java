import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanControl {

    List<Consulta> consultas = new ArrayList<>();

    public static void read_csv(String archivoCSV, List<Consulta> consultas){
        try(BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null){
                String[] campos = linea.split(",");

                long DPI = Long.parseLong(campos[0]);
                String nombrePaciente = campos[1];
                int edad = Integer.parseInt(campos[2]);
                String nombreDoctor = campos[3];
                String sintomasPaciente = campos[4];
                String diagnostico = campos[5];
                String descripcion = campos[6];

                Consulta agregarConsulta = new Consulta(DPI, nombrePaciente, edad, nombreDoctor, sintomasPaciente, diagnostico, descripcion);
                consultas.add(agregarConsulta);
            }
        } catch (Exception e) {
            e.printStackTrace();
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
