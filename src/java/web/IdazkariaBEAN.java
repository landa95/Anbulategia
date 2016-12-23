package web;

import Anbulategi.Idazkaria;
import Anbulategi.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import util.DAOFactory;

@ManagedBean(name = "IdazkariaBEAN")

@SessionScoped
public class IdazkariaBEAN implements Serializable {

    private int id;
    private String passwordIdazkari;
    
    private ArrayList<Integer> gaixolista;
    
    private Gaixoa gaixo;
    
    private Date date;
    private ArrayList<String> orduak;
    private String ordua;

    private int GSZ;

    private String gizena;
    private String gabizena1;
    private String gabizena2;
    private int gjaiotzedata;
    private int gtelefonoa;
    private String gbizilekua;

    public IdazkariaBEAN() {
    
    }
    
    public String login(){
       
        /*Idazkaria idaz = new Idazkaria();
        
        //gaixolista = KARGATUGAIXOAK

 
        IdazkariaDAO idazkariaDAO = DAOFactory.idazkariaDAOSortu();
       
        if (idazkariaDAO.checkIdazkari(id, passwordIdazkari)) {
            return "idazkariLayout";
        }else{
            return "idazkariLogin";
        }*/
        
        return "idazkariLayout";

    }

    public String historialaSortu(){
        
        Idazkaria i = new Idazkaria();
        i.historialBerria(gizena, gabizena1, gabizena2, gjaiotzedata, gtelefonoa, gbizilekua, GSZ);
        
        return "idazkariLayout";
    }
    
    public void kargatuOrduak(){
        Idazkaria i = new Idazkaria();
        orduak = i.orduLibreakErakutsi(date, gaixo.getGSZ());
    }
    
    
    public void kargatuDatuak(){
    
        GaixoaDAO gaixoaDAO = DAOFactory.gaixoaDAOSortu();
        
        gaixo = gaixoaDAO.getGaixoaByGSZ(GSZ);
    
    }
    
    public String txandaEsleitu(){
   
        Idazkaria i = new Idazkaria();
        
        i.txandakEsleitu(date, ordua , gaixo.getGSZ());
    
        return "idazkariLayout";
    
    }
    
    public String editatuDatuak(){
   
        Idazkaria i = new Idazkaria();
        
        i.gaixoAbizena1Aldatu(GSZ, gaixo.getAbizena1());
        i.gaixoAbizena2Aldatu(GSZ, gaixo.getAbizena2());
        i.gaixoHelbAldatu(GSZ, gaixo.getBizilekua());
        i.gaixoIzenaAldatu(GSZ, gaixo.getIzena());
        i.gaixoTelfAldatu(GSZ, gaixo.getTelefonoa());
        
        return "idazkariLayout";

    }

    public int getGSZ() {
        return GSZ;
    }

    public void setGSZ(int GSZ) {
        this.GSZ = GSZ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
    public String getPasswordIdazkari() {
        return passwordIdazkari;
    }

    public void setPasswordIdazkari(String passwordIdazkari) {
        this.passwordIdazkari = passwordIdazkari;
    }
    
     public String getGizena() {
        return gizena;
    }

    public void setGizena(String gizena) {
        this.gizena = gizena;
    }

    public String getGabizena1() {
        return gabizena1;
    }

    public void setGabizena1(String gabizena1) {
        this.gabizena1 = gabizena1;
    }

    public String getGabizena2() {
        return gabizena2;
    }

    public void setGabizena2(String gabizena2) {
        this.gabizena2 = gabizena2;
    }

    public int getGjaiotzedata() {
        return gjaiotzedata;
    }

    public void setGjaiotzedata(int gjaiotzedata) {
        this.gjaiotzedata = gjaiotzedata;
    }

    public int getGtelefonoa() {
        return gtelefonoa;
    }

    public void setGtelefonoa(int gtelefonoa) {
        this.gtelefonoa = gtelefonoa;
    }

    public String getGbizilekua() {
        return gbizilekua;
    }

    public void setGbizilekua(String gbizilekua) {
        this.gbizilekua = gbizilekua;
    }
    
    public ArrayList<Integer> getGaixolista() {
        return gaixolista;
    }

    public void setGaixolista(ArrayList<Integer> gaixolista) {
        this.gaixolista = gaixolista;
    }

    public Gaixoa getGaixo() {
        return gaixo;
    }

    public void setGaixo(Gaixoa gaixo) {
        this.gaixo = gaixo;
    }
    
    public Date getDate() {
        return date;
    }
    
     public void setDate(Date date) {
        this.date = date;
    }
     
     public ArrayList<String> getOrduak() {
        return orduak;
    }

    public void setOrduak(ArrayList<String> orduak) {
        this.orduak = orduak;
    }

    public String getOrdua() {
        return ordua;
    }

    public void setOrdua(String ordua) {
        this.ordua = ordua;
    }
    
}
