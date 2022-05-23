package com.github.badoualy.telegram.tl.api.wallpaper;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLWallPaperNoFile extends TLAbsWallPaper {

    public static final int CONSTRUCTOR_ID = 0xe0804116;

    private final String _constructor = "wallPaperNoFile#e0804116";

    public TLWallPaperNoFile() {
    }

    public TLWallPaperNoFile(long id, boolean isDefault, boolean dark, TLWallPaperSettings settings) {
        super(id, isDefault, dark, settings);
    }

    private void computeFlags() {
        flags = 0;
        flags = isDefault ? (flags | 2) : (flags & ~2);
        flags = dark ? (flags | 16) : (flags & ~16);
        flags = settings != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeLong(id, stream);
        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
            writeTLObject(settings, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        flags = readInt(stream);
        isDefault = (flags & 2) != 0;
        dark = (flags & 16) != 0;
        if ((flags & 4) != 0) {
            settings = readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID);
        }
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (settings == null) {
                throwNullFieldException("settings", flags);
            }
            size += settings.computeSerializedSize();
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
}
