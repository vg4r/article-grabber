package net.sf.vgrs.gamesys.service;

public interface Deserializer {

    <T> T deserialize(byte[] bytes, Class<T> type) throws Exception;
}
