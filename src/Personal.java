public class Personal extends Persona implements MiembroUniversidad {

    private String departamento;
    private String puesto;
    private String fechaIngreso;

    // constructor
    public Personal(String nombre, String apellido, int edad, String documento,
            String departamento, String puesto, String fechaIngreso) {
        super(nombre, apellido, edad, documento);
        this.departamento = departamento;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;

    }

    // getter y setter de Personal

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String obtenerRol() {
        return "personal";
    }

    @Override
    public String obtenerInformacionCompleta() {
        return "Personal: " + getNombre() + " " + getApellido() +
                "-departamento: " + departamento +
                "-puesto: " + puesto +
                "-ingreso: " + fechaIngreso;
    }

    @Override
    public String toString() {
        return obtenerInformacionCompleta();
    }

}
