package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
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
public class TLRequestMessagesSearchGlobal extends TLMethod<TLAbsMessages> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean broadcastsOnly;

    protected boolean groupsOnly;

    protected boolean usersOnly;

    protected Integer folderId;

    protected String q;

    protected TLAbsMessagesFilter filter;

    protected int minDate;

    protected int maxDate;

    protected int offsetRate;

    protected TLAbsInputPeer offsetPeer;

    protected int offsetId;

    protected int limit;

    private final String _constructor = "messages.searchGlobal#0";

    public TLRequestMessagesSearchGlobal() {
    }

    public TLRequestMessagesSearchGlobal(boolean broadcastsOnly, boolean groupsOnly, boolean usersOnly, Integer folderId, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offsetRate, TLAbsInputPeer offsetPeer, int offsetId, int limit) {
        this.broadcastsOnly = broadcastsOnly;
        this.groupsOnly = groupsOnly;
        this.usersOnly = usersOnly;
        this.folderId = folderId;
        this.q = q;
        this.filter = filter;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.offsetRate = offsetRate;
        this.offsetPeer = offsetPeer;
        this.offsetId = offsetId;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsMessages)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsMessages) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = broadcastsOnly ? (flags | 2) : (flags & ~2);
        flags = groupsOnly ? (flags | 4) : (flags & ~4);
        flags = usersOnly ? (flags | 8) : (flags & ~8);
        flags = folderId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        writeString(q, stream);
        writeTLObject(filter, stream);
        writeInt(minDate, stream);
        writeInt(maxDate, stream);
        writeInt(offsetRate, stream);
        writeTLObject(offsetPeer, stream);
        writeInt(offsetId, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        broadcastsOnly = (flags & 2) != 0;
        groupsOnly = (flags & 4) != 0;
        usersOnly = (flags & 8) != 0;
        folderId = (flags & 1) != 0 ? readInt(stream) : null;
        q = readTLString(stream);
        filter = readTLObject(stream, context, TLAbsMessagesFilter.class, -1);
        minDate = readInt(stream);
        maxDate = readInt(stream);
        offsetRate = readInt(stream);
        offsetPeer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        offsetId = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        size += computeTLStringSerializedSize(q);
        size += filter.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += offsetPeer.computeSerializedSize();
        size += SIZE_INT32;
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

    public boolean getBroadcastsOnly() {
        return broadcastsOnly;
    }

    public void setBroadcastsOnly(boolean broadcastsOnly) {
        this.broadcastsOnly = broadcastsOnly;
    }

    public boolean getGroupsOnly() {
        return groupsOnly;
    }

    public void setGroupsOnly(boolean groupsOnly) {
        this.groupsOnly = groupsOnly;
    }

    public boolean getUsersOnly() {
        return usersOnly;
    }

    public void setUsersOnly(boolean usersOnly) {
        this.usersOnly = usersOnly;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsMessagesFilter filter) {
        this.filter = filter;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int minDate) {
        this.minDate = minDate;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int maxDate) {
        this.maxDate = maxDate;
    }

    public int getOffsetRate() {
        return offsetRate;
    }

    public void setOffsetRate(int offsetRate) {
        this.offsetRate = offsetRate;
    }

    public TLAbsInputPeer getOffsetPeer() {
        return offsetPeer;
    }

    public void setOffsetPeer(TLAbsInputPeer offsetPeer) {
        this.offsetPeer = offsetPeer;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
