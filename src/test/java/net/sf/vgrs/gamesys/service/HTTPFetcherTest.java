package net.sf.vgrs.gamesys.service;

import org.junit.Before;
import org.junit.Test;
import java.net.URI;
import java.net.URISyntaxException;
import static org.assertj.core.api.Assertions.assertThat;

public class HTTPFetcherTest {

    private String uri = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=05aab06ca65746529dd129d84a4fd334";

    private Fetcher fetcher;

    @Before
    public void init() throws URISyntaxException {
        fetcher = new HTTPFetcher(new URI(uri));
    }


    @Test
    public void test() {
        byte[] bytes = fetcher.fetch();

        assertThat(bytes.length).isGreaterThan(0);

    }


}