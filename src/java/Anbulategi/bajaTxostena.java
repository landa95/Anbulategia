/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.Date;

/**
 *
 * @author Oier
 */
class bajaTxostena {
    //AT
    private Date bajaData;
    private Date altaData;
    private String bajaArrazoia;
    private String altaArrazoia;
    private int GSZ;
    
    public bajaTxostena(){}
    
    public bajaTxostena(Date dBaja, Date dAlta) {
        bajaData = dBaja;
        altaData = dAlta;
    }
    
    public void setBajaArrazoia(String bArrazoi) {
        bajaArrazoia = bArrazoi;
    }
    
    public void setAltaArrazoia(String aArrazoi) {
        altaArrazoia = aArrazoi;
    }

    /**
     * @return the bajaData
     */
    public Date getBajaData() {
        return bajaData;
    }

    /**
     * @param bajaData the bajaData to set
     */
    public void setBajaData(Date bajaData) {
        this.bajaData = bajaData;
    }

    /**
     * @return the altaData
     */
    public Date getAltaData() {
        return altaData;
    }

    /**
     * @param altaData the altaData to set
     */
    public void setAltaData(Date altaData) {
        this.altaData = altaData;
    }

    /**
     * @return the bajaArrazoia
     */
    public String getBajaArrazoia() {
        return bajaArrazoia;
    }

    /**
     * @return the altaArrazoia
     */
    public String getAltaArrazoia() {
        return altaArrazoia;
    }

    /**
     * @return the GSZ
     */
    public int getGSZ() {
        return GSZ;
    }

    /**
     * @param GSZ the GSZ to set
     */
    public void setGSZ(int GSZ) {
        this.GSZ = GSZ;
    }
}
