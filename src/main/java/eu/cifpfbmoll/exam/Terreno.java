/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.exam;

import static eu.cifpfbmoll.exam.Vivienda.IVAVivienda;
import java.util.Scanner;

/**
 *
 * @author rafa
 */
public class Terreno extends Inmueble {

    public static float IVARustico = (float) 4;
    public static float IVAUrbano = (float) 6;
    public static float IVAUrbanizable = (float) 8;
    private Calificacion tipoCalificacion;

    public Terreno() {
    }

    public Calificacion getTipoCalificacion() {
        return tipoCalificacion;
    }

    public void setTipoCalificacion(Calificacion tipoCali) {
        this.tipoCalificacion = tipoCali;
    }

    public void setTipoCalificacion() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el tipo de calificación del suelo "
                + "//1 RUSTICO\n"
                + "        //2 URBANO\n"
                + "        //3 URBANIZABLE");
        int numCalificacion = lector.nextInt();
        lector.nextLine();// limpio el retorno de carro.
        //1 RUSTICO
        //2 URBANO
        //3 URBANIZABLE
        switch (numCalificacion) {
            case 1:
                this.tipoCalificacion = Calificacion.RUSTICO;
                break;
            case 2:
                this.tipoCalificacion = Calificacion.URBANO;
                break;
            case 3:
                this.tipoCalificacion = Calificacion.URBANIZABLE;
                break;
            default:
                System.out.println("Error: el tipo de suelo introducido no es correcto");
                break;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "Terreno{" + "tipoCalificacion=" + tipoCalificacion + this.calcularPrecioCompraventa() + '}';
    }

    @Override
    public void solicitarDatos() {
        super.solicitarDatos(); //To change body of generated methods, choose Tools | Templates.
        this.setTipoCalificacion();
        System.out.println("Has añadido " + this.toString());
    }

    public static Terreno añadirTerreno() {
        Terreno vivTemp = new Terreno();
        vivTemp.solicitarDatos();
        return vivTemp;
    }

    @Override
    public String calcularPrecioCompraventa() {
        String resultado;
        //1 RUSTICO
        //2 URBANO
        //3 URBANIZABLE
        switch (this.getTipoCalificacion().ordinal()) {
            case 0:
                resultado = "Precio de compraventa de la vivienda"
                        + this.getPrecio() * IVARustico + " €";
                break;
            case 1:
                resultado = "Precio de compraventa de la vivienda"
                        + this.getPrecio() * IVAUrbano + " €";
                break;
            case 2:
                resultado = "Precio de compraventa de la vivienda"
                        + this.getPrecio() * IVAUrbanizable + " €";
                break;
            default:
                resultado = ("Error: no se ha podido calcular el precio ya que no "
                        + "se conoce el tipo de suelo");
                break;
        }
        return resultado;
    }

}
