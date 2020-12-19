/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;

/**
 *
 * @author mamechapa
 */
public class Inicio extends javax.swing.JPanel {

    private JFrame framePadre;

    private DefaultListModel listModel;
    
    Vector<String> idioma;

    private Vector<Libro> vectorLibros;
    private Libro libroAnterior;

    /**
     * Creates new form Inicio
     */
    public Inicio(JFrame framePadre, Vector<String> idioma) {
        initComponents();

        this.framePadre = framePadre;
        this.vectorLibros = new Vector<>();
        this.idioma = idioma;
        cambiarIdioma();

        this.listModel = new DefaultListModel();
        addLibrosEjemplo();
        list.setModel(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        list.addMouseListener(new MouseListener(this));
        setMinimumSize(new Dimension(500, 400));
        addButton.addActionListener(new NuevoListener(this));

        setVisible(true);
    }

    private void addLibrosEjemplo() {
        vectorLibros.add(new Libro("La chica de nieve", "Javier Castillo", "Thriller", "2020"));
        vectorLibros.add(new Libro("Marina", "Carlos Ruiz Zafon", "pf xd", "nosexd"));
        vectorLibros.add(new Libro("La pareja de al lado", "Shari Lapena", "ajajjjajj", "xd"));
        vectorLibros.add(new Libro("Tierra", "Eloy Moreno", "Thriller", "2020"));

        for (Libro libro : vectorLibros) {
            listModel.addElement(libro.getNombre() + " | " + libro.getAutor());
        }
    }

    public void guardarLibro(Libro libro) {
        vectorLibros.add(libro);
        listModel.addElement(libro.getNombre() + " | " + libro.getAutor());
    }

    public void restaurarLibro() {
        vectorLibros.add(libroAnterior);
        listModel.addElement(libroAnterior.getNombre() + " | " + libroAnterior.getAutor());
    }
    
    public void cambiarIdioma(){
        addButton.setText(idioma.get(5));
        deleteButton.setText(idioma.get(6));
    }
    
    public void setIdioma(Vector<String> idioma){
        this.idioma = idioma;
        cambiarIdioma();
    }

    class MouseListener extends MouseAdapter {

        Inicio inicio;

        public MouseListener(Inicio JPanel) {
            this.inicio = JPanel;
        }

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                int elementoSeleccionado = list.getSelectedIndex();
                list.setSelectedIndex(elementoSeleccionado);
                list.ensureIndexIsVisible(elementoSeleccionado);

                Edicion edicion = new Edicion(inicio, vectorLibros.get(elementoSeleccionado), idioma);
                libroAnterior = vectorLibros.get(elementoSeleccionado);
                vectorLibros.remove(elementoSeleccionado);
                listModel.remove(elementoSeleccionado);

                framePadre.add(edicion, BorderLayout.PAGE_START);
                framePadre.pack();
                edicion.setVisible(true);
                inicio.setVisible(false);
            }
        }
    }

    class NuevoListener implements ActionListener {

        Inicio inicio;

        public NuevoListener(Inicio JPanel) {
            this.inicio = JPanel;
        }

        public void actionPerformed(ActionEvent e) {
            Libro libro = new Libro();
            Nuevo nuevo = new Nuevo(inicio, libro, idioma);

            framePadre.add(nuevo, BorderLayout.PAGE_START);
            framePadre.pack();
            nuevo.setVisible(true);
            inicio.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();

        list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list);

        addButton.setText("Nuevo");

        deleteButton.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addGap(0, 277, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(deleteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list;
    // End of variables declaration//GEN-END:variables

}
