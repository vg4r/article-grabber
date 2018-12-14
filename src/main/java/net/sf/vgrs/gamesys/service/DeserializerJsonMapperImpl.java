package net.sf.vgrs.gamesys.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component("deserializer-jsonmapper")
public class DeserializerJsonMapperImpl implements Deserializer {

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws Exception {
        ObjectMapper xmlMapper = new ObjectMapper();
        return xmlMapper.readValue(bytes, type);

    }
}
