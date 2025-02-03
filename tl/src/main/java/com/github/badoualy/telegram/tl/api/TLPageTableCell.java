package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLPageTableCell extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean header;

    protected boolean alignCenter;

    protected boolean alignRight;

    protected boolean valignMiddle;

    protected boolean valignBottom;

    protected TLAbsRichText text;

    protected Integer colspan;

    protected Integer rowspan;

    private final String _constructor = "pageTableCell#0";

    public TLPageTableCell() {
    }

    public TLPageTableCell(boolean header, boolean alignCenter, boolean alignRight, boolean valignMiddle, boolean valignBottom, TLAbsRichText text, Integer colspan, Integer rowspan) {
        this.header = header;
        this.alignCenter = alignCenter;
        this.alignRight = alignRight;
        this.valignMiddle = valignMiddle;
        this.valignBottom = valignBottom;
        this.text = text;
        this.colspan = colspan;
        this.rowspan = rowspan;
    }

    private void computeFlags() {
        flags = 0;
        flags = header ? (flags | 1) : (flags & ~1);
        flags = alignCenter ? (flags | 8) : (flags & ~8);
        flags = alignRight ? (flags | 16) : (flags & ~16);
        flags = valignMiddle ? (flags | 32) : (flags & ~32);
        flags = valignBottom ? (flags | 64) : (flags & ~64);
        flags = text != null ? (flags | 128) : (flags & ~128);
        flags = colspan != null ? (flags | 2) : (flags & ~2);
        flags = rowspan != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 128) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            writeTLObject(text, stream);
        }
        if ((flags & 2) != 0) {
            if (colspan == null) throwNullFieldException("colspan", flags);
            writeInt(colspan, stream);
        }
        if ((flags & 4) != 0) {
            if (rowspan == null) throwNullFieldException("rowspan", flags);
            writeInt(rowspan, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        header = (flags & 1) != 0;
        alignCenter = (flags & 8) != 0;
        alignRight = (flags & 16) != 0;
        valignMiddle = (flags & 32) != 0;
        valignBottom = (flags & 64) != 0;
        text = (flags & 128) != 0 ? readTLObject(stream, context, TLAbsRichText.class, -1) : null;
        colspan = (flags & 2) != 0 ? readInt(stream) : null;
        rowspan = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 128) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            size += text.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (colspan == null) throwNullFieldException("colspan", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (rowspan == null) throwNullFieldException("rowspan", flags);
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

    public boolean getHeader() {
        return header;
    }

    public void setHeader(boolean header) {
        this.header = header;
    }

    public boolean getAlignCenter() {
        return alignCenter;
    }

    public void setAlignCenter(boolean alignCenter) {
        this.alignCenter = alignCenter;
    }

    public boolean getAlignRight() {
        return alignRight;
    }

    public void setAlignRight(boolean alignRight) {
        this.alignRight = alignRight;
    }

    public boolean getValignMiddle() {
        return valignMiddle;
    }

    public void setValignMiddle(boolean valignMiddle) {
        this.valignMiddle = valignMiddle;
    }

    public boolean getValignBottom() {
        return valignBottom;
    }

    public void setValignBottom(boolean valignBottom) {
        this.valignBottom = valignBottom;
    }

    public TLAbsRichText getText() {
        return text;
    }

    public void setText(TLAbsRichText text) {
        this.text = text;
    }

    public Integer getColspan() {
        return colspan;
    }

    public void setColspan(Integer colspan) {
        this.colspan = colspan;
    }

    public Integer getRowspan() {
        return rowspan;
    }

    public void setRowspan(Integer rowspan) {
        this.rowspan = rowspan;
    }
}
