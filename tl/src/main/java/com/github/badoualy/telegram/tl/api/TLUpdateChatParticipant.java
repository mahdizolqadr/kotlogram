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
public class TLUpdateChatParticipant extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long chatId;

    protected int date;

    protected long actorId;

    protected long userId;

    protected TLAbsChatParticipant prevParticipant;

    protected TLAbsChatParticipant newParticipant;

    protected TLAbsExportedChatInvite invite;

    protected int qts;

    private final String _constructor = "updateChatParticipant#0";

    public TLUpdateChatParticipant() {
    }

    public TLUpdateChatParticipant(long chatId, int date, long actorId, long userId, TLAbsChatParticipant prevParticipant, TLAbsChatParticipant newParticipant, TLAbsExportedChatInvite invite, int qts) {
        this.chatId = chatId;
        this.date = date;
        this.actorId = actorId;
        this.userId = userId;
        this.prevParticipant = prevParticipant;
        this.newParticipant = newParticipant;
        this.invite = invite;
        this.qts = qts;
    }

    private void computeFlags() {
        flags = 0;
        flags = prevParticipant != null ? (flags | 1) : (flags & ~1);
        flags = newParticipant != null ? (flags | 2) : (flags & ~2);
        flags = invite != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(chatId, stream);
        writeInt(date, stream);
        writeLong(actorId, stream);
        writeLong(userId, stream);
        if ((flags & 1) != 0) {
            if (prevParticipant == null) throwNullFieldException("prevParticipant", flags);
            writeTLObject(prevParticipant, stream);
        }
        if ((flags & 2) != 0) {
            if (newParticipant == null) throwNullFieldException("newParticipant", flags);
            writeTLObject(newParticipant, stream);
        }
        if ((flags & 4) != 0) {
            if (invite == null) throwNullFieldException("invite", flags);
            writeTLObject(invite, stream);
        }
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chatId = readLong(stream);
        date = readInt(stream);
        actorId = readLong(stream);
        userId = readLong(stream);
        prevParticipant = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsChatParticipant.class, -1) : null;
        newParticipant = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsChatParticipant.class, -1) : null;
        invite = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsExportedChatInvite.class, -1) : null;
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
            if (prevParticipant == null) throwNullFieldException("prevParticipant", flags);
            size += prevParticipant.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (newParticipant == null) throwNullFieldException("newParticipant", flags);
            size += newParticipant.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (invite == null) throwNullFieldException("invite", flags);
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

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
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

    public TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
