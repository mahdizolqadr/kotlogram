package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLUpdateReadMessagesContents extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLIntVector messages;

    protected int pts;

    protected int ptsCount;

    protected Integer date;

    private final String _constructor = "updateReadMessagesContents#0";

    public TLUpdateReadMessagesContents() {
    }

    public TLUpdateReadMessagesContents(TLIntVector messages, int pts, int ptsCount, Integer date) {
        this.messages = messages;
        this.pts = pts;
        this.ptsCount = ptsCount;
        this.date = date;
    }

    private void computeFlags() {
        flags = 0;
        flags = date != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(messages, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
        if ((flags & 1) != 0) {
            if (date == null) throwNullFieldException("date", flags);
            writeInt(date, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        messages = readTLIntVector(stream, context);
        pts = readInt(stream);
        ptsCount = readInt(stream);
        date = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += messages.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (date == null) throwNullFieldException("date", flags);
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

    public TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(TLIntVector messages) {
        this.messages = messages;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }
}
