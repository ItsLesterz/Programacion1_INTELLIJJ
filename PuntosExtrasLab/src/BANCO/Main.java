package BANCO;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AccountAlreadyExists, IOException {
        ManageBank mgb = new ManageBank();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        do{
            System.out.print("\n---- Banco ----" +
                    "\n(1) Agregar Cuenta" +
                    "\n(2) Deposito" +
                    "\n(3) Retiro" +
                    "\n(4) Registrar Intereses" +
                    "\n(5) Importar" +
                    "\n(6) Salir" +
                    "\nSELECCIONE OPCION: ");
            opcion = leer.nextInt();

            switch(opcion){
                case 1:
                    System.out.println("\n--- AGREGAR CUENTA ---");
                    System.out.print("\nIngrese un codigo: ");
                    int code = leer.nextInt();
                    System.out.print("Ingrese un nombre: ");
                    String name = leer.next();
                    System.out.print("Ingrese el tipo (NORMAL, PLANILLA y VIP): ");
                    String tipo = leer.next().toUpperCase();
                    mgb.addCuenta(code, name, tipo);
                    break;

                case 2:
                    System.out.println("\n--- DEPOSITO ---");
                    System.out.print("Ingrese codigo de su cuenta: ");
                    int codigo = leer.nextInt();
                    System.out.print("Ingrese monto de deposito: ");
                    double monto = leer.nextDouble();
                    mgb.deposito(codigo, monto);
                    break;

                case 3:
                    System.out.println("\n--- RETIRO ---");
                    System.out.print("Ingrese codigo de cuenta: ");
                    int cod = leer.nextInt();
                    System.out.print("Ingrese monto a retirar: ");
                    double cash = leer.nextDouble();
                    mgb.retiro(cod, cash);
                    break;

                case 4:
                    System.out.println("\n--- REGISTRAR INTERESES ---");
                    mgb.registrarIntereses();
                    System.out.println("Se le ha generado intereses a todas las cuentas!");
                    break;

                case 5:
                    System.out.println("\n--- IMPORTAR ---");
                    System.out.print("Ingrese el nombre del archivo a importar: ");
                    String fileName = leer.next();
                    mgb.Import(fileName);
                    break;

                case 6:
                    System.out.println("Ha salido de Banco!");
                    break;

                default:
                    System.out.println("OPCION INVALIDA!");
                    break;
            }
        }while(opcion!=6);
    }
}