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
public class DB {
    //AT
    private static DB ndb = null;
    private final ErrezetaDAOHibernate errezetaManager = new ErrezetaDAOHibernate();
    private final EspezialistaDAOHibernate espezialistaManager = new EspezialistaDAOHibernate();
    private final GaixoaDAOHibernate gaixoaManager =new GaixoaDAOHibernate();
    private final HistorialDAOHibernate historialManager = new HistorialDAOHibernate();
    //private final IdazkariDAOHibernate idazkariManager = new IdazkariDAOHibernate();
    private final SendagileaDAOHibernate sendagileaManager = new SendagileaDAOHibernate();
    //private final TxandaDAOHibernate txandaManager = new TxandaDAOHibernate();
    private final bajaTxostenaDAOHibernate bajaTxostenaManager = new bajaTxostenaDAOHibernate();
    //Constructor
    private DB(){}
    
    //Methods
    public static DB getNDB(){
        if (ndb == null) 
            ndb = new DB();
        return ndb;
    }

    void gaisoBerria(Gaixoa ga) {
       gaixoaManager.save(ga);
    }
    

    void historialaGorde(Historial his) {
        historialManager.save(his);
    }

    ArrayList<String> egunekoOrduLibreak(Date pEguna, int pMedikuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void txandaGorde(Txanda txanda) {
        //txandaManager.save(txanda);
    }

    void bajaBerritu(int pGaixoGSZ, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<String> datuakErakusti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   void eguneratuGaixoa(int pGaixoGSZ, String aldaketa, String pIzBerria) {
              
       Gaixoa gaixo = gaixoaManager.getGaixoaByGSZ(pGaixoGSZ);
       gaixo.setIzena(pIzBerria);
       gaixoaManager.edit(gaixo);
    }

    public void eguneratuGaixoa(int pGaixoGSZ, String Aldaketa,int pTelBerria) {
       Gaixoa gaixo = gaixoaManager.getGaixoaByGSZ(pGaixoGSZ);
       gaixo.setTelefonoa(pTelBerria);
       gaixoaManager.edit(gaixo);
    }

    int azkenHistorialZenbakia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static Date bajaAzkenEguna(int pGaixoGSZ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Historial historialaBilatu(int pGSZ) {
       return historialManager.historialaBilatu(pGSZ);
    }

   void historialalEguneratu(Historial his) {
        historialManager.edit(his);
    }

    int gaixoGutxienDituenMedikua() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bajaBerritu(int pGaixoGSZ, Date bajaEgunBerria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void errezetaGehitu(Errezeta errezeta) {
        errezetaManager.save(errezeta);
    }

    TxandaZerrenda sendagilearenEgunekoTxandak(Date date, int NAN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    TxandaZerrenda gaixoarenTxandak(Date date, int GSZ) {
        //Data honetatik aurrerako txandak bakarrik eskatuko dira
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean gaixoaDago(Gaixoa ga) {
        return gaixoaManager.gaixoaDago(ga);
    }

    int gaixoarenMedikua(int pGSZ) {
        return gaixoaManager.getGaixoaByGSZ(pGSZ).getMedikua().getNAN();
    }

    ArrayList<Integer> espezialistaLibrerik(Date pEguna, String espezialitatea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    TxandaZerrenda medikuarenTxanda(int pMedikuID, Date pEguna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int bilatuEgunaLibrekoSendagileak(Date pEguna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void txandaAldatu(Txanda txanda, Txanda txanda0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Date orduLibrea(Date pEguna, int pMedikuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean orduaLibreDago(Date data, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    Sendagilea bilatuMedikua(int pMedikuNAN) {
        return sendagileaManager.getSendagileaByNAN(pMedikuNAN);
    }
}
