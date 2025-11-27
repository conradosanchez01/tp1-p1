public class Materia {

    private String materiaNombre;
    private Profesor profesor;
     private double nota; // nueva

    public Materia(String materiaNombre, Profesor profesor, double nota) {
        this.materiaNombre = materiaNombre;
        this.profesor = profesor;
         this.nota = nota;
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
    public double getNota() 
    { return nota; }
    public void setNota(double nota) 
    { this.nota = nota; }
    
    @Override
    public String toString() {
        return materiaNombre + " (Profesor: " + profesor.getNombre() + ")";
    }

}