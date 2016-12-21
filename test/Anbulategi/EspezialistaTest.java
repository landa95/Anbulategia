/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

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
public class EspezialistaTest {
    
    private DB ndb = DB.getNDB();
    private Espezialista sendagile1 = new Espezialista(789632145, "Juan", "Iglesias", "Kardiologia");
    private Espezialista sendagile2 = new Espezialista(789632141, "Alazne", "Iglesias", "Traumatologia");
    
    public EspezialistaTest() {
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
    public void testHistorialBerezia(){
        //daturen bat sartuz
        Historial his = sendagile1.historialaKontsultatu(987654321); //gaixoa datubasean egongo da
        HorriBereziList hb = his.gethBereziak();
        HorriBerezia kardio = hb.bilatuEspezialitatekoHorria("Kardiologia");
        sendagile1.historialBerezia(987654321, "proba 1");
        hb = his.gethBereziak();
        if (kardio != null)
            assertNotEquals(kardio.getHistoria(), hb.bilatuEspezialitatekoHorria("Kardiologia").getHistoria());
        else 
            assertNotEquals(hb.bilatuEspezialitatekoHorria("Kardiologia"), null); //sortu egin dela adierazteko
        //gehiketa hutsa
       his = sendagile2.historialaKontsultatu(987654321);
       hb = his.gethBereziak();
       HorriBerezia trauma = hb.bilatuEspezialitatekoHorria("Traumatologia");
       sendagile2.historialBerezia(987654321, "");
        hb = his.gethBereziak();
        if (trauma != null)
            assertEquals(trauma.getHistoria(), hb.bilatuEspezialitatekoHorria("Traumatologia").getHistoria());
        else 
            assertNotEquals(hb.bilatuEspezialitatekoHorria("Traumatologia"), null); //sortu egin dela adierazteko
    }
}
