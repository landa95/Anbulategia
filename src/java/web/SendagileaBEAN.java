
package web;

import Anbulategi.Errezeta;
import Anbulategi.ErrezetaDAO;
import Anbulategi.Espezialista;
import Anbulategi.Gaixoa;
import Anbulategi.GaixoaDAO;
import Anbulategi.Historial;
import Anbulategi.Sendagilea;
import Anbulategi.bajaTxostena;
import Anbulategi.bajaTxostenaDAO;
import java.util.ArrayList;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import util.DAOFactory;

/**
 *
 * @author Portatil
 */
@Named(value = "SendagileaBEAN")
@Dependent
public class SendagileaBEAN {

    private int id;
    private int id2;
    
    private String botika;
    
    private Date date3;
    
    private int iraupena;

    private String aginduak;
    
    private String password;
    
    private ArrayList<Integer> gaixolista;
    private int GSZ;
    
    private Date date1;
    private Date date2;
    private String arrazoia;

    private Historial h;
    
    private ArrayList<Integer> espezialistalista;
    private int espezialista;
    
    private Date date4;
    
    private String espezialitatea;

    
 
    public SendagileaBEAN() {
    }
    
    public String login(){
   
         /*
        SendagileaDAO sendagileaDAO = DAOFactory.sendagileaDAOSortu();
       
        if (sendagileaDAO.checkSendagilea(id, password)) {
            return "sendagileaLayout";
        }else{
            return "sendagileLogin";
        }*/
        
        return "sendagileaLayout";
    }
    
    public void kargatuDatuak(){
       
        Gaixoa g = new Gaixoa();
        
        h = g.getHistoriala();
 
    }
    
    public String gordeHistoriala(){

        Sendagilea s = new Sendagilea();

        s.historialaEguneratu(GSZ, h.getHistoria());

        return "sendagileaLayout";

    }
    
    public String gordeBajaTxostena(){
    
        bajaTxostena b = new bajaTxostena();
        
        b.setDokumentuId(id);
        b.setBajaData(date1);
        b.setAltaData(date2);
        b.setAltaArrazoia(arrazoia);
        
       GaixoaDAO gaixoaDAO = DAOFactory.gaixoaDAOSortu();
       Gaixoa g = gaixoaDAO.getGaixoaByGSZ(GSZ);
       
       bajaTxostenaDAO bajaDAO = DAOFactory.bajaTxostenaDAOSortu();
       bajaDAO.save(b);
       
       //g.setBajaDokumentuak(b);
       
       return "sendagileaLayout";
    }
    
    public String gordeErrezetaTxostena(){
    
        Errezeta e = new Errezeta();
         
        GaixoaDAO gaixoaDAO = DAOFactory.gaixoaDAOSortu();
        Gaixoa g = gaixoaDAO.getGaixoaByGSZ(GSZ);
        
        e.setGSZ(g);
        e.setErrezetaId(id2);
        e.setBotika(botika);
        e.setIraupena(iraupena);
        e.setData(date3);
        e.setAginduak(aginduak);
        
        ErrezetaDAO errezetaDAO = DAOFactory.ErrezetaDAOSortu();
        errezetaDAO.save(e);

        return "sendagileaLayout";
    }
    
    
    public String esleituEspezialista(){
    
        GaixoaDAO gaixoaDAO = DAOFactory.gaixoaDAOSortu();
        Gaixoa g = gaixoaDAO.getGaixoaByGSZ(GSZ);
        
       //metodoa
        
        return "sendagileaLayout";
    }
    
    public void bilatuEspezialistak(){
    
         Sendagilea s = new Sendagilea();
         espezialistalista = s.espezialistaBilatu(date4, espezialitatea);

    }
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public ArrayList<Integer> getGaixolista() {
        return gaixolista;
    }

    public void setGaixolista(ArrayList<Integer> gaixolista) {
        this.gaixolista = gaixolista;
    }

    public int getGSZ() {
        return GSZ;
    }

    public void setGSZ(int GSZ) {
        this.GSZ = GSZ;
    }
    
     public Historial getH() {
        return h;
    }

    public void setH(Historial h) {
        this.h = h;
    }
    
    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
    
      public String getArrazoia() {
        return arrazoia;
    }

    public void setArrazoia(String arrazoia) {
        this.arrazoia = arrazoia;
    }
    
    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public String getBotika() {
        return botika;
    }

    public void setBotika(String botika) {
        this.botika = botika;
    }

    public Date getDate3() {
        return date3;
    }

    public void setDate3(Date date3) {
        this.date3 = date3;
    }

    public String getAginduak() {
        return aginduak;
    }

    public void setAginduak(String aginduak) {
        this.aginduak = aginduak;
    }
    
     public int getIraupena() {
        return iraupena;
    }

    public void setIraupena(int iraupena) {
        this.iraupena = iraupena;
    }
    
     public ArrayList<Integer> getEspezialistalista() {
        return espezialistalista;
    }

    public void setEspezialistalista(ArrayList<Integer> espezialistalista) {
        this.espezialistalista = espezialistalista;
    }

    public Integer getEspezialista() {
        return espezialista;
    }

    public void setEspezialista(Integer espezialista) {
        this.espezialista = espezialista;
    }

     public Date getDate4() {
        return date4;
    }

    public void setDate4(Date date4) {
        this.date4 = date4;
    }
    
    public String getEspezialitatea() {
        return espezialitatea;
    }

    public void setEspezialitatea(String espezialitatea) {
        this.espezialitatea = espezialitatea;
    }
    
}
