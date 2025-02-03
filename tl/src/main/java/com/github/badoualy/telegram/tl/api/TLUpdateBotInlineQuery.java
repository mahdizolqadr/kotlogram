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
public class TLUpdateBotInlineQuery extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long queryId;

    protected long userId;

    protected String query;

    protected TLAbsGeoPoint geo;

    protected TLAbsInlineQueryPeerType peerType;

    protected String offset;

    private final String _constructor = "updateBotInlineQuery#0";

    public TLUpdateBotInlineQuery() {
    }

    public TLUpdateBotInlineQuery(long queryId, long userId, String query, TLAbsGeoPoint geo, TLAbsInlineQueryPeerType peerType, String offset) {
        this.queryId = queryId;
        this.userId = userId;
        this.query = query;
        this.geo = geo;
        this.peerType = peerType;
        this.offset = offset;
    }

    private void computeFlags() {
        flags = 0;
        flags = geo != null ? (flags | 1) : (flags & ~1);
        flags = peerType != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeLong(userId, stream);
        writeString(query, stream);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            writeTLObject(geo, stream);
        }
        if ((flags & 2) != 0) {
            if (peerType == null) throwNullFieldException("peerType", flags);
            writeTLObject(peerType, stream);
        }
        writeString(offset, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readLong(stream);
        query = readTLString(stream);
        geo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsGeoPoint.class, -1) : null;
        peerType = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInlineQueryPeerType.class, -1) : null;
        offset = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(query);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            size += geo.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (peerType == null) throwNullFieldException("peerType", flags);
            size += peerType.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(offset);
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

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public TLAbsInlineQueryPeerType getPeerType() {
        return peerType;
    }

    public void setPeerType(TLAbsInlineQueryPeerType peerType) {
        this.peerType = peerType;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
