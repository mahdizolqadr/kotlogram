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
public class TLDocumentAttributeCustomEmoji extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean free;

    protected boolean textColor;

    protected String alt;

    protected TLAbsInputStickerSet stickerset;

    private final String _constructor = "documentAttributeCustomEmoji#0";

    public TLDocumentAttributeCustomEmoji() {
    }

    public TLDocumentAttributeCustomEmoji(boolean free, boolean textColor, String alt, TLAbsInputStickerSet stickerset) {
        this.free = free;
        this.textColor = textColor;
        this.alt = alt;
        this.stickerset = stickerset;
    }

    private void computeFlags() {
        flags = 0;
        flags = free ? (flags | 1) : (flags & ~1);
        flags = textColor ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(alt, stream);
        writeTLObject(stickerset, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        free = (flags & 1) != 0;
        textColor = (flags & 2) != 0;
        alt = readTLString(stream);
        stickerset = readTLObject(stream, context, TLAbsInputStickerSet.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(alt);
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

    public boolean getFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean getTextColor() {
        return textColor;
    }

    public void setTextColor(boolean textColor) {
        this.textColor = textColor;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public TLAbsInputStickerSet getStickerset() {
        return stickerset;
    }

    public void setStickerset(TLAbsInputStickerSet stickerset) {
        this.stickerset = stickerset;
    }
}
