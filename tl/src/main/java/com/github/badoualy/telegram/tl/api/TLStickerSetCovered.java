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
public class TLStickerSetCovered extends TLAbsStickerSetCovered {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsDocument cover;

    private final String _constructor = "stickerSetCovered#0";

    public TLStickerSetCovered() {
    }

    public TLStickerSetCovered(TLStickerSet set, TLAbsDocument cover) {
        this.set = set;
        this.cover = cover;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(set, stream);
        writeTLObject(cover, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        set = readTLObject(stream, context, TLStickerSet.class, TLStickerSet.CONSTRUCTOR_ID);
        cover = readTLObject(stream, context, TLAbsDocument.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += set.computeSerializedSize();
        size += cover.computeSerializedSize();
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

    public TLAbsDocument getCover() {
        return cover;
    }

    public void setCover(TLAbsDocument cover) {
        this.cover = cover;
    }
}
