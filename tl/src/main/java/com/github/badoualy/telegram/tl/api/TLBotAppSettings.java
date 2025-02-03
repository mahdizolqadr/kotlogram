package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotAppSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLBytes placeholderPath;

    protected Integer backgroundColor;

    protected Integer backgroundDarkColor;

    protected Integer headerColor;

    protected Integer headerDarkColor;

    private final String _constructor = "botAppSettings#0";

    public TLBotAppSettings() {
    }

    public TLBotAppSettings(TLBytes placeholderPath, Integer backgroundColor, Integer backgroundDarkColor, Integer headerColor, Integer headerDarkColor) {
        this.placeholderPath = placeholderPath;
        this.backgroundColor = backgroundColor;
        this.backgroundDarkColor = backgroundDarkColor;
        this.headerColor = headerColor;
        this.headerDarkColor = headerDarkColor;
    }

    private void computeFlags() {
        flags = 0;
        flags = placeholderPath != null ? (flags | 1) : (flags & ~1);
        flags = backgroundColor != null ? (flags | 2) : (flags & ~2);
        flags = backgroundDarkColor != null ? (flags | 4) : (flags & ~4);
        flags = headerColor != null ? (flags | 8) : (flags & ~8);
        flags = headerDarkColor != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (placeholderPath == null) throwNullFieldException("placeholderPath", flags);
            writeTLBytes(placeholderPath, stream);
        }
        if ((flags & 2) != 0) {
            if (backgroundColor == null) throwNullFieldException("backgroundColor", flags);
            writeInt(backgroundColor, stream);
        }
        if ((flags & 4) != 0) {
            if (backgroundDarkColor == null) throwNullFieldException("backgroundDarkColor", flags);
            writeInt(backgroundDarkColor, stream);
        }
        if ((flags & 8) != 0) {
            if (headerColor == null) throwNullFieldException("headerColor", flags);
            writeInt(headerColor, stream);
        }
        if ((flags & 16) != 0) {
            if (headerDarkColor == null) throwNullFieldException("headerDarkColor", flags);
            writeInt(headerDarkColor, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        placeholderPath = (flags & 1) != 0 ? readTLBytes(stream, context) : null;
        backgroundColor = (flags & 2) != 0 ? readInt(stream) : null;
        backgroundDarkColor = (flags & 4) != 0 ? readInt(stream) : null;
        headerColor = (flags & 8) != 0 ? readInt(stream) : null;
        headerDarkColor = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (placeholderPath == null) throwNullFieldException("placeholderPath", flags);
            size += computeTLBytesSerializedSize(placeholderPath);
        }
        if ((flags & 2) != 0) {
            if (backgroundColor == null) throwNullFieldException("backgroundColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (backgroundDarkColor == null) throwNullFieldException("backgroundDarkColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (headerColor == null) throwNullFieldException("headerColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (headerDarkColor == null) throwNullFieldException("headerDarkColor", flags);
            size += SIZE_INT32;
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

    public TLBytes getPlaceholderPath() {
        return placeholderPath;
    }

    public void setPlaceholderPath(TLBytes placeholderPath) {
        this.placeholderPath = placeholderPath;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getBackgroundDarkColor() {
        return backgroundDarkColor;
    }

    public void setBackgroundDarkColor(Integer backgroundDarkColor) {
        this.backgroundDarkColor = backgroundDarkColor;
    }

    public Integer getHeaderColor() {
        return headerColor;
    }

    public void setHeaderColor(Integer headerColor) {
        this.headerColor = headerColor;
    }

    public Integer getHeaderDarkColor() {
        return headerDarkColor;
    }

    public void setHeaderDarkColor(Integer headerDarkColor) {
        this.headerDarkColor = headerDarkColor;
    }
}
