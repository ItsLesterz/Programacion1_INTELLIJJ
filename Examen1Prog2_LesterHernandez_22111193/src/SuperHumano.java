public class SuperHumano extends Persona{
    private String superpoderes;

    @Override
    public void finalchance(Persona p1, Persona p2) {
        throw new UnsupportedOperationException("No se puede soportar :3");
    }

    @Override
    public String toString() {
        return "SuperHumano{" + "superpoderes:" + superpoderes + '}';
    }

    public SuperHumano(String nombre, String poder, String tipo, String debilidad, int fuerza, int mental, int fisica, String superpoderes) {
        super(nombre, poder, tipo, debilidad, fuerza, mental, fisica);
        this.superpoderes = superpoderes;
    }
    public String getSuperpoder() {
        return superpoderes;
    }
    public void setSuperpoder(String superpoderes) {
        this.superpoderes = superpoderes;
    }

}
