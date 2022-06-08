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

public class TLUpdateChannelParticipant extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x985d3abb;

    protected int flags;
    protected long channelId;
    protected int date;
    protected long actorId;
    protected long userId;
    protected TLAbsChatParticipant prevParticipant;
    protected TLAbsChatParticipant newParticipant;
    protected TLChatInviteExported invite;
    protected int qts;

    private final String _constructor = "updateChannelParticipant#985d3abb";

    public TLUpdateChannelParticipant() {
    }

    public TLUpdateChannelParticipant(long channelId, int date, long actorId, long userId, TLAbsChatParticipant prevParticipant,
                                      TLAbsChatParticipant newParticipant, TLChatInviteExported invite, int qts) {
        this.channelId = channelId;
        this.date = date;
        this.actorId = actorId;
        this.userId = userId;
        this.prevParticipant = prevParticipant;
        this.newParticipant = newParticipant;
        this.invite = invite;
        this.qts = qts;
    }

    protected void computeFlags() {
        flags = 0;
        flags = prevParticipant != null ? (flags | 1) : (flags & ~1);
        flags = newParticipant != null ? (flags | 2) : (flags & ~2);
        flags = invite != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(channelId, stream);
        writeInt(date, stream);
        writeLong(actorId, stream);
        writeLong(userId, stream);
        if ((flags & 1) != 0) {
            if (prevParticipant == null) {
                throwNullFieldException("prevParticipant", flags);
            }
            writeTLObject(prevParticipant, stream);
        }
        if ((flags & 2) != 0) {
            if (newParticipant == null) {
                throwNullFieldException("newParticipant", flags);
            }
            writeTLObject(newParticipant, stream);
        }
        if ((flags & 4) != 0) {
            if (invite == null) {
                throwNullFieldException("invite", flags);
            }
            writeTLObject(invite, stream);
        }
        writeInt(qts, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channelId = readLong(stream);
        date = readInt(stream);
        actorId = readLong(stream);
        userId = readLong(stream);
        prevParticipant = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsChatParticipant.class, -1) : null;
        newParticipant = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsChatParticipant.class, -1) : null;
        invite = (flags & 4) != 0 ? readTLObject(stream, context, TLChatInviteExported.class, TLChatInviteExported.CONSTRUCTOR_ID) : null;
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (prevParticipant == null) {
                throwNullFieldException("prevParticipant", flags);
            }
            size += prevParticipant.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (newParticipant == null) {
                throwNullFieldException("newParticipant", flags);
            }
            size += newParticipant.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (invite == null) {
                throwNullFieldException("invite", flags);
            }
            size += invite.computeSerializedSize();
        }
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

    public long getChannelId() {
        return channelId;
    }

    public void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getActorId() {
        return actorId;
    }

    public void setActorId(long actorId) {
        this.actorId = actorId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public TLAbsChatParticipant getPrevParticipant() {
        return prevParticipant;
    }

    public void setPrevParticipant(TLAbsChatParticipant prevParticipant) {
        this.prevParticipant = prevParticipant;
    }

    public TLAbsChatParticipant getNewParticipant() {
        return newParticipant;
    }

    public void setNewParticipant(TLAbsChatParticipant newParticipant) {
        this.newParticipant = newParticipant;
    }

    public TLChatInviteExported getInvite() {
        return invite;
    }

    public void setInvite(TLChatInviteExported invite) {
        this.invite = invite;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
