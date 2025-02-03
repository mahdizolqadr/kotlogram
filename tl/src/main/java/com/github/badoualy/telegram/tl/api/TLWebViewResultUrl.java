package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLWebViewResultUrl extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean fullsize;

    protected boolean fullscreen;

    protected Long queryId;

    protected String url;

    private final String _constructor = "webViewResultUrl#0";

    public TLWebViewResultUrl() {
    }

    public TLWebViewResultUrl(boolean fullsize, boolean fullscreen, Long queryId, String url) {
        this.fullsize = fullsize;
        this.fullscreen = fullscreen;
        this.queryId = queryId;
        this.url = url;
    }

    private void computeFlags() {
        flags = 0;
        flags = fullsize ? (flags | 2) : (flags & ~2);
        flags = fullscreen ? (flags | 4) : (flags & ~4);
        flags = queryId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (queryId == null) throwNullFieldException("queryId", flags);
            writeLong(queryId, stream);
        }
        writeString(url, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        fullsize = (flags & 2) != 0;
        fullscreen = (flags & 4) != 0;
        queryId = (flags & 1) != 0 ? readLong(stream) : null;
        url = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (queryId == null) throwNullFieldException("queryId", flags);
            size += SIZE_INT64;
        }
        size += computeTLStringSerializedSize(url);
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

    public boolean getFullsize() {
        return fullsize;
    }

    public void setFullsize(boolean fullsize) {
        this.fullsize = fullsize;
    }

    public boolean getFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public Long getQueryId() {
        return queryId;
    }

    public void setQueryId(Long queryId) {
        this.queryId = queryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
