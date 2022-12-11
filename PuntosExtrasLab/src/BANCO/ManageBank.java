package BANCO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;

public class ManageBank {

    private RandomAccessFile cuentas;

    public ManageBank() throws FileNotFoundException {
        File carpeta = new File("banco");
        carpeta.mkdir();
        if (carpeta.exists()) {
            cuentas = new RandomAccessFile("banco/cuentas.bnk", "rw");
        }
    }

    public boolean buscar(int code) throws IOException {
        cuentas.seek(0);
        while (cuentas.getFilePointer() < cuentas.length()) {
            if (code == cuentas.readInt()) {
                return true;
            } else {
                cuentas.readUTF();
                cuentas.readLong();
                cuentas.readDouble();
                cuentas.readUTF();
            }
        }
        return false;
    }

    public void addCuenta(int cod, String nombre, String tipo) throws AccountAlreadyExists {
        try {
            if (!buscar(cod)) {
                cuentas.seek(cuentas.length());
                cuentas.writeInt(cod);
                cuentas.writeUTF(nombre);
                cuentas.writeLong(Calendar.getInstance().getTimeInMillis());
                double saldo = (tipo.equals("NORMAL")) ? TipoCuenta.NORMAL.getMiniSaldo():(tipo.equals("PLANILLA")) ? TipoCuenta.PLANILLA.getMiniSaldo(): TipoCuenta.VIP.getMiniSaldo();
                cuentas.writeDouble(saldo);
                cuentas.writeUTF(tipo);
                System.out.println("Empleado Creado Correctamente");
            } else {
                throw new AccountAlreadyExists(cod);
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }

    public void deposito(int cod, double monto) throws IOException {
        if (buscar(cod)) {
            cuentas.readUTF();
            cuentas.readLong();
            double saldo = cuentas.readDouble();
            buscar(cod);
            cuentas.readUTF();
            cuentas.writeLong(Calendar.getInstance().getTimeInMillis());
            cuentas.writeDouble(saldo + monto);
            System.out.println("Deposito realizado! " +
                              "\nSaldo actual: " + (saldo + monto) + " Lps.");
        } else {
            System.out.println("No existe cuenta con este codigo!");
        }
    }

    public boolean retiro(int cod, double monto) throws IOException {
        if (buscar(cod)) {
            cuentas.readUTF();
            cuentas.readLong();
            double saldo = cuentas.readDouble();
            if (monto < saldo) {
                buscar(cod);
                cuentas.readUTF();
                cuentas.writeLong(Calendar.getInstance().getTimeInMillis());
                cuentas.writeDouble(saldo - monto);
                System.out.println("Retiro realizado de: " + monto + " Lps." +
                        "\nSaldo actual: " + (saldo - monto) + " Lps.");
                return true;
            } else {
                System.out.println("FONDOS INSUFICIENTES!");
                return false;
            }
        } else {
            System.out.println("No existe cuenta con este codigo!");
            return false;
        }
    }

    public void registrarIntereses() throws IOException {
        cuentas.seek(0);
        while (cuentas.getFilePointer() < cuentas.length()) {
            int code = cuentas.readInt();
            cuentas.readUTF();
            cuentas.readLong();
            double saldo = cuentas.readDouble();
            String type = cuentas.readUTF();
            double tasa = (type.equals("NORMAL")) ? saldo * TipoCuenta.NORMAL.getTasa(): (type.equals("PLANILLA"))
                    ? saldo * TipoCuenta.PLANILLA.getTasa() : saldo * TipoCuenta.VIP.getTasa();

            buscar(code);
            cuentas.readUTF();
            cuentas.writeLong(Calendar.getInstance().getTimeInMillis());
            cuentas.writeDouble(saldo + tasa);
            cuentas.readUTF();
        }
    }

    public void Import(String filename) throws IOException {
        File registro = new File(filename + ".txt");
        FileWriter fw = new FileWriter(registro, false);
        String contenido = "";
        cuentas.seek(0);
        while (cuentas.getFilePointer() < cuentas.length()) {
            int code = cuentas.readInt();
            String nombre = cuentas.readUTF();
            cuentas.readLong();
            double saldo = cuentas.readDouble();
            String tipo = cuentas.readUTF();
            contenido += " Codigo: " + code + " Nombre: " + nombre + " Saldo: " + saldo + " Tipo: " + tipo + "\n";
        }
        fw.write(contenido);
        fw.flush();
        System.out.println("Datos Importados: \n" + contenido);
    }

}
