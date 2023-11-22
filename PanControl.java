import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PanControl {

    public static void read_csv(String archivoCSV, List<Consulta> consultas, List<Sangre> sangres, List<Glucosa> glucosas, List<Lab> labs){
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
                int prueba = Integer.parseInt(campos[10]);

                switch (prueba) {
                    case 1:
                        String tipo = campos[11];
                        Sangre consultSangre = new Sangre(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, tipo);
                        sangres.add(consultSangre);
                        consultas.add(consultSangre);
                        break;

                    case 2:
                        String niveles = campos[11];
                        Glucosa consultGlucosa = new Glucosa(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, niveles);
                        glucosas.add(consultGlucosa);
                        consultas.add(consultGlucosa);
                        break;

                    case 3:
                        String examen = campos[12];
                        Lab consultLab = new Lab(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, examen);
                        labs.add(consultLab);
                        consultas.add(consultLab);
                        break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void NuevaConsulta(List<Consulta> consultas, List<Sangre> sangres, List<Glucosa> glucosas, List<Lab> labs){
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
            int prueba = Vista.pedirEntero("Ingrese el numero del tipo de prueba (1.Sangre general / 2. Glucosa / 3. Laboratorio)");

            if (prueba == 1){
                String tipo = Vista.pedirCadena("Ingrese el tipo de sangre del paciente");
                Sangre consultSangre = new Sangre(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, tipo);
                sangres.add(consultSangre);
                consultas.add(consultSangre);
            } else if (prueba == 2){
                String niveles = Vista.pedirCadena("Ingrese los niveles de glucosa del paciente");
                Glucosa consultGlucosa = new Glucosa(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, niveles);
                glucosas.add(consultGlucosa);
                consultas.add(consultGlucosa);
            } else if (prueba == 3){
                String examen = Vista.pedirCadena("Ingrese los examen de laboratorio del paciente");
                Lab consultLab = new Lab(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba, examen);
                labs.add(consultLab);
                consultas.add(consultLab);
            } else {
                System.out.println("El dato que ingreso no se encuentra en la base de datos.");
            }

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
                System.out.println();
            }
        }
        
        if (estado.isEmpty()) {
            System.out.println("No se encontraron datos para el número ingresado.");
        }
    }
    
    public static List<Consulta> ordenarPorMes(String mes, List<Consulta> consultas) {
        List<Consulta> consultasFiltradas = new ArrayList<>();
        for (Consulta consulta : consultas) {
            if (consulta.getMes().equalsIgnoreCase(mes)) {
                consultasFiltradas.add(consulta);
            }
        }
        return consultasFiltradas;
    }

    public static void nuevoCSV(String DPI, List<Consulta> consultas, List<Sangre> sangres, List<Glucosa> glucosas, List<Lab> labs) {
        String nombreArchivo = DPI + "_historial_medico.csv";
        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            for (Sangre consulta : sangres) {
                if (consulta.getDPI() == Long.parseLong(DPI) & consulta.getPrueba() == 1) {
                    writer.append(Long.toString(consulta.getDPI()));
                    writer.append(",");
                    writer.append(consulta.getNombrePaciente());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getEdad()));
                    writer.append(",");
                    writer.append(consulta.getNombreDoctor());
                    writer.append(",");
                    writer.append(consulta.getSintomasPaciente());
                    writer.append(",");
                    writer.append(consulta.getDiagnostico());
                    writer.append(",");
                    writer.append(consulta.getDescripcion());
                    writer.append(",");
                    writer.append(consulta.getDia() + "/" + consulta.getMes() + "/" + consulta.getAño());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getPrueba()));
                    writer.append(",");
                    writer.append(consulta.getTipo());
                    writer.append(",");
                    writer.append(",");
                    writer.append("\n");
                }
            }
            for (Glucosa consulta : glucosas) {
                if (consulta.getDPI() == Long.parseLong(DPI) & consulta.getPrueba() == 2) {
                    writer.append(Long.toString(consulta.getDPI()));
                    writer.append(",");
                    writer.append(consulta.getNombrePaciente());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getEdad()));
                    writer.append(",");
                    writer.append(consulta.getNombreDoctor());
                    writer.append(",");
                    writer.append(consulta.getSintomasPaciente());
                    writer.append(",");
                    writer.append(consulta.getDiagnostico());
                    writer.append(",");
                    writer.append(consulta.getDescripcion());
                    writer.append(",");
                    writer.append(consulta.getDia() + "/" + consulta.getMes() + "/" + consulta.getAño());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getPrueba()));
                    writer.append(",");
                    writer.append(",");
                    writer.append(consulta.getNiveles());
                    writer.append(",");
                    writer.append("\n");
                }
            }
            for (Lab consulta : labs) {
                if (consulta.getDPI() == Long.parseLong(DPI) & consulta.getPrueba() == 3) {
                    writer.append(Long.toString(consulta.getDPI()));
                    writer.append(",");
                    writer.append(consulta.getNombrePaciente());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getEdad()));
                    writer.append(",");
                    writer.append(consulta.getNombreDoctor());
                    writer.append(",");
                    writer.append(consulta.getSintomasPaciente());
                    writer.append(",");
                    writer.append(consulta.getDiagnostico());
                    writer.append(",");
                    writer.append(consulta.getDescripcion());
                    writer.append(",");
                    writer.append(consulta.getDia() + "/" + consulta.getMes() + "/" + consulta.getAño());
                    writer.append(",");
                    writer.append(Integer.toString(consulta.getPrueba()));
                    writer.append(",");
                    writer.append(",");
                    writer.append(",");
                    writer.append(consulta.getExamen());
                    writer.append("\n");
                }
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean validarRutaArchivoCsv(String ruta) {
        // Verificar que la ruta no esté vacía
        if (ruta == null || ruta.isEmpty()) {
            System.out.println("Error: La ruta del archivo no puede estar vacía.");
            return false;
        }

        // Crear un objeto File con la ruta proporcionada
        File archivo = new File(ruta);

        // Verificar que el archivo exista
        if (!archivo.exists()) {
            System.out.println("Error: El archivo no existe en la ruta especificada.");
            return false;
        }

        // Verificar que el archivo tenga la extensión CSV
        String nombreArchivo = archivo.getName();
        if (!nombreArchivo.toLowerCase().endsWith(".csv")) {
            System.out.println("Error: El archivo no tiene la extensión CSV.");
            return false;
        }

        // La ruta del archivo CSV es válida
        return true;
    }
}