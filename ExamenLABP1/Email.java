package ExamenLABP1;

public class Email {

    // Atributos
    String emailRemitente;
    String asunto;
    String contenido;
    boolean leido;

    // Constructor
    public Email(String emailRemitente, String asunto, String contenido) {
        this.emailRemitente = emailRemitente;
        this.asunto = asunto;
        this.contenido = contenido;
        this.leido = false;
    }

    // Getters
    public String getEmailRemitente() {
        return emailRemitente;
    }

    public String getAsunto() {
        return asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean isLeido() {
        return leido;
    }

    public void setLeido() {
        this.leido = true;
    }

    public void print() {
        System.out.printf("""
                De: %s
                Asunto: %s
                Contenido: %s
                """, emailRemitente, asunto, contenido);
    }

}
