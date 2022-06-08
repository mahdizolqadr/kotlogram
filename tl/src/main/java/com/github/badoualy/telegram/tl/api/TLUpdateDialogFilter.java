package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLUpdateDialogFilter extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x26ffde7d;

    protected int flags;
    protected int id;
    protected TLDialogFilter filter;

    private final String _constructor = "updateDialogFilter#26ffde7d";

    public TLUpdateDialogFilter() {
    }

    public TLUpdateDialogFilter(int id, TLDialogFilter filter) {
        this.id = id;
        this.filter = filter;
    }

    protected void computeFlags() {
        flags = 0;
        flags = filter != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) {
            if (filter == null) {
                throwNullFieldException("filter", flags);
            }
            writeTLObject(filter, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readInt(stream);
        filter = (flags & 1) != 0 ? readTLObject(stream, context, TLDialogFilter.class, TLDialogFilter.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (filter == null) {
                throwNullFieldException("filter", flags);
            }
            size += filter.computeSerializedSize();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLDialogFilter getFilter() {
        return filter;
    }

    public void setFilter(TLDialogFilter filter) {
        this.filter = filter;
    }
}
