package paulberinde_tampanariu.paulberinde_pset5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Handles interaction with Destiny (Bungie) API
 */

public class DestinyHelper {

    private static String playerID;
    private static String memID;
    private static final String urlBase = "http://www.bungie.net/Platform/Destiny/";
    private static final String profileURL = urlBase + "2/Account" + memID + "/Summary/";
    private static final String apiKey= "bcb5763dbca64694b048ca26297e9fec";

    //method to download from server
    protected static synchronized String serverDownload( String params){
        String memIdURL = urlBase + "SearchDestinyPlayer/2/" + params;
        String result ="";
        URL url = null;

        try {
            url = new URL(memIdURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection connection;
        if (url != null) {
            try {
                connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("X-API-Key", apiKey);
                Integer responseCode = connection.getResponseCode();
                if (200 <= responseCode && responseCode <= 299) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        result = result + line;
                    }
                }
                else{
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                    // communicate error
                    }
                } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
