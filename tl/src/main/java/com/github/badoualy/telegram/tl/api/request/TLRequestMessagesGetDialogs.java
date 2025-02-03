package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
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
public class TLRequestMessagesGetDialogs extends TLMethod<TLAbsDialogs> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean excludePinned;

    protected Integer folderId;

    protected int offsetDate;

    protected int offsetId;

    protected TLAbsInputPeer offsetPeer;

    protected int limit;

    protected long hash;

    private final String _constructor = "messages.getDialogs#0";

    public TLRequestMessagesGetDialogs() {
    }

    public TLRequestMessagesGetDialogs(boolean excludePinned, Integer folderId, int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit, long hash) {
        this.excludePinned = excludePinned;
        this.folderId = folderId;
        this.offsetDate = offsetDate;
        this.offsetId = offsetId;
        this.offsetPeer = offsetPeer;
        this.limit = limit;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsDialogs deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDialogs)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsDialogs) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = excludePinned ? (flags | 1) : (flags & ~1);
        flags = folderId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        writeInt(offsetDate, stream);
        writeInt(offsetId, stream);
        writeTLObject(offsetPeer, stream);
        writeInt(limit, stream);
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        excludePinned = (flags & 1) != 0;
        folderId = (flags & 2) != 0 ? readInt(stream) : null;
        offsetDate = readInt(stream);
        offsetId = readInt(stream);
        offsetPeer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        limit = readInt(stream);
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += offsetPeer.computeSerializedSize();
        size += SIZE_INT32;
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

    public boolean getExcludePinned() {
        return excludePinned;
    }

    public void setExcludePinned(boolean excludePinned) {
        this.excludePinned = excludePinned;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int offsetDate) {
        this.offsetDate = offsetDate;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public TLAbsInputPeer getOffsetPeer() {
        return offsetPeer;
    }

    public void setOffsetPeer(TLAbsInputPeer offsetPeer) {
        this.offsetPeer = offsetPeer;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
