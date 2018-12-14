package net.sf.vgrs.gamesys.dao.h2;

public enum H2SQLStates {

    DUPLICATE_KEY_1("23505");

    public String value;
    H2SQLStates(String value) {
        this.value = value;
    }
}
