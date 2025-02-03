package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument;
import com.github.badoualy.telegram.tl.api.TLInputStickerSetItem;
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
public class TLRequestStickersReplaceSticker extends TLMethod<TLAbsStickerSet> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputDocument sticker;

    protected TLInputStickerSetItem newSticker;

    private final String _constructor = "stickers.replaceSticker#0";

    public TLRequestStickersReplaceSticker() {
    }

    public TLRequestStickersReplaceSticker(TLAbsInputDocument sticker, TLInputStickerSetItem newSticker) {
        this.sticker = sticker;
        this.newSticker = newSticker;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(sticker, stream);
        writeTLObject(newSticker, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        sticker = readTLObject(stream, context, TLAbsInputDocument.class, -1);
        newSticker = readTLObject(stream, context, TLInputStickerSetItem.class, TLInputStickerSetItem.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += sticker.computeSerializedSize();
        size += newSticker.computeSerializedSize();
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

    public TLInputStickerSetItem getNewSticker() {
        return newSticker;
    }

    public void setNewSticker(TLInputStickerSetItem newSticker) {
        this.newSticker = newSticker;
    }
}
