package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLKeyboardButtonRequestPeer extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int buttonId;

    protected TLAbsRequestPeerType peerType;

    protected int maxQuantity;

    private final String _constructor = "keyboardButtonRequestPeer#0";

    public TLKeyboardButtonRequestPeer() {
    }

    public TLKeyboardButtonRequestPeer(String text, int buttonId, TLAbsRequestPeerType peerType, int maxQuantity) {
        this.text = text;
        this.buttonId = buttonId;
        this.peerType = peerType;
        this.maxQuantity = maxQuantity;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(text, stream);
        writeInt(buttonId, stream);
        writeTLObject(peerType, stream);
        writeInt(maxQuantity, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
        buttonId = readInt(stream);
        peerType = readTLObject(stream, context, TLAbsRequestPeerType.class, -1);
        maxQuantity = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(text);
        size += SIZE_INT32;
        size += peerType.computeSerializedSize();
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }

    public TLAbsRequestPeerType getPeerType() {
        return peerType;
    }

    public void setPeerType(TLAbsRequestPeerType peerType) {
        this.peerType = peerType;
    }

    public int getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(int maxQuantity) {
        this.maxQuantity = maxQuantity;
    }
}
