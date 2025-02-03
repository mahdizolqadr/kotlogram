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
public class TLStoryFwdHeader extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean modified;

    protected TLAbsPeer from;

    protected String fromName;

    protected Integer storyId;

    private final String _constructor = "storyFwdHeader#0";

    public TLStoryFwdHeader() {
    }

    public TLStoryFwdHeader(boolean modified, TLAbsPeer from, String fromName, Integer storyId) {
        this.modified = modified;
        this.from = from;
        this.fromName = fromName;
        this.storyId = storyId;
    }

    private void computeFlags() {
        flags = 0;
        flags = modified ? (flags | 8) : (flags & ~8);
        flags = from != null ? (flags | 1) : (flags & ~1);
        flags = fromName != null ? (flags | 2) : (flags & ~2);
        flags = storyId != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (from == null) throwNullFieldException("from", flags);
            writeTLObject(from, stream);
        }
        if ((flags & 2) != 0) {
            if (fromName == null) throwNullFieldException("fromName", flags);
            writeString(fromName, stream);
        }
        if ((flags & 4) != 0) {
            if (storyId == null) throwNullFieldException("storyId", flags);
            writeInt(storyId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        modified = (flags & 8) != 0;
        from = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        fromName = (flags & 2) != 0 ? readTLString(stream) : null;
        storyId = (flags & 4) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (from == null) throwNullFieldException("from", flags);
            size += from.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (fromName == null) throwNullFieldException("fromName", flags);
            size += computeTLStringSerializedSize(fromName);
        }
        if ((flags & 4) != 0) {
            if (storyId == null) throwNullFieldException("storyId", flags);
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

    public boolean getModified() {
        return modified;
    }

    public void setModified(boolean modified) {
        this.modified = modified;
    }

    public TLAbsPeer getFrom() {
        return from;
    }

    public void setFrom(TLAbsPeer from) {
        this.from = from;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }
}
