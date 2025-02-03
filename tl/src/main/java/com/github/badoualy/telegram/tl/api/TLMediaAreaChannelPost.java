package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLMediaAreaChannelPost extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long channelId;

    protected int msgId;

    private final String _constructor = "mediaAreaChannelPost#0";

    public TLMediaAreaChannelPost() {
    }

    public TLMediaAreaChannelPost(TLMediaAreaCoordinates coordinates, long channelId, int msgId) {
        this.coordinates = coordinates;
        this.channelId = channelId;
        this.msgId = msgId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(coordinates, stream);
        writeLong(channelId, stream);
        writeInt(msgId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        channelId = readLong(stream);
        msgId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += coordinates.computeSerializedSize();
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

    public TLMediaAreaCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(TLMediaAreaCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
