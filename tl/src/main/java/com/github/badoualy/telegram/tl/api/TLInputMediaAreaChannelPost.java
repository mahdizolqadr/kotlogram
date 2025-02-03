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
public class TLInputMediaAreaChannelPost extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputChannel channel;

    protected int msgId;

    private final String _constructor = "inputMediaAreaChannelPost#0";

    public TLInputMediaAreaChannelPost() {
    }

    public TLInputMediaAreaChannelPost(TLMediaAreaCoordinates coordinates, TLAbsInputChannel channel, int msgId) {
        this.coordinates = coordinates;
        this.channel = channel;
        this.msgId = msgId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(coordinates, stream);
        writeTLObject(channel, stream);
        writeInt(msgId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        msgId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += coordinates.computeSerializedSize();
        size += channel.computeSerializedSize();
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
}
