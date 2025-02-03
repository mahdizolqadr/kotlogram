package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLSavedReactionTag;
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
public class TLSavedReactionTags extends TLAbsSavedReactionTags {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLSavedReactionTag> tags;

    protected long hash;

    private final String _constructor = "messages.savedReactionTags#0";

    public TLSavedReactionTags() {
    }

    public TLSavedReactionTags(TLVector<TLSavedReactionTag> tags, long hash) {
        this.tags = tags;
        this.hash = hash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(tags, stream);
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        tags = readTLVector(stream, context);
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += tags.computeSerializedSize();
        size += SIZE_INT64;
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

    public TLVector<TLSavedReactionTag> getTags() {
        return tags;
    }

    public void setTags(TLVector<TLSavedReactionTag> tags) {
        this.tags = tags;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
