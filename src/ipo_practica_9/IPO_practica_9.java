/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author mamechapa
 */
public class IPO_practica_9 {

    static private String jMenu1Text;
    static private String jMenuItem3Text;
    static private String jMenuItem2Text;
    static private String jMenu2Text;

    static private Idiomas idiomas;

    static private javax.swing.JMenu jMenu1;
    static private javax.swing.JMenu jMenu2;
    static private javax.swing.JMenuBar jMenuBar1;
    static private javax.swing.JMenuItem jMenuItem2;
    static private javax.swing.JMenuItem jMenuItem3;

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
        jMenuItem3Text = idiomas.getIdioma(0).get(2);
        jMenuItem2Text = idiomas.getIdioma(0).get(3);
        jMenu2Text = idiomas.getIdioma(0).get(4);
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 400));
        Inicio inicio = new Inicio(frame);

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu1.setText(jMenu1Text);
        jMenuItem3.setText(jMenuItem3Text);
        jMenu1.add(jMenuItem3);
        jMenuItem2.setText(jMenuItem2Text);
        jMenu1.add(jMenuItem2);
        jMenuBar1.add(jMenu1);
        jMenu2.setText(jMenu2Text);
        jMenuBar1.add(jMenu2);
        frame.setJMenuBar(jMenuBar1);

        frame.add(inicio, BorderLayout.PAGE_START);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
