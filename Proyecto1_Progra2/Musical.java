package Proyecto1_Progra2;

import java.util.ArrayList;
import java.util.List;

public class Musical extends Eventos {

    private Genero genero;
    private List<String> miembros;

    public Musical(int codigo, String titulo, String descripcion, int year, int month,
     int date, int hour, int minute, double monto, Genero genero) {

        super(codigo, titulo, descripcion, year, month, date, hour, minute, (monto + (monto*0.3)));
        this.genero = genero;
        miembros = new ArrayList<String>();
        capacidad = 25000;

    }

    public void agregarMiembro(String miembro) {
        miembros.add(miembro);
    }

    public String getMiembros() {
        String stringMiembros = "";
        for (String miembro : miembros) {
            stringMiembros = stringMiembros.concat(miembro + "\n");
        }
        return stringMiembros;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getGenero() {

        return genero.toString();

    }

    @Override
    public String toString() {
        return (super.toString() +
            "\nEvento Musical de "+ genero.toString().toLowerCase() +
            "\nMiembros-------- \n" + getMiembros()+"\n\n");
    }
    
}
