package net.sf.vgrs.gamesys.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.stereotype.Component;

@Component("deserializer-xmlmapper")
public class DeserializerXMLMapperImpl implements Deserializer {

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> type) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(bytes, type);

    }
}
