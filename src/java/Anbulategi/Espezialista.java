/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Oier
 */
@Entity
@Table(name="espezialista")
@PrimaryKeyJoinColumn(name="SNan")
public class Espezialista extends Sendagilea{
    //AT
    @Column(name="Espezialitatea")
    private String espezialitatea;
      //Constructor
    public Espezialista(){}
    
    public Espezialista(int pNan, String pIz, String pAb,String pEsp) {
        super(pNan, pIz, pAb);
        espezialitatea = pEsp;
    }
    
    //Methods
    public void historialBerezia(int pGSZ, String pEguneraketa) {
        Historial his = DB.getNDB().historialaBilatu(pGSZ);
        his.eguneratuHorriBrezia(pEguneraketa, getEspezialitatea());
        DB.getNDB().historialalEguneratu(his);
    }
    
    
    /**
     * @return the espezialitatea
     */
    public String getEspezialitatea() {
        return espezialitatea;
    }

    /**
     * @param espezialitatea the espezialitatea to set
     */
    public void setEspezialitatea(String espezialitatea) {
        this.espezialitatea = espezialitatea;
    }
}
