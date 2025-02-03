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
public class TLWebPageAttributeStickerSet extends TLAbsWebPageAttribute {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean emojis;

    protected boolean textColor;

    protected TLVector<TLAbsDocument> stickers;

    private final String _constructor = "webPageAttributeStickerSet#0";

    public TLWebPageAttributeStickerSet() {
    }

    public TLWebPageAttributeStickerSet(boolean emojis, boolean textColor, TLVector<TLAbsDocument> stickers) {
        this.emojis = emojis;
        this.textColor = textColor;
        this.stickers = stickers;
    }

    private void computeFlags() {
        flags = 0;
        flags = emojis ? (flags | 1) : (flags & ~1);
        flags = textColor ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(stickers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        emojis = (flags & 1) != 0;
        textColor = (flags & 2) != 0;
        stickers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += stickers.computeSerializedSize();
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

    public boolean getEmojis() {
        return emojis;
    }

    public void setEmojis(boolean emojis) {
        this.emojis = emojis;
    }

    public boolean getTextColor() {
        return textColor;
    }

    public void setTextColor(boolean textColor) {
        this.textColor = textColor;
    }

    public TLVector<TLAbsDocument> getStickers() {
        return stickers;
    }

    public void setStickers(TLVector<TLAbsDocument> stickers) {
        this.stickers = stickers;
    }
}
