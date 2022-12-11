public class Deidad extends Extraterrestre{
    private boolean tieneCreyentes;
    String religion_mitologia;
    //Todo es bastante repetitivo Onichan UwU 7u7 ~v~ XD ;) :) :D :p
    @Override
    public void finalchance(Persona p1, Persona p2) {
        throw new UnsupportedOperationException("No se puede soportar :3");
    }

    @Override
    public String toString() {
        return "Deidad{" + "Creyentes:" + tieneCreyentes + ", Religion/Mitologia=" + religion_mitologia + '}';
    }

    public Deidad(String nombre, String poder, String tipo, String debilidad, int fuerza, int habilidadmental, int habilidadfisica, boolean creyente, String religion_mitologia) {
        super(nombre, poder, tipo, debilidad, fuerza, habilidadmental, habilidadfisica);
        this.tieneCreyentes = creyente;
        this.religion_mitologia = religion_mitologia;
    }

}
