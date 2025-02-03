package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLBoost extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean gift;

    protected boolean giveaway;

    protected boolean unclaimed;

    protected String id;

    protected Long userId;

    protected Integer giveawayMsgId;

    protected int date;

    protected int expires;

    protected String usedGiftSlug;

    protected Integer multiplier;

    protected Long stars;

    private final String _constructor = "boost#0";

    public TLBoost() {
    }

    public TLBoost(boolean gift, boolean giveaway, boolean unclaimed, String id, Long userId, Integer giveawayMsgId, int date, int expires, String usedGiftSlug, Integer multiplier, Long stars) {
        this.gift = gift;
        this.giveaway = giveaway;
        this.unclaimed = unclaimed;
        this.id = id;
        this.userId = userId;
        this.giveawayMsgId = giveawayMsgId;
        this.date = date;
        this.expires = expires;
        this.usedGiftSlug = usedGiftSlug;
        this.multiplier = multiplier;
        this.stars = stars;
    }

    private void computeFlags() {
        flags = 0;
        flags = gift ? (flags | 2) : (flags & ~2);
        flags = giveaway ? (flags | 4) : (flags & ~4);
        flags = unclaimed ? (flags | 8) : (flags & ~8);
        flags = userId != null ? (flags | 1) : (flags & ~1);
        flags = giveawayMsgId != null ? (flags | 4) : (flags & ~4);
        flags = usedGiftSlug != null ? (flags | 16) : (flags & ~16);
        flags = multiplier != null ? (flags | 32) : (flags & ~32);
        flags = stars != null ? (flags | 64) : (flags & ~64);

        // Following parameters might be forced to true by another field that updated the flags
        giveaway = (flags & 4) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            writeLong(userId, stream);
        }
        if ((flags & 4) != 0) {
            if (giveawayMsgId == null) throwNullFieldException("giveawayMsgId", flags);
            writeInt(giveawayMsgId, stream);
        }
        writeInt(date, stream);
        writeInt(expires, stream);
        if ((flags & 16) != 0) {
            if (usedGiftSlug == null) throwNullFieldException("usedGiftSlug", flags);
            writeString(usedGiftSlug, stream);
        }
        if ((flags & 32) != 0) {
            if (multiplier == null) throwNullFieldException("multiplier", flags);
            writeInt(multiplier, stream);
        }
        if ((flags & 64) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
            writeLong(stars, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        gift = (flags & 2) != 0;
        giveaway = (flags & 4) != 0;
        unclaimed = (flags & 8) != 0;
        id = readTLString(stream);
        userId = (flags & 1) != 0 ? readLong(stream) : null;
        giveawayMsgId = (flags & 4) != 0 ? readInt(stream) : null;
        date = readInt(stream);
        expires = readInt(stream);
        usedGiftSlug = (flags & 16) != 0 ? readTLString(stream) : null;
        multiplier = (flags & 32) != 0 ? readInt(stream) : null;
        stars = (flags & 64) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 4) != 0) {
            if (giveawayMsgId == null) throwNullFieldException("giveawayMsgId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (usedGiftSlug == null) throwNullFieldException("usedGiftSlug", flags);
            size += computeTLStringSerializedSize(usedGiftSlug);
        }
        if ((flags & 32) != 0) {
            if (multiplier == null) throwNullFieldException("multiplier", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (stars == null) throwNullFieldException("stars", flags);
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

    public boolean getGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public boolean getGiveaway() {
        return giveaway;
    }

    public void setGiveaway(boolean giveaway) {
        this.giveaway = giveaway;
    }

    public boolean getUnclaimed() {
        return unclaimed;
    }

    public void setUnclaimed(boolean unclaimed) {
        this.unclaimed = unclaimed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getGiveawayMsgId() {
        return giveawayMsgId;
    }

    public void setGiveawayMsgId(Integer giveawayMsgId) {
        this.giveawayMsgId = giveawayMsgId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public String getUsedGiftSlug() {
        return usedGiftSlug;
    }

    public void setUsedGiftSlug(String usedGiftSlug) {
        this.usedGiftSlug = usedGiftSlug;
    }

    public Integer getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Integer multiplier) {
        this.multiplier = multiplier;
    }

    public Long getStars() {
        return stars;
    }

    public void setStars(Long stars) {
        this.stars = stars;
    }
}
