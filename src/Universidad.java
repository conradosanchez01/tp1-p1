
public class Universidad {

    private class NodoMiembro {
        MiembroUniversidad dato;
        NodoMiembro siguiente;

        public NodoMiembro(MiembroUniversidad dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    // puntero inicio
    private NodoMiembro inicio;

    // const
    public Universidad() {
        this.inicio = null;
    }

    // agrega un miembro a la lista
    public void agregarMiembro(MiembroUniversidad miembro) {
        NodoMiembro nuevo = new NodoMiembro(miembro);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoMiembro aux = inicio;
            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }
            aux.siguiente = nuevo;
        }
    }

    // muestra todos los miembros

    public void listarMiembros() {
        if (inicio == null) {
            System.out.println("La universidad no tiene miembros cargados.");
            return;
        }

        NodoMiembro aux = inicio;
        while (aux != null) {
            System.out.println(aux.dato.obtenerInformacionCompleta());
            System.out.println("--");
            aux = aux.siguiente;
        }
    }

    // busca miembro dni
    public MiembroUniversidad buscarPorDocumento(String documento) {
        NodoMiembro aux = inicio;
        while (aux != null) {
            if (aux.dato instanceof Persona) {
                Persona p = (Persona) aux.dato;
                if (p.getDocumento().equals(documento)) {
                    return aux.dato;
                }
            }
            aux = aux.siguiente;
        }
        return null;
    }

    // busca miembro por estudiante,profesor,personal

    public void buscarPorRol(String rol) {
        NodoMiembro aux = inicio;
        boolean encontrado = false;

        while (aux != null) {
            if (aux.dato.obtenerRol().equalsIgnoreCase(rol)) {
                System.out.println(aux.dato.obtenerInformacionCompleta());
              
                encontrado = true;
            }
            aux = aux.siguiente;
        }

        if (!encontrado) {
            System.out.println("No se encontraron miembros con el rol: " + rol);
        }
    }



// version recursiva
public int contarEstudiantesRecursivo(String carrera) {
    return contarEstudiantesRecursivoHelper(inicio, carrera);
}

// recursivo que recorre la lista
private int contarEstudiantesRecursivoHelper(NodoMiembro nodo, String carrera) {
    if (nodo == null) return 0; // caso base: fin de la lista
    int count = 0;
    if (nodo.dato instanceof Estudiante) {
        Estudiante e = (Estudiante) nodo.dato;
        if (e.getCarrera().equalsIgnoreCase(carrera)) {
            count = 1;
        }
    }
    return count + contarEstudiantesRecursivoHelper(nodo.siguiente, carrera);
}


// iterativa
public int contarEstudiantesIterativo(String carrera) {
    int count = 0;
    NodoMiembro aux = inicio;
    while (aux != null) {
        if (aux.dato instanceof Estudiante) {
            Estudiante e = (Estudiante) aux.dato;
            if (e.getCarrera().equalsIgnoreCase(carrera)) {
                count++;
            }
        }
        aux = aux.siguiente;
    }
    return count;
}

















}