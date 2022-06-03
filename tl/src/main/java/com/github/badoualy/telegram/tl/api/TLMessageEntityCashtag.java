package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityCashtag extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0x4c4e743f;

    private final String _constructor = "messageEntityCashtag#4c4e743f";

    public TLMessageEntityCashtag() {
    }

    public TLMessageEntityCashtag(int offset, int length) {
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
