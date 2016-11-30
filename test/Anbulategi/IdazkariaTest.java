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
        
        //jadanik dagoen gaixo batekin proba
        fail("Not yet implemented");
    }
    
    @Test
    public void testOrduLibreakErakutsi(){
        //ordu libreak dituen medikuaren proba 
        //ordu librerik ez duen medikuaren proba
        //datubasean ez dagoen medikuaren proba
        //datubasean ez dagoen gaixoaren proba
        fail("Not yet implemented");
    }
    
    @Test
    public void testTxandakEsleitu(){
        //ordu posibleekin txandak eslitzea
        //ordu ezinezkoekin orduak esleitzea
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
    
    @Test
    public void testGaixoIzenaAldatu(){
        //datua aldatu badago
        //datua aldatu ez badago
        fail("Not yet implemented");
    }
    
    @Test
    public void testGaixoAbizenakAldatu(){
        //datua aldatu badago
        //datua aldatu ez badago
        fail("Not yet implemented");
    }
    
    @Test
    public void testTelfAldatu(){
        //datua aldatu badago
        //datua aldatu ez badago
        fail("Not yet implemented");
    }
    
    @Test
    public void testGaixoHelbAldatu(){
        //datua aldatu badago
        //datua aldatu ez badago
        fail("Not yet implemented");
    }
}
