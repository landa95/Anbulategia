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
    private int GSZ;    
    
   public Errezeta(){}
    
    //Constructor
    public Errezeta(String pBot, int pEgunak, int gGSZ){
        botika = pBot;
        iraupena = pEgunak;
        GSZ = gGSZ;
        data = new Date();
    }
    
    //Methods
    public void setAginduak(String pAginduak){
        aginduak = pAginduak;
    }

    public boolean equals(Errezeta pEr) {
      if (this.getBotika().equals(pEr.getBotika()) && this.getData().equals(pEr.getData())) return true;
      
      else return false;
    }

    /**
     * @return the botika
     */
    public String getBotika() {
        return botika;
    }

    /**
     * @param botika the botika to set
     */
    public void setBotika(String botika) {
        this.botika = botika;
    }

    /**
     * @return the iraupena
     */
    public int getIraupena() {
        return iraupena;
    }

    /**
     * @param iraupena the iraupena to set
     */
    public void setIraupena(int iraupena) {
        this.iraupena = iraupena;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the aginduak
     */
    public String getAginduak() {
        return aginduak;
    }   

    /**
     * @return the GSZ
     */
    public int getGSZ() {
        return GSZ;
    }

    /**
     * @param GSZ the GSZ to set
     */
    public void setGSZ(int GSZ) {
        this.GSZ = GSZ;
    }
    
}
