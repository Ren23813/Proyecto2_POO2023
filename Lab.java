public class Lab extends Consulta {
    private String examen;

    public String getExamen() {
        return examen;
    }

    public void setExamen(String examen){
        this.examen = examen;
    }

    public Lab(long DPI, String nombrePaciente, int edad, int dia, String mes, int año, String nombreDoctor, 
            String sintomasPaciente, String diagnostico, String descripcion, int prueba, String examen){
        super(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba);
        this.examen = examen;
    }

    public String toString(){
        return "DPI: " + getDPI() + ", Nombre del paciente: " + getNombrePaciente() + 
        ", Edad: " + getEdad() + ", El dia de la consulta fue el " + getDia() + " de " + getMes() + 
        " de " + getAño() + ", Nombre del doctor: " + getNombreDoctor() + ", Sintomas del paciente: " + getSintomasPaciente() + 
        ", Diagnóstico: " + getDiagnostico() + ", Descripción: " + getDescripcion() + ", Prueba: " + getPrueba() + ", Examen: " + getExamen();
    }

}
