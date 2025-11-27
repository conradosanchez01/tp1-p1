public class Estudiante extends Persona implements MiembroUniversidad {
  private String carrera;
  private double promedio;
  private int materias;
   private Materia[] materiasEstudiante; // array de materias con nota
  // constructor

    public Estudiante(String nombre, String apellido, int edad, String documento,
                      String carrera, Materia[] materiasEstudiante) {
        super(nombre, apellido, edad, documento);
        this.carrera = carrera;
        this.materias = materiasEstudiante.length;
        this.materiasEstudiante = materiasEstudiante;
        this.promedio = calcularPromedioIterativo(); // inicializa promedio
  }

  // getters y setters

  public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) { this.carrera = carrera; }

    public double getPromedio() { return promedio; }
    public void setPromedio(double promedio) { this.promedio = promedio; }

    public int getMaterias() { return materias; }

    public Materia[] getMateriasEstudiante() { return materiasEstudiante; }
    public void setMateriasEstudiante(Materia[] materiasEstudiante) {
        this.materiasEstudiante = materiasEstudiante;
        this.materias = materiasEstudiante.length;
        this.promedio = calcularPromedioIterativo();
    }

//

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


    // calculos de promedio
   // version iterativa
    public double calcularPromedioIterativo() {
        double suma = 0;
        for (Materia m : materiasEstudiante) {
            suma += m.getNota();
        }
        return materiasEstudiante.length > 0 ? suma / materiasEstudiante.length : 0;
    }


  // version recursiva
public static double calcularPromedioRecursivo(Materia[] materias, int indice) {
    if (indice == materias.length) return 0;
    return materias[indice].getNota() + calcularPromedioRecursivo(materias, indice + 1);
}
// obtener
public double obtenerPromedioRecursivo() {
    return materiasEstudiante.length > 0 ?
           calcularPromedioRecursivo(materiasEstudiante, 0) / materiasEstudiante.length : 0;
}







}
