package Anbulategi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oier
 */
class Historial {
     //AT
    private int gGSZ;
    private int hZenbakia;
    private String historia;
    private HorriBereziList hBereziak;

    public Historial(int pGSZ, int pHzenb) {
        gGSZ = pGSZ;
        hZenbakia = pHzenb;
        historia="";
        hBereziak=new HorriBereziList();
    }

    public void eguneratu(String pEguneraketa) {
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
       historia+=dateFormat.format(date)+":\n"+pEguneraketa+"\n\n";   
    }

    public void eguneratuHorriBrezia(String pEguneraketa, String pEspezialitatea) {
        hBereziak.eguneratuHorria(pEguneraketa, pEspezialitatea);
    }
    
    public boolean nireGSZda(int pGSZ){
        if (gGSZ == pGSZ) return true;
        else return false;
    }
    
}
