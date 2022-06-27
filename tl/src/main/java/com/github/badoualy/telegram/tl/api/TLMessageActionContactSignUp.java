package com.github.badoualy.telegram.tl.api;

public class TLMessageActionContactSignUp extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0xf3f25f76;

    private final String _constructor = "messageActionContactSignUp#f3f25f76";

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
