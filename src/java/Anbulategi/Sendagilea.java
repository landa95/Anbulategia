package Anbulategi;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
    
    public void bajaEman(int pGSZ, int pBajaEgunak){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date dBaja = new Date();
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(dBaja); 
        cal.add(Calendar.DATE, pBajaEgunak);
        Date dAlta = cal.getTime();
        bajaTxostena txostena = new bajaTxostena(dBaja, dAlta);
    }
    
    public Errezeta errezetaSortu(String pBotika, int pIraupena, String pAginduak){
        Errezeta errezeta= new Errezeta(pBotika, pIraupena, NAN);
        errezeta.setAginduak(pAginduak);
        DB.getNDB().errezetaGehitu(errezeta);
        return errezeta; //gaisoak behar badu errezeta izan dezan
    }
    
    public TxandaZerrenda egunekoTxandak(){
        return DB.getNDB().sendagilearenEgunekoTxandak(new Date(),NAN);
    }
}
