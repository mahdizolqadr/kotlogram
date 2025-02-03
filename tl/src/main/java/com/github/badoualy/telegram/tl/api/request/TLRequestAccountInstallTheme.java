package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBaseTheme;
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestAccountInstallTheme extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean dark;

    protected TLAbsInputTheme theme;

    protected String format;

    protected TLAbsBaseTheme baseTheme;

    private final String _constructor = "account.installTheme#0";

    public TLRequestAccountInstallTheme() {
    }

    public TLRequestAccountInstallTheme(boolean dark, TLAbsInputTheme theme, String format, TLAbsBaseTheme baseTheme) {
        this.dark = dark;
        this.theme = theme;
        this.format = format;
        this.baseTheme = baseTheme;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = dark ? (flags | 1) : (flags & ~1);
        flags = theme != null ? (flags | 2) : (flags & ~2);
        flags = format != null ? (flags | 4) : (flags & ~4);
        flags = baseTheme != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (theme == null) throwNullFieldException("theme", flags);
            writeTLObject(theme, stream);
        }
        if ((flags & 4) != 0) {
            if (format == null) throwNullFieldException("format", flags);
            writeString(format, stream);
        }
        if ((flags & 8) != 0) {
            if (baseTheme == null) throwNullFieldException("baseTheme", flags);
            writeTLObject(baseTheme, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        dark = (flags & 1) != 0;
        theme = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputTheme.class, -1) : null;
        format = (flags & 4) != 0 ? readTLString(stream) : null;
        baseTheme = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsBaseTheme.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (theme == null) throwNullFieldException("theme", flags);
            size += theme.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (format == null) throwNullFieldException("format", flags);
            size += computeTLStringSerializedSize(format);
        }
        if ((flags & 8) != 0) {
            if (baseTheme == null) throwNullFieldException("baseTheme", flags);
            size += baseTheme.computeSerializedSize();
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

    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public TLAbsInputTheme getTheme() {
        return theme;
    }

    public void setTheme(TLAbsInputTheme theme) {
        this.theme = theme;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public TLAbsBaseTheme getBaseTheme() {
        return baseTheme;
    }

    public void setBaseTheme(TLAbsBaseTheme baseTheme) {
        this.baseTheme = baseTheme;
    }
}
