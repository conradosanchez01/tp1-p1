
public class Profesor  extends Persona  implements MiembroUniversidad
{
 private String especialidad;
 private int añosExperiencia;
 private String materiasAsignadas;

  //constructor
  public Profesor (String nombre, String apellido,
   int edad, String documento, String especialidad, 
   int añosExperiencia, String materiasAsignadas )
  {
    super (nombre,apellido,edad,documento);
    this.especialidad = especialidad;
    this.añosExperiencia = añosExperiencia;
    this.materiasAsignadas = materiasAsignadas ;
  }

  //getters y setters 
   public String getEspecialidad () 
   {
    return especialidad;
   }

   public void setEspecialidad (String especialidad) 
   {
    this.especialidad = especialidad;
   }
   public int getAñosExperiencia () 
   {
    return añosExperiencia;
   }

   public void setAñosExperiencia (int añosExperiencia) 
   {
    this.añosExperiencia = añosExperiencia;
   }

   public String getMateriasAsignadas () 
   {
    return materiasAsignadas;
   }

   public void setMateriasAsignadas (String materiasAsignadas) 
   {
    this.materiasAsignadas = materiasAsignadas;
   }

    @Override
    public String obtenerRol() {
        return "profesor";
    }
    @Override
    public String obtenerInformacionCompleta() {
        return "profesor: " +getNombre() + " " + getApellido() +
        "-especialidad: " +especialidad +
        "-años de experiencia: " +añosExperiencia +
        "-materias: " +materiasAsignadas;
    }

    @Override
    public String toString() {
        return obtenerInformacionCompleta();
    }
}
