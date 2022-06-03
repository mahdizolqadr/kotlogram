package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypeAddress extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0xcbe31e26;

    private final String _constructor = "secureValueTypeAddress#cbe31e26";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
