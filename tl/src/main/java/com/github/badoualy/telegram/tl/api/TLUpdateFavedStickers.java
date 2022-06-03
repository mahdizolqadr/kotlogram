package com.github.badoualy.telegram.tl.api;

public class TLUpdateFavedStickers extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xe511996d;

    private final String _constructor = "updateFavedStickers#e511996d";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
