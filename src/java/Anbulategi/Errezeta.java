/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

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
    private int medikua;
    
    
    //Constructor
    public Errezeta(String pBot, int pEgunak, int mNAN){
        botika = pBot;
        iraupena = pEgunak;
        data = new Date();
        medikua=mNAN;
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
