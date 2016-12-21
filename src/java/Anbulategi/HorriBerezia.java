/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Oier
 */
class HorriBerezia {
    //AT
    private String espezialitatea;
    private String historia;
    
    //Constructor
    public HorriBerezia(String pEsp){
        espezialitatea=pEsp;
        historia="";
    }
    
    //Methods
    public void eguneratu(String pText){
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       historia+=dateFormat.format(date)+":\n"+pText+"\n\n";   
    }
    
    public boolean espezialitateHorriaDa(String pEsp){
        return espezialitatea.equals(pEsp);
    }
    
    public String getHistoria(){
        return historia;
    }
    
}
