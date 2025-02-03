package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.stories.TLStoryViewsList;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestStoriesGetStoryViewsList extends TLMethod<TLStoryViewsList> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean justContacts;

    protected boolean reactionsFirst;

    protected boolean forwardsFirst;

    protected TLAbsInputPeer peer;

    protected String q;

    protected int id;

    protected String offset;

    protected int limit;

    private final String _constructor = "stories.getStoryViewsList#0";

    public TLRequestStoriesGetStoryViewsList() {
    }

    public TLRequestStoriesGetStoryViewsList(boolean justContacts, boolean reactionsFirst, boolean forwardsFirst, TLAbsInputPeer peer, String q, int id, String offset, int limit) {
        this.justContacts = justContacts;
        this.reactionsFirst = reactionsFirst;
        this.forwardsFirst = forwardsFirst;
        this.peer = peer;
        this.q = q;
        this.id = id;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLStoryViewsList deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLStoryViewsList)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLStoryViewsList) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = justContacts ? (flags | 1) : (flags & ~1);
        flags = reactionsFirst ? (flags | 4) : (flags & ~4);
        flags = forwardsFirst ? (flags | 8) : (flags & ~8);
        flags = q != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 2) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            writeString(q, stream);
        }
        writeInt(id, stream);
        writeString(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        justContacts = (flags & 1) != 0;
        reactionsFirst = (flags & 4) != 0;
        forwardsFirst = (flags & 8) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        q = (flags & 2) != 0 ? readTLString(stream) : null;
        id = readInt(stream);
        offset = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            size += computeTLStringSerializedSize(q);
        }
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(offset);
        size += SIZE_INT32;
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

    public boolean getJustContacts() {
        return justContacts;
    }

    public void setJustContacts(boolean justContacts) {
        this.justContacts = justContacts;
    }

    public boolean getReactionsFirst() {
        return reactionsFirst;
    }

    public void setReactionsFirst(boolean reactionsFirst) {
        this.reactionsFirst = reactionsFirst;
    }

    public boolean getForwardsFirst() {
        return forwardsFirst;
    }

    public void setForwardsFirst(boolean forwardsFirst) {
        this.forwardsFirst = forwardsFirst;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
