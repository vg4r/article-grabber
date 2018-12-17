package net.sf.vgrs.gamesys.service;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

@Component("fetcher-http")
public class HTTPFetcher extends Fetcher {

    private static final Logger logger = LoggerFactory.getLogger(HTTPFetcher.class);

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
            byte[] returnBytes = IOUtils.toByteArray(inputStream);
            inputStream.close();
            con.disconnect();
            return returnBytes ;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
