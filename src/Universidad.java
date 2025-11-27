
public class Universidad {
//lista enlazada de miembros 
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

    // recorre y muestra todos los miembros de la lista

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

    // busca miembro x dni (metodo iterativo)
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
//cuenta cuantos estudiantes pertenecen a una carrera
public int contarEstudiantesRecursivo(String carrera) {
    return contarEstudiantesRecursivoHelper(inicio, carrera);
}

// helperrecursivo que recorre la lista nodo x nodo
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


// iterativa cuenta estudiantes que pertenecen a una carrera
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


// Método público que llama al helper recursivo
public Estudiante buscarEstudianteRecursivo(String documento) {
    return buscarEstudianteRecursivoHelper(inicio, documento);
}

// Helper recursivo que recorre y busca estudiante en la lista
private Estudiante buscarEstudianteRecursivoHelper(NodoMiembro nodo, String documento) {
    if (nodo == null) return null; // caso base: fin de la lista
    if (nodo.dato instanceof Estudiante) {
        Estudiante e = (Estudiante) nodo.dato;
        if (e.getDocumento().equals(documento)) {
            return e;
        }
    }
    return buscarEstudianteRecursivoHelper(nodo.siguiente, documento);


}

//Busca un estudiante por documento utilizando método iterativo
public Estudiante buscarEstudianteIterativo(String documento) {
    NodoMiembro aux = inicio;
    while (aux != null) {
        if (aux.dato instanceof Estudiante) {
            Estudiante e = (Estudiante) aux.dato;
            if (e.getDocumento().equals(documento)) {
                return e;
            }
        }
        aux = aux.siguiente;
    }
    return null;
}

//ordena un arreglo de estudiantes por apellido usando selection sort.
  public static Estudiante[] ordenarEstudiantesPorApellido(Estudiante[] estudiantes) {
        int n = estudiantes.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMinimo = i;
               // Buscar el menor apellido a partir de i
            for (int j = i + 1; j < n; j++) {
                if (estudiantes[j].getApellido().compareTo(estudiantes[indiceMinimo].getApellido()) < 0) {
                    indiceMinimo = j;
                }
            } // Intercambio
            if (indiceMinimo != i) {
                Estudiante temp = estudiantes[i];
                estudiantes[i] = estudiantes[indiceMinimo];
                estudiantes[indiceMinimo] = temp;
            }
        }
        return estudiantes;
    }


//Realiza busqueda binaria sobre un arreglo de estudiantes ordenado por apellido
//Devuelve el indice donde se encontro el apellido o -1 si no existe
public static int busquedaBinariaEstudiantes(Estudiante[] estudiantes, String apellido) {
    int inicio = 0;
    int fin = estudiantes.length - 1;

    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        int comparacion = estudiantes[medio].getApellido().compareToIgnoreCase(apellido);

        if (comparacion == 0) {
            return medio; //encontrado, devuelve el indice
        } else if (comparacion < 0) {
            inicio = medio + 1; //buscar en la mitad der
        } else {
            fin = medio - 1; //busca en la mitad izq
        }
    }

    return -1; //no encontro
}






}