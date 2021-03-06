/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Oier
 */
@Entity
@Table(name = "bajadokumentua")
class bajaTxostena {

    /**
     * @return the dokumentuId
     */
    public int getDokumentuId() {
        return dokumentuId;
    }

    /**
     * @param dokumentuId the dokumentuId to set
     */
    public void setDokumentuId(int dokumentuId) {
        this.dokumentuId = dokumentuId;
    }

    /**
     * @param gaixoa the gaixoa to set
     */
    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }
    //AT
    @Id
    @GeneratedValue
    @Column(name="DokumentuIdd")
    private int dokumentuId;
    
    @Column(name ="BajaData")
    private Date bajaData;
    @Column(name="AltaData")
    private Date altaData;
    @Column(name = "BajaArrazoia")
    private String bajaArrazoia;
    @Column(name="AltaArrazoia")
    private String altaArrazoia;
    @ManyToOne
    @JoinColumn(name  ="GSZ")
    private Gaixoa gaixoa;
    
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
    public Gaixoa getGaixoa() {
        return gaixoa;
    }

    /**
     * @param GSZ the GSZ to set
     */
    public void setGSZ(Gaixoa gaixoa) {
        this.setGaixoa(gaixoa);
    }
    
    @Override
    public String toString() { 
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       String text = "Baja: "+sdf.format(bajaData)+"\r\nArrazoia: "+bajaArrazoia+"\r\nAlta: "+sdf.format(altaData)+"\r\nArrazoia: "+altaArrazoia;
       return text;
    } 
}
