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
    private int gTelefono;
    private String gHelbide;
    private int gGSZ;
    private int hZenbakia;

    public Historial(String pIz, String pAb1, String pAb2, int pTelf, String pHelb, int pGSZ) {
        gIzena = pIz;
        gAbizena1 = pAb1;
        gAbizena2 = pAb2;
        gTelefono = pTelf;
        gHelbide = pHelb;
        gGSZ = pGSZ;
        //hZenbakia = DB.bilatuAzkenHistoialZbk();
    }
}
