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
public class TLInputKeyboardButtonRequestPeer extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean nameRequested;

    protected boolean usernameRequested;

    protected boolean photoRequested;

    protected int buttonId;

    protected TLAbsRequestPeerType peerType;

    protected int maxQuantity;

    private final String _constructor = "inputKeyboardButtonRequestPeer#0";

    public TLInputKeyboardButtonRequestPeer() {
    }

    public TLInputKeyboardButtonRequestPeer(boolean nameRequested, boolean usernameRequested, boolean photoRequested, String text, int buttonId, TLAbsRequestPeerType peerType, int maxQuantity) {
        this.nameRequested = nameRequested;
        this.usernameRequested = usernameRequested;
        this.photoRequested = photoRequested;
        this.text = text;
        this.buttonId = buttonId;
        this.peerType = peerType;
        this.maxQuantity = maxQuantity;
    }

    private void computeFlags() {
        flags = 0;
        flags = nameRequested ? (flags | 1) : (flags & ~1);
        flags = usernameRequested ? (flags | 2) : (flags & ~2);
        flags = photoRequested ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(text, stream);
        writeInt(buttonId, stream);
        writeTLObject(peerType, stream);
        writeInt(maxQuantity, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        nameRequested = (flags & 1) != 0;
        usernameRequested = (flags & 2) != 0;
        photoRequested = (flags & 4) != 0;
        text = readTLString(stream);
        buttonId = readInt(stream);
        peerType = readTLObject(stream, context, TLAbsRequestPeerType.class, -1);
        maxQuantity = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean getNameRequested() {
        return nameRequested;
    }

    public void setNameRequested(boolean nameRequested) {
        this.nameRequested = nameRequested;
    }

    public boolean getUsernameRequested() {
        return usernameRequested;
    }

    public void setUsernameRequested(boolean usernameRequested) {
        this.usernameRequested = usernameRequested;
    }

    public boolean getPhotoRequested() {
        return photoRequested;
    }

    public void setPhotoRequested(boolean photoRequested) {
        this.photoRequested = photoRequested;
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
