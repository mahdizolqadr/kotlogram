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
public class TLStoryItemSkipped extends TLAbsStoryItem {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean closeFriends;

    protected int date;

    protected int expireDate;

    private final String _constructor = "storyItemSkipped#0";

    public TLStoryItemSkipped() {
    }

    public TLStoryItemSkipped(boolean closeFriends, int id, int date, int expireDate) {
        this.closeFriends = closeFriends;
        this.id = id;
        this.date = date;
        this.expireDate = expireDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = closeFriends ? (flags | 256) : (flags & ~256);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(date, stream);
        writeInt(expireDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        closeFriends = (flags & 256) != 0;
        id = readInt(stream);
        date = readInt(stream);
        expireDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public boolean getCloseFriends() {
        return closeFriends;
    }

    public void setCloseFriends(boolean closeFriends) {
        this.closeFriends = closeFriends;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }
}
