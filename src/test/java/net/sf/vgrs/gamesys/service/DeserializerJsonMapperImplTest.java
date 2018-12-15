package net.sf.vgrs.gamesys.service;

import net.sf.vgrs.gamesys.Application;
import net.sf.vgrs.gamesys.domain.Response;
import net.sf.vgrs.gamesys.utils.TestConstants;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

// import static org.junit.Assert.*;

@ActiveProfiles("test-deserializer-jsonMapper")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DeserializerJsonMapperImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Deserializer deserializer;

    @Before
    public void init(){
        deserializer = new DeserializerJsonMapperImpl();
    }

    @Test
    public void deserialize() throws Exception {
        Response response = deserializer.deserialize(TestConstants.TEST_ARTICLES_URL_JSON_RESPONSE.getBytes(), Response.class);

        assertEquals(Response.ResponseStatuses.OK.value(), response.getStatus());

        assertEquals(2, response.getArticles().size());

    }
}