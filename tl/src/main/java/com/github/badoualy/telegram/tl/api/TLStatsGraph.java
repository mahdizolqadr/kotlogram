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
public class TLStatsGraph extends TLAbsStatsGraph {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLDataJSON json;

    protected String zoomToken;

    private final String _constructor = "statsGraph#0";

    public TLStatsGraph() {
    }

    public TLStatsGraph(TLDataJSON json, String zoomToken) {
        this.json = json;
        this.zoomToken = zoomToken;
    }

    private void computeFlags() {
        flags = 0;
        flags = zoomToken != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(json, stream);
        if ((flags & 1) != 0) {
            if (zoomToken == null) throwNullFieldException("zoomToken", flags);
            writeString(zoomToken, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        json = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
        zoomToken = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += json.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (zoomToken == null) throwNullFieldException("zoomToken", flags);
            size += computeTLStringSerializedSize(zoomToken);
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

    public TLDataJSON getJson() {
        return json;
    }

    public void setJson(TLDataJSON json) {
        this.json = json;
    }

    public String getZoomToken() {
        return zoomToken;
    }

    public void setZoomToken(String zoomToken) {
        this.zoomToken = zoomToken;
    }
}
