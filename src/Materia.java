public class Materia {
    
private String materiaNombre;
private Profesor profesor;

 public Materia(String materiaNombre, Profesor profesor) {
        this.materiaNombre = materiaNombre;
        this.profesor = profesor;
    }



    public String getMateriaNombre() {
    return materiaNombre;
    }
    public void setMateriaNombre(String materiaNombre) {
    this.materiaNombre = materiaNombre;
    }

  public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }


 @Override
    public String toString() {
        return materiaNombre + " (Profesor: " + profesor.getNombre() + ")";
    }






}