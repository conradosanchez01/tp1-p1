public class Estudiante extends Persona implements MiembroUniversidad {
  private String carrera;
  private double promedio;
  private int materias;
  // constructor

  public Estudiante(String nombre, String apellido, int edad, String documento, String carrera,
      double promedio, int materias)
  // Llamamos al constructor de la clase base Persona
  {
    super(nombre, apellido, edad, documento);
    this.carrera = carrera;
    this.promedio = promedio;
    this.materias = materias;
  }

  // getters y setters

  public String getCarrera() {
    return carrera;
  }

  public void setCarrera(String carrera) {
    this.carrera = carrera;
  }

  public double getPromedio() {
    return promedio;
  }

  public void setPromedio(double promedio) {
    this.promedio = promedio;
  }

  public int getMaterias() {
    return materias;
  }

  public void setMaterias(int materias) {
    this.materias = materias;
  }

  @Override
  public String obtenerRol() {
    return "Estudiante";
  }

  @Override
  public String obtenerInformacionCompleta() {
    return "Estudiante:" + getNombre() + " " + getApellido() +
    " -carrera:" + carrera +
    " -promedio:" + promedio +
    " -materias:" + materias;
  }

  @Override
  public String toString() {
    return obtenerInformacionCompleta();
  }
}
