package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.api.TLStickerPack;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLRecentStickers extends TLAbsRecentStickers {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long hash;

    protected TLVector<TLStickerPack> packs;

    protected TLVector<TLAbsDocument> stickers;

    protected TLIntVector dates;

    private final String _constructor = "messages.recentStickers#0";

    public TLRecentStickers() {
    }

    public TLRecentStickers(long hash, TLVector<TLStickerPack> packs, TLVector<TLAbsDocument> stickers, TLIntVector dates) {
        this.hash = hash;
        this.packs = packs;
        this.stickers = stickers;
        this.dates = dates;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(hash, stream);
        writeTLVector(packs, stream);
        writeTLVector(stickers, stream);
        writeTLVector(dates, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readLong(stream);
        packs = readTLVector(stream, context);
        stickers = readTLVector(stream, context);
        dates = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += packs.computeSerializedSize();
        size += stickers.computeSerializedSize();
        size += dates.computeSerializedSize();
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

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public TLVector<TLStickerPack> getPacks() {
        return packs;
    }

    public void setPacks(TLVector<TLStickerPack> packs) {
        this.packs = packs;
    }

    public TLVector<TLAbsDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsDocument> stickers) {
        this.stickers = stickers;
    }

    public TLIntVector getDates() {
        return dates;
    }

    public void setDates(TLIntVector dates) {
        this.dates = dates;
    }
}
