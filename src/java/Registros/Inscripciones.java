/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

import Modelo.Inscripcion;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

/**
 *
 * @author Pedro
 */
public class Inscripciones {

    private ArrayList<Inscripcion> inscripciones;
    private RandomAccessFile raf;

    public Inscripciones() throws FileNotFoundException {
        this.inscripciones = new ArrayList<>();
        this.raf = new RandomAccessFile("Profesores.txt", "rw");
        File f = new File("Profesores.txt");
        System.out.println(f.getAbsolutePath());
    }

    public ArrayList<Inscripcion> leer() throws FileNotFoundException {
        inscripciones.clear();
        try {
            raf.seek(0);
            for (long i = 0; i < raf.length(); i += 90) {
                raf.seek(i);
                char existe = raf.readChar();
                if (existe == 's') {
                    int id = raf.readInt();
                    int idCurso = raf.readInt();
                    char[] apellido = new char[20];
                    for (int j = 0; j < 20; j++) {
                        char n = raf.readChar();
                        if (n != '0') {
                            apellido[j] = n;
                        }
                    }
                    int ext = raf.readInt();
                    Inscripcion p = new Inscripcion(id, idCurso, apellido, ext);
                    this.inscripciones.add(p);
                }
            }
        } catch (IOException ex) {

        }
        return inscripciones;
    }

    public Inscripcion buscar(int id) {
        Inscripcion p = null;
        try {
            for (int i = 0; i < raf.length(); i += 90) {
                raf.seek(i);
                char existe = raf.readChar();
                if (existe != 'n') {
                    int id2 = raf.readInt();
                    if (id == id2) {
                        int idCurso = raf.readInt();
                        char[] apellido = new char[20];
                        for (int j = 0; j < 20; j++) {
                            char n = raf.readChar();
                            if (n != '0') {
                                apellido[j] = n;
                            }
                        }
                        int ext = raf.readInt();
                        p = new Inscripcion(id, idCurso, apellido, ext);
                        break;
                    }
                }
            }

        } catch (IOException ex) {

        }

        return p;
    }

    public boolean agregar(Inscripcion p) throws IOException {
        boolean res = false;
        if (buscar(p.getIdEst()) == null) {
            long pos = this.raf.length();
            this.raf.seek(pos);
            this.raf.writeChars("s");
            this.raf.writeInt(p.getIdEst());
            int i;
            this.raf.writeChar(p.getIDCurso());
            
            for (i = 0; i < p.getApellido().length; i++) {
                this.raf.writeChar(p.getApellido()[i]);
            }
            if (i < 20) {
                for (int j = i; j < 20; j++) {
                    this.raf.writeChar('0');
                }
            }
            this.raf.writeInt(p.getExt());
            res = true;
        }
        return res;
    }

    public boolean eliminar(int id) {
        boolean res = false;
        try {
            for (int i = 0; i < raf.length(); i += 90) {
                raf.seek(i);
                char existe = raf.readChar();
                if (existe != 'n') {
                    int id2 = raf.readInt();
                    if (id == id2) {
                        raf.seek(i);
                        String h = "n";
                        raf.writeChars(h);
                        res = true;
                        break;
                    }
                }
            }

        } catch (IOException ex) {

        }
        return res;
    }

}
