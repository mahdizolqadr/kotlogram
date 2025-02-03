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
public class TLPageListOrderedItemBlocks extends TLAbsPageListOrderedItem {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsPageBlock> blocks;

    private final String _constructor = "pageListOrderedItemBlocks#0";

    public TLPageListOrderedItemBlocks() {
    }

    public TLPageListOrderedItemBlocks(String num, TLVector<TLAbsPageBlock> blocks) {
        this.num = num;
        this.blocks = blocks;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(num, stream);
        writeTLVector(blocks, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        num = readTLString(stream);
        blocks = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(num);
        size += blocks.computeSerializedSize();
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

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public TLVector<TLAbsPageBlock> getBlocks() {
        return blocks;
    }

    public void setBlocks(TLVector<TLAbsPageBlock> blocks) {
        this.blocks = blocks;
    }
}
