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
class HorriBereziList {
    //AT
    private ArrayList<HorriBerezia> horriak;
    
    //Constructor
    public HorriBereziList(){
        horriak=new ArrayList<HorriBerezia>();
    } 
    
    //Methods
    public void eguneratuHorria(String pTextua, String pEsp){
        HorriBerezia hb = bilatuEspezialitatekoHorria(pEsp);
        if(hb == null){
            hb=new HorriBerezia(pEsp);
            hb.eguneratu(pTextua);
            horriak.add(hb);
        }
        else{
            hb.eguneratu(pTextua);
        }
    }

    public HorriBerezia bilatuEspezialitatekoHorria(String pEsp) { //probetarako beharrezkoa publikoa
        Iterator<HorriBerezia> itr= horriak.iterator();
        boolean aurkitua = false;
        HorriBerezia horri = null;
        while (itr.hasNext() && !aurkitua){
            horri=itr.next();
            aurkitua = horri.espezialitateHorriaDa(pEsp);
        }
        if (aurkitua) return horri;
        else return null;
    }
}
