
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Víctor
 */
public class Fichero {

    File fichero;
    FileOutputStream fout = null;
    ObjectOutputStream out = null;
    FileInputStream fin = null;
    ObjectInputStream in = null;

    /**
     * Este constructor llama a crearDirectorio y crea directorio
     *
     * @param ruta Carpeta donde se guarda el proyecto
     * @param nombre String con el nombre del fichero
     */
    public Fichero(String ruta, String nombre) {
        crearDirectorio(ruta, nombre);
    }

    /**
     * Este constructor sobrecarga al otro constructor y le pasa ruta y nombre
     *
     * @param nombre
     */
    public Fichero(String nombre) {
        this("", nombre);

    }

    /**
     * Creamos directorio en la carpeta donde almacenamos el proyecto
     *
     * @param ruta String de la carpeta del proyecto
     * @param nombre String del nombre qu le queremos dar.
     */
    public void crearDirectorio(String ruta, String nombre) {
        File fiche = new File(ruta).getAbsoluteFile();
         System.out.println(fiche);
        fiche = new File(fiche + File.separator + "Ficheros_Generados");
        System.out.println(fiche.toString());
        fichero = new File(fiche, nombre);

        if (fichero.getParentFile().mkdir()) {
            System.out.println("Se ha creado el directorio " + this.fichero.getParent());
        } else {
            System.out.println("Ya existe el directorio " + this.fichero.getParent());
        }
    }

    /**
     * Insertamos el coche pasado por parametro al fichero libro.dat
     *
     * @param coche Objeto pasado desde el Main que instroducimos en el fichero
     */
    public void insertarObjeto(Coche coche) {

        try {

            if (!fichero.exists()) {
                fichero.createNewFile();
                fout = new FileOutputStream(fichero, true);
                out = new ObjectOutputStream(fout);
                out.writeObject(coche);
            } else {
                fout = new FileOutputStream(fichero, true);
                out = new MiObjetcOutputStream(fout);
                out.writeObject(coche);
            }

            out.close();
            fout.close();

        } catch (Exception e) {
            System.out.println("No se pudo guardar el coche");
        }
    }

    /**
     * Lee el fichero libro.dat que contiene los objetos
     */
    public void LeerCoche() {
        try {
            fin = new FileInputStream(fichero);
            in = new ObjectInputStream(fin);
            try {
                while (true) {
                    Coche coche = (Coche) in.readObject();
                    System.out.println("Matricula " + coche.getMatricula() + " Modelo: " + coche.getModelo() + " Color: " + coche.getColor() + " Año: " + coche.getAño());
                }
            } catch (EOFException e) {
                in.close();
                fin.close();
            }

        } catch (IOException ex) {
            ex.getMessage();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Fichero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
