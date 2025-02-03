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
public class TLMessageMediaPaidMedia extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long starsAmount;

    protected TLVector<TLAbsMessageExtendedMedia> extendedMedia;

    private final String _constructor = "messageMediaPaidMedia#0";

    public TLMessageMediaPaidMedia() {
    }

    public TLMessageMediaPaidMedia(long starsAmount, TLVector<TLAbsMessageExtendedMedia> extendedMedia) {
        this.starsAmount = starsAmount;
        this.extendedMedia = extendedMedia;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(starsAmount, stream);
        writeTLVector(extendedMedia, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        starsAmount = readLong(stream);
        extendedMedia = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += extendedMedia.computeSerializedSize();
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

    public TLVector<TLAbsMessageExtendedMedia> getExtendedMedia() {
        return extendedMedia;
    }

    public void setExtendedMedia(TLVector<TLAbsMessageExtendedMedia> extendedMedia) {
        this.extendedMedia = extendedMedia;
    }
}
