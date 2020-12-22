/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipo_practica_9;

/**
 *
 * @author mamechapa
 */
public class Libro {
    private String nombre;
    private String autor;
    private String genero;
    private String año;

    public Libro(String nombre, String autor, String genero, String año) {
        this.nombre = nombre;
        this.autor = autor;
        this.genero = genero;
        this.año = año;
    }

    public Libro() {      
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getGenero() {
        return genero;
    }

    public String getAño() {
        return año;
    }
}
