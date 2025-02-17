package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLReplyKeyboardMarkup extends TLAbsReplyMarkup {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean resize;

    protected boolean singleUse;

    protected boolean selective;

    protected boolean persistent;

    protected TLVector<TLKeyboardButtonRow> rows;

    protected String placeholder;

    private final String _constructor = "replyKeyboardMarkup#0";

    public TLReplyKeyboardMarkup() {
    }

    public TLReplyKeyboardMarkup(boolean resize, boolean singleUse, boolean selective, boolean persistent, TLVector<TLKeyboardButtonRow> rows, String placeholder) {
        this.resize = resize;
        this.singleUse = singleUse;
        this.selective = selective;
        this.persistent = persistent;
        this.rows = rows;
        this.placeholder = placeholder;
    }

    private void computeFlags() {
        flags = 0;
        flags = resize ? (flags | 1) : (flags & ~1);
        flags = singleUse ? (flags | 2) : (flags & ~2);
        flags = selective ? (flags | 4) : (flags & ~4);
        flags = persistent ? (flags | 16) : (flags & ~16);
        flags = placeholder != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(rows, stream);
        if ((flags & 8) != 0) {
            if (placeholder == null) throwNullFieldException("placeholder", flags);
            writeString(placeholder, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        resize = (flags & 1) != 0;
        singleUse = (flags & 2) != 0;
        selective = (flags & 4) != 0;
        persistent = (flags & 16) != 0;
        rows = readTLVector(stream, context);
        placeholder = (flags & 8) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += rows.computeSerializedSize();
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

    public boolean getResize() {
        return resize;
    }

    public void setResize(boolean resize) {
        this.resize = resize;
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

    public boolean getPersistent() {
        return persistent;
    }

    public void setPersistent(boolean persistent) {
        this.persistent = persistent;
    }

    public TLVector<TLKeyboardButtonRow> getRows() {
        return rows;
    }

    public void setRows(TLVector<TLKeyboardButtonRow> rows) {
        this.rows = rows;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }
}
