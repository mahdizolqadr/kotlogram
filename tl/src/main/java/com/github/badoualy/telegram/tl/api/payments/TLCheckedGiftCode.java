package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLCheckedGiftCode extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean viaGiveaway;

    protected TLAbsPeer fromId;

    protected Integer giveawayMsgId;

    protected Long toId;

    protected int date;

    protected int months;

    protected Integer usedDate;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "payments.checkedGiftCode#0";

    public TLCheckedGiftCode() {
    }

    public TLCheckedGiftCode(boolean viaGiveaway, TLAbsPeer fromId, Integer giveawayMsgId, Long toId, int date, int months, Integer usedDate, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.viaGiveaway = viaGiveaway;
        this.fromId = fromId;
        this.giveawayMsgId = giveawayMsgId;
        this.toId = toId;
        this.date = date;
        this.months = months;
        this.usedDate = usedDate;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = viaGiveaway ? (flags | 4) : (flags & ~4);
        flags = fromId != null ? (flags | 16) : (flags & ~16);
        flags = giveawayMsgId != null ? (flags | 8) : (flags & ~8);
        flags = toId != null ? (flags | 1) : (flags & ~1);
        flags = usedDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 16) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            writeTLObject(fromId, stream);
        }
        if ((flags & 8) != 0) {
            if (giveawayMsgId == null) throwNullFieldException("giveawayMsgId", flags);
            writeInt(giveawayMsgId, stream);
        }
        if ((flags & 1) != 0) {
            if (toId == null) throwNullFieldException("toId", flags);
            writeLong(toId, stream);
        }
        writeInt(date, stream);
        writeInt(months, stream);
        if ((flags & 2) != 0) {
            if (usedDate == null) throwNullFieldException("usedDate", flags);
            writeInt(usedDate, stream);
        }
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        viaGiveaway = (flags & 4) != 0;
        fromId = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        giveawayMsgId = (flags & 8) != 0 ? readInt(stream) : null;
        toId = (flags & 1) != 0 ? readLong(stream) : null;
        date = readInt(stream);
        months = readInt(stream);
        usedDate = (flags & 2) != 0 ? readInt(stream) : null;
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (fromId == null) throwNullFieldException("fromId", flags);
            size += fromId.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (giveawayMsgId == null) throwNullFieldException("giveawayMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (toId == null) throwNullFieldException("toId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (usedDate == null) throwNullFieldException("usedDate", flags);
            size += SIZE_INT32;
        }
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public boolean getViaGiveaway() {
        return viaGiveaway;
    }

    public void setViaGiveaway(boolean viaGiveaway) {
        this.viaGiveaway = viaGiveaway;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public Integer getGiveawayMsgId() {
        return giveawayMsgId;
    }

    public void setGiveawayMsgId(Integer giveawayMsgId) {
        this.giveawayMsgId = giveawayMsgId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonths() {
        return months;
    }

    public void setMonths(int months) {
        this.months = months;
    }

    public Integer getUsedDate() {
        return usedDate;
    }

    public void setUsedDate(Integer usedDate) {
        this.usedDate = usedDate;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
