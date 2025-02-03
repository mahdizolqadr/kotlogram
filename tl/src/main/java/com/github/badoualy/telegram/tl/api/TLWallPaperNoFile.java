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
public class TLWallPaperNoFile extends TLAbsWallPaper {
    public static final int CONSTRUCTOR_ID = 0x0;

    private final String _constructor = "wallPaperNoFile#0";

    public TLWallPaperNoFile() {
    }

    public TLWallPaperNoFile(long id, boolean ddefault, boolean dark, TLWallPaperSettings settings) {
        this.id = id;
        this.ddefault = ddefault;
        this.dark = dark;
        this.settings = settings;
    }

    private void computeFlags() {
        flags = 0;
        flags = ddefault ? (flags | 2) : (flags & ~2);
        flags = dark ? (flags | 16) : (flags & ~16);
        flags = settings != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeLong(id, stream);
        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLObject(settings, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        flags = readInt(stream);
        ddefault = (flags & 2) != 0;
        dark = (flags & 16) != 0;
        settings = (flags & 4) != 0 ? readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getDdefault() {
        return ddefault;
    }

    public void setDdefault(boolean ddefault) {
        this.ddefault = ddefault;
    }

    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public TLWallPaperSettings getSettings() {
        return settings;
    }

    public void setSettings(TLWallPaperSettings settings) {
        this.settings = settings;
    }
}
