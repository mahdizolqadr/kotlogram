package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLFileHash extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long offset;

    protected int limit;

    protected TLBytes hash;

    private final String _constructor = "fileHash#0";

    public TLFileHash() {
    }

    public TLFileHash(long offset, int limit, TLBytes hash) {
        this.offset = offset;
        this.limit = limit;
        this.hash = hash;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(offset, stream);
        writeInt(limit, stream);
        writeTLBytes(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        offset = readLong(stream);
        limit = readInt(stream);
        hash = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(hash);
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

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public TLBytes getHash() {
        return hash;
    }

    public void setHash(TLBytes hash) {
        this.hash = hash;
    }
}
