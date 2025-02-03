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
public class TLUpdateGroupCall extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long chatId;

    protected TLAbsGroupCall call;

    private final String _constructor = "updateGroupCall#0";

    public TLUpdateGroupCall() {
    }

    public TLUpdateGroupCall(long chatId, TLAbsGroupCall call) {
        this.chatId = chatId;
        this.call = call;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(chatId, stream);
        writeTLObject(call, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readLong(stream);
        call = readTLObject(stream, context, TLAbsGroupCall.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += call.computeSerializedSize();
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

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public TLAbsGroupCall getCall() {
        return call;
    }

    public void setCall(TLAbsGroupCall call) {
        this.call = call;
    }
}
