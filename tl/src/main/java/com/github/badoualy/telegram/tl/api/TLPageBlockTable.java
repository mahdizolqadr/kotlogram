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
public class TLPageBlockTable extends TLAbsPageBlock {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean bordered;

    protected boolean striped;

    protected TLAbsRichText title;

    protected TLVector<TLPageTableRow> rows;

    private final String _constructor = "pageBlockTable#0";

    public TLPageBlockTable() {
    }

    public TLPageBlockTable(boolean bordered, boolean striped, TLAbsRichText title, TLVector<TLPageTableRow> rows) {
        this.bordered = bordered;
        this.striped = striped;
        this.title = title;
        this.rows = rows;
    }

    private void computeFlags() {
        flags = 0;
        flags = bordered ? (flags | 1) : (flags & ~1);
        flags = striped ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(title, stream);
        writeTLVector(rows, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        bordered = (flags & 1) != 0;
        striped = (flags & 2) != 0;
        title = readTLObject(stream, context, TLAbsRichText.class, -1);
        rows = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += title.computeSerializedSize();
        size += rows.computeSerializedSize();
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

    public boolean getBordered() {
        return bordered;
    }

    public void setBordered(boolean bordered) {
        this.bordered = bordered;
    }

    public boolean getStriped() {
        return striped;
    }

    public void setStriped(boolean striped) {
        this.striped = striped;
    }

    public TLAbsRichText getTitle() {
        return title;
    }

    public void setTitle(TLAbsRichText title) {
        this.title = title;
    }

    public TLVector<TLPageTableRow> getRows() {
        return rows;
    }

    public void setRows(TLVector<TLPageTableRow> rows) {
        this.rows = rows;
    }
}
