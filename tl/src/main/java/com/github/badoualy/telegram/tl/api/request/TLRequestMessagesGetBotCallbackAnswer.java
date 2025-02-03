package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.messages.TLBotCallbackAnswer;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLRequestMessagesGetBotCallbackAnswer extends TLMethod<TLBotCallbackAnswer> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean game;

    protected TLAbsInputPeer peer;

    protected int msgId;

    protected TLBytes data;

    protected TLAbsInputCheckPasswordSRP password;

    private final String _constructor = "messages.getBotCallbackAnswer#0";

    public TLRequestMessagesGetBotCallbackAnswer() {
    }

    public TLRequestMessagesGetBotCallbackAnswer(boolean game, TLAbsInputPeer peer, int msgId, TLBytes data, TLAbsInputCheckPasswordSRP password) {
        this.game = game;
        this.peer = peer;
        this.msgId = msgId;
        this.data = data;
        this.password = password;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBotCallbackAnswer deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBotCallbackAnswer)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBotCallbackAnswer) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = game ? (flags | 2) : (flags & ~2);
        flags = data != null ? (flags | 1) : (flags & ~1);
        flags = password != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(msgId, stream);
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            writeTLBytes(data, stream);
        }
        if ((flags & 4) != 0) {
            if (password == null) throwNullFieldException("password", flags);
            writeTLObject(password, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        game = (flags & 2) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        msgId = readInt(stream);
        data = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        password = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputCheckPasswordSRP.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            size += computeTLBytesSerializedSize(data);
        }
        if ((flags & 4) != 0) {
            if (password == null) throwNullFieldException("password", flags);
            size += password.computeSerializedSize();
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

    public boolean getGame() {
        return game;
    }

    public void setGame(boolean game) {
        this.game = game;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }

    public TLAbsInputCheckPasswordSRP getPassword() {
        return password;
    }

    public void setPassword(TLAbsInputCheckPasswordSRP password) {
        this.password = password;
    }
}
