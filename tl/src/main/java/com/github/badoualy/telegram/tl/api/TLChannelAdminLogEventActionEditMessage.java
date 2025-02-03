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
public class TLChannelAdminLogEventActionEditMessage extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsMessage prevMessage;

    protected TLAbsMessage newMessage;

    private final String _constructor = "channelAdminLogEventActionEditMessage#0";

    public TLChannelAdminLogEventActionEditMessage() {
    }

    public TLChannelAdminLogEventActionEditMessage(TLAbsMessage prevMessage, TLAbsMessage newMessage) {
        this.prevMessage = prevMessage;
        this.newMessage = newMessage;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevMessage, stream);
        writeTLObject(newMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevMessage = readTLObject(stream, context, TLAbsMessage.class, -1);
        newMessage = readTLObject(stream, context, TLAbsMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevMessage.computeSerializedSize();
        size += newMessage.computeSerializedSize();
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

    public TLAbsMessage getPrevMessage() {
        return prevMessage;
    }

    public void setPrevMessage(TLAbsMessage prevMessage) {
        this.prevMessage = prevMessage;
    }

    public TLAbsMessage getNewMessage() {
        return newMessage;
    }

    public void setNewMessage(TLAbsMessage newMessage) {
        this.newMessage = newMessage;
    }
}
