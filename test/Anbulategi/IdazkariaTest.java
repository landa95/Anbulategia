/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oier
 */
public class IdazkariaTest {
    
    private DB ndb = DB.getNDB();
    Idazkaria idazkari = new Idazkaria();
            
    public IdazkariaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testHistorialBerria(){
        //ez dagoen gaixo batekin proba
        Gaixoa ga = new Gaixoa("Jon","Alberdi","Nuñez",20,111111111,"Bilbo", 555414297);
        assertFalse(ndb.gaixoaDago(ga)); //ez da existitzen datu basean
        assertEquals(ndb.historialaBilatu(ga.getTxartela()), null); //historiala ezta ere ez dago sortua
        //orain bere historiala sortuko dugu, horrela gaisoa datu basean sartuko da eta bere historiala ere sortuko da
        idazkari.historialBerria(ga.getIzena(), ga.getAbizena1(), ga.getAbizena2(), ga.getAdina(), ga.getTelefonoa(), ga.getBizilekua(), ga.getTxartela());
        assertTrue(ndb.gaixoaDago(ga)); //gaisoa datu basean dago
        Historial his = ndb.historialaBilatu(ga.getTxartela());
        assertTrue(his.nireGSZda(ga.getTxartela())); //gaisoaren historiala sortu da
        
        //jadanik dagoen gaixo batekin proba -- deberia petar, pero como?
        fail("Not yet implemented");
    }
    
    @Test
    public void testOrduLibreakErakutsi(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2016-12-23";
        Date data = null;
        try {
            data = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(IdazkariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ordu libreak dituen medikuaren proba 
        ArrayList<String> lista = idazkari.orduLibreakErakutsi(data,987654321);
        assertFalse(lista.isEmpty());
        assertNotEquals(lista.size(), 0);
        //ordu librerik ez duen medikuaren proba
        lista = idazkari.orduLibreakErakutsi(data,987654321);
        assertTrue(lista.isEmpty());
        assertEquals(lista.size(), 0);
        //datubasean ez dagoen gaixoaren proba
        //datubasean ez dagoen gaixoaren proba
        fail("Not yet implemented");
    }
    
    @Test
    public void testTxandakEsleitu(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
        String dateInString = "2016-12-23";
        Date data = null;
        try {
            data = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(IdazkariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        //ordu posibleekin txandak esleitzea
        assertTrue(ndb.orduaLibreDago(data,1234567)); //medikuaren id-a da
        idazkari.txandakEsleitu(data, "08:00", 987654321);
        assertFalse(ndb.orduaLibreDago(data,1234567)); //medikuaren id-a da
        //ordu ezinezkoekin orduak esleitzea
        dateInString = "2016-11-20"; //pasata dagoen data
        try {
            data = sdf.parse(dateInString);
        } catch (ParseException ex) {
            Logger.getLogger(IdazkariaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        idazkari.txandakEsleitu(data, "08:00", 987654321);
        //datubasean ez dagoen gaixoak ordua esleiztea
        //datubasean ez dagoen medikua esleitzea
        fail("Not yet implemented");
    }
    
    @Test
    public void testBajaPaperaBerritu(){
        //baja papera berritu aste bat
        //aste bat baino gutxaigo
        //ez berritu
        //bajarik ez duen gaixoa
        //datubasean ez dagoen gaixoa
        fail("Not yet implemented");
    }
    
    @Test
    public void testGaixoDatuakIkusi(){
        //datuak normal ikusi
        //gaixoa datubasean ez dagoenean
        fail("Not yet implemented");
    }
}
