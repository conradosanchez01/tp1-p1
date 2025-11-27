public class App {
    public static void main(String[] args) {

     
        // Profesores
   
        Profesor prof1 = new Profesor("Carlos", "Gomez", 45, "25000333",
                                      "Matemática", 20, "Álgebra y Cálculo");
        Profesor prof2 = new Profesor("Ana", "Lopez", 38, "30000444",
                                      "Medicina", 15, "Anatomía y Fisiología");

       
        // creacion de materias con notas y profesores asignados
      
        Materia m1 = new Materia("Álgebra", prof1, 8.5);
        Materia m2 = new Materia("Cálculo", prof1, 9.0);
        Materia m3 = new Materia("Anatomía", prof2, 9.5);
        Materia m4 = new Materia("Fisiología", prof2, 8.0);

       
        // creacion de estudiantes, c/u con array de materias
       
        Materia[] materiasLucas = {m1, m2};
        Estudiante e1 = new Estudiante("Lucas", "Perez", 20, "45000111",
                                       "Ingeniería en Sistemas", materiasLucas);

        Materia[] materiasMaria = {m3, m4};
        Estudiante e2 = new Estudiante("María", "Martinez", 21, "45000222",
                                       "Medicina", materiasMaria);

     
        // creacion de personal
    
        Personal per1 = new Personal("Marta", "Lopez", 38, "40000444",
                                     "Administración", "Secretaria", "2015");

       
        // crear Universidad y agregar los miembros
    
        Universidad uni = new Universidad();
        uni.agregarMiembro(e1);
        uni.agregarMiembro(e2);
        uni.agregarMiembro(prof1);
        uni.agregarMiembro(prof2);
        uni.agregarMiembro(per1);

       
        // Listamos todos los miembros(polimorfismo)
        
        System.out.println("=== LISTA DE MIEMBROS ===");
        uni.listarMiembros();

       
        // calculamos y mostramos promedios iterativo y recursivo
        
        System.out.println("\n=== PROMEDIOS DE ESTUDIANTES ===");
        for (MiembroUniversidad m : new MiembroUniversidad[]{e1, e2}) {
            Estudiante est = (Estudiante) m;
            System.out.println(est.getNombre() + ":");
            System.out.println("Promedio iterativo: " + est.calcularPromedioIterativo());
            System.out.println("Promedio recursivo: " + est.obtenerPromedioRecursivo());
        }
    
    //contar estudiantes por carrera iterativo y recursivo

 System.out.println("--");
    System.out.println("Cantidad de estudiantes en Ingeniería en Sistemas (iterativo): " +
                   uni.contarEstudiantesIterativo("Ingeniería en Sistemas"));

    System.out.println("Cantidad de estudiantes en Ingeniería en Sistemas (recursivo): " +
                   uni.contarEstudiantesRecursivo("Ingeniería en Sistemas"));


//Busqueda de estudiante por documento iterarivo y recursivo
String docBuscar = "45000111"; // dni de lucas
Estudiante estRec = uni.buscarEstudianteRecursivo(docBuscar);
Estudiante estIter = uni.buscarEstudianteIterativo(docBuscar);

System.out.println("\n=== BÚSQUEDA DE ESTUDIANTE POR DOCUMENTO ===");
System.out.println("Recursivo: " + (estRec != null ? estRec.obtenerInformacionCompleta() : "No encontrado"));
System.out.println("Iterativo: " + (estIter != null ? estIter.obtenerInformacionCompleta() : "No encontrado"));




// Array de estudiantes a ordenar
Estudiante[] listaEstudiantes = {e1, e2};

// Ordenamos por apellido usando selection sort
Estudiante[] estudiantesOrdenados = Universidad.ordenarEstudiantesPorApellido(listaEstudiantes);

System.out.println("\n=== ESTUDIANTES ORDENADOS POR APELLIDO ===");
for (Estudiante e : estudiantesOrdenados) {
    System.out.println(e.getApellido() + ", " + e.getNombre());
}

//bscamos un estudiante por apellido mediante busqueda binaria(ordenado de antes)
String apellidoBuscar = "Martinez";
int indice = Universidad.busquedaBinariaEstudiantes(estudiantesOrdenados, apellidoBuscar);

System.out.println("\n=== BÚSQUEDA BINARIA POR APELLIDO ===");
if (indice != -1) {
    System.out.println("Estudiante encontrado: " + estudiantesOrdenados[indice].obtenerInformacionCompleta());
} else {
    System.out.println("No se encontró ningún estudiante con apellido " + apellidoBuscar);
}

}




}

