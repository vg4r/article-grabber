package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.utils.TestConstants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;

// import static org.junit.Assert.*;


public class DeserializerXmlMapperImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Deserializer deserializer;

    @Before
    public void setUp(){
        deserializer = new DeserializerXMLMapperImpl();
    }

    @Test
    public void deserialize() throws Exception {
        Response response = deserializer.deserialize(TestConstants.TEST_ARTICLES_URL_XML_RESPONSE.getBytes(), Response.class);

        assertTrue(Response.ResponseStatuses.OK.value().equals(response.getStatus()));

        assertTrue(response.getArticles().size() == 2 );

    }
}