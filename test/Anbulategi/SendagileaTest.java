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
public class SendagileaTest {
    
    private DB ndb = DB.getNDB();
    private Sendagilea sendagile = new Sendagilea(123456789, "Pablo", "Agirre"); //datubasean gordeta egon beharko da
    
    public SendagileaTest() {
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
    
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void testHistorialaKontsultatu(){
        //dagoen historial bat bilatu
        Historial his = sendagile.historialaKontsultatu(98765321); //gaixoa datubasean egongo da
        assertNotEquals(his, null);
        assertEquals(his.getgGSZ(), 987654321);
        System.out.println(his.getHistoria());
        //historiala ez badago
        his = sendagile.historialaKontsultatu(00000000); //gaixoa datubasean egongo da
        assertEquals(his, null);
        fail("Not yet implemented");
    }
    
    @Test
    public void testHistorialaEguneratu(){
        //daturen bat sartuz
        Historial his = sendagile.historialaKontsultatu(987654321); //gaixoa datubasean egongo da
        String text = his.getHistoria();
        sendagile.historialaEguneratu(987654321, "proba aldaketa");
        his = sendagile.historialaKontsultatu(987654321);
        assertNotEquals(text, his.getHistoria()); //historia berria eta zaharra konparatu
        //gehiketa hutsa
        his = sendagile.historialaKontsultatu(987654321); //gaixoa datubasean egongo da
        text = his.getHistoria();
        sendagile.historialaEguneratu(987654321, "");
        his = sendagile.historialaKontsultatu(987654321);
        assertEquals(text, his.getHistoria()); //historia berria eta zaharra konparatu
        fail("Not yet implemented");
    }
    
    @Test
    public void testBajaEman(){
        fail("Not yet implemented");
    }
    
    @Test
    public void testErrezetaSortu(){
        Gaixoa ga = new Gaixoa("Jon", "Nuñez", "Perez", 20, 654321987, "Bilbo", 456789123);
        Errezeta er = sendagile.errezetaSortu("Botika", 3, "Jan eta gero hartzekoa", ga);
        fail("Not yet implemented");
    }
    
    @Test
    public void testEgunekoTxandak(){
        //txandaren bat duen sendagilea
        TxandaZerrenda tz = sendagile.egunekoTxandak();
        assertTrue(tz.size() > 0);
        assertTrue(tz.size() == 1);
        System.out.println(tz.toString());
        //txanda bat baino gehiago dituen sendagilea
        Sendagilea sen2 = new Sendagilea(78985215, "Jose", "Menendez");
        tz = sen2.egunekoTxandak();
        assertTrue(tz.size() > 1);
        System.out.println(tz.toString());
        //txandarik ez duen sendagilea
        sen2 = new Sendagilea(78985215, "Pedro", "Portela");
        tz = sen2.egunekoTxandak();
        assertTrue(tz.size() == 0);
        System.out.println(tz.toString());
    }
}
