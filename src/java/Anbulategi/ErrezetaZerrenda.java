/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.ArrayList;

/**
 *
 * @author Oier
 */
public class ErrezetaZerrenda {
    //AT
    private ArrayList<Errezeta> lista;
    
    //Constructor
    public ErrezetaZerrenda(){
        lista = new ArrayList<Errezeta>();
    }
    
    //Methods
    public void addErrezeta(Errezeta pEr){
        lista.add(pEr);
    }
    
    public void removeErrezeta(Errezeta pEr){
        lista.remove(pEr);
    }
}
