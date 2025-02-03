package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper;
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper;
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
public class TLRequestAccountGetWallPaper extends TLMethod<TLAbsWallPaper> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputWallPaper wallpaper;

    private final String _constructor = "account.getWallPaper#0";

    public TLRequestAccountGetWallPaper() {
    }

    public TLRequestAccountGetWallPaper(TLAbsInputWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsWallPaper deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsWallPaper)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsWallPaper) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(wallpaper, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        wallpaper = readTLObject(stream, context, TLAbsInputWallPaper.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += wallpaper.computeSerializedSize();
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

    public TLAbsInputWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsInputWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
