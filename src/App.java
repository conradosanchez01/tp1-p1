public class App {
    public static void main(String[] args) throws Exception {
        

        Universidad uni = new Universidad();

        // miembros

        Estudiante e1 = new Estudiante("Lucas", "Perez", 20, "45000111", "Ingeniería en Sistemas", 8.5, 6);
        Estudiante e2 = new Estudiante("María", "Martinez", 22, "43000222", "Medicina", 9.0, 8);

        Profesor p1 = new Profesor("Carlos", "Gomez", 45, "25000333", "Matemática", 20, "Álgebra y Cálculo");
        Profesor p2 = new Profesor("Ana", "Lopez", 50, "27000444", "Medicina", 25, "Anatomía y Fisiología");

        Personal per1 = new Personal("Marta", "Lopez", 38, "30000444", "Administración", "Secretaria", "2015");
        Personal per2 = new Personal("Juan", "Ramirez", 30, "31000555", "Mantenimiento", "Técnico", "2018");

        uni.agregarMiembro(e1);
        uni.agregarMiembro(e2);
        uni.agregarMiembro(p1);
        uni.agregarMiembro(p2);
        uni.agregarMiembro(per1);
        uni.agregarMiembro(per2);

        System.out.println("----------------------- "); // polimorf
        System.out.println("Todos los miembros: ");
        uni.listarMiembros();

        
        System.out.println("Solo estudiantes ");
        uni.buscarPorRol("Estudiante");

        System.out.println("------------- ");
        System.out.println("SOlo Profesores ");
        uni.buscarPorRol("Profesor");

         System.out.println("------------- ");
        System.out.println("Solo Personal ");
        uni.buscarPorRol("Personal");
System.out.println("----------------------- ");
        // Buscar miembro por documento
        MiembroUniversidad encontrado = uni.buscarPorDocumento("25000333");
        if (encontrado != null) {
            System.out.println("Miembro encontrado: " + encontrado.obtenerInformacionCompleta()); // poli
        } else {
            System.out.println("No se encontró el miembro.");
        }

    }
}
