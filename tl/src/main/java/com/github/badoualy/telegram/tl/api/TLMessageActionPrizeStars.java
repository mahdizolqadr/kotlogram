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
public class TLMessageActionPrizeStars extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean unclaimed;

    protected long stars;

    protected String transactionId;

    protected TLAbsPeer boostPeer;

    protected int giveawayMsgId;

    private final String _constructor = "messageActionPrizeStars#0";

    public TLMessageActionPrizeStars() {
    }

    public TLMessageActionPrizeStars(boolean unclaimed, long stars, String transactionId, TLAbsPeer boostPeer, int giveawayMsgId) {
        this.unclaimed = unclaimed;
        this.stars = stars;
        this.transactionId = transactionId;
        this.boostPeer = boostPeer;
        this.giveawayMsgId = giveawayMsgId;
    }

    private void computeFlags() {
        flags = 0;
        flags = unclaimed ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(stars, stream);
        writeString(transactionId, stream);
        writeTLObject(boostPeer, stream);
        writeInt(giveawayMsgId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unclaimed = (flags & 1) != 0;
        stars = readLong(stream);
        transactionId = readTLString(stream);
        boostPeer = readTLObject(stream, context, TLAbsPeer.class, -1);
        giveawayMsgId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(transactionId);
        size += boostPeer.computeSerializedSize();
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

    public boolean getUnclaimed() {
        return unclaimed;
    }

    public void setUnclaimed(boolean unclaimed) {
        this.unclaimed = unclaimed;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public TLAbsPeer getBoostPeer() {
        return boostPeer;
    }

    public void setBoostPeer(TLAbsPeer boostPeer) {
        this.boostPeer = boostPeer;
    }

    public int getGiveawayMsgId() {
        return giveawayMsgId;
    }

    public void setGiveawayMsgId(int giveawayMsgId) {
        this.giveawayMsgId = giveawayMsgId;
    }
}
