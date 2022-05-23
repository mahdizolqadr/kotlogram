package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipantBanned extends TLAbsChannelParticipant {

    public static final int CONSTRUCTOR_ID = 0x6df8014e;

    protected int flags;

    protected boolean left;

    protected TLAbsPeer peer;

    protected long kickedBy;

    protected int date;

    protected TLChatBannedRights bannedRights;

    private final String _constructor = "channelParticipantBanned#6df8014e";

    public TLChannelParticipantBanned() {
    }

    public TLChannelParticipantBanned(boolean left, TLAbsPeer peer, long kickedBy, int date,
                                      TLChatBannedRights bannedRights) {
        this.left = left;
        this.peer = peer;
        this.kickedBy = kickedBy;
        this.date = date;
        this.bannedRights = bannedRights;
    }

    private void computeFlags() {
        flags = 0;
        flags = left ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeLong(kickedBy, stream);
        writeInt(date, stream);
        writeTLObject(bannedRights, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        left = (flags & 1) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        kickedBy = readLong(stream);
        date = readInt(stream);
        bannedRights = readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += bannedRights.computeSerializedSize();
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

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public long getKickedBy() {
        return kickedBy;
    }

    public void setKickedBy(long kickedBy) {
        this.kickedBy = kickedBy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLChatBannedRights getBannedRights() {
        return bannedRights;
    }

    public void setBannedRights(TLChatBannedRights bannedRights) {
        this.bannedRights = bannedRights;
    }
}
