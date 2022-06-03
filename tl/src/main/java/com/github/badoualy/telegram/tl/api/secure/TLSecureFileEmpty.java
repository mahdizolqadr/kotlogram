package com.github.badoualy.telegram.tl.api.secure;

public class TLSecureFileEmpty extends TLAbsSecureFile {

    public static final int CONSTRUCTOR_ID = 0x64199744;

    private final String _constructor = "secureFileEmpty#64199744";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
