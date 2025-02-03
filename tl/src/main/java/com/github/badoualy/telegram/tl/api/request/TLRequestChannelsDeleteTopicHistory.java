package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory;
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
public class TLRequestChannelsDeleteTopicHistory extends TLMethod<TLAffectedHistory> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputChannel channel;

    protected int topMsgId;

    private final String _constructor = "channels.deleteTopicHistory#0";

    public TLRequestChannelsDeleteTopicHistory() {
    }

    public TLRequestChannelsDeleteTopicHistory(TLAbsInputChannel channel, int topMsgId) {
        this.channel = channel;
        this.topMsgId = topMsgId;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeInt(topMsgId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        topMsgId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public int getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(int topMsgId) {
        this.topMsgId = topMsgId;
    }
}
