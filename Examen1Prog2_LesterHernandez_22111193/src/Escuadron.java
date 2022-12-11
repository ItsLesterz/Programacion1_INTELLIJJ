import java.util.ArrayList;

public class Escuadron {
    private String nombre, lugarbase,lider, HeroeoOvillanos;

    ArrayList<Persona> miembros = new ArrayList();

    @Override
    public String toString() {
        return "Escuadron{" + "nombre:" + nombre + ", lugar:" + lugarbase + ", lider:" + lider + ", tipo:" + HeroeoOvillanos + ", miembros:" + miembros + '}';
    }

    public Escuadron(String nombre, String lugarbase, String HeroeoOvillanos) {
        this.nombre = nombre;
        this.lugarbase = lugarbase;
        this.HeroeoOvillanos = HeroeoOvillanos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugarbase() {
        return lugarbase;
    }

    public void setLugarbase(String lugarbase) {
        this.lugarbase = lugarbase;
    }

    public String getLider() {
        return lider;
    }

    public void setLider(String persona) {
        this.lider = persona;
    }

    public String getLugarBase() {
        return lugarbase;
    }

    public void setLugarBase(String lugarbase) {
        this.lugarbase = lugarbase;
    }

    public String getHeroeoOvillanos() {
        return HeroeoOvillanos;
    }

    public void setHeroeoOvillanos(String heroeoOvillanos) {
        HeroeoOvillanos = heroeoOvillanos;
    }

    public ArrayList<Persona> getMiembros() {
        return miembros;
    }

    public void setMiembros(ArrayList<Persona> miembros) {
        this.miembros = miembros;
    }
}
