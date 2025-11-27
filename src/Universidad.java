
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
}