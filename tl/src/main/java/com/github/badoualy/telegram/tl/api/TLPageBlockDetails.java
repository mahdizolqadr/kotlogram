package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPageBlockDetails extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean open;

    protected TLVector<TLAbsPageBlock> blocks;

    protected TLAbsRichText title;

    private final String _constructor = "pageBlockDetails#0";

    public TLPageBlockDetails() {
    }

    public TLPageBlockDetails(boolean open, TLVector<TLAbsPageBlock> blocks, TLAbsRichText title) {
        this.open = open;
        this.blocks = blocks;
        this.title = title;
    }

    private void computeFlags() {
        flags = 0;
        flags = open ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(blocks, stream);
        writeTLObject(title, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        open = (flags & 1) != 0;
        blocks = readTLVector(stream, context);
        title = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += blocks.computeSerializedSize();
        size += title.computeSerializedSize();
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

    public boolean getOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public TLVector<TLAbsPageBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(TLVector<TLAbsPageBlock> blocks) {
        this.blocks = blocks;
    }

    public TLAbsRichText getTitle() {
        return title;
    }

    public void setTitle(TLAbsRichText title) {
        this.title = title;
    }
}
