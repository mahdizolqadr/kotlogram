package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypeTemporaryRegistration extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0xea02ec33;

    private final String _constructor = "secureValueTypeTemporaryRegistration#ea02ec33";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
