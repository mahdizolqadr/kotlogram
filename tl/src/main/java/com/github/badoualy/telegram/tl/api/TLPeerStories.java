package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerStories extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsPeer peer;

    protected Integer maxReadId;

    protected TLVector<TLAbsStoryItem> stories;

    private final String _constructor = "peerStories#0";

    public TLPeerStories() {
    }

    public TLPeerStories(TLAbsPeer peer, Integer maxReadId, TLVector<TLAbsStoryItem> stories) {
        this.peer = peer;
        this.maxReadId = maxReadId;
        this.stories = stories;
    }

    private void computeFlags() {
        flags = 0;
        flags = maxReadId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (maxReadId == null) throwNullFieldException("maxReadId", flags);
            writeInt(maxReadId, stream);
        }
        writeTLVector(stories, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        maxReadId = (flags & 1) != 0 ? readInt(stream) : null;
        stories = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (maxReadId == null) throwNullFieldException("maxReadId", flags);
            size += SIZE_INT32;
        }
        size += stories.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public Integer getMaxReadId() {
        return maxReadId;
    }

    public void setMaxReadId(Integer maxReadId) {
        this.maxReadId = maxReadId;
    }

    public TLVector<TLAbsStoryItem> getStories() {
        return stories;
    }

    public void setStories(TLVector<TLAbsStoryItem> stories) {
        this.stories = stories;
    }
}
