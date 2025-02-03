package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputReplyTo;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestMessagesProlongWebView extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean silent;

    protected TLAbsInputPeer peer;

    protected TLAbsInputUser bot;

    protected long queryId;

    protected TLAbsInputReplyTo replyTo;

    protected TLAbsInputPeer sendAs;

    private final String _constructor = "messages.prolongWebView#0";

    public TLRequestMessagesProlongWebView() {
    }

    public TLRequestMessagesProlongWebView(boolean silent, TLAbsInputPeer peer, TLAbsInputUser bot, long queryId, TLAbsInputReplyTo replyTo, TLAbsInputPeer sendAs) {
        this.silent = silent;
        this.peer = peer;
        this.bot = bot;
        this.queryId = queryId;
        this.replyTo = replyTo;
        this.sendAs = sendAs;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = silent ? (flags | 32) : (flags & ~32);
        flags = replyTo != null ? (flags | 1) : (flags & ~1);
        flags = sendAs != null ? (flags | 8192) : (flags & ~8192);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLObject(bot, stream);
        writeLong(queryId, stream);
        if ((flags & 1) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            writeTLObject(replyTo, stream);
        }
        if ((flags & 8192) != 0) {
            if (sendAs == null) throwNullFieldException("sendAs", flags);
            writeTLObject(sendAs, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        silent = (flags & 32) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        queryId = readLong(stream);
        replyTo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputReplyTo.class, -1) : null;
        sendAs = (flags & 8192) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += bot.computeSerializedSize();
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (replyTo == null) throwNullFieldException("replyTo", flags);
            size += replyTo.computeSerializedSize();
        }
        if ((flags & 8192) != 0) {
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

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public TLAbsInputReplyTo getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(TLAbsInputReplyTo replyTo) {
        this.replyTo = replyTo;
    }

    public TLAbsInputPeer getSendAs() {
        return sendAs;
    }

    public void setSendAs(TLAbsInputPeer sendAs) {
        this.sendAs = sendAs;
    }
}
