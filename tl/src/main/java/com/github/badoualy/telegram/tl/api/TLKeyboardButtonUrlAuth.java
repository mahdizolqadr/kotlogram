package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLKeyboardButtonUrlAuth extends TLAbsKeyboardButton {

    public static final int CONSTRUCTOR_ID = 0x10b78d29;

    protected int flags;
    protected String fwdText;
    protected String url;
    protected int buttonId;

    private final String _constructor = "keyboardButtonUrlAuth#10b78d29";

    public TLKeyboardButtonUrlAuth() {
    }

    public TLKeyboardButtonUrlAuth(String text, String fwdText, String url, int buttonId) {
        this.text = text;
        this.fwdText = fwdText;
        this.url = url;
        this.buttonId = buttonId;
    }

    private void computeFlags() {
        flags = 0;
        flags = fwdText != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeString(text, stream);
        if ((flags & 1) != 0) {
            if (fwdText == null) {
                throwNullFieldException("fwdText", flags);
            }
            writeString(fwdText, stream);
        }
        writeString(url, stream);
        writeInt(buttonId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        text = readTLString(stream);
        fwdText = (flags & 1) != 0 ? readTLString(stream) : null;
        url = readTLString(stream);
        buttonId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(text);
        if ((flags & 1) != 0) {
            if (fwdText == null) {
                throwNullFieldException("fwdText", flags);
            }
            size += computeTLStringSerializedSize(fwdText);
        }
        size += computeTLStringSerializedSize(url);
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

    public String getFwdText() {
        return fwdText;
    }

    public void setFwdText(String fwdText) {
        this.fwdText = fwdText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getButtonId() {
        return buttonId;
    }

    public void setButtonId(int buttonId) {
        this.buttonId = buttonId;
    }
}
