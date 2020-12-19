/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author mamechapa
 */
public class IPO_practica_9 {

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
                crearVentana();
            }
        });
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
        jMenu1.setText("Archivo");
        jMenuItem3.setText("Idioma");
        jMenu1.add(jMenuItem3);
        jMenuItem2.setText("Salir");
        jMenu1.add(jMenuItem2);
        jMenuBar1.add(jMenu1);
        jMenu2.setText("Ayuda");
        jMenuBar1.add(jMenu2);
        frame.setJMenuBar(jMenuBar1);
        
        frame.add(inicio, BorderLayout.PAGE_START);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
