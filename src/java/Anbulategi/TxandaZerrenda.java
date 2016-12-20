/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Oier
 */
class TxandaZerrenda {
    //AT
    ArrayList<Txanda> lista;
    
    //Constructor
    public TxandaZerrenda(){
        lista=new ArrayList<Txanda>();
    }
    
    //Methods
    public void addTxanda(Txanda pTxanda){
        lista.add(pTxanda);
    }

    Iterator<Txanda> getIterator() {
        return lista.iterator();
    }

    int size() {
        return lista.size();
    }
    
    @Override
    public String toString() { 
        String text = "";
        Iterator<Txanda> itr = getIterator();
        while (itr.hasNext()){
            text = itr.next().toString()+"\r\n";
        }
        return text;
    } 
}
