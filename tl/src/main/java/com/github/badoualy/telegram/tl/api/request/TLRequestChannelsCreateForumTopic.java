package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestChannelsCreateForumTopic extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputChannel channel;

    protected String title;

    protected Integer iconColor;

    protected Long iconEmojiId;

    protected long randomId;

    protected TLAbsInputPeer sendAs;

    private final String _constructor = "channels.createForumTopic#0";

    public TLRequestChannelsCreateForumTopic() {
    }

    public TLRequestChannelsCreateForumTopic(TLAbsInputChannel channel, String title, Integer iconColor, Long iconEmojiId, long randomId, TLAbsInputPeer sendAs) {
        this.channel = channel;
        this.title = title;
        this.iconColor = iconColor;
        this.iconEmojiId = iconEmojiId;
        this.randomId = randomId;
        this.sendAs = sendAs;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = iconColor != null ? (flags | 1) : (flags & ~1);
        flags = iconEmojiId != null ? (flags | 8) : (flags & ~8);
        flags = sendAs != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(channel, stream);
        writeString(title, stream);
        if ((flags & 1) != 0) {
            if (iconColor == null) throwNullFieldException("iconColor", flags);
            writeInt(iconColor, stream);
        }
        if ((flags & 8) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            writeLong(iconEmojiId, stream);
        }
        writeLong(randomId, stream);
        if ((flags & 4) != 0) {
            if (sendAs == null) throwNullFieldException("sendAs", flags);
            writeTLObject(sendAs, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        title = readTLString(stream);
        iconColor = (flags & 1) != 0 ? readInt(stream) : null;
        iconEmojiId = (flags & 8) != 0 ? readLong(stream) : null;
        randomId = readLong(stream);
        sendAs = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += channel.computeSerializedSize();
        size += computeTLStringSerializedSize(title);
        if ((flags & 1) != 0) {
            if (iconColor == null) throwNullFieldException("iconColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT64;
        if ((flags & 4) != 0) {
            if (sendAs == null) throwNullFieldException("sendAs", flags);
            size += sendAs.computeSerializedSize();
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIconColor() {
        return iconColor;
    }

    public void setIconColor(Integer iconColor) {
        this.iconColor = iconColor;
    }

    public Long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(Long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public TLAbsInputPeer getSendAs() {
        return sendAs;
    }

    public void setSendAs(TLAbsInputPeer sendAs) {
        this.sendAs = sendAs;
    }
}
