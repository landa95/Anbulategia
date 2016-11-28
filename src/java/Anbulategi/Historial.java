package Anbulategi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oier
 */
class Historial {
     //AT
    private String gIzena;
    private String gAbizena1;
    private String gAbizena2;
    private int gAdina;
    private int gTelefono;
    private String gHelbide;
    private int gGSZ;
    private int hZenbakia;

    public Historial(String pIz, String pAb1, String pAb2, int pAdin, int pTelf, String pHelb, int pGSZ, int pHzenb) {
        gIzena = pIz;
        gAbizena1 = pAb1;
        gAbizena2 = pAb2;
        gAdina = pAdin;
        gTelefono = pTelf;
        gHelbide = pHelb;
        gGSZ = pGSZ;
        hZenbakia = pHzenb;
    }

    void eguneratu(String pEguneraketa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void eguneratuHorriBrezia(String pEguneraketa, String espezialitatea) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
