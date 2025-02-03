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
public class TLUpdatePeerBlocked extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean blocked;

    protected boolean blockedMyStoriesFrom;

    protected TLAbsPeer peerId;

    private final String _constructor = "updatePeerBlocked#0";

    public TLUpdatePeerBlocked() {
    }

    public TLUpdatePeerBlocked(boolean blocked, boolean blockedMyStoriesFrom, TLAbsPeer peerId) {
        this.blocked = blocked;
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
        this.peerId = peerId;
    }

    private void computeFlags() {
        flags = 0;
        flags = blocked ? (flags | 1) : (flags & ~1);
        flags = blockedMyStoriesFrom ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peerId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blocked = (flags & 1) != 0;
        blockedMyStoriesFrom = (flags & 2) != 0;
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peerId.computeSerializedSize();
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

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getBlockedMyStoriesFrom() {
        return blockedMyStoriesFrom;
    }

    public void setBlockedMyStoriesFrom(boolean blockedMyStoriesFrom) {
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
    }

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }
}
