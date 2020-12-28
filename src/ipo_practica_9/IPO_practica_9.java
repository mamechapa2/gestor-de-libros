/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import utils.Idiomas;
import interfaces.Inicio;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mamechapa
 */
public class IPO_practica_9 {

    static private String jMenu1Text;
    static private String jMenu3Text;
    static private String jMenuItem2Text;
    static private String jMenu2Text;
    private static String jMenuItem3Text;
    private static String jMenuItem4Text;
    private static String jMenuItem5Text;
    private static String textoAyuda;

    static private Idiomas idiomas;

    static private javax.swing.JMenu jMenu1;
    static private javax.swing.JMenu jMenu2;
    static private javax.swing.JMenuBar jMenuBar1;
    static private javax.swing.JMenuItem jMenuItem2;
    static private javax.swing.JMenuItem jMenu3;
    static private javax.swing.JMenuItem jMenuItem3;
    static private javax.swing.JMenuItem jMenuItem4;
    static private javax.swing.JMenuItem jMenuItem5;

    static private Inicio inicio;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                cargarIdiomas();
                crearVentana();
            }
        });
    }

    private static void cargarIdiomas() {
        try {
            idiomas = new Idiomas("idiomas.txt");
        } catch (IOException ex) {
            Logger.getLogger(IPO_practica_9.class.getName()).log(Level.SEVERE, null, ex);
        }

        jMenu1Text = idiomas.getIdioma(0).get(1);
        jMenu3Text = idiomas.getIdioma(0).get(2);
        jMenuItem2Text = idiomas.getIdioma(0).get(3);
        jMenu2Text = idiomas.getIdioma(0).get(4);
        jMenuItem3Text = idiomas.getIdioma(0).get(11);
        jMenuItem4Text = idiomas.getIdioma(0).get(12);
        jMenuItem5Text = idiomas.getIdioma(0).get(13);
        textoAyuda = idiomas.getIdioma(0).get(14);
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("Gestor de libros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 300));
        inicio = new Inicio(frame, idiomas.getIdioma(0));

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu1.setText(jMenu1Text);//Archivo
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem3.setText(jMenuItem3Text);
        jMenuItem3.addActionListener(new AbrirListener(frame));
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem4.setText(jMenuItem4Text);
        jMenuItem4.addActionListener(new GuardarListener(frame));
        jMenu3 = new javax.swing.JMenu();
        jMenu3.setText(jMenu3Text); //Idioma
        for (int i = 0; i < idiomas.getNumIdiomas(); i++) {
            JMenuItem menuItemAux = new JMenuItem(idiomas.getIdioma(i).firstElement());
            menuItemAux.addActionListener(new IdiomaListener(i));
            jMenu3.add(menuItemAux);
        }
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem2.setText(jMenuItem2Text);//Salir
        jMenuItem2.addActionListener(new CloseListener());
        jMenu2 = new javax.swing.JMenu();
        jMenu2.setText(jMenu2Text); //Ayuda
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem5.setText(jMenuItem5Text);
        jMenuItem5.addActionListener(new AyudaListener(frame));

        jMenu1.add(jMenuItem3);
        jMenu1.add(jMenuItem4);
        jMenu1.add(jMenu3);
        jMenu1.add(jMenuItem2);
        jMenu2.add(jMenuItem5);
        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        frame.setJMenuBar(jMenuBar1);

        frame.add(inicio, BorderLayout.PAGE_START);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    static class IdiomaListener implements ActionListener {

        private int idioma;

        public IdiomaListener(int idioma) {
            this.idioma = idioma;
        }

        public void actionPerformed(ActionEvent e) {
            inicio.setIdioma(idiomas.getIdioma(idioma));
            cambiarIdioma(idioma);
        }
    }

    static class AbrirListener implements ActionListener {

        private JFrame frame;

        public AbrirListener(JFrame frame) {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    ".txt", "txt");
            selectorArchivos.setFileFilter(filter);
            int resultado = selectorArchivos.showOpenDialog(frame);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selectorArchivos.getSelectedFile();
                System.out.println("Fichero cargado: " + archivo.getAbsolutePath());
                cargarDatos(archivo.getAbsolutePath());
            }
        }
    }

    static class GuardarListener implements ActionListener {

        private JFrame frame;

        public GuardarListener(JFrame frame) {
            this.frame = frame;
        }

        public void actionPerformed(ActionEvent e) {
            inicio.guardarDatos();
        }
    }

    static class AyudaListener implements ActionListener {

        private JFrame framePadre;

        public AyudaListener(JFrame frame) {
            this.framePadre = frame;
        }

        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(framePadre, textoAyuda);
        }
    }

    static private class CloseListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    public static void cambiarIdioma(int cual) {
        jMenu1Text = idiomas.getIdioma(cual).get(1);
        jMenu3Text = idiomas.getIdioma(cual).get(2);
        jMenuItem2Text = idiomas.getIdioma(cual).get(3);
        jMenu2Text = idiomas.getIdioma(cual).get(4);
        jMenuItem3Text = idiomas.getIdioma(cual).get(11);
        jMenuItem4Text = idiomas.getIdioma(cual).get(12);
        jMenuItem5Text = idiomas.getIdioma(cual).get(13);
        textoAyuda = idiomas.getIdioma(cual).get(14);

        jMenu1.setText(jMenu1Text);//Archivo
        jMenu3.setText(jMenu3Text); //Idioma
        jMenuItem2.setText(jMenuItem2Text);//Salir
        jMenu2.setText(jMenu2Text);
        jMenuItem3.setText(jMenuItem3Text);
        jMenuItem4.setText(jMenuItem4Text);
        jMenuItem5.setText(jMenuItem5Text);
    }

    public static void cargarDatos(String ruta) {
        inicio.cargarDatos(ruta);
    }

}
