package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityStrike extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0xbf0693d4;

    private final String _constructor = "messageEntityStrike#bf0693d4";

    public TLMessageEntityStrike() {
    }

    public TLMessageEntityStrike(int offset, int length) {
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
