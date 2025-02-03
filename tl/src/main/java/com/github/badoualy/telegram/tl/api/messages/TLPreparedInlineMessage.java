package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult;
import com.github.badoualy.telegram.tl.api.TLAbsInlineQueryPeerType;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLPreparedInlineMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long queryId;

    protected TLAbsBotInlineResult result;

    protected TLVector<TLAbsInlineQueryPeerType> peerTypes;

    protected int cacheTime;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "messages.preparedInlineMessage#0";

    public TLPreparedInlineMessage() {
    }

    public TLPreparedInlineMessage(long queryId, TLAbsBotInlineResult result, TLVector<TLAbsInlineQueryPeerType> peerTypes, int cacheTime, TLVector<TLAbsUser> users) {
        this.queryId = queryId;
        this.result = result;
        this.peerTypes = peerTypes;
        this.cacheTime = cacheTime;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(queryId, stream);
        writeTLObject(result, stream);
        writeTLVector(peerTypes, stream);
        writeInt(cacheTime, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        queryId = readLong(stream);
        result = readTLObject(stream, context, TLAbsBotInlineResult.class, -1);
        peerTypes = readTLVector(stream, context);
        cacheTime = readInt(stream);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += result.computeSerializedSize();
        size += peerTypes.computeSerializedSize();
        size += SIZE_INT32;
        size += users.computeSerializedSize();
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public TLAbsBotInlineResult getResult() {
        return result;
    }

    public void setResult(TLAbsBotInlineResult result) {
        this.result = result;
    }

    public TLVector<TLAbsInlineQueryPeerType> getPeerTypes() {
        return peerTypes;
    }

    public void setPeerTypes(TLVector<TLAbsInlineQueryPeerType> peerTypes) {
        this.peerTypes = peerTypes;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
