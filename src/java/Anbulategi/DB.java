package Anbulategi;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private static ErrezetaDAOHibernate errezetaManager = new ErrezetaDAOHibernate();
    private static EspezialistaDAOHibernate espezialistaManager = new EspezialistaDAOHibernate();
    private static GaixoaDAOHibernate gaixoaManager =new GaixoaDAOHibernate();
    private static HistorialDAOHibernate historialManager = new HistorialDAOHibernate();
    //private final IdazkariDAOHibernate idazkariManager = new IdazkariDAOHibernate();
    private static SendagileaDAOHibernate sendagileaManager = new SendagileaDAOHibernate();
    //private final TxandaDAOHibernate txandaManager = new TxandaDAOHibernate();
    private static bajaTxostenaDAOHibernate bajaTxostenaManager = new bajaTxostenaDAOHibernate();
    private static IdazkariaDAOHibernate idazkariManager = new IdazkariaDAOHibernate();
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
    
    public static Date bajaAzkenEguna(int pGaixoGSZ) {
        List<bajaTxostena> bajak   = gaixoaManager.lortuBajaTxostenak(pGaixoGSZ);
        int i = bajak.size();
        return bajak.get(i).getAltaData();
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
        //baja edo alta?
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
    
    public boolean checkGaixoa(int GSZ, String pasahitza){
        return gaixoaManager.checkGaixoa(GSZ, pasahitza);
    }
    
    public boolean checkSendagile(int NAN, String pasahitza){
        return sendagileaManager.checkSendagile(NAN, pasahitza);
    }
    
     public boolean checkIdazkari(int Id, String pasahitza){
        return idazkariManager.checkIdazkari(Id, pasahitza);
    }
}