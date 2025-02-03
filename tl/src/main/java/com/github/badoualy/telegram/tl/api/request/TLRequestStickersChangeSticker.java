package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument;
import com.github.badoualy.telegram.tl.api.TLMaskCoords;
import com.github.badoualy.telegram.tl.api.messages.TLAbsStickerSet;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestStickersChangeSticker extends TLMethod<TLAbsStickerSet> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputDocument sticker;

    protected String emoji;

    protected TLMaskCoords maskCoords;

    protected String keywords;

    private final String _constructor = "stickers.changeSticker#0";

    public TLRequestStickersChangeSticker() {
    }

    public TLRequestStickersChangeSticker(TLAbsInputDocument sticker, String emoji, TLMaskCoords maskCoords, String keywords) {
        this.sticker = sticker;
        this.emoji = emoji;
        this.maskCoords = maskCoords;
        this.keywords = keywords;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsStickerSet deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsStickerSet)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsStickerSet) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = emoji != null ? (flags | 1) : (flags & ~1);
        flags = maskCoords != null ? (flags | 2) : (flags & ~2);
        flags = keywords != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(sticker, stream);
        if ((flags & 1) != 0) {
            if (emoji == null) throwNullFieldException("emoji", flags);
            writeString(emoji, stream);
        }
        if ((flags & 2) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            writeTLObject(maskCoords, stream);
        }
        if ((flags & 4) != 0) {
            if (keywords == null) throwNullFieldException("keywords", flags);
            writeString(keywords, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        sticker = readTLObject(stream, context, TLAbsInputDocument.class, -1);
        emoji = (flags & 1) != 0 ? readTLString(stream) : null;
        maskCoords = (flags & 2) != 0 ? readTLObject(stream, context, TLMaskCoords.class, TLMaskCoords.CONSTRUCTOR_ID) : null;
        keywords = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += sticker.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (emoji == null) throwNullFieldException("emoji", flags);
            size += computeTLStringSerializedSize(emoji);
        }
        if ((flags & 2) != 0) {
            if (maskCoords == null) throwNullFieldException("maskCoords", flags);
            size += maskCoords.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (keywords == null) throwNullFieldException("keywords", flags);
            size += computeTLStringSerializedSize(keywords);
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

    public TLAbsInputDocument getSticker() {
        return sticker;
    }

    public void setSticker(TLAbsInputDocument sticker) {
        this.sticker = sticker;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public TLMaskCoords getMaskCoords() {
        return maskCoords;
    }

    public void setMaskCoords(TLMaskCoords maskCoords) {
        this.maskCoords = maskCoords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
