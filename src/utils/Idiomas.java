/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author mamechapa
 */
public class Idiomas {
    
    private Vector<Vector<String>> idiomas;
    private int numIdiomas;

    public Idiomas(String fichero) throws FileNotFoundException, IOException {
        FileReader f = null;
        String linea;

        f = new FileReader(fichero);
        BufferedReader b = new BufferedReader(f);
        
        numIdiomas = Integer.parseInt(b.readLine());
        idiomas = new Vector<>();
        for (int i = 0; i < numIdiomas; i++) {
            Vector<String> idioma = new Vector<>();
            idioma.add(b.readLine());
            int numPalabras = Integer.parseInt(b.readLine());
            for (int j = 0; j < numPalabras; j++) {
                idioma.add(b.readLine());
            }
            
            int numImagenes = Integer.parseInt(b.readLine());
            for (int j = 0; j < numImagenes; j++) {
                //Guardar imagenes
            }
            
            idiomas.add(idioma);
        }
    }

    public Vector<Vector<String>> getIdiomas() {
        return idiomas;
    }
    
    public Vector<String> getIdioma(int cual) {
        return idiomas.get(cual);
    }
    
    public int getNumIdiomas() {
        return numIdiomas;
    }

}
