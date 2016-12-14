package Anbulategi;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

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
   
    private Set<Gaixoa> gaixoak;
    private Espezialista espezialista;
    //Constructor
    public Sendagilea(){}
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
    
    public Errezeta errezetaSortu(String pBotika, int pIraupena, String pAginduak,int GSZ){
        Errezeta errezeta= new Errezeta(pBotika, pIraupena, GSZ);
        errezeta.setAginduak(pAginduak);
        DB.getNDB().errezetaGehitu(errezeta);
        return errezeta; //gaisoak behar badu errezeta izan dezan
    }
    
    public TxandaZerrenda egunekoTxandak(){
        return DB.getNDB().sendagilearenEgunekoTxandak(new Date(), getNAN());
    }
    
    public ArrayList<Integer> espezialistaBilatu(Date pEguna, String espezialitatea) {
        ArrayList<Integer> medikuList = DB.getNDB().espezialistaLibrerik(pEguna, espezialitatea);
        return medikuList;
    }
    
    public ArrayList<String> orduLibreakErakutsi(Date pEguna, int medikuID){
        ArrayList<String> orduak = DB.getNDB().egunekoOrduLibreak(pEguna, medikuID);
        return orduak;
    }
    
    public void txandakEsleitu(Date pOrdua, int pGSZ, int pMedikua){
        Txanda txanda = new Txanda(pOrdua, pMedikua, pGSZ);
        DB.getNDB().txandaGorde(txanda);
    }

    /**
     * @return the gaixoak
     */
    public Set<Gaixoa> getGaixoak() {
        return gaixoak;
    }

    /**
     * @param gaixoak the gaixoak to set
     */
    public void setGaixoak(Set<Gaixoa> gaixoak) {
        this.gaixoak = gaixoak;
    }

    /**
     * @return the NAN
     */
    public int getNAN() {
        return NAN;
    }

    /**
     * @param NAN the NAN to set
     */
    public void setNAN(int NAN) {
        this.NAN = NAN;
    }

    /**
     * @return the izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * @param izena the izena to set
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * @return the abizena
     */
    public String getAbizena() {
        return abizena;
    }

    /**
     * @param abizena the abizena to set
     */
    public void setAbizena(String abizena) {
        this.abizena = abizena;
    }

    /**
     * @return the espezialista
     */
    public Espezialista getEspezialista() {
        return espezialista;
    }

    /**
     * @param espezialista the espezialista to set
     */
    public void setEspezialista(Espezialista espezialista) {
        this.espezialista = espezialista;
    }
        
}
