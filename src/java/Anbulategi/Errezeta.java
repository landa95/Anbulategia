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
@Table(name = "errezeta")
public class Errezeta {

    //AT
    @Id
    @GeneratedValue
    @Column(name ="ErrezetaId")
    private int errezetaId;
    
    @Column(name = "Botika")
    private String botika;
    @Column(name = "Iraupena")
    private int iraupena;
    @Column(name = "Data")
    private Date data;
    @Column(name = "Aginduak")
    private String aginduak;
    
    @ManyToOne
    @JoinColumn(name  ="GSZ")
    private Gaixoa gaixoa;    
    
   public Errezeta(){}
    
    //Constructor
    public Errezeta(String pBot, int pEgunak, Gaixoa gGSZ){
        botika = pBot;
        iraupena = pEgunak;
        gaixoa = gGSZ;
        data = new Date();
    }
    
    //Methods
    public void setAginduak(String pAginduak){
        aginduak = pAginduak;
    }

    public boolean equals(Errezeta pEr){
       return (pEr.botika.equals(this.botika) && pEr.iraupena==this.iraupena && pEr.data.equals(this.data));
    }

    /**
     * @return the botika
     */
    public String getBotika() {
        return botika;
    }

    /**
     * @param botika the botika to set
     */
    public void setBotika(String botika) {
        this.botika = botika;
    }

    /**
     * @return the iraupena
     */
    public int getIraupena() {
        return iraupena;
    }

    /**
     * @param iraupena the iraupena to set
     */
    public void setIraupena(int iraupena) {
        this.iraupena = iraupena;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the aginduak
     */
    public String getAginduak() {
        return aginduak;
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
    
     /**
     * @return the errezetaId
     */
    public int getErrezetaId() {
        return errezetaId;
    }

    /**
     * @param errezetaId the errezetaId to set
     */
    public void setErrezetaId(int errezetaId) {
        this.errezetaId = errezetaId;
    }

    /**
     * @param gaixoa the gaixoa to set
     */
    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }
}
