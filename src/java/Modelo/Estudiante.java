/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Pedro
 */
public class Estudiante {

    private int id;
    private char[] nombre;
    private char[] apellido;
    private int Telefono;

    public Estudiante(int id, char[] nombre, char[] apellido, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char[] getNombre() {
        return nombre;
    }

    public void setNombre(char[] nombre) {
        this.nombre = nombre;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getTelefono() {
        return Telefono;
    }

    public void setTelefono(int ext) {
        this.Telefono = ext;
    }

}
