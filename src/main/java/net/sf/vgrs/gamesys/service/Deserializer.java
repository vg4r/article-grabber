package net.sf.vgrs.gamesys.service;

import org.springframework.stereotype.Component;

@Component
public interface Deserializer {

    public <T> T deserialize(byte[] bytes, Class<T> type) throws Exception;
}
