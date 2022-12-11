/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1_Progra2;

public abstract class Limited {
    
    protected String usuario;
    protected String password;
    protected String nombre;
    protected int edad;
    
    public Limited(String usuario, String password, String nombre, int edad) {

        this.nombre = nombre;
        this.edad = edad;
        this.usuario = usuario;
        this.password = password;
        
    }
    
    public Limited(Limited user){
        
        this.usuario = user.usuario;
        this.password = user.password;
        
    }
    
    public void printUser() {
        
        System.out.println(usuario);
        
    }

    public abstract void agregarEvento(Eventos evento);
    
}
