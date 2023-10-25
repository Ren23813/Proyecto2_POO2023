import java.util.Scanner;

public class Vista {
    public static int mostrarmenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("+- Opciones del menu proncipal -+");
        System.out.println("1. Registrar nueva consulta");
        System.out.println("2. Agregar registro de paciente (leer csv)");
        System.out.println("3. Consultar de un paciente específico");
        System.out.println("4. Consultar el último mes del hospital");
        System.out.println("5. Exportar datos de un paciente específico (guardar en csv)");
        System.out.println("0. Salir");
        System.out.println("");

        System.out.println("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        
        return opcion;
    }

    public static int pedirEntero(String mensaje) {
        Scanner scanneri = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        int num = scanneri.nextInt();
        
        return num;
    }

    public static String pedirCadena(String mensaje) {
        Scanner scanners = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        String s = scanners.nextLine();
        
        return s;
    }

    public static long pedirLong(String mensaje) {
        Scanner scannerl = new Scanner(System.in);
        System.out.print(mensaje + ": ");
        long lo = scannerl.nextLong();
    
        return lo;
    }
    
}