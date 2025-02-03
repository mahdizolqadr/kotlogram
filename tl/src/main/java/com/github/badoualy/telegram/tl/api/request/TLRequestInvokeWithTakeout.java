package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLRequestInvokeWithTakeout<T extends TLObject> extends TLMethod<T> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long takeoutId;

    protected TLMethod<T> query;

    private final String _constructor = "invokeWithTakeout#0";

    public TLRequestInvokeWithTakeout() {
    }

    public TLRequestInvokeWithTakeout(long takeoutId, TLMethod<T> query) {
        this.takeoutId = takeoutId;
        this.query = query;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return query.deserializeResponse(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(takeoutId, stream);
        writeTLMethod(query, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        takeoutId = readLong(stream);
        query = readTLMethod(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += query.computeSerializedSize();
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

    public long getTakeoutId() {
        return takeoutId;
    }

    public void setTakeoutId(long takeoutId) {
        this.takeoutId = takeoutId;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> query) {
        this.query = query;
    }
}
