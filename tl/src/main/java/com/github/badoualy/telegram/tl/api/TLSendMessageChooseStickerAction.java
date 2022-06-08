package com.github.badoualy.telegram.tl.api;

public class TLSendMessageChooseStickerAction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0xb05ac6b1;

    private final String _constructor = "sendMessageChooseStickerAction#b05ac6b1";

    public TLSendMessageChooseStickerAction() {
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
