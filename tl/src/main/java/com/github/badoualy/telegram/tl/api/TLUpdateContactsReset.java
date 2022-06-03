package com.github.badoualy.telegram.tl.api;

public class TLUpdateContactsReset extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x7084a7be;

    private final String _constructor = "updateContactsReset#7084a7be";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
