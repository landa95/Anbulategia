package Anbulategi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

class Sendagilea {
    //AT
    private int NAN;
    private String izena;
    private String abizena;
    
    //Constructor
    public Sendagilea(int pNan, String pIz, String pAb) {
        NAN = pNan;
        izena = pIz;
        abizena = pAb;
    }
    
    //Methods
    public Historial historialaKontsultatu(int pGSZ){
        return DB.getNDB().historialaBilatu(pGSZ);
    }
    
    public void historialaEguneratu(int pGSZ, String pEguneraketa){
        Historial his = DB.getNDB().historialaBilatu(pGSZ);
        his.eguneratu(pEguneraketa);
        DB.getNDB().historialalEguneratu(his);
    }
    
    public int getNAN(){
        return NAN;
    }
}
