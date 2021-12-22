
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author instalador
 */
public class Coche implements Serializable {

    String matricula;
    String color;
    String modelo;
    int año;

    public Coche(String matricula, String color, String modelo, int año) {
        this.matricula = matricula;
        this.color = color;
        this.modelo = modelo;
        this.año = año;
    }

    public void mostrarCoche() {
        System.out.println("Matricula " + matricula + " Color: " + color + " Modelo: " + modelo);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

}
