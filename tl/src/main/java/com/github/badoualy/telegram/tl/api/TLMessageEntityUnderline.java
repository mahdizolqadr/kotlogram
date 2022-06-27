package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityUnderline extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0x9c4e7e8b;

    private final String _constructor = "messageEntityUnderline#9c4e7e8b";

    public TLMessageEntityUnderline() {
    }

    public TLMessageEntityUnderline(int offset, int length) {
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
