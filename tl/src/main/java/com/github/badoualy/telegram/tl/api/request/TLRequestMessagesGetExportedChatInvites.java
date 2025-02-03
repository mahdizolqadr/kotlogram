package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.messages.TLExportedChatInvites;
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
public class TLRequestMessagesGetExportedChatInvites extends TLMethod<TLExportedChatInvites> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean revoked;

    protected TLAbsInputPeer peer;

    protected TLAbsInputUser adminId;

    protected Integer offsetDate;

    protected String offsetLink;

    protected int limit;

    private final String _constructor = "messages.getExportedChatInvites#0";

    public TLRequestMessagesGetExportedChatInvites() {
    }

    public TLRequestMessagesGetExportedChatInvites(boolean revoked, TLAbsInputPeer peer, TLAbsInputUser adminId, Integer offsetDate, String offsetLink, int limit) {
        this.revoked = revoked;
        this.peer = peer;
        this.adminId = adminId;
        this.offsetDate = offsetDate;
        this.offsetLink = offsetLink;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLExportedChatInvites deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLExportedChatInvites)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLExportedChatInvites) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = revoked ? (flags | 8) : (flags & ~8);
        flags = offsetDate != null ? (flags | 4) : (flags & ~4);
        flags = offsetLink != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLObject(adminId, stream);
        if ((flags & 4) != 0) {
            if (offsetDate == null) throwNullFieldException("offsetDate", flags);
            writeInt(offsetDate, stream);
        }
        if ((flags & 4) != 0) {
            if (offsetLink == null) throwNullFieldException("offsetLink", flags);
            writeString(offsetLink, stream);
        }
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revoked = (flags & 8) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        adminId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        offsetDate = (flags & 4) != 0 ? readInt(stream) : null;
        offsetLink = (flags & 4) != 0 ? readTLString(stream) : null;
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += adminId.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (offsetDate == null) throwNullFieldException("offsetDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (offsetLink == null) throwNullFieldException("offsetLink", flags);
            size += computeTLStringSerializedSize(offsetLink);
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

    public boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputUser getAdminId() {
        return adminId;
    }

    public void setAdminId(TLAbsInputUser adminId) {
        this.adminId = adminId;
    }

    public Integer getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(Integer offsetDate) {
        this.offsetDate = offsetDate;
    }

    public String getOffsetLink() {
        return offsetLink;
    }

    public void setOffsetLink(String offsetLink) {
        this.offsetLink = offsetLink;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
