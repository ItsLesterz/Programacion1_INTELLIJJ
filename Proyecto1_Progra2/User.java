/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1_Progra2;

import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class User extends Limited{

    private ArrayList<Eventos> eventos;
    
    public User(String usuario, String password, String nombre, int edad) {
        
        super(usuario, password, nombre, edad);
        eventos = new ArrayList<>();
        
    }
    
    public User(User user) {
        
        super(user.usuario, user.password, user.nombre, user.edad);
        
    }

    @Override
    public void agregarEvento(Eventos evento) {

        eventos.add(evento);

    } 

    public String stringEvList() {
        String Ev = "";
        for (Eventos evento : eventos) {
            Ev = Ev.concat(evento.toString());
        }
        return (Ev);
    }
    
}
