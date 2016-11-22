import java.util.ArrayList;
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
    
    public Idazkaria(){};
    
    public void historialBerria(String pIzena, String pAbizena1, String pAbizena2,int pAdina, int pTelf, String pHelb, int pGSZ){    
        Historial his = new Historial(pIzena,pAbizena1,pAbizena2,pTelf,pHelb,pGSZ);
        Gaisoa ga = new Gaisoa(pIzena, pAbizena1, pAbizena2, pAdina, pTelf, pHelb, pGSZ);
        //DB.gaisoBerria(ga);
        //DB.historialaGorde(his);
    }
    
    public ArrayList<String> orduLibreakErakutsi(Date pEguna){
        ArrayList<String> erantzuna = new ArrayList<String>();
       // ArrayList<Date> orduak = DB.egunekoOrduLibreak(pEguna);
       // Iterator<Date> itr = orduak.iterator();
       /* while(itr.hasNext()){
          date aux = orduak.next();
          erantzuna.add(orduak.toString());
        }*/
        return erantzuna;
    }
    
    public void txandakEsleitu(String pOrdua, String pGSZ){
        //String medikuID = DB.gaisoarenMedikua(pGSZ);
        //DB.txandaGorde(pOrdua, medikuID, pGSZ);
    }
    
    public void bajaPaperaBerritu(int pGaixoGSZ){
        Date bajaAzkenEguna = null; 
        //bajaAzkenEguna = DB.bajaAzkenEguna(pGaixoGSZ);
        Date bajaEgunBerria = null;
        if (bajaEgunBerria.compareTo(bajaAzkenEguna) <= 0) {
            //DB.bajaBerritu(pGaixoGSZ, 7);
        }
        else{
            //DB.bajaBerritu(pGaixoGSz, datenArtekoDiferentzia(bajaAzkenEguna,bajaEgunBerria));
        }
    }
    
    private int datenArtekoDiferentzia(Date pAzkena, Date pBerria){
        long dif = pBerria.getTime() - pAzkena.getTime();
        long egun = dif / (1000 * 60 * 60 * 24);
        return (int) egun;
    }
    
    public ArrayList<String> gaixoDatuakIkusi(int pGaixoGSZ){
        //return DB.datuakErakusti();
        return null;
    }
    
    public void gaixoIzenaAldatu(int pGaixoGSZ, String pIzBerria){
        //db.EguneratuGaixoa(pGaixoGSZ, "Izena", pIzBerria);
    }
    
    public void gaixoAbizenakAldatu(int pGaixoGSZ, String pAbBerria){
        //db.EguneratuGaixoa(pGaixoGSZ, "Abizenak", pAbBerria);
    }
    
    public void gaixoTelfAldatu(int pGaixoGSZ, int pTelBerria){
        //db.EguneratuGaixoa(pGaixoGSZ, "Telefonoa", pTelBerria);
    }
    
    public void gaixoHelbAldatu(int pGaixoGSZ, String pHelbBerria){
        //db.EguneratuGaixoa(pGaixoGSZ, "Helbidea", pHelbBerria);
    }
    
}
