package net.sf.vgrs.gamesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URI;


@Component
public abstract class Fetcher {


    protected URI uri;

    @Autowired
    public Fetcher(@Value("${app.data.source.url}") URI uri){
        this.uri = uri;
    }

    public abstract byte[] fetch();

}
