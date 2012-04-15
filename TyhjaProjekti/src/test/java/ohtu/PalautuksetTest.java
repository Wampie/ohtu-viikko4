/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wampie
 */
public class PalautuksetTest {
    
    public PalautuksetTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetPalautukset() {
        Palautukset pp = new Palautukset();
        ArrayList<Palautus> p = new ArrayList<Palautus>();
        p.add(new Palautus());
        p.add(new Palautus());
        pp.setPalautukset(p);
        assertEquals(2, pp.getPalautukset());
    }

}
