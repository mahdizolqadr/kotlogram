package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLUpdateReadChannelUserTyping extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x8c88c923;

    protected int flags;
    protected long channelId;
    protected Integer topMsgId;
    protected TLAbsPeer fromId;
    protected TLAbsSendMessageAction action;

    private final String _constructor = "updateChannelUserTyping#8c88c923";

    public TLUpdateReadChannelUserTyping() {
    }

    public TLUpdateReadChannelUserTyping(long channelId, Integer topMsgId, TLAbsPeer fromId, TLAbsSendMessageAction action) {
        this.channelId = channelId;
        this.topMsgId = topMsgId;
        this.fromId = fromId;
        this.action = action;
    }

    protected void computeFlags() {
        flags = 0;
        flags = topMsgId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(channelId, stream);
        if ((flags & 1) != 0) {
            if (topMsgId == null) {
                throwNullFieldException("topMsgId", flags);
            }
            writeInt(topMsgId, stream);
        }
        writeTLObject(fromId, stream);
        writeTLObject(action, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channelId = readLong(stream);
        topMsgId = (flags & 1) != 0 ? readInt(stream) : null;
        fromId = readTLObject(stream, context, TLAbsPeer.class, -1);
        action = readTLObject(stream, context, TLAbsSendMessageAction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (topMsgId == null) {
                throwNullFieldException("topMsgId", flags);
            }
            size += SIZE_INT32;
        }
        size += fromId.computeSerializedSize();
        size += action.computeSerializedSize();
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

    public Integer getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(Integer topMsgId) {
        this.topMsgId = topMsgId;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public TLAbsSendMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsSendMessageAction action) {
        this.action = action;
    }
}
