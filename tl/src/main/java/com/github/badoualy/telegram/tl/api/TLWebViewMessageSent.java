package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLWebViewMessageSent extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputBotInlineMessageID msgId;

    private final String _constructor = "webViewMessageSent#0";

    public TLWebViewMessageSent() {
    }

    public TLWebViewMessageSent(TLAbsInputBotInlineMessageID msgId) {
        this.msgId = msgId;
    }

    private void computeFlags() {
        flags = 0;
        flags = msgId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            writeTLObject(msgId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        msgId = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputBotInlineMessageID.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            size += msgId.computeSerializedSize();
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

    public TLAbsInputBotInlineMessageID getMsgId() {
        return msgId;
    }

    public void setMsgId(TLAbsInputBotInlineMessageID msgId) {
        this.msgId = msgId;
    }
}
