package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLChatInviteExported;
import com.github.badoualy.telegram.tl.api.peer.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesExportChatInvite extends TLMethod<TLChatInviteExported> {

    public static final int CONSTRUCTOR_ID = 0x14b9bcd7;

    protected int flags;

    protected boolean legacyRevokePermanent;

    protected TLAbsInputPeer peer;

    protected Integer expireDate;

    protected Integer usageLimit;

    private final String _constructor = "messages.exportChatInvite#14b9bcd7";

    public TLRequestMessagesExportChatInvite() {
    }

    public TLRequestMessagesExportChatInvite(boolean legacyRevokePermanent, TLAbsInputPeer peer, Integer expireDate,
                                             Integer usageLimit) {
        this.legacyRevokePermanent = legacyRevokePermanent;
        this.peer = peer;
        this.expireDate = expireDate;
        this.usageLimit = usageLimit;
    }

    private void computeFlags() {
        flags = 0;
        flags = legacyRevokePermanent ? (flags | 4) : (flags & ~4);
        flags = expireDate != null ? (flags | 1) : (flags & ~1);
        flags = usageLimit != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public TLChatInviteExported deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLChatInviteExported)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLChatInviteExported) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (expireDate == null) {
                throwNullFieldException("expireDate", flags);
            }
            writeInt(expireDate, stream);
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) {
                throwNullFieldException("usageLimit", flags);
            }
            writeInt(usageLimit, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        legacyRevokePermanent = (flags & 4) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        expireDate = (flags & 1) != 0 ? readInt(stream) : null;
        usageLimit = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (expireDate == null) {
                throwNullFieldException("expireDate", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (usageLimit == null) {
                throwNullFieldException("usageLimit", flags);
            }
            size += SIZE_INT32;
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

    public boolean isLegacyRevokePermanent() {
        return legacyRevokePermanent;
    }

    public void setLegacyRevokePermanent(boolean legacyRevokePermanent) {
        this.legacyRevokePermanent = legacyRevokePermanent;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
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
}
