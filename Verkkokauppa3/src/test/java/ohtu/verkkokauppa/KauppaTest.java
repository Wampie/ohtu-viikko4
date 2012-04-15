package ohtu.verkkokauppa;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
public class KauppaTest {
    
    public KauppaTest() {
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
    public void yksiTuoteJaTilisiirto() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        
        when(mockVarasto.saldo(1)).thenReturn(1);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(20));
    }
   @Test
    public void kaksiEriTuotettaJaTilisiirto() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        Tuote tuote2 = new Tuote(2, "dor", 10);
        
        when(mockVarasto.saldo(1)).thenReturn(2);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        when(mockVarasto.saldo(2)).thenReturn(2);
        when(mockVarasto.haeTuote(2)).thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(30));
    }
    @Test
    public void kaksiSamaaTuotettaJaTilisiirto() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        
        when(mockVarasto.saldo(1)).
                thenReturn(2).
                thenReturn(1);
        when(mockVarasto.haeTuote(1)).
                thenReturn(tuote).
                thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(40));
    }

    @Test
    public void kaksiEriTuotettaJoistaToinenLoppuJaTilisiirto() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        Tuote tuote2 = new Tuote(2, "dor", 10);
        
        when(mockVarasto.saldo(1)).thenReturn(2);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        when(mockVarasto.saldo(2)).thenReturn(0);
        when(mockVarasto.haeTuote(2)).thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(20));
    }
    
    @Test
    public void aloitaAsiointiNollaaTiedot() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        Tuote tuote2 = new Tuote(2, "dor", 10);
        
        when(mockVarasto.saldo(1)).thenReturn(2);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        
        kauppa.aloitaAsiointi();
        when(mockVarasto.saldo(2)).thenReturn(2);
        when(mockVarasto.haeTuote(2)).thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(10));
    }
    
    @Test
    public void jokaiselleMaksutapahtumalleUusiViitenumero() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        Tuote tuote2 = new Tuote(2, "dor", 10);
        
        when(mockVarasto.saldo(1)).thenReturn(2);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        
        kauppa.tilimaksu("aatu", "123");
        
        kauppa.aloitaAsiointi();
        when(mockVarasto.saldo(2)).thenReturn(2);
        when(mockVarasto.haeTuote(2)).thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("aatu", "123");
        
        kauppa.aloitaAsiointi();
        when(mockVarasto.saldo(2)).thenReturn(2);
        when(mockVarasto.haeTuote(2)).thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("aatu", "123");
        
        verify(mockViite, times(3)).uusi();
    }
    
       @Test
    public void kaksiEriTuotettaYhdenTuotteenPoistoJaTilisiirto() {
        Pankki mockPankki = mock(Pankki.class);
        Viitegeneraattori mockViite = mock(Viitegeneraattori.class);
        Varasto mockVarasto = mock(Varasto.class);
        
        Kauppa kauppa = new Kauppa(mockVarasto, mockPankki, mockViite);
        kauppa.aloitaAsiointi();
        
        Tuote tuote = new Tuote(1, "jee", 20);
        Tuote tuote2 = new Tuote(2, "dor", 10);
        
        when(mockVarasto.saldo(1)).thenReturn(2);
        when(mockVarasto.haeTuote(1)).thenReturn(tuote);
        kauppa.lisaaKoriin(1);
        when(mockVarasto.saldo(2)).thenReturn(2);
        when(mockVarasto.haeTuote(2)).
                thenReturn(tuote2).
                thenReturn(tuote2);
        kauppa.lisaaKoriin(2);
        
        kauppa.poistaKorista(2);
        
        kauppa.tilimaksu("aatu", "123");
        verify(mockPankki).tilisiirto(eq("aatu"), anyInt(), eq("123"),
                anyString(), eq(20));
    }
}