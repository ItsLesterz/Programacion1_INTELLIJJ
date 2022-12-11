package BANCO;

public class AccountAlreadyExists extends Exception {
    public AccountAlreadyExists(int code){
        super("La cuenta: "+code+"ya esta en el sistema");
    }
}
