package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateReadChannelDiscussionInbox extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long channelId;

    protected int topMsgId;

    protected int readMaxId;

    protected Long broadcastId;

    protected Integer broadcastPost;

    private final String _constructor = "updateReadChannelDiscussionInbox#0";

    public TLUpdateReadChannelDiscussionInbox() {
    }

    public TLUpdateReadChannelDiscussionInbox(long channelId, int topMsgId, int readMaxId, Long broadcastId, Integer broadcastPost) {
        this.channelId = channelId;
        this.topMsgId = topMsgId;
        this.readMaxId = readMaxId;
        this.broadcastId = broadcastId;
        this.broadcastPost = broadcastPost;
    }

    private void computeFlags() {
        flags = 0;
        flags = broadcastId != null ? (flags | 1) : (flags & ~1);
        flags = broadcastPost != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(channelId, stream);
        writeInt(topMsgId, stream);
        writeInt(readMaxId, stream);
        if ((flags & 1) != 0) {
            if (broadcastId == null) throwNullFieldException("broadcastId", flags);
            writeLong(broadcastId, stream);
        }
        if ((flags & 1) != 0) {
            if (broadcastPost == null) throwNullFieldException("broadcastPost", flags);
            writeInt(broadcastPost, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channelId = readLong(stream);
        topMsgId = readInt(stream);
        readMaxId = readInt(stream);
        broadcastId = (flags & 1) != 0 ? readLong(stream) : null;
        broadcastPost = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (broadcastId == null) throwNullFieldException("broadcastId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 1) != 0) {
            if (broadcastPost == null) throwNullFieldException("broadcastPost", flags);
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

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public int getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(int topMsgId) {
        this.topMsgId = topMsgId;
    }

    public int getReadMaxId() {
        return readMaxId;
    }

    public void setReadMaxId(int readMaxId) {
        this.readMaxId = readMaxId;
    }

    public Long getBroadcastId() {
        return broadcastId;
    }

    public void setBroadcastId(Long broadcastId) {
        this.broadcastId = broadcastId;
    }

    public Integer getBroadcastPost() {
        return broadcastPost;
    }

    public void setBroadcastPost(Integer broadcastPost) {
        this.broadcastPost = broadcastPost;
    }
}
