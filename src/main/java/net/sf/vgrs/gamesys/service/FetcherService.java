package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FetcherService {

    private final Fetcher fetcher;

    private final Deserializer deserializer;

    @Autowired
    public FetcherService(@Qualifier("fetcherProvider") Fetcher fetcher, @Qualifier("deserializerProvider") Deserializer deserializer) {
        this.fetcher = fetcher;
        this.deserializer = deserializer;
    }


    public Response fetch() throws Exception {
        byte[] bytes = fetcher.fetch();
        return deserializer.deserialize(bytes, Response.class);
    }

}
