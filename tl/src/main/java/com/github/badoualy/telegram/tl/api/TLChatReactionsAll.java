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
public class TLChatReactionsAll extends TLAbsChatReactions {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean allowCustom;

    private final String _constructor = "chatReactionsAll#0";

    public TLChatReactionsAll() {
    }

    public TLChatReactionsAll(boolean allowCustom) {
        this.allowCustom = allowCustom;
    }

    private void computeFlags() {
        flags = 0;
        flags = allowCustom ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        allowCustom = (flags & 1) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getAllowCustom() {
        return allowCustom;
    }

    public void setAllowCustom(boolean allowCustom) {
        this.allowCustom = allowCustom;
    }
}
