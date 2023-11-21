public class Glucosa extends Consulta {
    private String niveles;

    public String getNiveles() {
        return niveles;
    }

    public void setNiveles(String niveles){
        this.niveles = niveles;
    }

    public Glucosa(long DPI, String nombrePaciente, int edad, int dia, String mes, int año, String nombreDoctor, 
            String sintomasPaciente, String diagnostico, String descripcion, int prueba, String niveles){
        super(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba);
        this.niveles = niveles;
    }

    public String toString(){
        return "DPI: " + getDPI() + ", Nombre del paciente: " + getNombrePaciente() + 
        ", Edad: " + getEdad() + ", El dia de la consulta fue el " + getDia() + " de " + getMes() + 
        " de " + getAño() + ", Nombre del doctor: " + getNombreDoctor() + ", Sintomas del paciente: " + getSintomasPaciente() + 
        ", Diagnóstico: " + getDiagnostico() + ", Descripción: " + getDescripcion() + "Niveles: " + getNiveles();
    }

}
