package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLVideoSizeStickerMarkup extends TLAbsVideoSize {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputStickerSet stickerset;

    protected long stickerId;

    protected TLIntVector backgroundColors;

    private final String _constructor = "videoSizeStickerMarkup#0";

    public TLVideoSizeStickerMarkup() {
    }

    public TLVideoSizeStickerMarkup(TLAbsInputStickerSet stickerset, long stickerId, TLIntVector backgroundColors) {
        this.stickerset = stickerset;
        this.stickerId = stickerId;
        this.backgroundColors = backgroundColors;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(stickerset, stream);
        writeLong(stickerId, stream);
        writeTLVector(backgroundColors, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        stickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
        stickerId = readLong(stream);
        backgroundColors = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += stickerset.computeSerializedSize();
        size += SIZE_INT64;
        size += backgroundColors.computeSerializedSize();
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

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }

    public long getStickerId() {
        return stickerId;
    }

    public void setStickerId(long stickerId) {
        this.stickerId = stickerId;
    }

    public TLIntVector getBackgroundColors() {
        return backgroundColors;
    }

    public void setBackgroundColors(TLIntVector backgroundColors) {
        this.backgroundColors = backgroundColors;
    }
}
