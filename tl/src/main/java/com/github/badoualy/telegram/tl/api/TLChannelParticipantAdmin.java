package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLChannelParticipantAdmin extends TLAbsChannelParticipant {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean canEdit;

    protected boolean self;

    protected long userId;

    protected Long inviterId;

    protected long promotedBy;

    protected int date;

    protected TLChatAdminRights adminRights;

    protected String rank;

    private final String _constructor = "channelParticipantAdmin#0";

    public TLChannelParticipantAdmin() {
    }

    public TLChannelParticipantAdmin(boolean canEdit, boolean self, long userId, Long inviterId, long promotedBy, int date, TLChatAdminRights adminRights, String rank) {
        this.canEdit = canEdit;
        this.self = self;
        this.userId = userId;
        this.inviterId = inviterId;
        this.promotedBy = promotedBy;
        this.date = date;
        this.adminRights = adminRights;
        this.rank = rank;
    }

    private void computeFlags() {
        flags = 0;
        flags = canEdit ? (flags | 1) : (flags & ~1);
        flags = self ? (flags | 2) : (flags & ~2);
        flags = inviterId != null ? (flags | 2) : (flags & ~2);
        flags = rank != null ? (flags | 4) : (flags & ~4);

        // Following parameters might be forced to true by another field that updated the flags
        self = (flags & 2) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
        if ((flags & 2) != 0) {
            if (inviterId == null) throwNullFieldException("inviterId", flags);
            writeLong(inviterId, stream);
        }
        writeLong(promotedBy, stream);
        writeInt(date, stream);
        writeTLObject(adminRights, stream);
        if ((flags & 4) != 0) {
            if (rank == null) throwNullFieldException("rank", flags);
            writeString(rank, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canEdit = (flags & 1) != 0;
        self = (flags & 2) != 0;
        userId = readLong(stream);
        inviterId = (flags & 2) != 0 ? readLong(stream) : null;
        promotedBy = readLong(stream);
        date = readInt(stream);
        adminRights = readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID);
        rank = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (inviterId == null) throwNullFieldException("inviterId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += adminRights.computeSerializedSize();
        if ((flags & 4) != 0) {
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

    public boolean getCanEdit() {
        return canEdit;
    }

    public void setCanEdit(boolean canEdit) {
        this.canEdit = canEdit;
    }

    public boolean getSelf() {
        return self;
    }

    public void setSelf(boolean self) {
        this.self = self;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Long getInviterId() {
        return inviterId;
    }

    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

    public long getPromotedBy() {
        return promotedBy;
    }

    public void setPromotedBy(long promotedBy) {
        this.promotedBy = promotedBy;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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
