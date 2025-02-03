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
public class TLReplyKeyboardForceReply extends TLAbsReplyMarkup {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean singleUse;

    protected boolean selective;

    protected String placeholder;

    private final String _constructor = "replyKeyboardForceReply#0";

    public TLReplyKeyboardForceReply() {
    }

    public TLReplyKeyboardForceReply(boolean singleUse, boolean selective, String placeholder) {
        this.singleUse = singleUse;
        this.selective = selective;
        this.placeholder = placeholder;
    }

    private void computeFlags() {
        flags = 0;
        flags = singleUse ? (flags | 2) : (flags & ~2);
        flags = selective ? (flags | 4) : (flags & ~4);
        flags = placeholder != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            if (placeholder == null) throwNullFieldException("placeholder", flags);
            writeString(placeholder, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        singleUse = (flags & 2) != 0;
        selective = (flags & 4) != 0;
        placeholder = (flags & 8) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (placeholder == null) throwNullFieldException("placeholder", flags);
            size += computeTLStringSerializedSize(placeholder);
        }
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

    public boolean getSingleUse() {
        return singleUse;
    }

    public void setSingleUse(boolean singleUse) {
        this.singleUse = singleUse;
    }

    public boolean getSelective() {
        return selective;
    }

    public void setSelective(boolean selective) {
        this.selective = selective;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}
