/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Anbulategi;

import java.util.Date;
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
public class GaixoaTest {
    
    private DB ndb = DB.getNDB();
    private Gaixoa ga = new Gaixoa("Oier", "Beaskoetxea", "Aldazabal", 20, 624631987, "Bilbo", 99999999); //jadanik datubasean egongo da
    
    public GaixoaTest() {
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
    public void testKontsulaEskatu(){
        TxandaZerrenda tz = ga.gaixoarenTxandak();
        assertTrue(tz.size() == 0); // ez dauka txandarik
        ga.kontsultaEskatu(new Date(), "10:00");
        tz = ga.gaixoarenTxandak();
        assertTrue(tz.size() == 1);
        ga.kontsultaEskatu(new Date(), "11:00");
        tz = ga.gaixoarenTxandak();
        assertTrue(tz.size() == 2);
    }
    
    @Test
    public void testGaixoarenTxandak(){ // bi probak oso loturik daude
        TxandaZerrenda tz = ga.gaixoarenTxandak();
        assertTrue(tz.size() == 0); 
        ga.kontsultaEskatu(new Date(), "10:00");
        tz = ga.gaixoarenTxandak();
        assertTrue(tz.size() == 1);
    }
}
