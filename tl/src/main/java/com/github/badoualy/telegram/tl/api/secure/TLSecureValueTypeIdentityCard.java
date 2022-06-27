package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypeIdentityCard extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0xa0d0744b;

    private final String _constructor = "secureValueTypeIdentityCard#a0d0744b";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
