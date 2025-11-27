public class App {
    public static void main(String[] args) {

     
        // Profesores
   
        Profesor prof1 = new Profesor("Carlos", "Gomez", 45, "25000333",
                                      "Matemática", 20, "Álgebra y Cálculo");
        Profesor prof2 = new Profesor("Ana", "Lopez", 38, "30000444",
                                      "Medicina", 15, "Anatomía y Fisiología");

       
        // Materias con notas
      
        Materia m1 = new Materia("Álgebra", prof1, 8.5);
        Materia m2 = new Materia("Cálculo", prof1, 9.0);
        Materia m3 = new Materia("Anatomía", prof2, 9.5);
        Materia m4 = new Materia("Fisiología", prof2, 8.0);

       
        // Estudiantes con array de materias
       
        Materia[] materiasLucas = {m1, m2};
        Estudiante e1 = new Estudiante("Lucas", "Perez", 20, "45000111",
                                       "Ingeniería en Sistemas", materiasLucas);

        Materia[] materiasMaria = {m3, m4};
        Estudiante e2 = new Estudiante("María", "Martinez", 21, "45000222",
                                       "Medicina", materiasMaria);

     
        // Personal
    
        Personal per1 = new Personal("Marta", "Lopez", 38, "40000444",
                                     "Administración", "Secretaria", "2015");

       
        // Universidad y agregamos miembros
    
        Universidad uni = new Universidad();
        uni.agregarMiembro(e1);
        uni.agregarMiembro(e2);
        uni.agregarMiembro(prof1);
        uni.agregarMiembro(prof2);
        uni.agregarMiembro(per1);

       
        // Listamos todos los miembros
        
        System.out.println("=== LISTA DE MIEMBROS ===");
        uni.listarMiembros();

       
        // Mostramos promedios iterativo y recursivo
        
        System.out.println("\n=== PROMEDIOS DE ESTUDIANTES ===");
        for (MiembroUniversidad m : new MiembroUniversidad[]{e1, e2}) {
            Estudiante est = (Estudiante) m;
            System.out.println(est.getNombre() + ":");
            System.out.println("Promedio iterativo: " + est.calcularPromedioIterativo());
            System.out.println("Promedio recursivo: " + est.obtenerPromedioRecursivo());
        }
    }
}
