package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantCreator extends TLAbsChannelParticipant {

    public static final int CONSTRUCTOR_ID = 0x2fe601d3;

    protected int flags;

    protected TLChatAdminRights adminRights;

    protected String rank;

    private final String _constructor = "channelParticipantCreator#2fe601d3";

    public TLChannelParticipantCreator() {
    }

    public TLChannelParticipantCreator(long userId, TLChatAdminRights adminRights, String rank) {
        this.userId = userId;
        this.adminRights = adminRights;
        this.rank = rank;
    }

    private void computeFlags() {
        flags = rank != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(userId, stream);
        writeTLObject(adminRights, stream);
        if ((flags & 1) != 0) {
            writeString(rank, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = readLong(stream);
        adminRights = readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID);
        if ((flags & 1) != 0) {
            rank = readTLString(stream);
        }
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += adminRights.computeSerializedSize();
        if ((flags & 1) != 0) {
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
