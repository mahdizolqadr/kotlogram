package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper;
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLRequestAccountGetMultiWallPapers extends TLMethod<TLVector<TLAbsWallPaper>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsInputWallPaper> wallpapers;

    private final String _constructor = "account.getMultiWallPapers#0";

    public TLRequestAccountGetMultiWallPapers() {
    }

    public TLRequestAccountGetMultiWallPapers(TLVector<TLAbsInputWallPaper> wallpapers) {
        this.wallpapers = wallpapers;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLAbsWallPaper> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(wallpapers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        wallpapers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += wallpapers.computeSerializedSize();
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

    public TLVector<TLAbsInputWallPaper> getWallpapers() {
        return wallpapers;
    }

    public void setWallpapers(TLVector<TLAbsInputWallPaper> wallpapers) {
        this.wallpapers = wallpapers;
    }
}
