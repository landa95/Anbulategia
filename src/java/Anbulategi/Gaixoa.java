package Anbulategi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

public class Gaixoa {
    //AT
    private String izena;
    private String abizena1;
    private String abizena2;
    private int adina;
    private int telefonoa;
    private String bizilekua;
    private int GSZ;
    private boolean pentsioduna = false;
    private Sendagilea medikua;
    private Set<Errezeta> errezetak;
    private Set<bajaTxostena> bajaDokumentuak;
    //private Txostena txostena;
    
    //Cosntructor
    
    public Gaixoa(){}
    public Gaixoa(String izena, String abizena1, String abizena2, int adina, int telefonoa, String bizilekua, int GSZ){
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
    
     public int setMedikua(){
        return this.getMedikua();
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

    public void setMedikua(int medikuNAN){
        this.setMedikua(medikuNAN);
    }
    //METODOAK
    public void kontsultaEskatu(){
    
    }
    
    public TxandaZerrenda gaixoarenTxandak(){
        //gaurtik aurrerakoak bakarrim eskatuko dira
        return DB.getNDB().gaixoarenTxandak(new Date(), GSZ);
    }

    /**
     * @return the medikua
     */
    public Sendagilea getMedikua() {
        return medikua;
    }

    /**
     * @param medikua the medikua to set
     */
    public void setMedikua(Sendagilea medikua) {
        this.medikua = medikua;
    }

    /**
     * @return the errezetak
     */
    public Set<Errezeta> getErrezetak() {
        return errezetak;
    }

    /**
     * @param errezetak the errezetak to set
     */
    public void setErrezetak(Set<Errezeta> errezetak) {
        this.errezetak = errezetak;
    }

    /**
     * @return the bajaDokumentuak
     */
    public Set<bajaTxostena> getBajaDokumentuak() {
        return bajaDokumentuak;
    }

    /**
     * @param bajaDokumentuak the bajaDokumentuak to set
     */
    public void setBajaDokumentuak(Set<bajaTxostena> bajaDokumentuak) {
        this.bajaDokumentuak = bajaDokumentuak;
    }
    
}
