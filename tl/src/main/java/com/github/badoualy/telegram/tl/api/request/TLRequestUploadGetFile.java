package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation;
import com.github.badoualy.telegram.tl.api.upload.TLAbsFile;
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
public class TLRequestUploadGetFile extends TLMethod<TLAbsFile> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean precise;

    protected boolean cdnSupported;

    protected TLAbsInputFileLocation location;

    protected long offset;

    protected int limit;

    private final String _constructor = "upload.getFile#0";

    public TLRequestUploadGetFile() {
    }

    public TLRequestUploadGetFile(boolean precise, boolean cdnSupported, TLAbsInputFileLocation location, long offset, int limit) {
        this.precise = precise;
        this.cdnSupported = cdnSupported;
        this.location = location;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsFile deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsFile)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsFile) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = precise ? (flags | 1) : (flags & ~1);
        flags = cdnSupported ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(location, stream);
        writeLong(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        precise = (flags & 1) != 0;
        cdnSupported = (flags & 2) != 0;
        location = readTLObject(stream, context, TLAbsInputFileLocation.class, -1);
        offset = readLong(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += location.computeSerializedSize();
        size += SIZE_INT64;
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

    public boolean getPrecise() {
        return precise;
    }

    public void setPrecise(boolean precise) {
        this.precise = precise;
    }

    public boolean getCdnSupported() {
        return cdnSupported;
    }

    public void setCdnSupported(boolean cdnSupported) {
        this.cdnSupported = cdnSupported;
    }

    public TLAbsInputFileLocation getLocation() {
        return location;
    }

    public void setLocation(TLAbsInputFileLocation location) {
        this.location = location;
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
}
