/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto1_Progra2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class JavaTickets extends JFrame {

    private List<Limited> usuarios = new ArrayList<Limited>();
    private List<Eventos> eventos = new ArrayList<Eventos>();
    private Font fuente;
    private JLayeredPane panel;
    private JLabel barraM, fondo, cuadro, texto1, texto2, texto3, titulo1, userTitulo, tituloJava, 
            barraR, popLabel, zona1, zona2, zona3, zona4, zona5, zona6, zona7, zona8;
    private JButton inicio, BCrearEvento, BEliminarEvento, BEditarEvento, BVerEvento, Cerrar, AgregarEv, BRealizados, cambiar,
            BCrearUsuario, BEditarUsuario, BEliminarUsuario, BPerfil, BFuturos, BCancelados, BListaFecha, EliminarEv, newMiembro;
    private JTextField usuario, contra, titulo, codigoField, equipo1, equipo2, fechaField, convertidosField, monto,
            cUsuarioField, cNombreField, cEdadField, cPasswordField, fechaDesde, fechaHasta, agregarMiembro;
    private JTextArea eventosLabel, descripcionArea, eventosLista;
    private JComboBox<String> tipoEvento, tipoUsuario;
    private JComboBox<Deporte> deporteBox; private JComboBox<Genero> generoBox;
    private JScrollPane scrollEventos, listadoScrollPane;
    private Color colorBase = new Color(0, 220, 203, 255), gris = new Color(255, 255, 255);
    private Limited userIn, administrador;
    private String[] tiposEvento = {"DEPORTE","MUSICAL","RELIGIOSO"};
    private String[] TiposUsuario = {"ADMIN","USER","LIMITED"};
    private String accion, userVer, tipoSel, fDesde, fHasta;
    private boolean hecho;
    private int codigoVer; private double montoFijo;


    public JavaTickets() {

        eventos.add(new Deportivo(23145, "Real Madrid vs Barcelona", "Evento de prueba", 2021, 11, 13, 10, 30, montoFijo, Deporte.BASEBALL, "Barcelona", "Madrid"));
        eventos.add(new Religioso(10000, "Ebenezer", "Evento de prueba", 2022, 4, 14, 10, 30, montoFijo, 100));
        eventos.add(new Musical(40000, "Musica Clasica en Vivo", "Evento de prueba", 2021, 10, 12, 10, 30, montoFijo, Genero.CLASICA));
        eventos.add(new Musical(40000, "Coldplay en vivo", "Evento de prueba", 2021, 11, 12, 10, 30, montoFijo, Genero.POP));

        eventos.get(3).cancelarEvento();

        eventos.add(new Religioso(50003, "Iglesia de Jesucristo de los Santos de los Ultimos Dias", "Evento de prueba", 2010, 4, 14, 10, 30, montoFijo, 100));
        eventos.add(new Musical(42512, "Red Hot Chili Peppers", "Evento de prueba", 2015, 10, 12, 10, 30, montoFijo,Genero.ROCK));

        administrador = new Admin("admin", "supersecreto", "Administrador", 0);
        usuarios.add(administrador);

        setBounds(0, 0, 1000, 800);
        setTitle("Java Tickets");
        setLocationRelativeTo(null);
        setResizable(false);
        userIn = null;
        fuente = new Font("arial", Font.PLAIN, 25);
        codigoVer = 10000;
        tipoSel = "DEPORTE";

        accion = "";
        hecho = false;
        montoFijo = 10000;

        iniciarComponentes();
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    private void iniciarComponentes() {
        colocarPanel();
        menuInicio();
    }

    private void colocarPanel() {
        panel = new JLayeredPane();
        panel.setLayout(null);
        this.add(panel);
    }

    private void menuInicio() {
        barraPrincipal();

        cuadro = new JLabel();
        cuadro.setBounds(300, 270, 400, 325);
        cuadro.setBorder(BorderFactory.createLineBorder(new Color(0, 220, 203), 2));
        cuadro.setOpaque(true);
        cuadro.setBackground(gris);
        panel.add(cuadro, JLayeredPane.MODAL_LAYER);

        usuario = new JTextField();
        usuario.setBounds(330, 390, 340, 45);
        usuario.setOpaque(true);
        usuario.setFont(fuente.deriveFont(20f));
        panel.add(usuario, JLayeredPane.DRAG_LAYER);

        contra = new JTextField();
        contra.setBounds(330, 510, 340, 45);
        contra.setOpaque(true);
        contra.setFont(fuente.deriveFont(20f));
        panel.add(contra, JLayeredPane.DRAG_LAYER);

        texto1 = new JLabel();
        texto1.setText("Usuario:");
        texto1.setBounds(335, 355, 340, 35);
        texto1.setOpaque(true);
        texto1.setFont(fuente.deriveFont(30f));
        texto1.setBackground(gris);
        panel.add(texto1, JLayeredPane.DRAG_LAYER);

        texto2 = new JLabel();
        texto2.setText("Contraseña:");
        texto2.setBounds(335, 475, 340, 35);
        texto2.setOpaque(true);
        texto2.setFont(fuente.deriveFont(30f));
        texto2.setBackground(gris);
        panel.add(texto2, JLayeredPane.DRAG_LAYER);

        titulo1 = new JLabel();
        titulo1.setText("Inicio de Sesión");
        titulo1.setBounds(330, 295, 340, 35);
        titulo1.setOpaque(true);
        titulo1.setHorizontalAlignment(JLabel.CENTER);
        titulo1.setFont(fuente.deriveFont(35f));
        titulo1.setBackground(gris);
        panel.add(titulo1, JLayeredPane.DRAG_LAYER);

        ListenersIngreso();
    }

    //Seccion buscar
    private final Eventos buscarEvento(int codigo) {
        return buscarEvento(codigo, 0);
    }
    private final Eventos buscarEvento(int codigo, int control) {
        //FUNCION RECURSIVA 1
        if (control < eventos.size()) {
            if (eventos.get(control).codigo == codigo) 
                return eventos.get(control);
            return buscarEvento(codigo, control + 1);
        }
        return null;

    }

    private final Limited buscarU(String user) {
        for (Limited usuario : usuarios) {
            if (usuario.usuario.equals(user)) {
                return usuario;
            }
        }
        return null;
    }

    private final int buscarUser(String user) {
        return buscarUser(user, 0);
    }
    private final int buscarUser(String user, int control) {
        //FUNCION RECURSIVA 2
        if (control < usuarios.size()) {
            if (usuarios.get(control).usuario.equals(user))
                return control;
            return buscarUser(user, control + 1);
        }
        return -1;
    }
    //metodos final
    private final Limited buscarUsuario(String usuario, String clave) {
        return buscarUsuario(usuario, clave, 0);
    }
    private final Limited buscarUsuario(String usuario, String clave, int control) {
        //FUNCION RECURSIVA 3
        if (control < usuarios.size()) {
            if (usuarios.get(control).usuario.equals(usuario) && usuarios.get(control).password.equals(clave))
                return usuarios.get(control);
            return buscarUsuario(usuario, clave, control + 1);
        }
        
        return null;
    }

    private void menuBasico() {
        barraPrincipal();
        barraLateral();
    }

    private void popUps(String boton) {
        System.out.println(accion);
        int x = 0, y = 0, ancho = 0, largo = 0;
        if (boton.equals(BCrearEvento.getActionCommand())) {
            x = 173; y = 200; ancho = 440; largo = 400;

            zona3 = new JLabel();
            zona3.setBounds(193, 213, 60, 30);
            zona3.setText("Codigo");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);
            
            codigoField = new JTextField(); 
            codigoField.setBounds(193, 250, 60, 30);
            codigoField.setBorder(BorderFactory.createLoweredBevelBorder());
            codigoField.setFont(fuente.deriveFont(18f));
            codigoField.setToolTipText("##### (5 digitos)");
            codigoField.setOpaque(true);
            panel.add(codigoField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(263, 213, 210, 30);
            zona1.setText("Titulo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            titulo = new JTextField();
            titulo.setBounds(263, 250, 210, 30);
            titulo.setBorder(BorderFactory.createLoweredBevelBorder());
            titulo.setFont(fuente.deriveFont(18f));
            titulo.setOpaque(true);
            panel.add(titulo, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(483, 213, 100, 30);
            zona2.setText("Fecha");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            fechaField = new JTextField();
            fechaField.setToolTipText("D/M/YYYY \n(No usar \"0\" antes de los numeros)");
            fechaField.setBorder(BorderFactory.createLoweredBevelBorder());
            fechaField.setBounds(483, 250, 100, 30);
            fechaField.setFont(fuente.deriveFont(18f));
            fechaField.setOpaque(true);
            panel.add(fechaField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(193, 298, 100, 30);
            zona4.setText("Descripción");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            descripcionArea = new JTextArea();
            descripcionArea.setBounds(193, 330, 390, 72);
            descripcionArea.setBorder(BorderFactory.createLoweredBevelBorder());
            descripcionArea.setFont(fuente.deriveFont(18f));
            descripcionArea.setOpaque(true);
            panel.add(descripcionArea, JLayeredPane.DRAG_LAYER);
            
            zona5 = new JLabel();
            zona5.setBounds(193, 410, 100, 35);
            zona5.setText("Tipo Evento");
            zona5.setFont(fuente.deriveFont(18f));
            zona5.setBackground(gris);
            zona5.setOpaque(true);
            panel.add(zona5, JLayeredPane.DRAG_LAYER);

            tipoEvento = new JComboBox<String>(tiposEvento);
            tipoEvento.setSelectedItem(tipoSel);
            tipoEvento.setBounds(308, 410, 120, 35);
            tipoEvento.setFont(fuente.deriveFont(16f));
            tipoEvento.setOpaque(true);
            panel.add(tipoEvento, JLayeredPane.DRAG_LAYER);

            AgregarEv = new JButton();
            AgregarEv.setText("Ok");
            AgregarEv.setFont(fuente.deriveFont(20f));
            AgregarEv.setOpaque(true);
            AgregarEv.setBounds(403, 540, 140, 50);
            panel.add(AgregarEv, JLayeredPane.DRAG_LAYER);

            if (tipoEvento.getSelectedItem().equals("DEPORTE")) {

                zona6 = new JLabel();
                zona6.setBounds(193, 455, 100, 30);
                zona6.setText("Equipo 1");
                zona6.setFont(fuente.deriveFont(18f));
                zona6.setBackground(gris);
                zona6.setOpaque(true);
                panel.add(zona6, JLayeredPane.DRAG_LAYER);

                equipo1 = new JTextField();
                equipo1.setBounds(193, 487, 120, 30);
                equipo1.setBorder(BorderFactory.createLoweredBevelBorder());
                equipo1.setFont(fuente.deriveFont(18f));
                equipo1.setOpaque(true);
                panel.add(equipo1, JLayeredPane.DRAG_LAYER);

                zona7 = new JLabel();
                zona7.setBounds(325, 455, 100, 30);
                zona7.setText("Equipo 2");
                zona7.setFont(fuente.deriveFont(18f));
                zona7.setBackground(gris);
                zona7.setOpaque(true);
                panel.add(zona7, JLayeredPane.DRAG_LAYER);

                equipo2 = new JTextField();
                equipo2.setBounds(325, 487, 120, 30);
                equipo2.setBorder(BorderFactory.createLoweredBevelBorder());
                equipo2.setFont(fuente.deriveFont(18f));
                equipo2.setOpaque(true);
                panel.add(equipo2, JLayeredPane.DRAG_LAYER);

                zona8 = new JLabel();
                zona8.setBounds(455, 455, 100, 30);
                zona8.setText("Deporte");
                zona8.setFont(fuente.deriveFont(16f));
                zona8.setBackground(gris);
                zona8.setOpaque(true);
                panel.add(zona8, JLayeredPane.DRAG_LAYER);

                deporteBox = new JComboBox<Deporte>(Deporte.values());
                deporteBox.setBounds(455, 487, 120, 30);
                deporteBox.setFont(fuente.deriveFont(18f));
                deporteBox.setOpaque(true);
                panel.add(deporteBox, JLayeredPane.DRAG_LAYER);
                
            } else if (tipoEvento.getSelectedItem().equals("MUSICAL")) {
                zona6 = new JLabel();
                zona6.setBounds(193, 455, 300, 30);
                zona6.setText("Genero Musical del Evento");
                zona6.setFont(fuente.deriveFont(18f));
                zona6.setBackground(gris);
                zona6.setOpaque(true);
                panel.add(zona6, JLayeredPane.DRAG_LAYER);

                generoBox = new JComboBox<Genero>(Genero.values());
                generoBox.setBounds(193, 487, 160, 30);
                generoBox.setFont(fuente.deriveFont(18f));
                generoBox.setOpaque(true);
                panel.add(generoBox, JLayeredPane.DRAG_LAYER);
            }
            
        } else if (boton.equals(BEliminarEvento.getActionCommand())) {
            x = 173; y = 200; ancho = 440; largo = 400;

            zona3 = new JLabel();
            zona3.setBounds(193, 213, 60, 30);
            zona3.setText("Codigo");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);
            
            codigoField = new JTextField(); 
            codigoField.setText(Integer.toString(codigoVer));
            codigoField.setBounds(193, 250, 60, 30);
            codigoField.setBorder(BorderFactory.createLoweredBevelBorder());
            codigoField.setFont(fuente.deriveFont(18f));
            codigoField.setToolTipText("##### (5 digitos)");
            codigoField.setOpaque(true);
            panel.add(codigoField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(263, 213, 210, 30);
            zona1.setText("Titulo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            titulo = new JTextField();
            titulo.setEditable(false);
            if (buscarEvento(codigoVer) != null) 
                titulo.setText(buscarEvento(codigoVer).titulo);
            titulo.setBounds(263, 250, 210, 30);
            titulo.setBorder(BorderFactory.createLoweredBevelBorder());
            titulo.setFont(fuente.deriveFont(18f));
            titulo.setOpaque(true);
            panel.add(titulo, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(483, 213, 100, 30);
            zona2.setText("Fecha");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            fechaField = new JTextField();
            fechaField.setEditable(false);
            if (buscarEvento(codigoVer) != null) 
                fechaField.setText(buscarEvento(codigoVer).stringFecha());
            fechaField.setToolTipText("D/M/YYYY \n(No usar \"0\" antes de los numeros)");
            fechaField.setBorder(BorderFactory.createLoweredBevelBorder());
            fechaField.setBounds(483, 250, 100, 30);
            fechaField.setFont(fuente.deriveFont(18f));
            fechaField.setOpaque(true);
            panel.add(fechaField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(193, 298, 100, 30);
            zona4.setText("Descripción");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            descripcionArea = new JTextArea();
            if (buscarEvento(codigoVer) != null) 
                descripcionArea.setText(buscarEvento(codigoVer).descripcion);
            descripcionArea.setEditable(false);
            descripcionArea.setBounds(193, 330, 390, 72);
            descripcionArea.setBorder(BorderFactory.createLoweredBevelBorder());
            descripcionArea.setFont(fuente.deriveFont(18f));
            descripcionArea.setOpaque(true);
            panel.add(descripcionArea, JLayeredPane.DRAG_LAYER);

            EliminarEv = new JButton();
            EliminarEv.setText("Eliminar");
            EliminarEv.setFont(fuente.deriveFont(20f));
            EliminarEv.setOpaque(true);
            EliminarEv.setBounds(403, 540, 140, 50);
            panel.add(EliminarEv, JLayeredPane.DRAG_LAYER);

        } else if (boton.equals(BEditarEvento.getActionCommand())) {
            x = 173; y = 200; ancho = 440; largo = 400;

            zona3 = new JLabel();
            zona3.setBounds(193, 213, 60, 30);
            zona3.setText("Codigo");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);
            
            codigoField = new JTextField();
            codigoField.setText(Integer.toString(codigoVer));
            codigoField.setBounds(193, 250, 60, 30);
            codigoField.setBorder(BorderFactory.createLoweredBevelBorder());
            codigoField.setFont(fuente.deriveFont(18f));
            codigoField.setToolTipText("##### (5 digitos)");
            codigoField.setOpaque(true);
            panel.add(codigoField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(263, 213, 210, 30);
            zona1.setText("Titulo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            titulo = new JTextField();
            if (buscarEvento(codigoVer) != null) 
                titulo.setText(buscarEvento(codigoVer).titulo);
            titulo.setBounds(263, 250, 210, 30);
            titulo.setBorder(BorderFactory.createLoweredBevelBorder());
            titulo.setFont(fuente.deriveFont(18f));
            titulo.setOpaque(true);
            panel.add(titulo, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(483, 213, 100, 30);
            zona2.setText("Fecha");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            fechaField = new JTextField();
            if (buscarEvento(codigoVer) != null) 
                fechaField.setText(buscarEvento(codigoVer).stringFecha());
            fechaField.setToolTipText("D/M/YYYY \n(No usar \"0\" antes de los numeros)");
            fechaField.setBorder(BorderFactory.createLoweredBevelBorder());
            fechaField.setBounds(483, 250, 100, 30);
            fechaField.setFont(fuente.deriveFont(18f));
            fechaField.setOpaque(true);
            panel.add(fechaField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(193, 298, 100, 30);
            zona4.setText("Descripción");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            descripcionArea = new JTextArea();
            if (buscarEvento(codigoVer) != null) 
                descripcionArea.setText(buscarEvento(codigoVer).descripcion);
            descripcionArea.setBounds(193, 330, 390, 72);
            descripcionArea.setBorder(BorderFactory.createLoweredBevelBorder());
            descripcionArea.setFont(fuente.deriveFont(18f));
            descripcionArea.setOpaque(true);
            panel.add(descripcionArea, JLayeredPane.DRAG_LAYER);

            AgregarEv = new JButton();
            AgregarEv.setText("Ok");
            AgregarEv.setFont(fuente.deriveFont(20f));
            AgregarEv.setOpaque(true);
            AgregarEv.setBounds(403, 540, 140, 50);
            panel.add(AgregarEv, JLayeredPane.DRAG_LAYER);

            if (buscarEvento(codigoVer).getClass() == Deportivo.class) {
            
                agregarMiembro = new JTextField();
                agregarMiembro.setBounds(193,415,200,30);
                agregarMiembro.setBorder(BorderFactory.createLoweredBevelBorder());
                agregarMiembro.setFont(fuente.deriveFont(18f));
                agregarMiembro.setOpaque(true);
                panel.add(agregarMiembro, JLayeredPane.DRAG_LAYER);
            
                newMiembro = new JButton();
                newMiembro.setBounds(403,415,180,30);
                newMiembro.setText("Agregar Jugador");
                newMiembro.setFont(fuente.deriveFont(17f));
                newMiembro.setOpaque(true);
                panel.add(newMiembro, JLayeredPane.DRAG_LAYER);

                zona6 = new JLabel();
                zona6.setBounds(193, 455, 100, 30);
                zona6.setText("Equipo 1");
                zona6.setFont(fuente.deriveFont(18f));
                zona6.setBackground(gris);
                zona6.setOpaque(true);
                panel.add(zona6, JLayeredPane.DRAG_LAYER);

                equipo1 = new JTextField();
                if (buscarEvento(codigoVer) != null) 
                    equipo1.setText(((Deportivo)buscarEvento(codigoVer)).getEquipo1());
                equipo1.setBounds(193, 487, 120, 30);
                equipo1.setBorder(BorderFactory.createLoweredBevelBorder());
                equipo1.setFont(fuente.deriveFont(18f));
                equipo1.setOpaque(true);
                panel.add(equipo1, JLayeredPane.DRAG_LAYER);

                zona7 = new JLabel();
                zona7.setBounds(325, 455, 100, 30);
                zona7.setText("Equipo 2");
                zona7.setFont(fuente.deriveFont(18f));
                zona7.setBackground(gris);
                zona7.setOpaque(true);
                panel.add(zona7, JLayeredPane.DRAG_LAYER);

                equipo2 = new JTextField();
                if (buscarEvento(codigoVer) != null) 
                    equipo2.setText(((Deportivo)buscarEvento(codigoVer)).getEquipo2());
                equipo2.setBounds(325, 487, 120, 30);
                equipo2.setBorder(BorderFactory.createLoweredBevelBorder());
                equipo2.setFont(fuente.deriveFont(18f));
                equipo2.setOpaque(true);
                panel.add(equipo2, JLayeredPane.DRAG_LAYER);

                zona8 = new JLabel();
                zona8.setBounds(455, 455, 100, 30);
                zona8.setText("Deporte");
                zona8.setFont(fuente.deriveFont(16f));
                zona8.setBackground(gris);
                zona8.setOpaque(true);
                panel.add(zona8, JLayeredPane.DRAG_LAYER);

                deporteBox = new JComboBox<Deporte>(Deporte.values());
                if (buscarEvento(codigoVer) != null) 
                    deporteBox.setSelectedItem(((Deportivo)buscarEvento(codigoVer)).getDeporte());
                deporteBox.setBounds(455, 487, 120, 30);
                deporteBox.setFont(fuente.deriveFont(18f));
                deporteBox.setOpaque(true);
                panel.add(deporteBox, JLayeredPane.DRAG_LAYER);
                
            } else if (buscarEvento(codigoVer).getClass() == Musical.class) {
            
                agregarMiembro = new JTextField();
                agregarMiembro.setBounds(193,415,200,30);
                agregarMiembro.setBorder(BorderFactory.createLoweredBevelBorder());
                agregarMiembro.setFont(fuente.deriveFont(18f));
                agregarMiembro.setOpaque(true);
                panel.add(agregarMiembro, JLayeredPane.DRAG_LAYER);
            
                newMiembro = new JButton();
                newMiembro.setBounds(403,415,180,30);
                newMiembro.setText("Agregar Miembro");
                newMiembro.setFont(fuente.deriveFont(17f));
                newMiembro.setOpaque(true);
                panel.add(newMiembro, JLayeredPane.DRAG_LAYER);

                zona6 = new JLabel();
                zona6.setBounds(193, 455, 300, 30);
                zona6.setText("Genero Musical del Evento");
                zona6.setFont(fuente.deriveFont(18f));
                zona6.setBackground(gris);
                zona6.setOpaque(true);
                panel.add(zona6, JLayeredPane.DRAG_LAYER);

                generoBox = new JComboBox<Genero>(Genero.values());
                generoBox.setBounds(193, 487, 160, 30);
                generoBox.setFont(fuente.deriveFont(18f));
                generoBox.setOpaque(true);
                panel.add(generoBox, JLayeredPane.DRAG_LAYER);
            } else {
                zona6 = new JLabel();
                zona6.setBounds(193, 455, 300, 30);
                zona6.setText("Convertidos");
                zona6.setFont(fuente.deriveFont(18f));
                zona6.setBackground(gris);
                zona6.setOpaque(true);
                panel.add(zona6, JLayeredPane.DRAG_LAYER);
                
                convertidosField = new JTextField();
                convertidosField.setBounds(193, 487, 160, 30);
                convertidosField.setFont(fuente.deriveFont(18f));
                convertidosField.setOpaque(true);
                panel.add(convertidosField, JLayeredPane.DRAG_LAYER);
            }

        } else if (boton.equals(BVerEvento.getActionCommand())) {
            //Menu Ver Evento
            x = 173; y = 200; ancho = 440; largo = 400;

            zona3 = new JLabel();
            zona3.setBounds(193, 210, 60, 30);
            zona3.setText("Codigo");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);
            
            codigoField = new JTextField(); 
            codigoField.setText(Integer.toString(codigoVer));
            codigoField.setBounds(193, 240, 60, 26);
            codigoField.setBorder(BorderFactory.createLoweredBevelBorder());
            codigoField.setFont(fuente.deriveFont(18f));
            codigoField.setToolTipText("##### (5 digitos)");
            codigoField.setOpaque(true);
            panel.add(codigoField, JLayeredPane.DRAG_LAYER);

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 10, y + 80, ancho - 20, largo - 150);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            eventosLista.setText(buscarEvento(codigoVer).toString());
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 10, y + 80, ancho - 20, largo - 150);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);

        } else if (boton.equals(BCrearUsuario.getActionCommand())) {
            x = 173; y = 300; ancho = 440; largo = 300;
            //Crear usuarios

            zona3 = new JLabel();
            zona3.setBounds(193, 313, 160, 30);
            zona3.setText("Nombre Completo");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);

            cNombreField = new JTextField();
            cNombreField.setBounds(193, 350, 180, 30);
            cNombreField.setBorder(BorderFactory.createLoweredBevelBorder());
            cNombreField.setFont(fuente.deriveFont(18f));
            cNombreField.setOpaque(true);
            panel.add(cNombreField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(403, 313, 210, 30);
            zona1.setText("Usuario");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            cUsuarioField = new JTextField();
            cUsuarioField.setBounds(403, 350, 180, 30);
            cUsuarioField.setBorder(BorderFactory.createLoweredBevelBorder());
            cUsuarioField.setFont(fuente.deriveFont(18f));
            cUsuarioField.setOpaque(true);
            panel.add(cUsuarioField, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(193, 398, 100, 30);
            zona2.setText("Password");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            cPasswordField = new JTextField();
            cPasswordField.setBounds(193, 430, 180, 30);
            cPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
            cPasswordField.setFont(fuente.deriveFont(18f));
            cPasswordField.setOpaque(true);
            panel.add(cPasswordField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(403, 398, 100, 30);
            zona4.setText("Edad");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            cEdadField = new JTextField();
            cEdadField.setBounds(403, 430, 180, 30);
            cEdadField.setBorder(BorderFactory.createLoweredBevelBorder());
            cEdadField.setFont(fuente.deriveFont(18f));
            cEdadField.setOpaque(true);
            panel.add(cEdadField, JLayeredPane.DRAG_LAYER);

            AgregarEv = new JButton();
            AgregarEv.setText("Ok");
            AgregarEv.setFont(fuente.deriveFont(20f));
            AgregarEv.setOpaque(true);
            AgregarEv.setBounds(403, 540, 140, 50);
            panel.add(AgregarEv, JLayeredPane.DRAG_LAYER);

            tipoUsuario = new JComboBox<String>(TiposUsuario);
            tipoUsuario.setBounds(193, 485, 180, 30);
            tipoUsuario.setFont(fuente.deriveFont(16f));
            tipoUsuario.setOpaque(true);
            panel.add(tipoUsuario, JLayeredPane.DRAG_LAYER);

        } else if (boton.equals(BEditarUsuario.getActionCommand())) {
            x = 173; y = 300; ancho = 440; largo = 300;
            //Editar usuarios

            zona3 = new JLabel();
            zona3.setBounds(193, 313, 160, 30);
            zona3.setText("Usuario");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);

            cUsuarioField = new JTextField();
            if (buscarU(userVer) != null)
                cUsuarioField.setText(buscarU(userVer).usuario);
            cUsuarioField.setBounds(193, 350, 180, 30);
            cUsuarioField.setBorder(BorderFactory.createLoweredBevelBorder());
            cUsuarioField.setFont(fuente.deriveFont(18f));
            cUsuarioField.setOpaque(true);
            panel.add(cUsuarioField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(403, 313, 210, 30);
            zona1.setText("Nombre Completo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            cNombreField = new JTextField();
            cNombreField.setBounds(403, 350, 180, 30);
            if (buscarU(userVer) != null)
                cNombreField.setText(buscarU(userVer).nombre);
            cNombreField.setBorder(BorderFactory.createLoweredBevelBorder());
            cNombreField.setFont(fuente.deriveFont(18f));
            cNombreField.setOpaque(true);
            panel.add(cNombreField, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(193, 398, 100, 30);
            zona2.setText("Password");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            cPasswordField = new JTextField();
            cPasswordField.setBounds(193, 430, 180, 30);
            if (buscarU(userVer) != null)
                cPasswordField.setText(buscarU(userVer).password);
            cPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
            cPasswordField.setFont(fuente.deriveFont(18f));
            cPasswordField.setOpaque(true);
            panel.add(cPasswordField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(403, 398, 100, 30);
            zona4.setText("Edad");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            cEdadField = new JTextField();
            cEdadField.setBounds(403, 430, 180, 30);
            if (buscarU(userVer) != null)
                cEdadField.setText(Integer.toString(buscarU(userVer).edad));
            cEdadField.setBorder(BorderFactory.createLoweredBevelBorder());
            cEdadField.setFont(fuente.deriveFont(18f));
            cEdadField.setOpaque(true);
            panel.add(cEdadField, JLayeredPane.DRAG_LAYER);

            AgregarEv = new JButton();
            AgregarEv.setText("Ok");
            AgregarEv.setFont(fuente.deriveFont(20f));
            AgregarEv.setOpaque(true);
            AgregarEv.setBounds(403, 540, 140, 50);
            panel.add(AgregarEv, JLayeredPane.DRAG_LAYER);

        } else if (boton.equals(BEliminarUsuario.getActionCommand())) {
            x = 173; y = 300; ancho = 440; largo = 300;
            //Eliminar usuario

            zona3 = new JLabel();
            zona3.setBounds(193, 313, 160, 30);
            zona3.setText("Usuario");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);

            cUsuarioField = new JTextField();
            if (buscarU(userVer) != null)
                cUsuarioField.setText(buscarU(userVer).usuario);
            cUsuarioField.setBounds(193, 350, 180, 30);
            cUsuarioField.setBorder(BorderFactory.createLoweredBevelBorder());
            cUsuarioField.setFont(fuente.deriveFont(18f));
            cUsuarioField.setOpaque(true);
            panel.add(cUsuarioField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(403, 313, 210, 30);
            zona1.setText("Nombre Completo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            cNombreField = new JTextField();
            cNombreField.setBounds(403, 350, 180, 30);
            if (buscarU(userVer) != null)
                cNombreField.setText(buscarU(userVer).nombre);
            cNombreField.setBorder(BorderFactory.createLoweredBevelBorder());
            cNombreField.setFont(fuente.deriveFont(18f));
            cNombreField.setOpaque(true);
            cNombreField.setEditable(false);
            panel.add(cNombreField, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(193, 398, 100, 30);
            zona2.setText("Password");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            cPasswordField = new JTextField();
            cPasswordField.setBounds(193, 430, 180, 30);
            if (buscarU(userVer) != null)
                cPasswordField.setText(buscarU(userVer).password);
            cPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
            cPasswordField.setFont(fuente.deriveFont(18f));
            cPasswordField.setOpaque(true);
            cPasswordField.setEditable(false);
            panel.add(cPasswordField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(403, 398, 100, 30);
            zona4.setText("Edad");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            cEdadField = new JTextField();
            cEdadField.setBounds(403, 430, 180, 30);
            if (buscarU(userVer) != null)
                cEdadField.setText(Integer.toString(buscarU(userVer).edad));
            cEdadField.setBorder(BorderFactory.createLoweredBevelBorder());
            cEdadField.setFont(fuente.deriveFont(18f));
            cEdadField.setOpaque(true);
            cEdadField.setEditable(false);
            panel.add(cEdadField, JLayeredPane.DRAG_LAYER);

            EliminarEv = new JButton();
            EliminarEv.setText("Eliminar");
            EliminarEv.setFont(fuente.deriveFont(20f));
            EliminarEv.setOpaque(true);
            EliminarEv.setBounds(403, 540, 140, 50);
            panel.add(EliminarEv, JLayeredPane.DRAG_LAYER);
            
        } else if (boton.equals(BFuturos.getActionCommand())) {
            x = 193; y = 200; ancho = 400; largo = 400;

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 10, y + 10, ancho - 20, largo - 60);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            eventosLista.setText("Eventos Futuros\n" + todoFuturos());
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 10, y + 10, ancho - 20, largo - 60);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);

        } else if (boton.equals(BRealizados.getActionCommand())) {
            x = 193; y = 200; ancho = 400; largo = 400;

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 10, y + 10, ancho - 20, largo - 80);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            eventosLista.setText("Eventos Realizados\n" + todoPasados());
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 10, y + 10, ancho - 20, largo - 80);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);

        }
        else if (boton.equals(BCancelados.getActionCommand())) {
            x = 193; y = 200; ancho = 400; largo = 400;

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 10, y + 10, ancho - 20, largo - 80);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            eventosLista.setText("Eventos Cancelados\n" + todoCancelados());
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 10, y + 10, ancho - 20, largo - 80);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);

        } else if (boton.equals(BListaFecha.getActionCommand())) {
            x = 193; y = 200; ancho = 400; largo = 400;

            fechaDesde = new JTextField();
            fechaDesde.setText(fDesde);
            fechaDesde.setBounds(203, 210, 180, 28);
            fechaDesde.setOpaque(true);
            fechaDesde.setBorder(BorderFactory.createLoweredBevelBorder());
            panel.add(fechaDesde, JLayeredPane.DRAG_LAYER);

            fechaHasta = new JTextField();
            fechaHasta.setText(fHasta);
            fechaHasta.setBounds(403, 210, 180, 28);
            fechaHasta.setOpaque(true);
            fechaHasta.setBorder(BorderFactory.createLoweredBevelBorder());
            panel.add(fechaHasta, JLayeredPane.DRAG_LAYER);

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 10, y + 40, ancho - 20, largo - 110);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            eventosLista.setText("Eventos por Fecha\n" + todoEntre(fechaDesde.getText(), fechaHasta.getText()));
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 10, y + 40, ancho - 20, largo - 110);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);

        } else if (boton.equals(BPerfil.getActionCommand())) {
            x = 173; y = 160; ancho = 440; largo = 440;
            //Ver Perfil

            zona3 = new JLabel();
            zona3.setBounds(193, 173, 160, 30);
            zona3.setText("Usuario");
            zona3.setBackground(gris);
            zona3.setFont(fuente.deriveFont(18f));
            zona3.setOpaque(true);
            panel.add(zona3, JLayeredPane.DRAG_LAYER);

            cUsuarioField = new JTextField();
            cUsuarioField.setText(userIn.usuario);
            cUsuarioField.setBounds(193, 210, 180, 30);
            cUsuarioField.setBorder(BorderFactory.createLoweredBevelBorder());
            cUsuarioField.setFont(fuente.deriveFont(18f));
            cUsuarioField.setOpaque(true);
            cUsuarioField.setEditable(false);
            panel.add(cUsuarioField, JLayeredPane.DRAG_LAYER);

            zona1 = new JLabel();
            zona1.setBounds(403, 173, 210, 30);
            zona1.setText("Nombre Completo");
            zona1.setBackground(gris);
            zona1.setFont(fuente.deriveFont(18f));
            zona1.setOpaque(true);
            panel.add(zona1, JLayeredPane.DRAG_LAYER);

            cNombreField = new JTextField();
            cNombreField.setBounds(403, 210, 180, 30);
            cNombreField.setText(userIn.nombre);
            cNombreField.setBorder(BorderFactory.createLoweredBevelBorder());
            cNombreField.setFont(fuente.deriveFont(18f));
            cNombreField.setOpaque(true);
            cNombreField.setEditable(false);
            panel.add(cNombreField, JLayeredPane.DRAG_LAYER);
            
            zona2 = new JLabel();
            zona2.setBounds(193, 258, 100, 30);
            zona2.setText("Password");
            zona2.setBackground(gris);
            zona2.setFont(fuente.deriveFont(18f));
            zona2.setOpaque(true);
            panel.add(zona2, JLayeredPane.DRAG_LAYER);

            cPasswordField = new JTextField();
            cPasswordField.setBounds(193, 290, 180, 30);
            cPasswordField.setText(userIn.password);
            cPasswordField.setBorder(BorderFactory.createLoweredBevelBorder());
            cPasswordField.setFont(fuente.deriveFont(18f));
            cPasswordField.setOpaque(true);
            cPasswordField.setEditable(false);
            panel.add(cPasswordField, JLayeredPane.DRAG_LAYER);

            zona4 = new JLabel();
            zona4.setBounds(403, 258, 100, 30);
            zona4.setText("Edad");
            zona4.setBackground(gris);
            zona4.setFont(fuente.deriveFont(18f));
            zona4.setOpaque(true);
            panel.add(zona4, JLayeredPane.DRAG_LAYER);

            cEdadField = new JTextField();
            cEdadField.setBounds(403, 290, 180, 30);
            cEdadField.setText(Integer.toString(userIn.edad));
            cEdadField.setBorder(BorderFactory.createLoweredBevelBorder());
            cEdadField.setFont(fuente.deriveFont(18f));
            cEdadField.setOpaque(true);
            cEdadField.setEditable(false);
            panel.add(cEdadField, JLayeredPane.DRAG_LAYER);

            eventosLista = new JTextArea();
            eventosLista.setBounds(x + 15, y + 140, ancho - 30, largo - 210);
            eventosLista.setOpaque(true);
            eventosLista.setSelectedTextColor(Color.black);
            eventosLista.setSelectionColor(new Color(225, 225, 225));
            eventosLista.setEditable(false);
            eventosLista.setFont(fuente.deriveFont(18f));
            if (userIn.getClass() == Admin.class) {
                eventosLista.setText("Eventos\n\n" + ((Admin)userIn).stringEvList());
            }
            if (userIn.getClass() == User.class) {
                eventosLista.setText("Eventos\n\n" + ((User)userIn).stringEvList());
            }
            eventosLista.setBorder(null);
            eventosLista.setLineWrap(true);
            eventosLista.setWrapStyleWord(true);
            eventosLista.setBackground(gris);
    
            listadoScrollPane = new JScrollPane(eventosLista);
            listadoScrollPane.setOpaque(true);
            listadoScrollPane.setBorder(null);
            listadoScrollPane.setBounds(x + 15, y + 190, ancho - 30, largo - 260);
            listadoScrollPane.setPreferredSize(new Dimension(160, 935));
            listadoScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            panel.add(listadoScrollPane, JLayeredPane.POPUP_LAYER);
        }
        
        popLabel = new JLabel();
        popLabel.setOpaque(true);
        popLabel.setBounds(x, y, ancho, largo);
        popLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        popLabel.setBackground(gris);
        panel.add(popLabel, JLayeredPane.POPUP_LAYER);

        Cerrar = new JButton();
        Cerrar.setText("Cerrar");
        Cerrar.setFont(fuente.deriveFont(20f));
        Cerrar.setOpaque(true);
        if (!boton.equals(BVerEvento.getActionCommand()) && !boton.equals(BFuturos.getActionCommand()) &&
            !boton.equals(BCancelados.getActionCommand()) && !boton.equals(BPerfil.getActionCommand()) &&
            !boton.equals(BListaFecha.getActionCommand())) {
            Cerrar.setBounds(243, 540, 140, 50);
        } else {
            Cerrar.setBounds(313, 540, 140, 50);
        }
        panel.add(Cerrar, JLayeredPane.DRAG_LAYER);
        
    }

    private void barraPrincipal() {
        barraM = new JLabel();
        barraM.setBounds(-5, -5, 1010, 70);
        barraM.setBorder(BorderFactory.createLineBorder(colorBase.darker()));
        barraM.setOpaque(true);
        barraM.setBackground(colorBase);
        panel.add(barraM);

        fondo = new JLabel();
        fondo.setBounds(0, 0, 1000, 1000);
        fondo.setOpaque(true);
        fondo.setBackground(new Color(240, 240, 240));
        panel.add(fondo);

        tituloJava = new JLabel();
        tituloJava.setFont(fuente);
        tituloJava.setText("JavaTickets");
        tituloJava.setBorder(null);
        tituloJava.setBounds(75, 5, 130, 60);
        tituloJava.setHorizontalAlignment(JTextField.CENTER);
        tituloJava.setForeground(Color.white);
        tituloJava.setOpaque(true);
        tituloJava.setBackground(colorBase);
        panel.add(tituloJava, JLayeredPane.POPUP_LAYER);

        ImageIcon init = new ImageIcon("Menu.png");
        inicio = new JButton();
        inicio.setBounds(0, 0, 65, 65);
        inicio.setOpaque(true);
        inicio.setIcon(new ImageIcon(
                init.getImage().getScaledInstance(inicio.getWidth(), inicio.getHeight(), Image.SCALE_SMOOTH)));
        inicio.setBorder(null);
        inicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
        inicio.setBackground(colorBase);
        panel.add(inicio, JLayeredPane.DRAG_LAYER);

        userTitulo = new JLabel();
        userTitulo.setBounds(570, 4, 400, 60);
        if (userIn != null)
            userTitulo.setText(userIn.nombre);
        else
            userTitulo.setText("");
        userTitulo.setOpaque(true);
        userTitulo.setHorizontalAlignment(JLabel.RIGHT);
        userTitulo.setFont(fuente.deriveFont(24f));
        userTitulo.setBackground(colorBase);
        userTitulo.setForeground(Color.white);
        userTitulo.setBorder(null);
        panel.add(userTitulo, JLayeredPane.DRAG_LAYER);
    }

    public void barraLateral() {
        eventosLabel = new JTextArea();
        eventosLabel.setBounds(815, 78, 160, 735);
        eventosLabel.setOpaque(true);
        eventosLabel.setSelectedTextColor(Color.black);
        eventosLabel.setSelectionColor(new Color(225, 225, 225));
        eventosLabel.setEditable(false);
        eventosLabel.setFont(fuente.deriveFont(16f));
        eventosLabel.setText("Eventos Proximos\n" + EventosFuturos() + "\nEventos Pasados\n" + EventosPasados() +
                            "\nEventos Cancelados\n" + EventosCancelados());
        eventosLabel.setBorder(null);
        eventosLabel.setLineWrap(true);
        eventosLabel.setWrapStyleWord(true);
        eventosLabel.setBackground(new Color(225, 225, 225));

        scrollEventos = new JScrollPane(eventosLabel);
        scrollEventos.setOpaque(true);
        scrollEventos.setBorder(null);
        scrollEventos.setBounds(815, 78, 160, 680);
        scrollEventos.setPreferredSize(new Dimension(160, 935));
        scrollEventos.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        panel.add(scrollEventos, JLayeredPane.POPUP_LAYER);

        barraR = new JLabel();
        barraR.setBounds(800, 65, 200, 735);
        barraR.setOpaque(true);
        barraR.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 205)));
        barraR.setBackground(new Color(225, 225, 225));
        panel.add(barraR, JLayeredPane.MODAL_LAYER);
    }

    private String EventosFuturos() {
        String futuros = "";
        Collections.sort(eventos);
        for (Eventos evento : eventos) {
            if (evento.fecha.after(Calendar.getInstance()) && !evento.cancelado) {
                futuros = futuros.concat(evento.getDate() + "/" + evento.getMonth() + "/" + evento.getYear());
                futuros = futuros.concat("\n" + evento.titulo + "\n\n");
            }
        }
        return futuros;
    }

    private String todoFuturos() {
        String futuros = "";
        String ultimo = "";
        double montoTotal = 0;
        Integer sport = 0; Integer music = 0; Integer church = 0;
        Collections.sort(eventos);
        for (Eventos evento : eventos) {
            if (evento.fecha.after(Calendar.getInstance()) && !evento.cancelado) {
                futuros = futuros.concat(evento.toString());
                montoTotal += evento.monto;
                if (evento.getClass() == Deportivo.class)
                    sport += 1;
                else if (evento.getClass() == Religioso.class)
                    church += 1;
                else if (evento.getClass() == Musical.class)
                    music += 1;
            }
        }
        ultimo = ultimo.concat("Deportivos: "+sport+" Musicales: "+music+"\nReligiosos: "+church+
                                "\nIngresos: "+montoTotal+"\n");
        ultimo = ultimo.concat("\n"+futuros);
        return ultimo;
    }

    private String todoEntre(String despues, String antes) {

        List<Eventos> futuros = new ArrayList<Eventos>();
        String ultimo = "";
        String futuroString = "";
        double montoTotal = 0;
        Integer sport = 0; Integer music = 0; Integer church = 0;
        Collections.sort(eventos);

        if (!fechaDesde.getText().equals("") && !fechaHasta.getText().equals("")) {
            Scanner rFecha = new Scanner(despues);
            int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
            int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
            int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());
            Calendar despuesDe = Calendar.getInstance();
            despuesDe.set(año, mes - 1, dia);
            
            Scanner ScFecha = new Scanner(antes);
            int dia1 = Integer.valueOf(ScFecha.useDelimiter("\\/").next());
            int mes1 = (Integer.valueOf(ScFecha.useDelimiter("\\/").next()) - 1);
            int año1 = Integer.valueOf(ScFecha.useDelimiter("\\/|\\n").next());
            Calendar antesDe = Calendar.getInstance();
            antesDe.set(año1, mes1 - 1, dia1);
            
            rFecha.close();
            ScFecha.close();

            for (Eventos evento : eventos) {
                if (evento.fecha.after(despuesDe) && evento.fecha.before(antesDe)) {
                    futuros.add(evento);
                    montoTotal += evento.monto;
                    if (evento.getClass() == Deportivo.class)
                        sport += 1;
                    else if (evento.getClass() == Religioso.class)
                        church += 1;
                    else if (evento.getClass() == Musical.class)
                        music += 1;
                }
            }
            for (Eventos evento : futuros) {
                futuroString = futuroString.concat(evento.toString());
            }
            ultimo = ultimo.concat("Deportivos: "+sport+" Musicales: "+music+"\nReligiosos: "+church+
                                    "\nIngresos: "+montoTotal+"\n");
            ultimo = ultimo.concat("\n"+futuroString);
            
        }
        return ultimo;
    }

    private String EventosPasados() {
        String futuros = "";
        Collections.sort(eventos, Collections.reverseOrder());
        for (Eventos evento : eventos) {
            if (evento.fecha.before(Calendar.getInstance()) && !evento.cancelado) {
                futuros = futuros.concat(evento.getDate() + "/" + evento.getMonth() + "/" + evento.getYear());
                futuros = futuros.concat("\n" + evento.titulo + "\n\n");
            }
        }
        return futuros;
    }

    private String todoPasados() {
        String futuros = "";
        String ultimo = "";
        double montoTotal = 0;
        Integer sport = 0; Integer music = 0; Integer church = 0;
        Collections.sort(eventos);
        for (Eventos evento : eventos) {
            if (evento.fecha.before(Calendar.getInstance()) && !evento.cancelado) {
                futuros = futuros.concat(evento.toString());
                montoTotal += evento.monto;
                if (evento.getClass() == Deportivo.class)
                    sport += 1;
                else if (evento.getClass() == Religioso.class)
                    church += 1;
                else if (evento.getClass() == Musical.class)
                    music += 1;
            }
        }
        ultimo = ultimo.concat("Deportivos: "+sport+" Musicales: "+music+"\nReligiosos: "+church+
                                "\nIngresos: "+montoTotal+"\n");
        ultimo = ultimo.concat("\n"+futuros);
        return ultimo;
    }

    private String todoCancelados() {
        String futuros = "";
        String ultimo = "";
        double montoTotal = 0;
        Integer sport = 0; Integer music = 0; Integer church = 0;
        Collections.sort(eventos);
        for (Eventos evento : eventos) {
            if (evento.cancelado) {
                futuros = futuros.concat(evento.toString());
                montoTotal += evento.monto;
                if (evento.getClass() == Deportivo.class)
                    sport += 1;
                else if (evento.getClass() == Religioso.class)
                    church += 1;
                else if (evento.getClass() == Musical.class)
                    music += 1;
            }
        }
        ultimo = ultimo.concat("Deportivos: "+sport+" Musicales: "+music+"\nReligiosos: "+church+
                                "\nIngresos por multa: "+montoTotal);
        ultimo = ultimo.concat("\n"+futuros);
        return ultimo;
    }

    private boolean diaAnterior(Eventos evento) {
        Calendar hoy = Calendar.getInstance();
        hoy.roll(Calendar.DATE, false);
        if (evento.getYear() == hoy.get(Calendar.YEAR) &&
            evento.getMonth() == hoy.get(Calendar.MONTH) &&
            evento.getDate() == hoy.get(Calendar.DATE)) {
            return true;
        }
        return false;
    }

    private Eventos buscarFecha(String fecha) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());
        Calendar nuevo = Calendar.getInstance();
        nuevo.set(año, mes - 1, dia);

        for (Eventos evento : eventos) {
            if (evento.fecha.get(Calendar.YEAR) == nuevo.get(Calendar.YEAR) && 
                evento.fecha.get(Calendar.MONTH) == nuevo.get(Calendar.MONTH) && 
                evento.fecha.get(Calendar.DATE) == nuevo.get(Calendar.DATE)) {
                rFecha.close();
                return evento;
            }
        }
        rFecha.close();
        return null;

    }

    private String EventosCancelados() {
        String futuros = "";
        Collections.sort(eventos, Collections.reverseOrder());
        for (Eventos evento : eventos) {
            if (evento.cancelado) {
                futuros = futuros.concat(evento.getDate() + "/" + evento.getMonth() + "/" + evento.getYear());
                futuros = futuros.concat("\n" + evento.titulo + "\n\n");
            }
        }
        return futuros;
    }

    private void menuAdmin(boolean adm, boolean limit, boolean disable) {
        cuadro = new JLabel();
        cuadro.setBounds(9, 74, 780, 680);
        cuadro.setOpaque(true);
        cuadro.setBorder(BorderFactory.createLineBorder(new Color(205, 205, 205)));
        cuadro.setBackground(gris);
        panel.add(cuadro, JLayeredPane.PALETTE_LAYER);

        texto1 = new JLabel();
        texto1.setText("Administración de Eventos");
        texto1.setBounds(12, 100, 385, 55);
        texto1.setHorizontalAlignment(JLabel.CENTER);
        texto1.setBorder(null);
        texto1.setOpaque(true);
        texto1.setFont(fuente.deriveFont(Font.BOLD, 25f));
        texto1.setBackground(gris);
        panel.add(texto1, JLayeredPane.MODAL_LAYER);

        texto2 = new JLabel();
        texto2.setText("Administración de Usuarios");
        texto2.setBounds(12, 450, 385, 55);
        texto2.setHorizontalAlignment(JLabel.CENTER);
        texto2.setBorder(null);
        texto2.setOpaque(true);
        texto2.setFont(fuente.deriveFont(Font.BOLD, 25f));
        texto2.setBackground(gris);
        panel.add(texto2, JLayeredPane.MODAL_LAYER);

        texto3 = new JLabel();
        texto3.setText("Reportes");
        texto3.setBounds(397, 100, 385, 55);
        texto3.setHorizontalAlignment(JLabel.CENTER);
        texto3.setBorder(null);
        texto3.setOpaque(true);
        texto3.setFont(fuente.deriveFont(Font.BOLD, 25f));
        texto3.setBackground(gris);
        panel.add(texto3, JLayeredPane.MODAL_LAYER);

        if (!disable) {
            botonesEventos(!limit, !disable);
            botonesUsuario(adm);
            botonesReportes(!disable);
        }
        else {
            botonesEventos(!limit, !disable);
            botonesUsuario(adm);
            botonesReportes(!disable);
        }

        hecho = false;

        ListenersBotones();
    }

    private void botonesEventos(boolean limit, boolean disable) {
        BCrearEvento = new JButton();
        BCrearEvento.setEnabled(limit);
        BCrearEvento.setBounds(30, 160, 355, 55);
        BCrearEvento.setText("Crear Evento");
        BCrearEvento.setFont(fuente.deriveFont(25f));
        BCrearEvento.setOpaque(true);
        panel.add(BCrearEvento, JLayeredPane.MODAL_LAYER);

        BEliminarEvento = new JButton();
        BEliminarEvento.setEnabled(limit);
        BEliminarEvento.setBounds(30, 225, 355, 55);
        BEliminarEvento.setText("Eliminar Evento");
        BEliminarEvento.setFont(fuente.deriveFont(25f));
        BEliminarEvento.setOpaque(true);
        panel.add(BEliminarEvento, JLayeredPane.MODAL_LAYER);

        BEditarEvento = new JButton();
        BEditarEvento.setEnabled(limit);
        BEditarEvento.setBounds(30, 290, 355, 55);
        BEditarEvento.setText("Editar Evento");
        BEditarEvento.setFont(fuente.deriveFont(25f));
        BEditarEvento.setOpaque(true);
        panel.add(BEditarEvento, JLayeredPane.MODAL_LAYER);

        BVerEvento = new JButton();
        BVerEvento.setEnabled(disable);
        BVerEvento.setBounds(30, 355, 355, 55);
        BVerEvento.setText("Ver Evento");
        BVerEvento.setFont(fuente.deriveFont(25f));
        BVerEvento.setOpaque(true);
        panel.add(BVerEvento, JLayeredPane.MODAL_LAYER);
    }

    private void botonesUsuario(boolean en) {
        BCrearUsuario = new JButton();
        BCrearUsuario.setEnabled(en);
        BCrearUsuario.setBounds(30, 510, 355, 55);
        BCrearUsuario.setText("Crear Usuario");
        BCrearUsuario.setFont(fuente.deriveFont(25f));
        BCrearUsuario.setOpaque(true);
        panel.add(BCrearUsuario, JLayeredPane.MODAL_LAYER);

        BEditarUsuario = new JButton();
        BEditarUsuario.setEnabled(en);
        BEditarUsuario.setBounds(30, 575, 355, 55);
        BEditarUsuario.setText("Editar Usuario");
        BEditarUsuario.setFont(fuente.deriveFont(25f));
        BEditarUsuario.setOpaque(true);
        panel.add(BEditarUsuario, JLayeredPane.MODAL_LAYER);

        BEliminarUsuario = new JButton();
        BEliminarUsuario.setEnabled(en);
        BEliminarUsuario.setBounds(30, 640, 355, 55);
        BEliminarUsuario.setText("Eliminar Usuario");
        BEliminarUsuario.setFont(fuente.deriveFont(25f));
        BEliminarUsuario.setOpaque(true);
        panel.add(BEliminarUsuario, JLayeredPane.MODAL_LAYER);
    }

    private void botonesReportes(boolean disable) {
        monto = new JTextField();
        monto.setText(Double.toString(montoFijo));
        monto.setEnabled(disable);
        monto.setBounds(415, 665, 185, 30);
        monto.setFont(fuente.deriveFont(18f));
        monto.setOpaque(true);
        panel.add(monto, JLayeredPane.MODAL_LAYER);
        
        cambiar = new JButton();
        cambiar.setText("Cambiar Monto");
        cambiar.setEnabled(disable);
        cambiar.setBounds(610, 665, 160, 30);
        cambiar.setFont(fuente.deriveFont(16f));
        cambiar.setOpaque(true);
        panel.add(cambiar, JLayeredPane.MODAL_LAYER);

        BFuturos = new JButton();
        BFuturos.setEnabled(disable);
        BFuturos.setBounds(415, 160, 355, 55);
        BFuturos.setText("Listar Futuros");
        BFuturos.setFont(fuente.deriveFont(25f));
        BFuturos.setOpaque(true);
        panel.add(BFuturos, JLayeredPane.MODAL_LAYER);

        BRealizados = new JButton();
        BRealizados.setEnabled(disable);
        BRealizados.setBounds(415, 225, 355, 55);
        BRealizados.setText("Listar Realizados");
        BRealizados.setFont(fuente.deriveFont(25f));
        BRealizados.setOpaque(true);
        panel.add(BRealizados, JLayeredPane.MODAL_LAYER);

        BCancelados = new JButton();
        BCancelados.setEnabled(disable);
        BCancelados.setBounds(415, 290, 355, 55);
        BCancelados.setText("Listar Cancelados");
        BCancelados.setFont(fuente.deriveFont(25f));
        BCancelados.setOpaque(true);
        panel.add(BCancelados, JLayeredPane.MODAL_LAYER);

        BListaFecha = new JButton();
        BListaFecha.setEnabled(disable);
        BListaFecha.setBounds(415, 355, 355, 55);
        BListaFecha.setText("Ingreso por Fecha");
        BListaFecha.setFont(fuente.deriveFont(25f));
        BListaFecha.setOpaque(true);
        panel.add(BListaFecha, JLayeredPane.MODAL_LAYER);

        BPerfil = new JButton();
        BPerfil.setEnabled(disable);
        BPerfil.setBounds(415, 420, 355, 55);
        BPerfil.setText("Perfil de Usuario");
        BPerfil.setFont(fuente.deriveFont(25f));
        BPerfil.setOpaque(true);
        panel.add(BPerfil, JLayeredPane.MODAL_LAYER);
    }

    public final void generarDeportivo(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            Deporte deporte, String equipo1, String equipo2) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());
        Eventos added = new Deportivo(codigo, titulo, descripcion, año, mes, dia, Hora, Min, monto, deporte, equipo1, equipo2);
        eventos.add(added);
        buscarU(userIn.usuario).agregarEvento(added);
        
        rFecha.close();
        rHora.close();
    }

    public final void editarDeportivo(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            Deporte deporte, String equipo1, String equipo2) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());

        Calendar nuevo = Calendar.getInstance();
        nuevo.set(año, mes, dia, Hora, Min);
        buscarEvento(codigo).titulo = titulo;
        buscarEvento(codigo).descripcion = descripcion;
        buscarEvento(codigo).fecha = nuevo;
        ((Deportivo)buscarEvento(codigo)).setEquipo1(equipo1);
        ((Deportivo)buscarEvento(codigo)).setEquipo2(equipo2);
        ((Deportivo)buscarEvento(codigo)).setDeporte(deporte);

        rFecha.close();
        rHora.close();
    }

    public final void crearAdmin(String nombre, String user, String pass, String edad) {
        int EDAD = Integer.valueOf(edad);
        if (buscarUser(user) == -1) {
            usuarios.add(new Admin(user, pass, nombre, EDAD));
        }
    }

    public final void crearUser(String nombre, String user, String pass, String edad) {
        int EDAD = Integer.valueOf(edad);
        if (buscarUser(user) == -1) {
            usuarios.add(new User(user, pass, nombre, EDAD));
            System.out.println("Confirmo");
        }
    }

    public final void crearLimited(String nombre, String user, String pass, String edad) {
        int EDAD = Integer.valueOf(edad);
        if (buscarUser(user) == -1) {
            usuarios.add(new Limited(user, pass, nombre, EDAD) {
                @Override
                public void agregarEvento(Eventos evento) {
                }
            });
        }
    }

    public final void generarMusical(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            Genero genero) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());
        Eventos added = new Musical(codigo, titulo, descripcion, año, mes, dia, Hora, Min, monto, genero);
        eventos.add(added);
        buscarU(userIn.usuario).agregarEvento(added);

        rFecha.close();
        rHora.close();
    }

    public final void editarMusical(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            Genero genero) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());

        Calendar nuevo = Calendar.getInstance();
        nuevo.set(año, mes, dia, Hora, Min);
        buscarEvento(codigo).titulo = titulo;
        buscarEvento(codigo).descripcion = descripcion;
        buscarEvento(codigo).fecha = nuevo;
        ((Musical)buscarEvento(codigo)).setGenero(genero);

        rFecha.close();
        rHora.close();
    }

    public final void generarReligioso(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            int convertidos) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());
        Eventos added = new Religioso(codigo, titulo, descripcion, año, mes, dia, Hora, Min, monto, convertidos);
        eventos.add(added);
        buscarU(userIn.usuario).agregarEvento(added);

        rFecha.close();
        rHora.close();
    }

    public final void editarReligioso(int codigo, String titulo, String descripcion, String fecha, String hora, double monto,
            int convertidos) {
        Scanner rFecha = new Scanner(fecha);
        int dia = Integer.valueOf(rFecha.useDelimiter("\\/").next());
        int mes = (Integer.valueOf(rFecha.useDelimiter("\\/").next()) - 1);
        int año = Integer.valueOf(rFecha.useDelimiter("\\/|\\n").next());

        Scanner rHora = new Scanner(hora);
        int Hora = Integer.valueOf(rHora.useDelimiter("\\:").next());
        int Min = Integer.valueOf(rHora.useDelimiter("\\:|\\n").next());

        Calendar nuevo = Calendar.getInstance();
        nuevo.set(año, mes, dia, Hora, Min);
        buscarEvento(codigo).titulo = titulo;
        buscarEvento(codigo).descripcion = descripcion;
        buscarEvento(codigo).fecha = nuevo;
        ((Religioso)buscarEvento(codigo)).setConvertidos(convertidos);

        rFecha.close();
        rHora.close();
    }

    private void ListenersIngreso() {

        ActionListener iniciarSesion = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                for (Limited user : usuarios) {
                    if (!usuario.getText().equals("") && !contra.getText().equals("")
                            && user.usuario.equals(usuario.getText()) && user.password.equals(contra.getText())) {
                        panel.removeAll();
                        userIn = buscarUsuario(usuario.getText(), contra.getText());
                        menuBasico();
                        if (userIn.getClass() == Admin.class) {
                            menuAdmin(true, false, false);
                        } else {
                            if (userIn.getClass() == User.class)
                                menuAdmin(false, false, false);
                            else
                                menuAdmin(false, true, false);
                        }
                        panel.updateUI();
                    }
                }
            }
        };

        usuario.addActionListener(iniciarSesion);
        contra.addActionListener(iniciarSesion);

    }

    private void ListenersBotones() {

        ActionListener BotonPresionado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    accion = ae.getActionCommand();
                    panel.removeAll();
                    menuBasico();
                    if (userIn.getClass() == Admin.class) {
                        popUps(accion);
                        menuAdmin(false, true, true);
                    } else {
                        if (userIn.getClass() == User.class) {
                            popUps(accion);
                            menuAdmin(false, true, true);
                        } else {
                            popUps(accion);
                            menuAdmin(false, true, true);
                        }
                    }
                    panel.updateUI();
            }
        };

        ActionListener salir = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                userIn = null;
                menuInicio();
                panel.updateUI();
            }
        };

        ActionListener PopCambio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                tipoSel = tipoEvento.getSelectedItem().toString();
                panel.removeAll();
                menuBasico();
                if (userIn.getClass() == Admin.class) {
                    popUps(accion);
                    menuAdmin(false, true, true);
                } else {
                    if (userIn.getClass() == User.class) {
                        popUps(accion);
                        menuAdmin(false, true, true);
                    } else {
                        popUps(accion);
                        menuAdmin(false, true, true);
                    }
                }
                panel.updateUI();
                
            }
        };

        ActionListener recargarPop = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    if (accion.equals(BEditarUsuario.getActionCommand()) || accion.equals(BEliminarUsuario.getActionCommand())) {
                        userVer = cUsuarioField.getText();
                    } else if (!accion.equals(BListaFecha.getActionCommand())){
                        codigoVer = (int)Integer.valueOf(codigoField.getText());
                    } else if (accion.equals(BListaFecha.getActionCommand())) {
                        fDesde = fechaDesde.getText();
                        fHasta = fechaHasta.getText();
                    }
                    if (buscarEvento(codigoVer) != null || accion.equals(BListaFecha.getActionCommand())) {
                        panel.removeAll();
                        menuBasico();
                        if (userIn.getClass() == Admin.class) {
                            popUps(accion);
                            menuAdmin(false, true, true);
                        } else if (userIn.getClass() == User.class) {
                            popUps(accion);
                            menuAdmin(false, true, true);
                        } else {
                            popUps(accion);
                            menuAdmin(false, true, true);
                        }
                        panel.updateUI();
                    } else {
                        titulo.setText("Inexistente");
                        panel.updateUI();
                    }
            }
        };

        ActionListener CerrarPop = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!hecho){
                    panel.removeAll();
                    menuBasico();
                    if (userIn.getClass() == Admin.class) {
                        menuAdmin(true, false, false);
                    } else {
                        if (userIn.getClass() == User.class) {
                            menuAdmin(false, false, false);
                        } else {
                            menuAdmin(false, true, false);
                        }
                    }
                    panel.updateUI();
                    hecho = true;
                }
            }
        };

        ActionListener CambiarMonto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                montoFijo = Double.valueOf(monto.getText());
            }
        };

        ActionListener Miembro = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (buscarEvento(codigoVer).getClass() == Deportivo.class) {
                    ((Deportivo)buscarEvento(codigoVer)).añadirJugador(agregarMiembro.getText());
                } else if (buscarEvento(codigoVer).getClass() == Musical.class) {
                    ((Musical)buscarEvento(codigoVer)).agregarMiembro(agregarMiembro.getText());
                }
                panel.removeAll();
                menuBasico();
                if (userIn.getClass() == Admin.class) {
                    popUps(accion);
                    menuAdmin(false, true, true);
                } else {
                    if (userIn.getClass() == User.class) {
                        popUps(accion);
                        menuAdmin(false, true, true);
                    } else {
                        popUps(accion);
                        menuAdmin(false, true, true);
                    }
                }
                panel.updateUI();
            }
        };

        ActionListener Agregado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!hecho){
                    if (accion.equals(BCrearEvento.getActionCommand()) && buscarFecha(fechaField.getText()) == null &&
                        buscarEvento((int)Integer.valueOf(codigoField.getText())) == null) {
                        if (tipoEvento.getSelectedIndex() == 0) {

                            generarDeportivo((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, (Deporte)deporteBox.getSelectedItem(),
                            equipo1.getText(), equipo2.getText());
                            System.out.println("Agregado");

                        } else if (tipoEvento.getSelectedIndex() == 1) {

                            generarMusical((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, (Genero)generoBox.getSelectedItem());
                            System.out.println("Agregado");

                        } else if (tipoEvento.getSelectedIndex() == 2) {

                            generarReligioso((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, 0);
                            System.out.println("Agregado");
                        }

                    } else if (accion.equals(BEditarEvento.getActionCommand()) && buscarEvento(codigoVer) != null) {

                        if (buscarEvento(codigoVer).getClass() == Deportivo.class) {

                            editarDeportivo((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, (Deporte)deporteBox.getSelectedItem(),
                            equipo1.getText(), equipo2.getText());

                        } else if (buscarEvento(codigoVer).getClass() == Musical.class) {

                            editarMusical((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, (Genero)generoBox.getSelectedItem());

                        } else if (buscarEvento(codigoVer).getClass() == Religioso.class) {

                            editarReligioso((int)Integer.valueOf(codigoField.getText()), titulo.getText(),
                            descripcionArea.getText(), fechaField.getText(), "22:30", montoFijo, (int)Integer.valueOf(convertidosField.getText()));

                        }
                    } else if (accion.equals(BCrearUsuario.getActionCommand())) {

                        if (tipoUsuario.getSelectedIndex() == 0) {

                            crearAdmin(cNombreField.getText(), cUsuarioField.getText(), cPasswordField.getText(), cEdadField.getText());
                            System.out.println("Creado");
                            
                        } else if (tipoUsuario.getSelectedIndex() == 1) {

                            crearUser(cNombreField.getText(), cUsuarioField.getText(), cPasswordField.getText(), cEdadField.getText());
                            System.out.println("Creado");

                        } else if (tipoUsuario.getSelectedIndex() == 2) {

                            crearLimited(cNombreField.getText(), cUsuarioField.getText(), cPasswordField.getText(), cEdadField.getText());
                            System.out.println("Creado");

                        }
                    } else if (accion.equals(BEditarUsuario.getActionCommand())) {

                        if (buscarU(cUsuarioField.getText()) != null) {
                            buscarU(cUsuarioField.getText()).password = cPasswordField.getText();
                            buscarU(cUsuarioField.getText()).nombre = cNombreField.getText();
                            buscarU(cUsuarioField.getText()).edad = (int)Integer.valueOf(cEdadField.getText());
                        }

                    }
                    //recarga dependiendo cada uno de los usuarios, haciendo que desahibilite segun el usuario
                    panel.removeAll();
                    menuBasico();
                    if (userIn.getClass() == Admin.class) {
                        menuAdmin(true, false, false);
                    } else {
                        if (userIn.getClass() == User.class) {
                            menuAdmin(false, false, false);
                        } else {
                            menuAdmin(false, true, false);
                        }
                    }
                    panel.updateUI();
                    hecho = true;
                }
            }
        };

        ActionListener Eliminado = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (accion.equals(BEliminarEvento.getActionCommand())) {
                    if (buscarEvento(codigoVer) != null && buscarEvento(codigoVer).fecha.after(Calendar.getInstance())) {
                        if (diaAnterior(buscarEvento(codigoVer)) || buscarEvento(codigoVer).getClass() == Religioso.class) {
                            buscarEvento(codigoVer).cancelarEvento();
                        } else
                            buscarEvento(codigoVer).cancelarMultar();
                    }
                } else if (accion.equals(BEliminarUsuario.getActionCommand())) {
                    if (buscarU(cUsuarioField.getText()) !=null && !cUsuarioField.getText().equals(administrador.usuario)) {
                        usuarios.remove(buscarUser(cUsuarioField.getText()));
                    }
                }
                panel.removeAll();
                menuBasico();
                if (userIn.getClass() == Admin.class) {
                    menuAdmin(true, false, false);
                } else {
                    if (userIn.getClass() == User.class) {
                        menuAdmin(false, false, false);
                    } else {
                        menuAdmin(false, true, false);
                    }
                }
                panel.updateUI();
            }
        };
        
        
        if (accion.equals(BCrearEvento.getActionCommand())) {
            tipoEvento.addActionListener(PopCambio);
        }
        if (accion.equals(BEditarEvento.getActionCommand()) || accion.equals(BEliminarEvento.getActionCommand()) ||
            accion.equals(BVerEvento.getActionCommand())) {
            codigoField.addActionListener(recargarPop);
        }

        if (accion.equals(BEditarEvento.getActionCommand()) || accion.equals(BEditarUsuario.getActionCommand()) ||
        accion.equals(BCrearEvento.getActionCommand()) || accion.equals(BCrearUsuario.getActionCommand()))
            AgregarEv.addActionListener(Agregado);

        if (accion.equals(BEliminarEvento.getActionCommand()) || accion.equals(BEliminarUsuario.getActionCommand()))
            EliminarEv.addActionListener(Eliminado);

        inicio.addActionListener(salir);
        if (accion.equals(BEditarEvento.getActionCommand()) &&
        (buscarEvento(codigoVer).getClass() == Deportivo.class || buscarEvento(codigoVer).getClass() == Deportivo.class)) { 
            newMiembro.addActionListener(Miembro);
        }

        if (accion.equals(BEditarUsuario.getActionCommand()) || accion.equals(BEliminarUsuario.getActionCommand()) ||
            accion.equals(BPerfil.getActionCommand())) {
            cUsuarioField.addActionListener(recargarPop);
        }
        if (accion.equals(BListaFecha.getActionCommand())) {
            fechaDesde.addActionListener(recargarPop);
            fechaHasta.addActionListener(recargarPop);
        }
        if (!BCrearEvento.isEnabled()) {
            Cerrar.addActionListener(CerrarPop);
        }
        cambiar.addActionListener(CambiarMonto);

        BCrearEvento.addActionListener(BotonPresionado);
        BEditarEvento.addActionListener(BotonPresionado);
        BEliminarEvento.addActionListener(BotonPresionado);
        BVerEvento.addActionListener(BotonPresionado);

        BCrearUsuario.addActionListener(BotonPresionado);
        BEditarUsuario.addActionListener(BotonPresionado);
        BEliminarUsuario.addActionListener(BotonPresionado);

        BFuturos.addActionListener(BotonPresionado);
        BCancelados.addActionListener(BotonPresionado);
        BRealizados.addActionListener(BotonPresionado);
        BListaFecha.addActionListener(BotonPresionado);
        BPerfil.addActionListener(BotonPresionado);

    }

}
