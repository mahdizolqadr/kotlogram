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

public class TLUpdateGroupCallConnection extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xb783982;

    protected int flags;
    protected boolean presentation;
    protected TLDataJSON params;

    private final String _constructor = "updateGroupCallConnection#b783982";

    public TLUpdateGroupCallConnection() {
    }

    public TLUpdateGroupCallConnection(boolean presentation, TLDataJSON params) {
        this.presentation = presentation;
        this.params = params;
    }

    protected void computeFlags() {
        flags = 0;
        flags = presentation ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(params, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        presentation = (flags & 1) != 0;
        params = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += params.computeSerializedSize();
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

    public boolean isPresentation() {
        return presentation;
    }

    public void setPresentation(boolean presentation) {
        this.presentation = presentation;
    }

    public TLDataJSON getParams() {
        return params;
    }

    public void setParams(TLDataJSON params) {
        this.params = params;
    }
}
