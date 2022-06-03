package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityPhone extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0x9b69e34b;

    private final String _constructor = "messageEntityPhone#9b69e34b";

    public TLMessageEntityPhone() {
    }

    public TLMessageEntityPhone(int offset, int length) {
        super(offset, length);
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
