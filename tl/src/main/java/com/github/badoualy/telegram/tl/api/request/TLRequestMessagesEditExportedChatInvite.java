package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.messages.TLAbsExportedChatInvite;
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
public class TLRequestMessagesEditExportedChatInvite extends TLMethod<TLAbsExportedChatInvite> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean revoked;

    protected TLAbsInputPeer peer;

    protected String link;

    protected Integer expireDate;

    protected Integer usageLimit;

    protected boolean requestNeeded;

    protected String title;

    private final String _constructor = "messages.editExportedChatInvite#0";

    public TLRequestMessagesEditExportedChatInvite() {
    }

    public TLRequestMessagesEditExportedChatInvite(boolean revoked, TLAbsInputPeer peer, String link, Integer expireDate, Integer usageLimit, boolean requestNeeded, String title) {
        this.revoked = revoked;
        this.peer = peer;
        this.link = link;
        this.expireDate = expireDate;
        this.usageLimit = usageLimit;
        this.requestNeeded = requestNeeded;
        this.title = title;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsExportedChatInvite deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsExportedChatInvite)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsExportedChatInvite) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = revoked ? (flags | 4) : (flags & ~4);
        flags = expireDate != null ? (flags | 1) : (flags & ~1);
        flags = usageLimit != null ? (flags | 2) : (flags & ~2);
        flags = requestNeeded != null ? (flags | 8) : (flags & ~8);
        flags = title != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeString(link, stream);
        if ((flags & 1) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            writeInt(expireDate, stream);
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            writeInt(usageLimit, stream);
        }
        if ((flags & 8) != 0) {
            writeBoolean(requestNeeded, stream);
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        revoked = (flags & 4) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        link = readTLString(stream);
        expireDate = (flags & 1) != 0 ? readInt(stream) : null;
        usageLimit = (flags & 2) != 0 ? readInt(stream) : null;
        requestNeeded = (flags & 8) != 0 ? readTLBool(stream) : false;
        title = (flags & 16) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += computeTLStringSerializedSize(link);
        if ((flags & 1) != 0) {
            if (expireDate == null) throwNullFieldException("expireDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) throwNullFieldException("usageLimit", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 16) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Integer expireDate) {
        this.expireDate = expireDate;
    }

    public Integer getUsageLimit() {
        return usageLimit;
    }

    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    public boolean getRequestNeeded() {
        return requestNeeded;
    }

    public void setRequestNeeded(boolean requestNeeded) {
        this.requestNeeded = requestNeeded;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
