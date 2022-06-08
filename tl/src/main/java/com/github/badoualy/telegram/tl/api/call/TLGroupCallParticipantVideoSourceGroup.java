package com.github.badoualy.telegram.tl.api.call;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLGroupCallParticipantVideoSourceGroup extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xdcb118b7;

    protected String semantics;
    protected TLIntVector sources;

    private final String _constructor = "groupCallParticipantVideoSourceGroup#dcb118b7";

    public TLGroupCallParticipantVideoSourceGroup() {
    }

    public TLGroupCallParticipantVideoSourceGroup(String semantics, TLIntVector sources) {
        this.semantics = semantics;
        this.sources = sources;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(semantics, stream);
        writeTLVector(sources, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        semantics = readTLString(stream);
        sources = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(semantics);
        size += sources.computeSerializedSize();
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

    public String getSemantics() {
        return semantics;
    }

    public void setSemantics(String semantics) {
        this.semantics = semantics;
    }

    public TLIntVector getSources() {
        return sources;
    }

    public void setSources(TLIntVector sources) {
        this.sources = sources;
    }
}
