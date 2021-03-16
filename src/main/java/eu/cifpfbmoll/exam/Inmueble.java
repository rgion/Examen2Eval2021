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
 * @author rafa 12.40-13.10 - hasta el punto d.+1 HORA
 */
public abstract class Inmueble {
    private float metrosCuadrados;
    private float precio;
    private String poblacion;
    private int id;
    private static int controlId;

    public Inmueble() {
        id=controlId++;     
    }

    public Inmueble(float metrosCuadrados, float precio, String poblacion, int id) {
        id=controlId++; 
        this.setMetrosCuadrados(metrosCuadrados);
        this.setPrecio(precio);
        this.setPoblacion(poblacion);
    }
    public Inmueble(Inmueble miInmueble) {
        id=controlId++; 
        this.setMetrosCuadrados(metrosCuadrados);
        this.setPrecio(precio);
        this.setPoblacion(poblacion);
    }    

    public float getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(float metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        Scanner lector= new Scanner(System.in);
        while(precio<=0){
            System.out.println("El precio debe ser superior a 0. Por favor "
                    + "introduzca de nuevo el precio. Gracias.");
            precio=lector.nextFloat();
        }
        this.precio = precio;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void solicitarDatos(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Dame los metros cuadrados de la vivienda");
        this.setMetrosCuadrados(lector.nextInt());
        lector.nextLine();//limpio el retorno de carro
        System.out.println("Dame el precio");
        this.setPrecio(lector.nextFloat());
        lector.nextLine();//limpio el retorno de carro.
        System.out.println("Dame la población");
        this.setPoblacion(lector.nextLine());      
        
    }
    
    public static void buscarVivienda(ArrayList<Inmueble> lista) {
        // en vivienda busca por número de habitaciones
        // mostraremos todas las viviendas con dicho criterio
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el número de habitaciones que quieres que tenga tu vivienda");
        int numHabit=lector.nextInt();
        lector.nextLine();
        System.out.println("Las viviendas encontradas que cumplen dicho criterio son");
        for (int i=0; i < lista.size();i++){
            if (lista.get(i) instanceof Vivienda){
                if (((Vivienda)lista.get(i)).getNumHabitaciones()==numHabit){
                    System.out.println(i+1+") "+((Vivienda)lista.get(i)).toString());
                }
            }
        }
    }
    
    public static void buscarTerreno(ArrayList<Inmueble> lista) {
        // solo queremos encontrar la primera ocurrencia que se encuentre con dicho criterio
        Scanner lector = new Scanner(System.in);
        Calificacion califTemp;
        System.out.println("Te vamos a decir el primer terreno con la calificación que nos digas"
                + "que encontremos");
       
                System.out.println("Introduce el tipo de calificación del suelo "
       + "//0 RUSTICO"+
         "//1 URBANO"+
         "//2 URBANIZABLE");
        int numCalificacion = lector.nextInt();
        lector.nextLine();// limpio el retorno de carro.
        
        int i=0;

        boolean encontrado = false;
        
        while ((i < lista.size()) && (encontrado == false)) {
            if (lista.get(i) instanceof Terreno){
                System.out.println("Terreno "+ ((Terreno)lista.get(i)).getTipoCalificacion().ordinal());
                if (((Terreno)lista.get(i)).getTipoCalificacion().ordinal()==numCalificacion){
                    System.out.println(((Terreno)lista.get(i)).toString());
                    encontrado=true;
                    System.out.println("Terreno encontrado "+((Terreno)lista.get(i)).toString());
                    
                }
            }
            i++;
        }
        if (encontrado == false) {
            System.out.println("NO SE HA ENCONTRADO NINGÚN TERRENO CON LA CALIFICACIÓN SOLICITADA");
        }
    }

    @Override
    public String toString() {
        return "Inmueble{" + "metrosCuadrados=" + metrosCuadrados + ", precio=" + precio + ", poblacion=" + poblacion + ", id=" + id + '}';
    }
    public abstract String calcularPrecioCompraventa();
    
}
