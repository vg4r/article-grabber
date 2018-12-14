package net.sf.vgrs.gamesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;


@Component
public abstract class Fetcher {

    @Autowired
    @Value("${app.rss.url}")
    protected URI uri;

    public abstract byte[] fetch();

}
