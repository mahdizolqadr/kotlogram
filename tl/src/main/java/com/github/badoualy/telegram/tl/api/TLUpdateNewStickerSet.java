package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet;
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
public class TLUpdateNewStickerSet extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsStickerSet stickerset;

    private final String _constructor = "updateNewStickerSet#0";

    public TLUpdateNewStickerSet() {
    }

    public TLUpdateNewStickerSet(TLAbsStickerSet stickerset) {
        this.stickerset = stickerset;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        stickerset = readTLObject(stream, context, TLAbsStickerSet.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += stickerset.computeSerializedSize();
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

    public TLAbsStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
