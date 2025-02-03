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
public class TLMessageMediaWebPage extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean forceLargeMedia;

    protected boolean forceSmallMedia;

    protected boolean manual;

    protected boolean safe;

    protected TLAbsWebPage webpage;

    private final String _constructor = "messageMediaWebPage#0";

    public TLMessageMediaWebPage() {
    }

    public TLMessageMediaWebPage(boolean forceLargeMedia, boolean forceSmallMedia, boolean manual, boolean safe, TLAbsWebPage webpage) {
        this.forceLargeMedia = forceLargeMedia;
        this.forceSmallMedia = forceSmallMedia;
        this.manual = manual;
        this.safe = safe;
        this.webpage = webpage;
    }

    private void computeFlags() {
        flags = 0;
        flags = forceLargeMedia ? (flags | 1) : (flags & ~1);
        flags = forceSmallMedia ? (flags | 2) : (flags & ~2);
        flags = manual ? (flags | 8) : (flags & ~8);
        flags = safe ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(webpage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        forceLargeMedia = (flags & 1) != 0;
        forceSmallMedia = (flags & 2) != 0;
        manual = (flags & 8) != 0;
        safe = (flags & 16) != 0;
        webpage = readTLObject(stream, context, TLAbsWebPage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += webpage.computeSerializedSize();
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

    public boolean getManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    public boolean getSafe() {
        return safe;
    }

    public void setSafe(boolean safe) {
        this.safe = safe;
    }

    public TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(TLAbsWebPage webpage) {
        this.webpage = webpage;
    }
}
