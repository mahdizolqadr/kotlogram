package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityBlockquote extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0x20df5d0;

    private final String _constructor = "messageEntityBlockquote#20df5d0";

    public TLMessageEntityBlockquote() {
    }

    public TLMessageEntityBlockquote(int offset, int length) {
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
