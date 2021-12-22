
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author instalador
 */
public class Principal {

    public static void main(String[] args) {
        Fichero ficher = new Fichero("Coches.dat");
        Coche coche1 = new Coche("5521-BBC", "Blanco", "Toledo", 2000);
        ficher.insertarObjeto(coche1);
        ficher.LeerCoche();

    }
}
