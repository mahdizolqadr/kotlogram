package com.github.badoualy.telegram.tl.api;

public class TLMessageEntityBankCard extends TLAbsMessageEntity {

    public static final int CONSTRUCTOR_ID = 0x761e6af4;

    private final String _constructor = "messageEntityPhone#9b69e34b";

    public TLMessageEntityBankCard() {
    }

    public TLMessageEntityBankCard(int offset, int length) {
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
