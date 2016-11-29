/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.Comparator;
import java.util.Date;


/**
 *
 * @author Oier
 */
public class Errezeta {
    //AT
    private String botika;
    private int iraupena;
    private Date data;
    private String aginduak;
    
    //Constructor
    public Errezeta(String pBot, int pEgunak){
        botika = pBot;
        iraupena = pEgunak;
    }
    
    //Methods
    public void setAginduak(String pAginduak){
        aginduak = pAginduak;
    }

    public boolean equals(Errezeta pEr) {
      if (this.botika.equals(pEr.botika) && this.data.equals(pEr.data)) return true;
      
      else return false;
    }
}
