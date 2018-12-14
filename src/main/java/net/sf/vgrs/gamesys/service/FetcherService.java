package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.domain.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FetcherService {

    @Autowired
    @Qualifier("fetcherProvider")
    private Fetcher fetcher;

    @Autowired
    @Qualifier("deserializerProvider")
    private Deserializer deserializer;


    public Response fetch() throws Exception {
        byte[] bytes = fetcher.fetch();
        return deserializer.deserialize(bytes, Response.class);
    }

}
