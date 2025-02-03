package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInviteImporter extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean requested;

    protected boolean viaChatlist;

    protected long userId;

    protected int date;

    protected String about;

    protected Long approvedBy;

    private final String _constructor = "chatInviteImporter#0";

    public TLChatInviteImporter() {
    }

    public TLChatInviteImporter(boolean requested, boolean viaChatlist, long userId, int date, String about, Long approvedBy) {
        this.requested = requested;
        this.viaChatlist = viaChatlist;
        this.userId = userId;
        this.date = date;
        this.about = about;
        this.approvedBy = approvedBy;
    }

    private void computeFlags() {
        flags = 0;
        flags = requested ? (flags | 1) : (flags & ~1);
        flags = viaChatlist ? (flags | 8) : (flags & ~8);
        flags = about != null ? (flags | 4) : (flags & ~4);
        flags = approvedBy != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeInt(date, stream);
        if ((flags & 4) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        if ((flags & 2) != 0) {
            if (approvedBy == null) throwNullFieldException("approvedBy", flags);
            writeLong(approvedBy, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requested = (flags & 1) != 0;
        viaChatlist = (flags & 8) != 0;
        userId = readLong(stream);
        date = readInt(stream);
        about = (flags & 4) != 0 ? readTLString(stream) : null;
        approvedBy = (flags & 2) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        if ((flags & 2) != 0) {
            if (approvedBy == null) throwNullFieldException("approvedBy", flags);
            size += SIZE_INT64;
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

    public boolean getRequested() {
        return requested;
    }

    public void setRequested(boolean requested) {
        this.requested = requested;
    }

    public boolean getViaChatlist() {
        return viaChatlist;
    }

    public void setViaChatlist(boolean viaChatlist) {
        this.viaChatlist = viaChatlist;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(Long approvedBy) {
        this.approvedBy = approvedBy;
    }
}
