/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.exam;

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class Inmobiliaria {
    private ArrayList<Inmueble> listaInmuebles = new ArrayList<Inmueble>();
    private String nombreInmobiliaria;
    private String CIF;

    public Inmobiliaria() {
    }

    public ArrayList<Inmueble> getListaInmuebles() {
        return listaInmuebles;
    }

    public void setListaInmuebles(ArrayList<Inmueble> listaInmuebles) {
        this.listaInmuebles = listaInmuebles;
    }

    public String getNombreInmobiliaria() {
        return nombreInmobiliaria;
    }

    public void setNombreInmobiliaria(String nombreInmobiliaria) {
        this.nombreInmobiliaria = nombreInmobiliaria;
    }

    public String getCIF() {
        return CIF;
    }

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    @Override
    public String toString() {
        return "Inmobiliaria{" + "listaInmuebles=" + listaInmuebles + ", nombreInmobiliaria=" + nombreInmobiliaria + ", CIF=" + CIF + '}';
    }
    
    
}
