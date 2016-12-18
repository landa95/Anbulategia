package Anbulategi;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "gaisoa")
public class Gaixoa {
    //AT
    @Column(name="Izena")
    private String izena;
    @Column(name="Abizena1")
    private String abizena1;
    @Column(name="Abizena2")
    private String abizena2;
    @Column(name="Adina")
    private int adina;
    @Column(name="Telefonoa")
    private int telefonoa;
    @Column(name="Herria")
    private String bizilekua;
   
    @Id
   @GeneratedValue
   @Column(name="GSZ")
    private int GSZ;
    private boolean pentsioduna = false;
    private Sendagilea medikua;
    
    @OneToOne(mappedBy="historiala", cascade=CascadeType.ALL)
    private Historial historiala;
    
    @OneToMany(mappedBy ="GSZ")
    private Set<Errezeta> errezetak;
    @OneToMany(mappedBy="GSZ")
    private Set<bajaTxostena> bajaDokumentuak;
    //private Txostena txostena;
    
    //Constructor
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
        return getGSZ();
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

    public void setMedikua(int medikuNAN){
        this.medikua = DB.getNDB().bilatuMedikua(medikuNAN);
    }
    //METODOAK   
    public ArrayList<String> OrduaAukeratu(Date pData){
        Idazkaria idaz = new Idazkaria();
        return idaz.orduLibreakErakutsi(pData, GSZ);
    }
    
     public void kontsultaEskatu(Date pData){
        Idazkaria idaz = new Idazkaria();
        idaz.txandakEsleitu(pData, GSZ);
    }
    
    public TxandaZerrenda gaixoarenTxandak(){
        //gaurtik aurrerakoak bakarrim eskatuko dira
        return DB.getNDB().gaixoarenTxandak(new Date(), getGSZ());
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

    /**
     * @return the historiala
     */
    public Historial getHistoriala() {
        return historiala;
    }

    /**
     * @param historiala the historiala to set
     */
    public void setHistoriala(Historial historiala) {
        this.historiala = historiala;
    }
    
}
