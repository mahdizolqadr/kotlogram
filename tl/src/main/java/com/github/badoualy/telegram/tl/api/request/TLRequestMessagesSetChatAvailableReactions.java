package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChatReactions;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestMessagesSetChatAvailableReactions extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected TLAbsChatReactions availableReactions;

    protected Integer reactionsLimit;

    protected boolean paidEnabled;

    private final String _constructor = "messages.setChatAvailableReactions#0";

    public TLRequestMessagesSetChatAvailableReactions() {
    }

    public TLRequestMessagesSetChatAvailableReactions(TLAbsInputPeer peer, TLAbsChatReactions availableReactions, Integer reactionsLimit, boolean paidEnabled) {
        this.peer = peer;
        this.availableReactions = availableReactions;
        this.reactionsLimit = reactionsLimit;
        this.paidEnabled = paidEnabled;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = reactionsLimit != null ? (flags | 1) : (flags & ~1);
        flags = paidEnabled != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLObject(availableReactions, stream);
        if ((flags & 1) != 0) {
            if (reactionsLimit == null) throwNullFieldException("reactionsLimit", flags);
            writeInt(reactionsLimit, stream);
        }
        if ((flags & 2) != 0) {
            writeBoolean(paidEnabled, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        availableReactions = readTLObject(stream, context, TLAbsChatReactions.class, -1);
        reactionsLimit = (flags & 1) != 0 ? readInt(stream) : null;
        paidEnabled = (flags & 2) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += availableReactions.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (reactionsLimit == null) throwNullFieldException("reactionsLimit", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            size += SIZE_BOOLEAN;
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsChatReactions getAvailableReactions() {
        return availableReactions;
    }

    public void setAvailableReactions(TLAbsChatReactions availableReactions) {
        this.availableReactions = availableReactions;
    }

    public Integer getReactionsLimit() {
        return reactionsLimit;
    }

    public void setReactionsLimit(Integer reactionsLimit) {
        this.reactionsLimit = reactionsLimit;
    }

    public boolean getPaidEnabled() {
        return paidEnabled;
    }

    public void setPaidEnabled(boolean paidEnabled) {
        this.paidEnabled = paidEnabled;
    }
}
