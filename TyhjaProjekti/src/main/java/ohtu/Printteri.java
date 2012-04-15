/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.ArrayList;

/**
 *
 * @author Wampie
 */
public class Printteri {
    public String printtaaTiedot(Palautukset palautukset, int tulostepituus) {
        String ret = "";
        ret += (palautukset.getPalautukset().get(0).getEtunimi() + " " + palautukset.getPalautukset().get(0).getSukunimi() + " Opiskelijanumero: " + palautukset.getPalautukset().get(0).getOpiskelijanumero());
        ret += "\n";
        ret += "\n";
        int aikalaskin = 0;
        int tehtlaskin = 0;
        for (Palautus palautus : palautukset.getPalautukset()) {
            if (palautus.getViikko() == 9) {
                ret += "\n";
                ret += ("Miniprojektiryhmä: " + palautus.getTehtavat());
                break;
            }
            ret += ( palautus );
            for (int i = 0; i < (tulostepituus - palautus.toString().length()); i++) {
                ret += (" ");
            }
            ret += ("aikaa kului " + palautus.getTunteja() + " tuntia \n");
            aikalaskin += palautus.getTunteja();
            tehtlaskin += palautus.getTehtavat().replaceAll(",", "").length();
        }
        ret += "\n";
        ret += "\n";
        ret += ("Yhteensä: " + tehtlaskin + " tehtävää ja " + aikalaskin + " tuntia");
        return ret;
    }
}
