package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLMessageReplies extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean comments;

    protected int replies;

    protected int repliesPts;

    protected TLVector<TLAbsPeer> recentRepliers;

    protected Long channelId;

    protected Integer maxId;

    protected Integer readMaxId;

    private final String _constructor = "messageReplies#0";

    public TLMessageReplies() {
    }

    public TLMessageReplies(boolean comments, int replies, int repliesPts, TLVector<TLAbsPeer> recentRepliers, Long channelId, Integer maxId, Integer readMaxId) {
        this.comments = comments;
        this.replies = replies;
        this.repliesPts = repliesPts;
        this.recentRepliers = recentRepliers;
        this.channelId = channelId;
        this.maxId = maxId;
        this.readMaxId = readMaxId;
    }

    private void computeFlags() {
        flags = 0;
        flags = comments ? (flags | 1) : (flags & ~1);
        flags = recentRepliers != null ? (flags | 2) : (flags & ~2);
        flags = channelId != null ? (flags | 1) : (flags & ~1);
        flags = maxId != null ? (flags | 4) : (flags & ~4);
        flags = readMaxId != null ? (flags | 8) : (flags & ~8);

        // Following parameters might be forced to true by another field that updated the flags
        comments = (flags & 1) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(replies, stream);
        writeInt(repliesPts, stream);
        if ((flags & 2) != 0) {
            if (recentRepliers == null) throwNullFieldException("recentRepliers", flags);
            writeTLVector(recentRepliers, stream);
        }
        if ((flags & 1) != 0) {
            if (channelId == null) throwNullFieldException("channelId", flags);
            writeLong(channelId, stream);
        }
        if ((flags & 4) != 0) {
            if (maxId == null) throwNullFieldException("maxId", flags);
            writeInt(maxId, stream);
        }
        if ((flags & 8) != 0) {
            if (readMaxId == null) throwNullFieldException("readMaxId", flags);
            writeInt(readMaxId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        comments = (flags & 1) != 0;
        replies = readInt(stream);
        repliesPts = readInt(stream);
        recentRepliers = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        channelId = (flags & 1) != 0 ? readLong(stream) : null;
        maxId = (flags & 4) != 0 ? readInt(stream) : null;
        readMaxId = (flags & 8) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (recentRepliers == null) throwNullFieldException("recentRepliers", flags);
            size += recentRepliers.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (channelId == null) throwNullFieldException("channelId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 4) != 0) {
            if (maxId == null) throwNullFieldException("maxId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (readMaxId == null) throwNullFieldException("readMaxId", flags);
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

    public boolean getComments() {
        return comments;
    }

    public void setComments(boolean comments) {
        this.comments = comments;
    }

    public int getReplies() {
        return replies;
    }

    public void setReplies(int replies) {
        this.replies = replies;
    }

    public int getRepliesPts() {
        return repliesPts;
    }

    public void setRepliesPts(int repliesPts) {
        this.repliesPts = repliesPts;
    }

    public TLVector<TLAbsPeer> getRecentRepliers() {
        return recentRepliers;
    }

    public void setRecentRepliers(TLVector<TLAbsPeer> recentRepliers) {
        this.recentRepliers = recentRepliers;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Integer getMaxId() {
        return maxId;
    }

    public void setMaxId(Integer maxId) {
        this.maxId = maxId;
    }

    public Integer getReadMaxId() {
        return readMaxId;
    }

    public void setReadMaxId(Integer readMaxId) {
        this.readMaxId = readMaxId;
    }
}
