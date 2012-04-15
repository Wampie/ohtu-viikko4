/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;
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
public class PrintteriTest {
    Palautus p = new Palautus();
    public PrintteriTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        p.setEtunimi("Aleksi");
        p.setSukunimi("Majander");
        p.setGithubtunnus("-");
        p.setOpiskelijanumero("12345678");
        p.setTehtavat("1");
        p.setViikko(1);
        p.setTunteja(1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testPrinttaaTiedot() {
        Palautukset pp = new Palautukset();
        ArrayList<Palautus> ppp = new ArrayList<Palautus>();
        ppp.add(p);
        pp.setPalautukset(ppp);
        
        assertEquals("Aleksi Majander Opiskelijanumero: 12345678", (new Printteri().printtaaTiedot(pp, 50)).substring(0, 42));
    }
}
