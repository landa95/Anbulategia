package Anbulategi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oier
 */
@Entity
@Table(name="idazkaria")
public class Idazkaria {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    private int id;
    @Column(name = "Pasahitza")
    private String pasahitza;
    
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
    
    public void txandakEsleitu(Date pEguna, String pOrdua, int pGSZ){
        SimpleDateFormat aux = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String gaur = aux.format(pEguna);
	String stringDataEguna = gaur+" "+pOrdua;
        try {
            Date dataEguna = sdf.parse(stringDataEguna);
            if (dataEguna.after(new Date())){
            int medikuID = DB.getNDB().gaixoarenMedikua(pGSZ);
            Txanda txanda = new Txanda(dataEguna, medikuID, pGSZ);
            DB.getNDB().txandaGorde(txanda);
        }
        } catch (ParseException ex) {
            Logger.getLogger(Idazkaria.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void gaixoAbizena1Aldatu(int pGaixoGSZ, String pAbBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Abizena1", pAbBerria);
    }
    
    public void gaixoAbizena2Aldatu(int pGaixoGSZ, String pAbBerria){
        DB.getNDB().eguneratuGaixoa(pGaixoGSZ, "Abizena2", pAbBerria);
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the pasahitza
     */
    public String getPasahitza() {
        return pasahitza;
    }

    /**
     * @param pasahitza the pasahitza to set
     */
    public void setPasahitza(String pasahitza) {
        this.pasahitza = pasahitza;
    }

}
