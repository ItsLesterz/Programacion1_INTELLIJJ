package ExamenLABP1;

public class EmailAccount {

    // Atributos
    String email;
    String password;
    String usuario;
    Email[] inbox;

    // Constructor
    public EmailAccount(String email, String password, String usuario) {
        this.email = email;
        this.password = password;
        this.usuario = usuario;
        this.inbox = new Email[100];
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean accountExists(String email) {
        return this.email.equals(email);
    }

    public void recibirEmail(Email email) {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] == null) {
                inbox[i] = email;
                break;
            } else if (i == inbox.length - 1) {
                System.out.println("Correo Lleno");
            }
        }
    }
    public void leerEmail(int posicion) {
        posicion--;
        if (inbox[posicion] != null) {
            inbox[posicion].print();
            inbox[posicion].setLeido();
        } else {
            System.out.println("Correo Inexistente!!!");
        }
    }

    public void borrarLeidos() {
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null && inbox[i].isLeido()) {
                inbox[i] = null;
            }
        }
    }
    public void printInbox() {
        System.out.println("Correo: " + email);
        System.out.println("Usuario: " + usuario);
        System.out.println("Posición\tCorreo Emisor\tAsunto\tLeído");
        for (int i = 0; i < inbox.length; i++) {
            if (inbox[i] != null) {
                System.out.printf("%d %s %s %s", i + 1, inbox[i].getEmailRemitente(), inbox[i].getAsunto(), inbox[i].isLeido());
            }
        }
    }



}
