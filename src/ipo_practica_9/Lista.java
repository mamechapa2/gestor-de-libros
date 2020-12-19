/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author mamechapa
 */
public class Lista extends JPanel
        implements ListSelectionListener {

    private JList list;
    private DefaultListModel listModel;

    private static final String anadirString = "Añadir";
    private static final String eliminarString = "Eliminar";
    private JButton eliminarButton;
    private JTextField campoTexto;
    private JFrame frame;

    private Vector<Libro> libros;

    public Lista(JFrame frame, Vector<Libro> librosEjemplo) {
        super(new BorderLayout());
        this.frame = frame;
        this.libros = librosEjemplo;

        listModel = new DefaultListModel();
        addLibros(librosEjemplo);

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        list.addMouseListener(new MouseListener(this));
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton anadirButton = new JButton(anadirString);
        anadirListener anadirListener = new anadirListener(anadirButton);
        anadirButton.setActionCommand(anadirString);
        anadirButton.addActionListener(anadirListener);
        anadirButton.setEnabled(false);

        eliminarButton = new JButton(eliminarString);
        eliminarButton.setActionCommand(eliminarString);
        eliminarButton.addActionListener(new FireListener());

        JButton editButton = new JButton("Editar");
        editButton.setActionCommand("Editar");
        editButton.addActionListener(new EditListener());

        campoTexto = new JTextField(10);
        campoTexto.addActionListener(anadirListener);
        campoTexto.getDocument().addDocumentListener(anadirListener);
        String nombre = listModel.getElementAt(list.getSelectedIndex()).toString();

        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
        buttonPane.add(eliminarButton);
        buttonPane.add(editButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(campoTexto);
        buttonPane.add(anadirButton);

        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
    }

    private void addLibros(Vector<Libro> librosEjemplo) {
        for (Libro libro : librosEjemplo) {
            listModel.addElement(libro.getNombre());
        }
    }

    class MouseListener extends MouseAdapter {

        JPanel lista;

        public MouseListener(JPanel JPanel) {
            this.lista = JPanel;
        }

        @Override
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                list.setVisible(false);
                int index = list.getSelectedIndex();
                list.setVisible(false);
                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
                JComponent panelEdicion = new Edicion(frame, libros.get(index));
                panelEdicion.setOpaque(true);

                frame.setContentPane(panelEdicion);
                frame.pack();
                frame.setVisible(true);
            }
        }
    }

    class EditListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            list.setVisible(false);
            int index = list.getSelectedIndex();
            list.setVisible(false);
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
            JComponent panelEdicion = new Edicion(frame, libros.get(index));
            panelEdicion.setOpaque(true);

            frame.setContentPane(panelEdicion);
            frame.pack();
            frame.setVisible(true);
        }

    }

    class FireListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                eliminarButton.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

//This listener is shared by the text field and the hire button.
    class anadirListener implements ActionListener, DocumentListener {

        private boolean alreadyEnabled = false;
        private JButton button;

        public anadirListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = campoTexto.getText();

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                campoTexto.requestFocusInWindow();
                campoTexto.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }

            listModel.insertElementAt(campoTexto.getText(), index);
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(employeeName.getText());

            //Reset the text field.
            campoTexto.requestFocusInWindow();
            campoTexto.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

//This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {

            if (list.getSelectedIndex() == -1) {
                //No selection, disable fire button.
                eliminarButton.setEnabled(false);

            } else {
                //Selection, enable the fire button.
                eliminarButton.setEnabled(true);
            }
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
