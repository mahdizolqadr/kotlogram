package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsReaction;
import com.github.badoualy.telegram.tl.api.messages.TLMessageReactionsList;
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
public class TLRequestMessagesGetMessageReactionsList extends TLMethod<TLMessageReactionsList> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected int id;

    protected TLAbsReaction reaction;

    protected String offset;

    protected int limit;

    private final String _constructor = "messages.getMessageReactionsList#0";

    public TLRequestMessagesGetMessageReactionsList() {
    }

    public TLRequestMessagesGetMessageReactionsList(TLAbsInputPeer peer, int id, TLAbsReaction reaction, String offset, int limit) {
        this.peer = peer;
        this.id = id;
        this.reaction = reaction;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLMessageReactionsList deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLMessageReactionsList)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLMessageReactionsList) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = reaction != null ? (flags | 1) : (flags & ~1);
        flags = offset != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            writeTLObject(reaction, stream);
        }
        if ((flags & 2) != 0) {
            if (offset == null) throwNullFieldException("offset", flags);
            writeString(offset, stream);
        }
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        id = readInt(stream);
        reaction = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsReaction.class, -1) : null;
        offset = (flags & 2) != 0 ? readTLString(stream) : null;
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (reaction == null) throwNullFieldException("reaction", flags);
            size += reaction.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (offset == null) throwNullFieldException("offset", flags);
            size += computeTLStringSerializedSize(offset);
        }
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
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
