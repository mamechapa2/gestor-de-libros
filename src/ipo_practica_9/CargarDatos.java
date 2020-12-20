/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author mamechapa
 */
public class CargarDatos {

    private Vector<Libro> datos;

    public CargarDatos(String fichero) throws FileNotFoundException, IOException {
        this.datos = new Vector<>();
        File archivo = new File(fichero);
        Scanner scn = new Scanner(archivo);
        while (scn.hasNext()) {
            String linea = scn.nextLine();
            String[] split = linea.split(";");
            Libro nuevoLibro = new Libro(split[0], split[1], split[2], split[3]);
            datos.add(nuevoLibro);
        }
    }

    public Vector<Libro> getDatos() {
        return datos;
    }
    
    

}
