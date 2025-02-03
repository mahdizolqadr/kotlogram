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
public class TLUpdateBotInlineSend extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long userId;

    protected String query;

    protected TLAbsGeoPoint geo;

    protected String id;

    protected TLAbsInputBotInlineMessageID msgId;

    private final String _constructor = "updateBotInlineSend#0";

    public TLUpdateBotInlineSend() {
    }

    public TLUpdateBotInlineSend(long userId, String query, TLAbsGeoPoint geo, String id, TLAbsInputBotInlineMessageID msgId) {
        this.userId = userId;
        this.query = query;
        this.geo = geo;
        this.id = id;
        this.msgId = msgId;
    }

    private void computeFlags() {
        flags = 0;
        flags = geo != null ? (flags | 1) : (flags & ~1);
        flags = msgId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeString(query, stream);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            writeTLObject(geo, stream);
        }
        writeString(id, stream);
        if ((flags & 2) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            writeTLObject(msgId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = readLong(stream);
        query = readTLString(stream);
        geo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsGeoPoint.class, -1) : null;
        id = readTLString(stream);
        msgId = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputBotInlineMessageID.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(query);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            size += geo.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(id);
        if ((flags & 2) != 0) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLAbsInputBotInlineMessageID getMsgId() {
        return msgId;
    }

    public void setMsgId(TLAbsInputBotInlineMessageID msgId) {
        this.msgId = msgId;
    }
}
