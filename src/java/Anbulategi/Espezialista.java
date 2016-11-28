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
    
    //Constructor
    public Espezialista(int pNan, String pIz, String pAb) {
        super(pNan, pIz, pAb);
    }
    
    //Methods
    public void historialBerezia(int pGSZ, String pEguneraketa) {
        Historial his = DB.getNDB().historialaBilatu(pGSZ);
        his.eguneratuHorriBrezia(pEguneraketa, espezialitatea);
        DB.getNDB().historialalEguneratu(his);
    }
    
}
