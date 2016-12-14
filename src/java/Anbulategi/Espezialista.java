/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

/**
 *
 * @author Oier
 */
public class Espezialista extends Sendagilea{
    //AT
    private String espezialitatea;
    
    private Sendagilea sendagilea;
    
    //Constructor
    public Espezialista(){}
    
    public Espezialista(int pNan, String pIz, String pAb) {
        super(pNan, pIz, pAb);
    }
    
    //Methods
    public void historialBerezia(int pGSZ, String pEguneraketa) {
        Historial his = DB.getNDB().historialaBilatu(pGSZ);
        his.eguneratuHorriBrezia(pEguneraketa, getEspezialitatea());
        DB.getNDB().historialalEguneratu(his);
    }
    
    
    /**
     * @return the espezialitatea
     */
    public String getEspezialitatea() {
        return espezialitatea;
    }

    /**
     * @param espezialitatea the espezialitatea to set
     */
    public void setEspezialitatea(String espezialitatea) {
        this.espezialitatea = espezialitatea;
    }
}
