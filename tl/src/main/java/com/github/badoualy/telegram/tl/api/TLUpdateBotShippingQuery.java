package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLUpdateBotShippingQuery extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long queryId;

    protected long userId;

    protected TLBytes payload;

    protected TLPostAddress shippingAddress;

    private final String _constructor = "updateBotShippingQuery#0";

    public TLUpdateBotShippingQuery() {
    }

    public TLUpdateBotShippingQuery(long queryId, long userId, TLBytes payload, TLPostAddress shippingAddress) {
        this.queryId = queryId;
        this.userId = userId;
        this.payload = payload;
        this.shippingAddress = shippingAddress;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(queryId, stream);
        writeLong(userId, stream);
        writeTLBytes(payload, stream);
        writeTLObject(shippingAddress, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        queryId = readLong(stream);
        userId = readLong(stream);
        payload = readTLBytes(stream, context);
        shippingAddress = readTLObject(stream, context, TLPostAddress.class, TLPostAddress.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(payload);
        size += shippingAddress.computeSerializedSize();
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TLBytes getPayload() {
        return payload;
    }

    public void setPayload(TLBytes payload) {
        this.payload = payload;
    }

    public TLPostAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(TLPostAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }
}
