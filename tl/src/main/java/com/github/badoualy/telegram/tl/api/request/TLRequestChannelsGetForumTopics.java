package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.messages.TLForumTopics;
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
public class TLRequestChannelsGetForumTopics extends TLMethod<TLForumTopics> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputChannel channel;

    protected String q;

    protected int offsetDate;

    protected int offsetId;

    protected int offsetTopic;

    protected int limit;

    private final String _constructor = "channels.getForumTopics#0";

    public TLRequestChannelsGetForumTopics() {
    }

    public TLRequestChannelsGetForumTopics(TLAbsInputChannel channel, String q, int offsetDate, int offsetId, int offsetTopic, int limit) {
        this.channel = channel;
        this.q = q;
        this.offsetDate = offsetDate;
        this.offsetId = offsetId;
        this.offsetTopic = offsetTopic;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLForumTopics deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLForumTopics)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLForumTopics) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = q != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(channel, stream);
        if ((flags & 1) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            writeString(q, stream);
        }
        writeInt(offsetDate, stream);
        writeInt(offsetId, stream);
        writeInt(offsetTopic, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        q = (flags & 1) != 0 ? readTLString(stream) : null;
        offsetDate = readInt(stream);
        offsetId = readInt(stream);
        offsetTopic = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += channel.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            size += computeTLStringSerializedSize(q);
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getOffsetTopic() {
        return offsetTopic;
    }

    public void setOffsetTopic(int offsetTopic) {
        this.offsetTopic = offsetTopic;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
