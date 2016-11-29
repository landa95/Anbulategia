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
}
