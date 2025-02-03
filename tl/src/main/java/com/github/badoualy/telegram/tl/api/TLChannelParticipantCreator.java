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
public class TLChannelParticipantCreator extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long userId;

    protected TLChatAdminRights adminRights;

    protected String rank;

    private final String _constructor = "channelParticipantCreator#0";

    public TLChannelParticipantCreator() {
    }

    public TLChannelParticipantCreator(long userId, TLChatAdminRights adminRights, String rank) {
        this.userId = userId;
        this.adminRights = adminRights;
        this.rank = rank;
    }

    private void computeFlags() {
        flags = 0;
        flags = rank != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        writeTLObject(adminRights, stream);
        if ((flags & 1) != 0) {
            if (rank == null) throwNullFieldException("rank", flags);
            writeString(rank, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = readLong(stream);
        adminRights = readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID);
        rank = (flags & 1) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += adminRights.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (rank == null) throwNullFieldException("rank", flags);
            size += computeTLStringSerializedSize(rank);
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

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TLChatAdminRights getAdminRights() {
        return adminRights;
    }

    public void setAdminRights(TLChatAdminRights adminRights) {
        this.adminRights = adminRights;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
