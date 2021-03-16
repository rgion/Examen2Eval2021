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
public class GestionInmobiliaria {
    public static Scanner sn = new Scanner(System.in);
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Inmobiliaria> listaInmobiliaria=new ArrayList<Inmobiliaria>();
        
        iniciarInmobiliaria(listaInmobiliaria);
        
        int numInmo=buscarInmobiliaria(listaInmobiliaria);
        
        gestionarInmobiliaria(numInmo, listaInmobiliaria);
    }

    public static void gestionarInmobiliaria(int numInmo, ArrayList<Inmobiliaria> listaInmobiliaria) {
        boolean salir = false;
        int opcion = 0; //Guardaremos la opcion del usuario
        
        
        while (!salir && numInmo!=-1) {

            System.out.println("1. Opcion 1 - Añadir terreno");
            System.out.println("2. Opcion 2 - Añadir vivienda");
            System.out.println("3. Opcion 3 - Buscar vivienda");
            System.out.println("3. Opcion 4 - Buscar terreno");
            
            System.out.println("5. Opcion 5 - Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sn.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("1. Opcion 1 - Añadir terreno");
                    listaInmobiliaria.get(numInmo).getListaInmuebles().add(Terreno.añadirTerreno());
                            
                    break;
                case 2:
                    System.out.println("2. Opcion 2 - Añadir vivienda");
                    listaInmobiliaria.get(numInmo).getListaInmuebles().add(Vivienda.añadirVivienda());
                    break;
                case 3:
                    System.out.println("3. Opcion 3 - Buscar vivienda");
                    Inmueble.buscarVivienda(listaInmobiliaria.get(numInmo).getListaInmuebles());
                    break;
                case 4:
                    System.out.println("4. Opcion 4 - Buscar terreno");
                    Inmueble.buscarTerreno(listaInmobiliaria.get(numInmo).getListaInmuebles());
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Las opciones disponibles son 1,2,3 y 4. "
                            + "Vuelva a intentarlo");
                    break;
            }

        }
    }
    
    public static int buscarInmobiliaria(ArrayList<Inmobiliaria> lista){
        System.out.println("Dime el CIF de la inmobiliaria que quieres trabajar");
        System.out.println(lista.toString());
        String CIFInmobiliaria=sn.nextLine();
        
        int i=0;
        int resultado=-1;

        boolean encontrado = false;
        
        while ((i < lista.size()) && (encontrado == false)) {
            if (lista.get(i).getCIF().equals(CIFInmobiliaria)){
                    encontrado=true;
                    resultado=i;
            }
            else {
                i++;
            }
        }
        if (encontrado == false) {
            System.out.println("NO SE HA ENCONTRADO NINGÚN TERRENO CON LA CALIFICACIÓN SOLICITADA");
        }
        return resultado;
    }

    public static void iniciarInmobiliaria(ArrayList<Inmobiliaria> listaInmobiliaria) {
        Inmobiliaria inmoTemp;
        Terreno terrenoTemp;
        Vivienda viviendaTemp;
        
        for (int i=0;i<3;i++){
            inmoTemp=new Inmobiliaria();
            inmoTemp.setCIF("Inmo0"+i);
            inmoTemp.setNombreInmobiliaria("nombreInmo"+1);
            for (int j=0;j<3;j++){
                terrenoTemp = new Terreno();
                terrenoTemp.setId(i+j);
                terrenoTemp.setMetrosCuadrados(j*80);
                terrenoTemp.setPoblacion("poblac"+j);
                terrenoTemp.setPrecio(30000*(i+1));
                terrenoTemp.setTipoCalificacion(Calificacion.RUSTICO);
                inmoTemp.getListaInmuebles().add(terrenoTemp);
                
                viviendaTemp = new Vivienda();
                viviendaTemp.setId(i+j);
                viviendaTemp.setMetrosCuadrados(j*80);
                viviendaTemp.setPoblacion("poblac"+j);
                viviendaTemp.setPrecio(30000*(i+1));                
                viviendaTemp.setDescripcion("descripcion vivienda "+i);
                viviendaTemp.setNumHabitaciones(i+j+1);
                
                inmoTemp.getListaInmuebles().add(viviendaTemp);
                
            }
            listaInmobiliaria.add(inmoTemp);
        }
        
    }
}
