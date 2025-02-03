package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLInputGroupCall;
import com.github.badoualy.telegram.tl.api.phone.TLGroupParticipants;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLRequestPhoneGetGroupParticipants extends TLMethod<TLGroupParticipants> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputGroupCall call;

    protected TLVector<TLAbsInputPeer> ids;

    protected TLIntVector sources;

    protected String offset;

    protected int limit;

    private final String _constructor = "phone.getGroupParticipants#0";

    public TLRequestPhoneGetGroupParticipants() {
    }

    public TLRequestPhoneGetGroupParticipants(TLInputGroupCall call, TLVector<TLAbsInputPeer> ids, TLIntVector sources, String offset, int limit) {
        this.call = call;
        this.ids = ids;
        this.sources = sources;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLGroupParticipants deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLGroupParticipants)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLGroupParticipants) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(call, stream);
        writeTLVector(ids, stream);
        writeTLVector(sources, stream);
        writeString(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        call = readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID);
        ids = readTLVector(stream, context);
        sources = readTLIntVector(stream, context);
        offset = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += call.computeSerializedSize();
        size += ids.computeSerializedSize();
        size += sources.computeSerializedSize();
        size += computeTLStringSerializedSize(offset);
        size += SIZE_INT32;
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

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public TLVector<TLAbsInputPeer> getIds() {
        return ids;
    }

    public void setIds(TLVector<TLAbsInputPeer> ids) {
        this.ids = ids;
    }

    public TLIntVector getSources() {
        return sources;
    }

    public void setSources(TLIntVector sources) {
        this.sources = sources;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
