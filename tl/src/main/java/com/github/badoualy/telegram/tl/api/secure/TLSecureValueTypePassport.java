package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureValueTypePassport extends TLAbsSecureValueType {

    public static final int CONSTRUCTOR_ID = 0x3dac6a00;

    private final String _constructor = "secureValueTypePassport#3dac6a00";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
