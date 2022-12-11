public class PorAccidenteRadioactivo extends Persona{
    private int edad;
    private String Accidente;

    @Override
    public void finalchance(Persona p1, Persona p2) {
        throw new UnsupportedOperationException("No se puede soportar :3");
    }

    @Override
    public String toString() {
        return "PorAccidenteRadioActivo{" + "edad:" + edad + ", Accidente:" + Accidente + '}';
    }

    public PorAccidenteRadioactivo(int edad, String tipoAccidente, String nombre, String poder, String tipo, String debilidad, int fuerza, int habilidadmental, int habilidadfisica) {
        super(nombre, poder, tipo, debilidad, fuerza, habilidadmental, habilidadfisica);
        this.edad = edad;
        this.Accidente = tipoAccidente;
    }
    public String getTipoAccidente() {
        return Accidente;
    }
    public void setTipoAccidente(String Accidente) {
        this.Accidente = Accidente;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
