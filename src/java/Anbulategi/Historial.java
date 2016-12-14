package Anbulategi;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
class Historial {
     //AT
    private int gGSZ;
    private int hZenbakia;
    private String historia;
    private HorriBereziList hBereziak;
    
    private Gaixoa gaisoa;

    public Historial(int pGSZ, int pHzenb) {
        gGSZ = pGSZ;
        hZenbakia = pHzenb;
        historia="";
        hBereziak=new HorriBereziList();
    }

    public void eguneratu(String pEguneraketa) {
       DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
       Date date = new Date();
        setHistoria(getHistoria() + dateFormat.format(date)+":\n"+pEguneraketa+"\n\n");   
    }

    public void eguneratuHorriBrezia(String pEguneraketa, String pEspezialitatea) {
        gethBereziak().eguneratuHorria(pEguneraketa, pEspezialitatea);
    }
    
    public boolean nireGSZda(int pGSZ){
        if (getgGSZ() == pGSZ) return true;
        else return false;
    }

    /**
     * @return the gGSZ
     */
    public int getgGSZ() {
        return gGSZ;
    }

    /**
     * @param gGSZ the gGSZ to set
     */
    public void setgGSZ(int gGSZ) {
        this.gGSZ = gGSZ;
    }

    /**
     * @return the hZenbakia
     */
    public int gethZenbakia() {
        return hZenbakia;
    }

    /**
     * @param hZenbakia the hZenbakia to set
     */
    public void sethZenbakia(int hZenbakia) {
        this.hZenbakia = hZenbakia;
    }

    /**
     * @return the historia
     */
    public String getHistoria() {
        return historia;
    }

    /**
     * @param historia the historia to set
     */
    public void setHistoria(String historia) {
        this.historia = historia;
    }

    /**
     * @return the hBereziak
     */
    public HorriBereziList gethBereziak() {
        return hBereziak;
    }

    /**
     * @param hBereziak the hBereziak to set
     */
    public void sethBereziak(HorriBereziList hBereziak) {
        this.hBereziak = hBereziak;
    }

    /**
     * @return the gaisoa
     */
    public Gaixoa getGaisoa() {
        return gaisoa;
    }

    /**
     * @param gaisoa the gaisoa to set
     */
    public void setGaisoa(Gaixoa gaisoa) {
        this.gaisoa = gaisoa;
    }
    
}
