package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypePersonalDetails extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0x9d2a81e3;

    private final String _constructor = "secureValueTypePersonalDetails#9d2a81e3";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
