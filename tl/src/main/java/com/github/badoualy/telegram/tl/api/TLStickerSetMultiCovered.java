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
public class TLStickerSetMultiCovered extends TLAbsStickerSetCovered {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsDocument> covers;

    private final String _constructor = "stickerSetMultiCovered#0";

    public TLStickerSetMultiCovered() {
    }

    public TLStickerSetMultiCovered(TLStickerSet set, TLVector<TLAbsDocument> covers) {
        this.set = set;
        this.covers = covers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(set, stream);
        writeTLVector(covers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        set = readTLObject(stream, context, TLStickerSet.class, TLStickerSet.CONSTRUCTOR_ID);
        covers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += set.computeSerializedSize();
        size += covers.computeSerializedSize();
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

    public TLStickerSet getSet() {
        return set;
    }

    public void setSet(TLStickerSet set) {
        this.set = set;
    }

    public TLVector<TLAbsDocument> getCovers() {
        return covers;
    }

    public void setCovers(TLVector<TLAbsDocument> covers) {
        this.covers = covers;
    }
}
