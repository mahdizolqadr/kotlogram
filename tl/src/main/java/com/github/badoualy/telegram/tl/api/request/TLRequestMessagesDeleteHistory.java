package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory;
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
public class TLRequestMessagesDeleteHistory extends TLMethod<TLAffectedHistory> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean justClear;

    protected boolean revoke;

    protected TLAbsInputPeer peer;

    protected int maxId;

    protected Integer minDate;

    protected Integer maxDate;

    private final String _constructor = "messages.deleteHistory#0";

    public TLRequestMessagesDeleteHistory() {
    }

    public TLRequestMessagesDeleteHistory(boolean justClear, boolean revoke, TLAbsInputPeer peer, int maxId, Integer minDate, Integer maxDate) {
        this.justClear = justClear;
        this.revoke = revoke;
        this.peer = peer;
        this.maxId = maxId;
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAffectedHistory deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAffectedHistory)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAffectedHistory) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = justClear ? (flags | 1) : (flags & ~1);
        flags = revoke ? (flags | 2) : (flags & ~2);
        flags = minDate != null ? (flags | 4) : (flags & ~4);
        flags = maxDate != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(maxId, stream);
        if ((flags & 4) != 0) {
            if (minDate == null) throwNullFieldException("minDate", flags);
            writeInt(minDate, stream);
        }
        if ((flags & 8) != 0) {
            if (maxDate == null) throwNullFieldException("maxDate", flags);
            writeInt(maxDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        justClear = (flags & 1) != 0;
        revoke = (flags & 2) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        maxId = readInt(stream);
        minDate = (flags & 4) != 0 ? readInt(stream) : null;
        maxDate = (flags & 8) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (minDate == null) throwNullFieldException("minDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (maxDate == null) throwNullFieldException("maxDate", flags);
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

    public boolean getJustClear() {
        return justClear;
    }

    public void setJustClear(boolean justClear) {
        this.justClear = justClear;
    }

    public boolean getRevoke() {
        return revoke;
    }

    public void setRevoke(boolean revoke) {
        this.revoke = revoke;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public Integer getMinDate() {
        return minDate;
    }

    public void setMinDate(Integer minDate) {
        this.minDate = minDate;
    }

    public Integer getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(Integer maxDate) {
        this.maxDate = maxDate;
    }
}
