public class Persona {

    private String nombre;
    private String apellido;
    private int edad;
    private String documento;

    public Persona(String nombre, String apellido, int edad, String documento) {
        setNombre(nombre);
        setApellido(apellido);
        setEdad(edad);
        setDocumento(documento);
    }

    // getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null)
            throw new IllegalArgumentException("el nombre no puede estar vacio");
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacio.");
        }
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad <= 16) {
            throw new IllegalArgumentException("La edad debe ser mayor a 16 ");
        }
        this.edad = edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El doc no puede estar vacio.");
        }
        this.documento = documento;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + "-DNI: " + documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Persona))
            return false;
        Persona p = (Persona) o;
        return documento.equals(p.documento);
    }

    @Override
    public int hashCode() {
        return documento.hashCode();
    }
}
