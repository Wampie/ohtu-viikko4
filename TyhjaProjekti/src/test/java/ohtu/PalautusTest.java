/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

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
public class PalautusTest {
    
    Palautus p;
    
    public PalautusTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        p = new Palautus();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testSetEtunimi() {
        p.setEtunimi("Aleksi");
        assertEquals(p.getEtunimi(), "Aleksi");
    }
    @Test
    public void testSetGithubtunnus() {
        p.setGithubtunnus("http://foo.bar");
        assertEquals(p.getGithubtunnus(), "http://foo.bar");
    }


    @Test
    public void testSetId() {
        p.setId(Long.MAX_VALUE);
        assertEquals(p.getId(), Long.MAX_VALUE, 1.0);
    }


    @Test
    public void testSetJenkinstunnus() {
        p.setJenkinstunnus("http://foo.bar");
        assertEquals(p.getJenkinstunnus(), "http://foo.bar");
    }

    @Test
    public void testSetOpiskelijanumero() {
        p.setOpiskelijanumero("12345678");
        assertEquals(p.getOpiskelijanumero(), "12345678");
    }
    
    @Test
    public void testSetSukunimi() {
        p.setSukunimi("aleksi");
        assertEquals(p.getSukunimi(), "aleksi");
    }

    @Test
    public void testSetTehtavat() {
        p.setTehtavat("1,2,3");
        assertEquals(p.getTehtavat(), "1,2,3");
    }

    @Test
    public void testSetTehtavia() {
        p.setTehtavia(3);
        assertEquals(p.getTehtavia(), 3);
    }

    @Test
    public void testSetTunteja() {
        p.setTunteja(1);
        assertEquals(p.getTunteja(), 1);
    }

    @Test
    public void testSetViikko() {
        p.setViikko(1);
        assertEquals(p.getViikko(), 1);
    }

    @Test
    public void testPrintAika() {
        assertEquals(p.printAika(), "aikaa kului 1 tuntia");
    }
}
