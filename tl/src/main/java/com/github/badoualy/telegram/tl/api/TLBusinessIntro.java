package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLBusinessIntro extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String title;

    protected String description;

    protected TLAbsDocument sticker;

    private final String _constructor = "businessIntro#0";

    public TLBusinessIntro() {
    }

    public TLBusinessIntro(String title, String description, TLAbsDocument sticker) {
        this.title = title;
        this.description = description;
        this.sticker = sticker;
    }

    private void computeFlags() {
        flags = 0;
        flags = sticker != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        writeString(description, stream);
        if ((flags & 1) != 0) {
            if (sticker == null) throwNullFieldException("sticker", flags);
            writeTLObject(sticker, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = readTLString(stream);
        description = readTLString(stream);
        sticker = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsDocument.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(description);
        if ((flags & 1) != 0) {
            if (sticker == null) throwNullFieldException("sticker", flags);
            size += sticker.computeSerializedSize();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsDocument getSticker() {
        return sticker;
    }

    public void setSticker(TLAbsDocument sticker) {
        this.sticker = sticker;
    }
}
