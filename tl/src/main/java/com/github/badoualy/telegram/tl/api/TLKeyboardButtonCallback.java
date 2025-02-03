package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLKeyboardButtonCallback extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean requiresPassword;

    protected TLBytes data;

    private final String _constructor = "keyboardButtonCallback#0";

    public TLKeyboardButtonCallback() {
    }

    public TLKeyboardButtonCallback(boolean requiresPassword, String text, TLBytes data) {
        this.requiresPassword = requiresPassword;
        this.text = text;
        this.data = data;
    }

    private void computeFlags() {
        flags = 0;
        flags = requiresPassword ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(text, stream);
        writeTLBytes(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requiresPassword = (flags & 1) != 0;
        text = readTLString(stream);
        data = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(text);
        size += computeTLBytesSerializedSize(data);
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

    public boolean getRequiresPassword() {
        return requiresPassword;
    }

    public void setRequiresPassword(boolean requiresPassword) {
        this.requiresPassword = requiresPassword;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }
}
