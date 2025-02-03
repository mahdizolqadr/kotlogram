package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLChannelParticipantsMentions extends TLAbsChannelParticipantsFilter {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String q;

    protected Integer topMsgId;

    private final String _constructor = "channelParticipantsMentions#0";

    public TLChannelParticipantsMentions() {
    }

    public TLChannelParticipantsMentions(String q, Integer topMsgId) {
        this.q = q;
        this.topMsgId = topMsgId;
    }

    private void computeFlags() {
        flags = 0;
        flags = q != null ? (flags | 1) : (flags & ~1);
        flags = topMsgId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            writeString(q, stream);
        }
        if ((flags & 2) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
            writeInt(topMsgId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        q = (flags & 1) != 0 ? readTLString(stream) : null;
        topMsgId = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (q == null) throwNullFieldException("q", flags);
            size += computeTLStringSerializedSize(q);
        }
        if ((flags & 2) != 0) {
            if (topMsgId == null) throwNullFieldException("topMsgId", flags);
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

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Integer getTopMsgId() {
        return topMsgId;
    }

    public void setTopMsgId(Integer topMsgId) {
        this.topMsgId = topMsgId;
    }
}
