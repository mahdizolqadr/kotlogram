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
public class TLUpdateStickerSets extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean masks;

    protected boolean emojis;

    private final String _constructor = "updateStickerSets#0";

    public TLUpdateStickerSets() {
    }

    public TLUpdateStickerSets(boolean masks, boolean emojis) {
        this.masks = masks;
        this.emojis = emojis;
    }

    private void computeFlags() {
        flags = 0;
        flags = masks ? (flags | 1) : (flags & ~1);
        flags = emojis ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        masks = (flags & 1) != 0;
        emojis = (flags & 2) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean getMasks() {
        return masks;
    }

    public void setMasks(boolean masks) {
        this.masks = masks;
    }

    public boolean getEmojis() {
        return emojis;
    }

    public void setEmojis(boolean emojis) {
        this.emojis = emojis;
    }
}
