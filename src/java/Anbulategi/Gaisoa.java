package Anbulategi;

import java.util.ArrayList;

public class Gaisoa {
    private String izena;
    private String abizena1;
    private String abizena2;
    private int adina;
    private int telefonoa;
    private String bizilekua;
    private int GSZ;
    private boolean pentsioduna = false;
    private int medikua;
    //private bajaTxostena baja;
    //private Historiala historiala
    //private Txostena txostena;
    //private ArrayList<Errezeta> errezetak = new ArrayList<Errezeta>();
    //private Sendagilea sendagilea;
    
   
    public Gaisoa(String izena, String abizena1, String abizena2, int adina, int telefonoa, String bizilekua, int GSZ, int medikuNAN){
        this.izena = izena;
        this.abizena1 = abizena1;
        this.abizena2 = abizena2;
        this.adina = adina;
            if(adina > 60){
                pentsioduna = true;
            }
        this.telefonoa = telefonoa;
        this.bizilekua = bizilekua;
        this.GSZ = GSZ;
        this.medikua = medikuNAN;
    }
    
    //GETTER
    
    public String getIzena(){
        return izena;
    }
   
    public String getAbizena1(){
        return abizena1;
    }
    
     public String getAbizena2(){
        return abizena2;
    }
    
    public int getAdina(){
        return adina;
    }
    
    public int getTelefonoa(){
        return telefonoa;
    }
    
    public String getBizilekua(){
        return bizilekua;
    }
    
    public int getTxartela(){
        return GSZ;
    }
    
    public ArrayList getDatuPertsonalak(){
    
        ArrayList lista = new ArrayList();

        lista.add(izena);
        lista.add(abizena1);
        lista.add(abizena2);
        lista.add(adina);
        lista.add(telefonoa);
        lista.add(bizilekua);
        lista.add(GSZ);
        
        return lista;
    }
    
    public boolean getPentsioduna(){
        return pentsioduna;
    }
    

    //SETTER
    
    public void setIzena(String izena){
        this.izena = izena;
    }
   
    public void setAbizena1(String abizena){
        this.abizena1 = abizena;
    }
    
    public void setAbizena2(String abizena){
        this.abizena2 = abizena;
    }
    
    public void setAdina(int adina){
        this.adina = adina;
    }
    
    public void setTelefonoa(int telefonoa){
        this.telefonoa = telefonoa;
    }
    
    public void setBizilekua(String bizilekua){
        this.bizilekua = bizilekua;
    }
    
    public void setTxartela(int txartelzenb){
        this.GSZ = txartelzenb;
    }


    //METODOAK
    
    public void kontsultaEskatu(){
    
    } 
}
