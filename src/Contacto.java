public class Contacto {

    private String nombre;
    private Long numero;

    public Contacto() {
    }

    public Contacto(String nombre, Long numero) {
        this.nombre = nombre.trim();
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public Long getNumero() {
        return numero;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }
}
