/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Labing
 */
public class Inscripcion {
    private int idEst;
    private int idCurso;
    private char[] apellido;
    private int ext;

    public Inscripcion(int idEst, int idCurso, char[] apellido, int ext) {
        this.idEst = idEst;
        this.idCurso = idCurso;
        this.apellido = apellido;
        this.ext = ext;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int id) {
        this.idEst = id;
    }

    public int getIDCurso() {
        return idCurso;
    }

    public void setIDCurso(int id) {
        this.idCurso = id;
    }

    public char[] getApellido() {
        return apellido;
    }

    public void setApellido(char[] apellido) {
        this.apellido = apellido;
    }

    public int getExt() {
        return ext;
    }

    public void setExt(int ext) {
        this.ext = ext;
    }
    
    
    
}
