package Proyecto1_Progra2;

public class Religioso extends Eventos {

    private int convertidos;
    
    public Religioso(int codigo, String titulo, String descripcion, int year, int month,
     int date, int hour, int minute, double monto, int convertidos) {

        super(codigo, titulo, descripcion, year, month, date, hour, minute, (monto + 2000));
        this.convertidos = convertidos;
        capacidad = 30000;

    }

    public int getConvertidos() {
        return convertidos;
    }

    @Override
    public void cancelarEvento() {
        monto = 0;
        cancelado = true;
    }
    
    public void setConvertidos(int convertidos) {
        this.convertidos = convertidos;
    }

    @Override
    public String toString() {
        return (super.toString() +
            "\nEvento Religioso" +
            "\nPersonas convertidas: "+ convertidos+"\n\n");
    }

}
