import java.util.ArrayList;

public class Mutante extends Persona{
    ArrayList <String> Mutacion = new ArrayList();
    @Override
    public void finalchance(Persona p1, Persona p2) {
        throw new UnsupportedOperationException("No se puede soportar :3");
    }

    @Override
    public String toString() {
        return "Mutante{" + "Mutaciones:" + Mutacion + '}';
    }

    public Mutante(String nombre, String poder, String heroeoOvillano, String debilidad, int fuerza, int habilidadmental, int habilidadfisica) {
        super(nombre, poder, heroeoOvillano, debilidad, fuerza, habilidadmental, habilidadfisica);
    }

    public ArrayList<String> getMutacion() {
        return Mutacion;
    }

    public void setMutacions(ArrayList<String> factoresMutantes) {
        this.Mutacion = factoresMutantes;
    }

}
