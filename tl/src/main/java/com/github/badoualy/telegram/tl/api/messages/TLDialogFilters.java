package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDialogFilter;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLDialogFilters extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean tagsEnabled;

    protected TLVector<TLAbsDialogFilter> filters;

    private final String _constructor = "messages.dialogFilters#0";

    public TLDialogFilters() {
    }

    public TLDialogFilters(boolean tagsEnabled, TLVector<TLAbsDialogFilter> filters) {
        this.tagsEnabled = tagsEnabled;
        this.filters = filters;
    }

    private void computeFlags() {
        flags = 0;
        flags = tagsEnabled ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(filters, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        tagsEnabled = (flags & 1) != 0;
        filters = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += filters.computeSerializedSize();
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

    public boolean getTagsEnabled() {
        return tagsEnabled;
    }

    public void setTagsEnabled(boolean tagsEnabled) {
        this.tagsEnabled = tagsEnabled;
    }

    public TLVector<TLAbsDialogFilter> getFilters() {
        return filters;
    }

    public void setFilters(TLVector<TLAbsDialogFilter> filters) {
        this.filters = filters;
    }
}
