package com.github.badoualy.telegram.tl.api;

public class TLUpdateLoginToken extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x564fe691;

    private final String _constructor = "updateLoginToken#564fe691";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
