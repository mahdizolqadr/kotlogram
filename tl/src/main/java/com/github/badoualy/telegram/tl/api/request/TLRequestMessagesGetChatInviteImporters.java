package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.messages.TLChatInviteImporters;
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
public class TLRequestMessagesGetChatInviteImporters extends TLMethod<TLChatInviteImporters> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean requested;

    protected boolean subscriptionExpired;

    protected TLAbsInputPeer peer;

    protected String link;

    protected String q;

    protected int offsetDate;

    protected TLAbsInputUser offsetUser;

    protected int limit;

    private final String _constructor = "messages.getChatInviteImporters#0";

    public TLRequestMessagesGetChatInviteImporters() {
    }

    public TLRequestMessagesGetChatInviteImporters(boolean requested, boolean subscriptionExpired, TLAbsInputPeer peer, String link, String q, int offsetDate, TLAbsInputUser offsetUser, int limit) {
        this.requested = requested;
        this.subscriptionExpired = subscriptionExpired;
        this.peer = peer;
        this.link = link;
        this.q = q;
        this.offsetDate = offsetDate;
        this.offsetUser = offsetUser;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLChatInviteImporters deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLChatInviteImporters)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLChatInviteImporters) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = requested ? (flags | 1) : (flags & ~1);
        flags = subscriptionExpired ? (flags | 8) : (flags & ~8);
        flags = link != null ? (flags | 2) : (flags & ~2);
        flags = q != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 2) != 0) {
            if (link == null) throwNullFieldException("link", flags);
            writeString(link, stream);
        }
        if ((flags & 4) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            writeString(q, stream);
        }
        writeInt(offsetDate, stream);
        writeTLObject(offsetUser, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requested = (flags & 1) != 0;
        subscriptionExpired = (flags & 8) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        link = (flags & 2) != 0 ? readTLString(stream) : null;
        q = (flags & 4) != 0 ? readTLString(stream) : null;
        offsetDate = readInt(stream);
        offsetUser = readTLObject(stream, context, TLAbsInputUser.class, -1);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (link == null) throwNullFieldException("link", flags);
            size += computeTLStringSerializedSize(link);
        }
        if ((flags & 4) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            size += computeTLStringSerializedSize(q);
        }
        size += SIZE_INT32;
        size += offsetUser.computeSerializedSize();
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

    public boolean getRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    public boolean getSubscriptionExpired() {
        return subscriptionExpired;
    }

    public void setSubscriptionExpired(boolean subscriptionExpired) {
        this.subscriptionExpired = subscriptionExpired;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int offsetDate) {
        this.offsetDate = offsetDate;
    }

    public TLAbsInputUser getOffsetUser() {
        return offsetUser;
    }

    public void setOffsetUser(TLAbsInputUser offsetUser) {
        this.offsetUser = offsetUser;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
