package net.sf.vgrs.gamesys.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

@Component("fetcher-http")
public class HTTPFetcher extends Fetcher {



    @Override
    public byte[] fetch() {
        try {
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream inputStream = con.getInputStream();
            byte[] targetArray = new byte[inputStream.available()];
            int read = inputStream.read(targetArray);
            return targetArray;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
