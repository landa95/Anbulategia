package web;

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

@ManagedBean(name = "GaixoaBEAN")

@SessionScoped
public class GaixoaBEAN implements Serializable {

   Gaixoa gaixoa;

   public int GSZ;
   private String passwordBezero;

   private Date date2;
   private ArrayList<String> orduak;
     
   private String ordua;
   
   public GaixoaBEAN() {
       
        orduak = new ArrayList<String>();
       
        orduak.add("12:30");
        orduak.add("13:00");
        orduak.add("14:15");
        orduak.add("15:00");
        
    }

    public String login(){
 
        GaixoaDAO gaixoaDAO = DAOFactory.gaixoaDAOSortu();
        
        if (DB.getNDB().checkGaixoa(GSZ, passwordBezero)) {
            gaixoa =  gaixoaDAO.getGaixoaByGSZ(GSZ);
            return "bezeroLayout";
        }else{
            return "idazkariLogin";
        }
    }
     
    public String kontsultaEskaera(){

       /* Gaixoa g = new Gaixoa();
        orduak = g.orduaAukeratu(date2);
   
        if(orduak == null){
           return "kontsultaEskaera";
        }*/
        
        //g.kontsultaEskatu(date2, ordua);
        return "bezeroLayout";
    }
   
    
     public Gaixoa getGaixoa() {
        return gaixoa;
    }

    public void setGaixoa(Gaixoa gaixoa) {
        this.gaixoa = gaixoa;
    }

    public int getGSZ() {
        return GSZ;
    }

    public void setGSZ(int GSZ) {
        this.GSZ = GSZ;
    }

    public String getPasswordBezero() {
        return passwordBezero;
    }

    public void setPasswordBezero(String password) {
        this.passwordBezero = password;
    }
    

    public Date getDate2() {
        return date2;
    }
    
     public void setDate2(Date date2) {
        this.date2 = date2;
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
