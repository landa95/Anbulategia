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
public class Txanda {
    //AT
    private Date ordua;
    private int medikua;
    private int gaixoa;
    
    //Constructor
    public Txanda(Date pOrdua, int medikuID, int pGSZ) {
        ordua=pOrdua;
        medikua=medikuID;
        gaixoa=pGSZ;
    }
    
    public int getGaixoa(){
        return gaixoa;
    }
}
