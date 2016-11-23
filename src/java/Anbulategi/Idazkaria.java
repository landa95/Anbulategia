package Anbulategi;

import java.util.ArrayList;
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
public class Idazkaria {
    
    public Idazkaria(){};
    
    public void historialBerria(String pIzena, String pAbizena1, String pAbizena2,int pAdina, int pTelf, String pHelb, int pGSZ){    
        int i = DB.getNDB().azkenHistorialZenbakia() + 1;
        Historial his = new Historial(pIzena,pAbizena1,pAbizena2, pAdina, pTelf,pHelb,pGSZ, i);
        Gaisoa ga = new Gaisoa(pIzena, pAbizena1, pAbizena2, pAdina, pTelf, pHelb, pGSZ);
        DB.getNDB().gaisoBerria(ga);
        DB.getNDB().historialaGorde(his);
    }
    
    public ArrayList<String> orduLibreakErakutsi(Date pEguna,int pMedikuID){
        ArrayList<String> orduak = DB.getNDB().egunekoOrduLibreak(pEguna, pMedikuID);
        return orduak;
    }
    
    public void txandakEsleitu(String pOrdua, String pGSZ){
        int medikuID = DB.getNDB().gaisoarenMedikua(pGSZ);
        DB.getNDB().txandaGorde(pOrdua, medikuID, pGSZ);
    }
    
    public void bajaPaperaBerritu(int pGaixoGSZ){
        Date bajaAzkenEguna = DB.bajaAzkenEguna(pGaixoGSZ);
        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date bajaEgunBerria = new Date();
        if (bajaEgunBerria.compareTo(bajaAzkenEguna) <= 0) {
            DB.getNDB().bajaBerritu(pGaixoGSZ, 7);
        }
        else{
            DB.getNDB().bajaBerritu(pGaixoGSZ, datenArtekoDiferentzia(bajaAzkenEguna,bajaEgunBerria));
        }
    }
    
    private int datenArtekoDiferentzia(Date pAzkena, Date pBerria){
        long dif = pBerria.getTime() - pAzkena.getTime();
        long egun = dif / (1000 * 60 * 60 * 24);
        return (int) egun;
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
    
}
