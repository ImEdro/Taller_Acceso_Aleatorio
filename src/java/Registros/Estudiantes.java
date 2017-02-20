/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registros;

/**
 *
 * @author Pedro
 */
import Modelo.Estudiante;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Estudiantes {

    private ArrayList<Estudiante> estudiantes;
    private RandomAccessFile raf;

    public Estudiantes() throws FileNotFoundException {
        this.estudiantes = new ArrayList<>();
        this.raf = new RandomAccessFile("Profesores.txt", "rw");
        File f = new File("Profesores.txt");
        System.out.println(f.getAbsolutePath());
    }

    public ArrayList<Estudiante> leer() throws FileNotFoundException {
        estudiantes.clear();
        try {
            raf.seek(0);
            for (long i = 0; i < raf.length(); i += 90) {
                raf.seek(i);
                char existe = raf.readChar();
                if (existe == 's') {
                    int id = raf.readInt();
                    char[] nombre = new char[20];
                    for (int j = 0; j < 20; j++) {
                        char n = raf.readChar();
                        if (n != '0') {
                            nombre[j] = n;
                        }
                    }
                    char[] apellido = new char[20];
                    for (int j = 0; j < 20; j++) {
                        char n = raf.readChar();
                        if (n != '0') {
                            apellido[j] = n;
                        }
                    }
                    int ext = raf.readInt();
                    Estudiante p = new Estudiante(id, nombre, apellido, ext);
                    this.estudiantes.add(p);
                }
            }
        } catch (IOException ex) {
            
        }
        return estudiantes;
    }

    public Estudiante buscar(int id) {
        Estudiante p = null;
        try {
            for (int i = 0; i < raf.length(); i += 90) {
                raf.seek(i);
                char existe = raf.readChar();
                if (existe != 'n') {
                    int id2 = raf.readInt();
                    if (id == id2) {
                        char[] nombre = new char[20];
                        for (int j = 0; j < 20; j++) {
                            char n = raf.readChar();
                            if (n != '0') {
                                nombre[j] = n;
                            }
                        }
                        char[] apellido = new char[20];
                        for (int j = 0; j < 20; j++) {
                            char n = raf.readChar();
                            if (n != '0') {
                                apellido[j] = n;
                            }
                        }
                        int ext = raf.readInt();
                        p = new Estudiante(id, nombre, apellido, ext);
                        break;
                    }
                }
            }

        } catch (IOException ex) {
            
        }

        return p;
    }

    public boolean agregar(Estudiante p) throws IOException {
        boolean res = false;
        if (buscar(p.getId()) == null) {
            long pos = this.raf.length();
            this.raf.seek(pos);
            this.raf.writeChars("s");
            this.raf.writeInt(p.getId());
            int i ;
            for (i = 0; i < p.getNombre().length; i++) {
                this.raf.writeChar(p.getNombre()[i]);
            }
            if (i < 20) {
                for (int j = i; j < 20; j++) {
                    this.raf.writeChar('0');
                }
            }
            for (i = 0; i < p.getApellido().length; i++) {
                this.raf.writeChar(p.getApellido()[i]);
            }
            if (i < 20) {
                for (int j = i; j < 20; j++) {
                    this.raf.writeChar('0');
                }
            }
            this.raf.writeInt(p.getTelefono());
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
