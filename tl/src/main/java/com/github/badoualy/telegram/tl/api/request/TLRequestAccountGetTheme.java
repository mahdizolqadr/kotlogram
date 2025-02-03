package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputTheme;
import com.github.badoualy.telegram.tl.api.TLTheme;
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
public class TLRequestAccountGetTheme extends TLMethod<TLTheme> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String format;

    protected TLAbsInputTheme theme;

    private final String _constructor = "account.getTheme#0";

    public TLRequestAccountGetTheme() {
    }

    public TLRequestAccountGetTheme(String format, TLAbsInputTheme theme) {
        this.format = format;
        this.theme = theme;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLTheme deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLTheme)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLTheme) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(format, stream);
        writeTLObject(theme, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        format = readTLString(stream);
        theme = readTLObject(stream, context, TLAbsInputTheme.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(format);
        size += theme.computeSerializedSize();
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public TLAbsInputTheme getTheme() {
        return theme;
    }

    public void setTheme(TLAbsInputTheme theme) {
        this.theme = theme;
    }
}
