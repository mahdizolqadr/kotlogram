package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypePhone extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0xb320aadb;

    private final String _constructor = "secureValueTypePhone#b320aadb";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
