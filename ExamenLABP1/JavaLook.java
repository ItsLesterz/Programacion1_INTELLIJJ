package ExamenLABP1;

import java.util.Scanner;

public class JavaLook {
    public static void main(String[] args) {

        // Scanner
        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        // Atributos
        EmailAccount[] cuentas = new EmailAccount[100];
        EmailAccount accountActual = null;

        // Menu
        int opcion;

        do {
            System.out.print("---- Javalook ----\n\n");
            System.out.println("[1] LOGIN");
            System.out.println("[2] CREAR ACCOUNT");
            System.out.println("[3] SALIR");
            System.out.print("Ingrese opcion:");
            opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su correo");
                    String correo = leer.next();
                    System.out.println("Ingrese su contraseña");
                    String password = leer.next();
                    for (int i = 0; i < cuentas.length; i++) {
                        if (cuentas[i] != null) {
                            if (cuentas[i] != null) {
                                for (EmailAccount cuenta : cuentas) {
                                    if (cuenta != null) {
                                        if (cuenta.accountExists(correo)) {
                                            if (cuenta.getPassword().equals(password)) {
                                                accountActual = cuenta;
                                                break;
                                            } else {
                                                System.out.println("Contraseña incorrecta");
                                            }
                                        } else {
                                            System.out.println("Correo incorrecto");
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (accountActual != null) {
                        System.out.println("Bienvenido " + accountActual.getUsuario());
                        int opcion2;
                        do {
                            System.out.println("----Menu Principal----\n\n");
                            System.out.println("[1] VER MI INBOX");
                            System.out.println("[2] MANDAR CORREO");
                            System.out.println("[3] LEER UN CORREO");
                            System.out.println("[4] LIMPIAR MI INBOX");
                            System.out.println("[5] CERRAR SESION");
                            System.out.println("Ingrese opcion: ");
                            opcion2 = leer.nextInt();
                            switch (opcion2) {
                                case 1:
                                    accountActual.printInbox();
                                    break;
                                case 2:
                                    System.out.println("Ingrese el correo del destinatario: ");
                                    String correoDestinatario = leer.next();
                                    System.out.println("Ingrese el asunto: ");
                                    String asunto = leer.next();
                                    System.out.println("Ingrese el mensaje: ");
                                    String mensaje = leer.next();
                                    Email email = new Email(correoDestinatario, asunto, mensaje);
                                    if ((cuentas[0] != null)) {
                                        for (EmailAccount cuenta : cuentas) {
                                            if (cuenta != null) {
                                                if (cuenta.accountExists(correoDestinatario)) {
                                                    cuenta.recibirEmail(email);
                                                    break;
                                                } else {
                                                    System.out.println("El correo no existe");
                                                }
                                            }
                                        }
                                    }
                                    break;
                                case 3:
                                    System.out.println("Ingrese la posición del correo a leer");
                                    int posicion = leer.nextInt();
                                    accountActual.leerEmail(posicion);
                                    break;
                                case 4:
                                    accountActual.borrarLeidos();
                                    break;
                                case 5:
                                    accountActual = null;
                                    System.out.println("Saliendo del programa...");
                                    break;
                                default:
                                    System.out.println("Opción inválida!!");
                                    break;
                            }
                        } while (opcion2 != 5);
                        System.out.println("Se ha cerrado la sesión!");
                    } else {
                        System.out.println("Cuenta no existe");
                    }
                    break;
                case 2:
                    boolean hayEspacio = false;
                    for (int i = 0; i < cuentas.length; i++) {
                        if (cuentas[i] == null) {
                            hayEspacio = true;
                            break;
                        }
                    }
                    if (!hayEspacio) {
                        System.out.println("No hay espacio para crear una nueva cuenta");
                        break;
                    } else {
                        boolean cuentaCreada = false;
                        boolean correoValido = false;
                        do {
                            System.out.println("-----REGISTRO-----");
                            System.out.println("Ingrese su correo: ");
                            String correoRegistro = leer.next();

                            for (int i = 0; i < cuentas.length; i++) {
                                if (cuentas[i] != null) {
                                    if (cuentas[i].accountExists(correoRegistro)) {
                                        System.out.println("Correo Existente!!!");
                                        break;
                                    } else {
                                        correoValido = true;
                                    }
                                } else {
                                    correoValido = true;
                                }
                            }

                            if (correoValido) {
                                System.out.println("Ingrese su nombre de usuario: ");
                                String usuarioRegistro = leer.next();
                                System.out.println("Ingrese su contraseña: ");
                                String passwordRegistro = leer.next();

                                for (int i = 0; i < cuentas.length; i++) {
                                    if (cuentas[i] == null) {
                                        cuentas[i] = new EmailAccount(correoRegistro, passwordRegistro, usuarioRegistro);
                                        cuentaCreada = true;
                                        break;
                                    }
                                }
                            }
                        } while (!cuentaCreada);
                    }
            }
        } while (opcion != 3);
    }
}
