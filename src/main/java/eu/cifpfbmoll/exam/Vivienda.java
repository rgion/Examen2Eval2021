/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rafa
 */
public class Vivienda extends Inmueble {
    public final static float IVAVivienda =(float) 10;
    private int numHabitaciones;
    private String descripcion;

    public Vivienda() {
    }

    
    public Vivienda(Vivienda vivCopia) {
        super((Inmueble)vivCopia);
        this.setNumHabitaciones(numHabitaciones);
        this.setDescripcion(descripcion);
    }

    public int getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(int numHabitaciones) {
        Scanner lector =new Scanner(System.in);
        while (numHabitaciones<=0){
            System.out.println("Debe establecer un número de habitiaciones correcto");
            numHabitaciones=lector.nextInt();
        }
        this.numHabitaciones = numHabitaciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void solicitarDatos() {
        super.solicitarDatos(); //To change body of generated methods, choose Tools | Templates.
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce la descripción de la vivienda");
        this.setDescripcion(lector.nextLine());
        System.out.println("Introduce el número de habitaciones de la vivienda");
        this.setNumHabitaciones(lector.nextInt());
        lector.nextLine();
        System.out.println("Has añadido "+super.toString()+ this.toString());
    }
    

    @Override
    public String toString() {
        return super.toString()+"Vivienda{" + "numHabitaciones=" + numHabitaciones + ", descripcion=" + descripcion + this.calcularPrecioCompraventa()+'}';
    }
    
    public static Vivienda añadirVivienda(){
        Vivienda vivTemp=new Vivienda();
        vivTemp.solicitarDatos();
        return vivTemp;
    }

    @Override
    public String calcularPrecioCompraventa() {
        return ("Precio de compraventa de la vivienda:" + this.getPrecio()*IVAVivienda +" €");
    }
       
}
