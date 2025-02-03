package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLWebPageNotModified extends TLAbsWebPage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected Integer cachedPageViews;

    private final String _constructor = "webPageNotModified#0";

    public TLWebPageNotModified() {
    }

    public TLWebPageNotModified(Integer cachedPageViews) {
        this.cachedPageViews = cachedPageViews;
    }

    private void computeFlags() {
        flags = 0;
        flags = cachedPageViews != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (cachedPageViews == null) throwNullFieldException("cachedPageViews", flags);
            writeInt(cachedPageViews, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        cachedPageViews = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (cachedPageViews == null) throwNullFieldException("cachedPageViews", flags);
            size += SIZE_INT32;
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

    public Integer getCachedPageViews() {
        return cachedPageViews;
    }

    public void setCachedPageViews(Integer cachedPageViews) {
        this.cachedPageViews = cachedPageViews;
    }
}
