package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputMediaPaidMedia extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long starsAmount;

    protected TLVector<TLAbsInputMedia> extendedMedia;

    protected String payload;

    private final String _constructor = "inputMediaPaidMedia#0";

    public TLInputMediaPaidMedia() {
    }

    public TLInputMediaPaidMedia(long starsAmount, TLVector<TLAbsInputMedia> extendedMedia, String payload) {
        this.starsAmount = starsAmount;
        this.extendedMedia = extendedMedia;
        this.payload = payload;
    }

    private void computeFlags() {
        flags = 0;
        flags = payload != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(starsAmount, stream);
        writeTLVector(extendedMedia, stream);
        if ((flags & 1) != 0) {
            if (payload == null) throwNullFieldException("payload", flags);
            writeString(payload, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        starsAmount = readLong(stream);
        extendedMedia = readTLVector(stream, context);
        payload = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += extendedMedia.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (payload == null) throwNullFieldException("payload", flags);
            size += computeTLStringSerializedSize(payload);
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

    public long getStarsAmount() {
        return starsAmount;
    }

    public void setStarsAmount(long starsAmount) {
        this.starsAmount = starsAmount;
    }

    public TLVector<TLAbsInputMedia> getExtendedMedia() {
        return extendedMedia;
    }

    public void setExtendedMedia(TLVector<TLAbsInputMedia> extendedMedia) {
        this.extendedMedia = extendedMedia;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
