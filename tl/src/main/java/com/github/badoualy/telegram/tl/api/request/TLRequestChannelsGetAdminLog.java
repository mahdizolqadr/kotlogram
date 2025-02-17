package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLChannelAdminLogEventsFilter;
import com.github.badoualy.telegram.tl.api.channels.TLAdminLogResults;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLRequestChannelsGetAdminLog extends TLMethod<TLAdminLogResults> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputChannel channel;

    protected String q;

    protected TLChannelAdminLogEventsFilter eventsFilter;

    protected TLVector<TLAbsInputUser> admins;

    protected long maxId;

    protected long minId;

    protected int limit;

    private final String _constructor = "channels.getAdminLog#0";

    public TLRequestChannelsGetAdminLog() {
    }

    public TLRequestChannelsGetAdminLog(TLAbsInputChannel channel, String q, TLChannelAdminLogEventsFilter eventsFilter, TLVector<TLAbsInputUser> admins, long maxId, long minId, int limit) {
        this.channel = channel;
        this.q = q;
        this.eventsFilter = eventsFilter;
        this.admins = admins;
        this.maxId = maxId;
        this.minId = minId;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAdminLogResults deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAdminLogResults)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAdminLogResults) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = eventsFilter != null ? (flags | 1) : (flags & ~1);
        flags = admins != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(channel, stream);
        writeString(q, stream);
        if ((flags & 1) != 0) {
            if (eventsFilter == null) throwNullFieldException("eventsFilter", flags);
            writeTLObject(eventsFilter, stream);
        }
        if ((flags & 2) != 0) {
            if (admins == null) throwNullFieldException("admins", flags);
            writeTLVector(admins, stream);
        }
        writeLong(maxId, stream);
        writeLong(minId, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        q = readTLString(stream);
        eventsFilter = (flags & 1) != 0 ? readTLObject(stream, context, TLChannelAdminLogEventsFilter.class, TLChannelAdminLogEventsFilter.CONSTRUCTOR_ID) : null;
        admins = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        maxId = readLong(stream);
        minId = readLong(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += channel.computeSerializedSize();
        size += computeTLStringSerializedSize(q);
        if ((flags & 1) != 0) {
            if (eventsFilter == null) throwNullFieldException("eventsFilter", flags);
            size += eventsFilter.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (admins == null) throwNullFieldException("admins", flags);
            size += admins.computeSerializedSize();
        }
        size += SIZE_INT64;
        size += SIZE_INT64;
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public TLChannelAdminLogEventsFilter getEventsFilter() {
        return eventsFilter;
    }

    public void setEventsFilter(TLChannelAdminLogEventsFilter eventsFilter) {
        this.eventsFilter = eventsFilter;
    }

    public TLVector<TLAbsInputUser> getAdmins() {
        return admins;
    }

    public void setAdmins(TLVector<TLAbsInputUser> admins) {
        this.admins = admins;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public long getMinId() {
        return minId;
    }

    public void setMinId(long minId) {
        this.minId = minId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
