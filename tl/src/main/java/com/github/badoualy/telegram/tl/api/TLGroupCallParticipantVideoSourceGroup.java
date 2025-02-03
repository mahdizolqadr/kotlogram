package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLGroupCallParticipantVideoSourceGroup extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String semantics;

    protected TLIntVector sources;

    private final String _constructor = "groupCallParticipantVideoSourceGroup#0";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
