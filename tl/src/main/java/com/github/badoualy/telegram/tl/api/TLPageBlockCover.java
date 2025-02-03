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
public class TLPageBlockCover extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPageBlock cover;

    private final String _constructor = "pageBlockCover#0";

    public TLPageBlockCover() {
    }

    public TLPageBlockCover(TLAbsPageBlock cover) {
        this.cover = cover;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(cover, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        cover = readTLObject(stream, context, TLAbsPageBlock.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += cover.computeSerializedSize();
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

    public TLAbsPageBlock getCover() {
        return cover;
    }

    public void setCover(TLAbsPageBlock cover) {
        this.cover = cover;
    }
}
