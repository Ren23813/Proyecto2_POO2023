/**
 * Clase que representa una consulta médica.
 * Esta clase almacena información esencial sobre una consulta médica. Contiene el DPI del paciente,
 * el nombre del paciente, la edad, el nombre del doctor, los síntomas del paciente, el diagnóstico
 * y una descripción adicional de la consulta.
 * 
 * @author Renato R.
 * @version 1.0
 * @since 22/10/23
 * Comentado Javadoc por ChatGPT
 */
public class Consulta {

    private long DPI; // DPI del paciente
    private String nombrePaciente; // Nombre del paciente
    private int edad; // Edad del paciente
    private int dia; //dia de la consulta
    private String mes; // mes de la consulta
    private int año; //año de la consulta


    

    private String nombreDoctor; // Nombre del doctor
    private String sintomasPaciente; // Síntomas del paciente
    private String diagnostico; // Diagnóstico de la consulta
    private String descripcion; // Descripción adicional de la consulta

    /**
     * Constructor para crear una instancia de Consulta.
     * 
     * @param DPI DPI del paciente
     * @param nombrePaciente Nombre del paciente
     * @param edad Edad del paciente
     * @param dia Día de la consulta
     * @param mes Mes de la consulta 
     * @param año año de la consulta
     * @param nombreDoctor Nombre del doctor
     * @param sintomasPaciente Síntomas del paciente
     * @param diagnostico Diagnóstico de la consulta
     * @param descripcion Descripción adicional de la consulta
     */
    public Consulta(long DPI, String nombrePaciente, int edad, int dia, String mes, int año, String nombreDoctor, String sintomasPaciente, String diagnostico, String descripcion) {
        this.DPI = DPI;
        this.nombrePaciente = nombrePaciente;
        this.edad = edad;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.nombreDoctor = nombreDoctor;
        this.sintomasPaciente = sintomasPaciente;
        this.diagnostico = diagnostico;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el DPI del paciente.
     * 
     * @return El DPI del paciente.
     */
    public long getDPI() {
        return DPI;
    }

    /**
     * Obtiene el nombre del paciente.
     * 
     * @return El nombre del paciente.
     */
    public String getNombrePaciente() {
        return nombrePaciente;
    }

    /**
     * Obtiene la edad del paciente.
     * 
     * @return La edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene el dia de la consulta.
     * 
     * @return El dia de la consulta
     */
    public int getDia() {
        return dia;
    }

    /**
     * Obtiene el mes de la consulta.
     * 
     * @return El mes de la consulta
     */
    public String getMes() {
        return mes;
    }
    
    /**
     * Obtiene el año de la consulta.
     * 
     * @return El año de la consulta
     */
    public int getAño() {
        return año;
    }

    /**
     * Obtiene el nombre del doctor.
     * 
     * @return El nombre del doctor.
     */
    public String getNombreDoctor() {
        return nombreDoctor;
    }

    /**
     * Obtiene los síntomas del paciente.
     * 
     * @return Los síntomas del paciente.
     */
    public String getSintomasPaciente() {
        return sintomasPaciente;
    }

    /**
     * Obtiene el diagnóstico de la consulta.
     * 
     * @return El diagnóstico de la consulta.
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * Obtiene la descripción adicional de la consulta.
     * 
     * @return La descripción adicional de la consulta.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece el DPI del paciente.
     * 
     * @param DPI El DPI del paciente.
     */
    public void setDPI(long DPI) {
        this.DPI = DPI;
    }

    /**
     * Establece el nombre del paciente.
     * 
     * @param nombrePaciente El nombre del paciente.
     */
    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    /**
     * Establece la edad del paciente.
     * 
     * @param edad La edad del paciente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Establece el dia de la consulta.
     * 
     * @param dia dia de la consulta.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Establece el mes de la consulta.
     * 
     * @param mes mes de la consulta.
     */
    public void setMes(String mes) {
        this.mes = mes;
    }

    /**
     * Establece el año de la consulta.
     * 
     * @param año año de la consulta.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Establece el nombre del doctor.
     * 
     * @param nombreDoctor El nombre del doctor.
     */
    public void setNombreDoctor(String nombreDoctor) {
        this.nombreDoctor = nombreDoctor;
    }

    /**
     * Establece los síntomas del paciente.
     * 
     * @param sintomasPaciente Los síntomas del paciente.
     */
    public void setSintomasPaciente(String sintomasPaciente) {
        this.sintomasPaciente = sintomasPaciente;
    }

    /**
     * Establece el diagnóstico de la consulta.
     * 
     * @param diagnostico El diagnóstico de la consulta.
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * Establece la descripción adicional de la consulta.
     * 
     * @param descripcion La descripción adicional de la consulta.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toString(){
        return "DPI: " + getDPI() + ", Nombre del paciente: " + getNombrePaciente() + ", Edad: " + getEdad() + ", El dia de la consulta fue el " + getDia() + " de " + getMes() + " de " + getAño() + ", Nombre del doctor: " + getNombreDoctor() + ", Sintomas del paciente: " + getSintomasPaciente() + ", Diagnóstico: " + getDiagnostico() + ", Descripción: " + getDescripcion();
    }

}
