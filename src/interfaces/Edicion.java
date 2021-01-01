/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import ipo_practica_9.Libro;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mamechapa
 */
public class Edicion extends javax.swing.JPanel {

    private Inicio panelAnterior;
    private Libro libro;

    private Vector<String> idioma;
    private Vector<ImageIcon> imagenes;

    /**
     * Creates new form Edicion
     */
    public Edicion(Inicio panelAnterior, Libro libro, Vector<String> idioma, Vector<ImageIcon> imagenes) {
        initComponents();
        this.panelAnterior = panelAnterior;
        this.libro = libro;
        this.idioma = idioma;
        this.imagenes = imagenes;
        cambiarIdioma();

        jTextFieldNombre.setText(libro.getNombre());
        jTextFieldAutor.setText(libro.getAutor());
        jTextFieldGenero.setText(libro.getGenero());
        jTextFieldAnio.setText(libro.getAño());

        if (libro.isTieneImagen()) {
           ImageIcon imageIcon = new ImageIcon(new ImageIcon(libro.getRutaImagen()).getImage().getScaledInstance(82, 125, Image.SCALE_DEFAULT));
           imagenLibro.setIcon(imageIcon);
        }else{
            imagenLibro.setIcon(imagenes.get(0));
        }
        
        

        saveButton.addActionListener(new SaveListener(this));
        volverButton.addActionListener(new VolverListener(this));
        addImage.addActionListener(new AddImageListener(this));
    }

    public void guardarLibro() {
        libro.setNombre(jTextFieldNombre.getText());
        libro.setAutor(jTextFieldAutor.getText());
        libro.setGenero(jTextFieldGenero.getText());
        libro.setAño(jTextFieldAnio.getText());
        panelAnterior.guardarLibro(libro);
    }

    public void cambiarIdioma() {
        jLabelNombre.setText(idioma.get(7));
        jLabelAutor.setText(idioma.get(8));
        jLabelGenero.setText(idioma.get(9));
        jLabelAnio.setText(idioma.get(10));
        saveButton.setText(idioma.get(16));
        volverButton.setText(idioma.get(15));        
        addImage.setText(idioma.get(18));
    }

    public void setImagenLibro(String ruta) {
        libro.setRutaImagen(ruta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldNombre = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jLabelAutor = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jLabelAnio = new javax.swing.JLabel();
        jTextFieldAnio = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        volverButton = new javax.swing.JButton();
        imagenLibro = new javax.swing.JLabel();
        addImage = new javax.swing.JButton();

        jTextFieldNombre.setText("jTextField1");

        jLabelNombre.setText("Nombre");

        jLabelAutor.setText("Autor");

        jTextFieldAutor.setText("jTextField2");

        jLabelGenero.setText("Genero");

        jTextFieldGenero.setText("jTextField3");

        jLabelAnio.setText("Año");

        jTextFieldAnio.setText("jTextField4");

        saveButton.setText("Guardar");

        volverButton.setText("Volver");

        addImage.setText("Añadir imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 287, Short.MAX_VALUE)
                        .addComponent(volverButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
                            .addComponent(jTextFieldGenero, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldAutor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAutor, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAnio, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addImage, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                            .addComponent(imagenLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabelNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelAutor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagenLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addImage)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(saveButton)
                            .addComponent(volverButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelAnio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addImage;
    private javax.swing.JLabel imagenLibro;
    private javax.swing.JLabel jLabelAnio;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JTextField jTextFieldAnio;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton volverButton;
    // End of variables declaration//GEN-END:variables

    class SaveListener implements ActionListener {

        Edicion panelEdicion;

        public SaveListener(Edicion panelEdicion) {
            this.panelEdicion = panelEdicion;
        }

        public void actionPerformed(ActionEvent e) {
            panelEdicion.guardarLibro();
            panelEdicion.setVisible(false);
            panelAnterior.setVisible(true);
        }
    }

    class VolverListener implements ActionListener {

        Edicion panelEdicion;

        public VolverListener(Edicion panelEdicion) {
            this.panelEdicion = panelEdicion;
        }

        public void actionPerformed(ActionEvent e) {
            panelAnterior.restaurarLibro();
            panelEdicion.setVisible(false);
            panelAnterior.setVisible(true);
        }
    }

    static class AddImageListener implements ActionListener {

        private Edicion nuevo;

        public AddImageListener(Edicion nuevo) {
            this.nuevo = nuevo;
        }

        public void actionPerformed(ActionEvent e) {
            JFileChooser selectorArchivos = new JFileChooser();
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
                    ".jpg", "jpg");
            selectorArchivos.setFileFilter(filter);
            int resultado = selectorArchivos.showOpenDialog(null);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selectorArchivos.getSelectedFile();
                System.out.println("Fichero cargado: " + archivo.getAbsolutePath());
                cargarImagen(archivo.getAbsolutePath());
            }
        }

        private void cargarImagen(String ruta) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(82, 125, Image.SCALE_DEFAULT));
            nuevo.imagenLibro.setIcon(imageIcon);
            nuevo.setImagenLibro(ruta);
        }
    }
}
