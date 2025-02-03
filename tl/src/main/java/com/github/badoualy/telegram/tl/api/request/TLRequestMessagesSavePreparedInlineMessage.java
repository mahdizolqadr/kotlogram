package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInlineQueryPeerType;
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineResult;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.messages.TLBotPreparedInlineMessage;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLRequestMessagesSavePreparedInlineMessage extends TLMethod<TLBotPreparedInlineMessage> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputBotInlineResult result;

    protected TLAbsInputUser userId;

    protected TLVector<TLAbsInlineQueryPeerType> peerTypes;

    private final String _constructor = "messages.savePreparedInlineMessage#0";

    public TLRequestMessagesSavePreparedInlineMessage() {
    }

    public TLRequestMessagesSavePreparedInlineMessage(TLAbsInputBotInlineResult result, TLAbsInputUser userId, TLVector<TLAbsInlineQueryPeerType> peerTypes) {
        this.result = result;
        this.userId = userId;
        this.peerTypes = peerTypes;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBotPreparedInlineMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBotPreparedInlineMessage)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBotPreparedInlineMessage) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = peerTypes != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(result, stream);
        writeTLObject(userId, stream);
        if ((flags & 1) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            writeTLVector(peerTypes, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        result = readTLObject(stream, context, TLAbsInputBotInlineResult.class, -1);
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        peerTypes = (flags & 1) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += result.computeSerializedSize();
        size += userId.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            size += peerTypes.computeSerializedSize();
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

    public TLAbsInputBotInlineResult getResult() {
        return result;
    }

    public void setResult(TLAbsInputBotInlineResult result) {
        this.result = result;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public TLVector<TLAbsInlineQueryPeerType> getPeerTypes() {
        return peerTypes;
    }

    public void setPeerTypes(TLVector<TLAbsInlineQueryPeerType> peerTypes) {
        this.peerTypes = peerTypes;
    }
}
