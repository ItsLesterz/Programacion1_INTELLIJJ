/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1_Progra2;

import java.util.ArrayList;

public class Admin extends Limited{

    private ArrayList<Eventos> eventos;
    
    public Admin(String usuario, String password, String nombre, int edad) {
        
        super(usuario, password, nombre, edad);
        eventos = new ArrayList<>();
        
    }
    
    public Admin(Admin user) {
        
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
