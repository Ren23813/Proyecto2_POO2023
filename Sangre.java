public class Sangre extends Consulta {
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public Sangre(long DPI, String nombrePaciente, int edad, int dia, String mes, int año, String nombreDoctor, 
            String sintomasPaciente, String diagnostico, String descripcion, int prueba, String tipo){
        super(DPI, nombrePaciente, edad, dia, mes, año, nombreDoctor, sintomasPaciente, diagnostico, descripcion, prueba);
        this.tipo = tipo;
    }

    public String toString(){
        return "DPI: " + getDPI() + ", Nombre del paciente: " + getNombrePaciente() + 
        ", Edad: " + getEdad() + ", El dia de la consulta fue el " + getDia() + " de " + getMes() + 
        " de " + getAño() + ", Nombre del doctor: " + getNombreDoctor() + ", Sintomas del paciente: " + getSintomasPaciente() + 
        ", Diagnóstico: " + getDiagnostico() + ", Descripción: " + getDescripcion() + ", Prueba: " + getPrueba() + ", Tipo: " + getTipo();
    }

}
