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

    //Constructor
    private DB(){}
    
    //Methods
    public static DB getNDB(){
        if (ndb == null) 
            ndb = new DB();
        return ndb;
    }

    void gaisoBerria(Gaisoa ga) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void historialaGorde(Historial his) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<String> egunekoOrduLibreak(Date pEguna, int pMedikuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int gaisoarenMedikua(String pGSZ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void txandaGorde(String pOrdua, int medikuID, String pGSZ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void bajaBerritu(int pGaixoGSZ, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    ArrayList<String> datuakErakusti() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eguneratuGaixoa(int pGaixoGSZ, String aldaketa, String pIzBerria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eguneratuGaixoa(int pGaixoGSZ, String telefonoa, int pTelBerria) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int azkenHistorialZenbakia() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    static Date bajaAzkenEguna(int pGaixoGSZ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Historial historialaBilatu(int pGSZ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
