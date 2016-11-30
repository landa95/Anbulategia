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
}
