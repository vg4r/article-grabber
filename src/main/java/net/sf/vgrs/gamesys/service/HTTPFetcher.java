package net.sf.vgrs.gamesys.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

@Component("fetcher-http")
public class HTTPFetcher extends Fetcher {

    public HTTPFetcher(@Value("${app.data.source.url}") URI uri) {
        super(uri);
    }

    @Override
    public byte[] fetch() {
        try {
            URL url = uri.toURL();
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            InputStream inputStream = con.getInputStream();
            return IOUtils.toByteArray(inputStream);
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
