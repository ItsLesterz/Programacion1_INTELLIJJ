package Proyecto1_Progra2;

import java.util.ArrayList;
import java.util.List;

public class Deportivo extends Eventos {

    private Deporte deporte;
    private String equipo1, equipo2;
    private List<String> jugadores;
    
    public Deportivo(int codigo, String titulo, String descripcion, int year, int month,
     int date, int hour, int minute, double monto, Deporte deporte, String equipo1, String equipo2) {

        super(codigo, titulo, descripcion, year, month, date, hour, minute, monto);
        this.deporte = deporte;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        jugadores = new ArrayList<String>();
        capacidad = 20000;

    }

    public void añadirJugador(String jugador) {
        jugadores.add(jugador);
    }

    public String stringDeporte() {
        return deporte.toString();
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    private String sJugadores() {
        String salida = "";
        for (String string : jugadores) {
            salida = salida.concat(string+"\n");
        }
        return salida;
    }

    @Override
    public String toString() {
        return (super.toString() +
            "\nEvento Deportivo de "+ deporte.toString().toLowerCase() +
            "\nEquipo 1: "+equipo1+"\tEquipo2: "+equipo2 +
            "\nJugadores--------\n" + sJugadores()+"\n\n");
    }

    public String getEquipo2() {
        return equipo2;
    }

}
