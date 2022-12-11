package Proyecto1_Progra2;

import java.util.Calendar;

public class Eventos implements Comparable<Eventos> {
    
    protected int codigo;
    protected String titulo;
    protected String descripcion;
    protected Calendar fecha;
    protected double monto;
    protected boolean cancelado;
    protected long capacidad;

    public Eventos(int codigo, String titulo, String descripcion, int year, int month, int date, int hour, int minute, double monto) {

        cancelado = false;
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.monto = monto;
        fecha = Calendar.getInstance();
        fecha.set(year, month, date, hour, minute);

    }

    public void cancelarEvento() {
        monto = 0;
        cancelado = true;
    }

    public void cancelarMultar() {
        monto = monto*0.5;
        cancelado = true;
    }

    public int getYear() {
        return fecha.get(Calendar.YEAR);
    }
    
    public int getMonth() {
        return (fecha.get(Calendar.MONTH) + 1);
    }

    public int getDate() {
        return fecha.get(Calendar.DATE);
    }
    
    public int getHour() {
        return fecha.get(Calendar.HOUR);
    }

    public int getMinute() {
        return fecha.get(Calendar.MINUTE);
    }

    public String stringFecha() {
        return (getDate()+"/"+getMonth()+"/"+getYear());
    }

    public String stringHora() {
        return (getHour()+":"+getMinute());
    }

    @Override
    public String toString() {
        String cancel = "";
        if (cancelado) {
            cancel = "\nEvento cancelado, multa pagada";
        }
        return ("Titulo: " + titulo + "\tN°" + codigo +
        "\nFecha: " + stringFecha() +
        "\nDescripcion: " + descripcion +
        "\nIngresos: " + monto + cancel);
    }

    @Override
    public int compareTo(Eventos o) {
        return fecha.compareTo(o.fecha);
    }

}
