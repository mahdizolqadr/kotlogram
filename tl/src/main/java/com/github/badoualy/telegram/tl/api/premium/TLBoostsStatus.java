package com.github.badoualy.telegram.tl.api.premium;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPrepaidGiveaway;
import com.github.badoualy.telegram.tl.api.TLStatsPercentValue;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLBoostsStatus extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean myBoost;

    protected int level;

    protected int currentLevelBoosts;

    protected int boosts;

    protected Integer giftBoosts;

    protected Integer nextLevelBoosts;

    protected TLStatsPercentValue premiumAudience;

    protected String boostUrl;

    protected TLVector<TLAbsPrepaidGiveaway> prepaidGiveaways;

    protected TLIntVector myBoostSlots;

    private final String _constructor = "premium.boostsStatus#0";

    public TLBoostsStatus() {
    }

    public TLBoostsStatus(boolean myBoost, int level, int currentLevelBoosts, int boosts, Integer giftBoosts, Integer nextLevelBoosts, TLStatsPercentValue premiumAudience, String boostUrl, TLVector<TLAbsPrepaidGiveaway> prepaidGiveaways, TLIntVector myBoostSlots) {
        this.myBoost = myBoost;
        this.level = level;
        this.currentLevelBoosts = currentLevelBoosts;
        this.boosts = boosts;
        this.giftBoosts = giftBoosts;
        this.nextLevelBoosts = nextLevelBoosts;
        this.premiumAudience = premiumAudience;
        this.boostUrl = boostUrl;
        this.prepaidGiveaways = prepaidGiveaways;
        this.myBoostSlots = myBoostSlots;
    }

    private void computeFlags() {
        flags = 0;
        flags = myBoost ? (flags | 4) : (flags & ~4);
        flags = giftBoosts != null ? (flags | 16) : (flags & ~16);
        flags = nextLevelBoosts != null ? (flags | 1) : (flags & ~1);
        flags = premiumAudience != null ? (flags | 2) : (flags & ~2);
        flags = prepaidGiveaways != null ? (flags | 8) : (flags & ~8);
        flags = myBoostSlots != null ? (flags | 4) : (flags & ~4);

        // Following parameters might be forced to true by another field that updated the flags
        myBoost = (flags & 4) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(level, stream);
        writeInt(currentLevelBoosts, stream);
        writeInt(boosts, stream);
        if ((flags & 16) != 0) {
            if (giftBoosts == null) throwNullFieldException("giftBoosts", flags);
            writeInt(giftBoosts, stream);
        }
        if ((flags & 1) != 0) {
            if (nextLevelBoosts == null) throwNullFieldException("nextLevelBoosts", flags);
            writeInt(nextLevelBoosts, stream);
        }
        if ((flags & 2) != 0) {
            if (premiumAudience == null) throwNullFieldException("premiumAudience", flags);
            writeTLObject(premiumAudience, stream);
        }
        writeString(boostUrl, stream);
        if ((flags & 8) != 0) {
            if (prepaidGiveaways == null) throwNullFieldException("prepaidGiveaways", flags);
            writeTLVector(prepaidGiveaways, stream);
        }
        if ((flags & 4) != 0) {
            if (myBoostSlots == null) throwNullFieldException("myBoostSlots", flags);
            writeTLVector(myBoostSlots, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        myBoost = (flags & 4) != 0;
        level = readInt(stream);
        currentLevelBoosts = readInt(stream);
        boosts = readInt(stream);
        giftBoosts = (flags & 16) != 0 ? readInt(stream) : null;
        nextLevelBoosts = (flags & 1) != 0 ? readInt(stream) : null;
        premiumAudience = (flags & 2) != 0 ? readTLObject(stream, context, TLStatsPercentValue.class, TLStatsPercentValue.CONSTRUCTOR_ID) : null;
        boostUrl = readTLString(stream);
        prepaidGiveaways = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        myBoostSlots = (flags & 4) != 0 ? readTLIntVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (giftBoosts == null) throwNullFieldException("giftBoosts", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (nextLevelBoosts == null) throwNullFieldException("nextLevelBoosts", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (premiumAudience == null) throwNullFieldException("premiumAudience", flags);
            size += premiumAudience.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(boostUrl);
        if ((flags & 8) != 0) {
            if (prepaidGiveaways == null) throwNullFieldException("prepaidGiveaways", flags);
            size += prepaidGiveaways.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (myBoostSlots == null) throwNullFieldException("myBoostSlots", flags);
            size += myBoostSlots.computeSerializedSize();
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

    public boolean getMyBoost() {
        return myBoost;
    }

    public void setMyBoost(boolean myBoost) {
        this.myBoost = myBoost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCurrentLevelBoosts() {
        return currentLevelBoosts;
    }

    public void setCurrentLevelBoosts(int currentLevelBoosts) {
        this.currentLevelBoosts = currentLevelBoosts;
    }

    public int getBoosts() {
        return boosts;
    }

    public void setBoosts(int boosts) {
        this.boosts = boosts;
    }

    public Integer getGiftBoosts() {
        return giftBoosts;
    }

    public void setGiftBoosts(Integer giftBoosts) {
        this.giftBoosts = giftBoosts;
    }

    public Integer getNextLevelBoosts() {
        return nextLevelBoosts;
    }

    public void setNextLevelBoosts(Integer nextLevelBoosts) {
        this.nextLevelBoosts = nextLevelBoosts;
    }

    public TLStatsPercentValue getPremiumAudience() {
        return premiumAudience;
    }

    public void setPremiumAudience(TLStatsPercentValue premiumAudience) {
        this.premiumAudience = premiumAudience;
    }

    public String getBoostUrl() {
        return boostUrl;
    }

    public void setBoostUrl(String boostUrl) {
        this.boostUrl = boostUrl;
    }

    public TLVector<TLAbsPrepaidGiveaway> getPrepaidGiveaways() {
        return prepaidGiveaways;
    }

    public void setPrepaidGiveaways(TLVector<TLAbsPrepaidGiveaway> prepaidGiveaways) {
        this.prepaidGiveaways = prepaidGiveaways;
    }

    public TLIntVector getMyBoostSlots() {
        return myBoostSlots;
    }

    public void setMyBoostSlots(TLIntVector myBoostSlots) {
        this.myBoostSlots = myBoostSlots;
    }
}
