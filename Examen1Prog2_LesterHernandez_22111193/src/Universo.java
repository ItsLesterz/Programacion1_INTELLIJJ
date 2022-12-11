import java.util.ArrayList;

public class Universo {
    private String nombre;
    ArrayList<Escuadron> escuadron = new ArrayList();

    @Override
    public String toString() {
        return "Universo{" + "nombre=" + nombre + ", squads=" + escuadron + '}';
    }

    public Universo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Escuadron> getEscuadron() {
        return escuadron;
    }
    public void setEscuadron(ArrayList<Escuadron> escuadron) {
        this.escuadron = escuadron;
    }

}
