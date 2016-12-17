package Anbulategi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oier
 */
public class Idazkaria {
    //Constructor
    public Idazkaria(){};
    
    //Methods
    public void historialBerria(String pIzena, String pAbizena1, String pAbizena2,int pAdina, int pTelf, String pHelb, int pGSZ){    
        int i = DB.getNDB().azkenHistorialZenbakia() + 1;
        Gaixoa ga = new Gaixoa(pIzena, pAbizena1, pAbizena2, pAdina, pTelf, pHelb, pGSZ);
        int mediku = DB.getNDB().gaixoGutxienDituenMedikua();
        ga.setMedikua(mediku);
        DB.getNDB().gaisoBerria(ga);
        Historial his = new Historial(pGSZ, i);
        DB.getNDB().historialaGorde(his);
    }
    
    public ArrayList<String> orduLibreakErakutsi(Date pEguna,int pGSZ){
        if (pEguna.after(new Date())){
            int medikuID = DB.getNDB().gaixoarenMedikua(pGSZ);
            ArrayList<String> orduak = DB.getNDB().egunekoOrduLibreak(pEguna, medikuID);
            return orduak;
        }
        else return null;
    }
    
    public void txandakEsleitu(Date pOrdua, int pGSZ){
        if (pOrdua.after(new Date())){
            int medikuID = DB.getNDB().gaixoarenMedikua(pGSZ);
            Txanda txanda = new Txanda(pOrdua, medikuID, pGSZ);
            DB.getNDB().txandaGorde(txanda);
        }
    }
    
    public void bajaPaperaBerritu(int pGaixoGSZ){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date bajaAzkenEguna = DB.bajaAzkenEguna(pGaixoGSZ);
        Date bajaEgunBerria = new Date();
        int egunak = datenArtekoDiferentzia(bajaAzkenEguna,bajaEgunBerria);
        if(egunak >= 7){
            Calendar cal = Calendar.getInstance(); 
            cal.setTime(bajaAzkenEguna); 
            cal.add(Calendar.DATE, 7);
            bajaEgunBerria = cal.getTime();
            DB.getNDB().bajaBerritu(pGaixoGSZ, bajaEgunBerria);
        }
        else if(egunak > 0){ //eguna beti izango da 0 edo handiagoa
            Calendar cal = Calendar.getInstance(); 
            cal.setTime(bajaAzkenEguna); 
            cal.add(Calendar.DATE, egunak);
            bajaEgunBerria = cal.getTime();
            DB.getNDB().bajaBerritu(pGaixoGSZ, bajaEgunBerria);
        } 
    }
    
    private int datenArtekoDiferentzia(Date pAzkena, Date pBerria){
        long dif = pAzkena.getTime() - pBerria.getTime();
        long egun = dif / (1000 * 60 * 60 * 24);
        return (int)egun;
    }
    
    public ArrayList<String> gaixoDatuakIkusi(int pGaixoGSZ){
        return DB.getNDB().datuakErakusti();
    }
    
    public void gaixoIzenaAldatu(int pGaixoGSZ, String pIzBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Izena", pIzBerria);
    }
    
    public void gaixoAbizenakAldatu(int pGaixoGSZ, String pAbBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Abizenak", pAbBerria);
    }
    
    public void gaixoTelfAldatu(int pGaixoGSZ, int pTelBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Telefonoa", pTelBerria);
    }
    
    public void gaixoHelbAldatu(int pGaixoGSZ, String pHelbBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Helbidea", pHelbBerria);
    }
    
    public void sendagileaAldatu(int pMedikuID, Date pEguna) {
        if (pEguna.after(new Date())){
            TxandaZerrenda egunekoTxanda = DB.getNDB().medikuarenTxanda(pMedikuID, pEguna);
            Iterator<Txanda> itr = egunekoTxanda.getIterator();
            Txanda txanda;
            boolean libre = true;
            while (itr.hasNext()) {
                txanda = itr.next();
                int gaixoa = txanda.getGaixoa();
                if (libre) {
                    int medikuId = DB.getNDB().bilatuEgunaLibrekoSendagileak(pEguna);
                    if (medikuId == -1) libre = false;
                    else{
                        Date orduLibrea = DB.getNDB().orduLibrea(pEguna, medikuId);
                        DB.getNDB().txandaAldatu(txanda, new Txanda(orduLibrea,medikuId, gaixoa));
                    }
                }
                else{
                    Calendar cal = Calendar.getInstance(); 
                    cal.setTime(pEguna); 
                    cal.add(Calendar.DATE, 1);
                    pEguna = cal.getTime();
                    Date orduLibrea = DB.getNDB().orduLibrea(pEguna, pMedikuID); //data horretaik aurrerako hurrengo ordu librea bilatuko du
                    DB.getNDB().txandaAldatu(txanda, new Txanda(orduLibrea,pMedikuID, gaixoa));
                }
            }
        }
    }

}
