package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;

public class Main {

    private static int tulostepituus = 50;

    public static void main(String[] args) throws IOException {
        String studentNr = "13881135";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats.herokuapp.com/opiskelija/" + studentNr + ".json";

        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod(url);
        client.executeMethod(method);

        InputStream stream = method.getResponseBodyAsStream();

        String bodyText = IOUtils.toString(stream);

        Gson mapper = new Gson();
        Palautukset palautukset = mapper.fromJson(bodyText, Palautukset.class);

        Printteri p = new Printteri();
        System.out.println(p.printtaaTiedot(palautukset, tulostepituus));

    }
}