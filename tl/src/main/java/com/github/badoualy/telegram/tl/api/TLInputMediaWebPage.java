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
public class TLInputMediaWebPage extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean forceLargeMedia;

    protected boolean forceSmallMedia;

    protected boolean optional;

    protected String url;

    private final String _constructor = "inputMediaWebPage#0";

    public TLInputMediaWebPage() {
    }

    public TLInputMediaWebPage(boolean forceLargeMedia, boolean forceSmallMedia, boolean optional, String url) {
        this.forceLargeMedia = forceLargeMedia;
        this.forceSmallMedia = forceSmallMedia;
        this.optional = optional;
        this.url = url;
    }

    private void computeFlags() {
        flags = 0;
        flags = forceLargeMedia ? (flags | 1) : (flags & ~1);
        flags = forceSmallMedia ? (flags | 2) : (flags & ~2);
        flags = optional ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(url, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        forceLargeMedia = (flags & 1) != 0;
        forceSmallMedia = (flags & 2) != 0;
        optional = (flags & 4) != 0;
        url = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean getForceLargeMedia() {
        return forceLargeMedia;
    }

    public void setForceLargeMedia(boolean forceLargeMedia) {
        this.forceLargeMedia = forceLargeMedia;
    }

    public boolean getForceSmallMedia() {
        return forceSmallMedia;
    }

    public void setForceSmallMedia(boolean forceSmallMedia) {
        this.forceSmallMedia = forceSmallMedia;
    }

    public boolean getOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
