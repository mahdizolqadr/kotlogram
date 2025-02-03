package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLStarsTransaction extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean refund;

    protected boolean pending;

    protected boolean failed;

    protected boolean gift;

    protected boolean reaction;

    protected String id;

    protected TLStarsAmount stars;

    protected int date;

    protected TLAbsStarsTransactionPeer peer;

    protected String title;

    protected String description;

    protected TLAbsWebDocument photo;

    protected Integer transactionDate;

    protected String transactionUrl;

    protected TLBytes botPayload;

    protected Integer msgId;

    protected TLVector<TLAbsMessageMedia> extendedMedia;

    protected Integer subscriptionPeriod;

    protected Integer giveawayPostId;

    protected TLStarGift stargift;

    protected Integer floodskipNumber;

    protected Integer starrefCommissionPermille;

    protected TLAbsPeer starrefPeer;

    protected TLStarsAmount starrefAmount;

    private final String _constructor = "starsTransaction#0";

    public TLStarsTransaction() {
    }

    public TLStarsTransaction(boolean refund, boolean pending, boolean failed, boolean gift, boolean reaction, String id, TLStarsAmount stars, int date, TLAbsStarsTransactionPeer peer, String title, String description, TLAbsWebDocument photo, Integer transactionDate, String transactionUrl, TLBytes botPayload, Integer msgId, TLVector<TLAbsMessageMedia> extendedMedia, Integer subscriptionPeriod, Integer giveawayPostId, TLStarGift stargift, Integer floodskipNumber, Integer starrefCommissionPermille, TLAbsPeer starrefPeer, TLStarsAmount starrefAmount) {
        this.refund = refund;
        this.pending = pending;
        this.failed = failed;
        this.gift = gift;
        this.reaction = reaction;
        this.id = id;
        this.stars = stars;
        this.date = date;
        this.peer = peer;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.transactionDate = transactionDate;
        this.transactionUrl = transactionUrl;
        this.botPayload = botPayload;
        this.msgId = msgId;
        this.extendedMedia = extendedMedia;
        this.subscriptionPeriod = subscriptionPeriod;
        this.giveawayPostId = giveawayPostId;
        this.stargift = stargift;
        this.floodskipNumber = floodskipNumber;
        this.starrefCommissionPermille = starrefCommissionPermille;
        this.starrefPeer = starrefPeer;
        this.starrefAmount = starrefAmount;
    }

    private void computeFlags() {
        flags = 0;
        flags = refund ? (flags | 8) : (flags & ~8);
        flags = pending ? (flags | 16) : (flags & ~16);
        flags = failed ? (flags | 64) : (flags & ~64);
        flags = gift ? (flags | 1024) : (flags & ~1024);
        flags = reaction ? (flags | 2048) : (flags & ~2048);
        flags = title != null ? (flags | 1) : (flags & ~1);
        flags = description != null ? (flags | 2) : (flags & ~2);
        flags = photo != null ? (flags | 4) : (flags & ~4);
        flags = transactionDate != null ? (flags | 32) : (flags & ~32);
        flags = transactionUrl != null ? (flags | 32) : (flags & ~32);
        flags = botPayload != null ? (flags | 128) : (flags & ~128);
        flags = msgId != null ? (flags | 256) : (flags & ~256);
        flags = extendedMedia != null ? (flags | 512) : (flags & ~512);
        flags = subscriptionPeriod != null ? (flags | 4096) : (flags & ~4096);
        flags = giveawayPostId != null ? (flags | 8192) : (flags & ~8192);
        flags = stargift != null ? (flags | 16384) : (flags & ~16384);
        flags = floodskipNumber != null ? (flags | 32768) : (flags & ~32768);
        flags = starrefCommissionPermille != null ? (flags | 65536) : (flags & ~65536);
        flags = starrefPeer != null ? (flags | 131072) : (flags & ~131072);
        flags = starrefAmount != null ? (flags | 131072) : (flags & ~131072);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        writeTLObject(stars, stream);
        writeInt(date, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            writeTLObject(photo, stream);
        }
        if ((flags & 32) != 0) {
            if (transactionDate == null) throwNullFieldException("transactionDate", flags);
            writeInt(transactionDate, stream);
        }
        if ((flags & 32) != 0) {
            if (transactionUrl == null) throwNullFieldException("transactionUrl", flags);
            writeString(transactionUrl, stream);
        }
        if ((flags & 128) != 0) {
            if (botPayload == null) throwNullFieldException("botPayload", flags);
            writeTLBytes(botPayload, stream);
        }
        if ((flags & 256) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            writeInt(msgId, stream);
        }
        if ((flags & 512) != 0) {
            if (extendedMedia == null) throwNullFieldException("extendedMedia", flags);
            writeTLVector(extendedMedia, stream);
        }
        if ((flags & 4096) != 0) {
            if (subscriptionPeriod == null) throwNullFieldException("subscriptionPeriod", flags);
            writeInt(subscriptionPeriod, stream);
        }
        if ((flags & 8192) != 0) {
            if (giveawayPostId == null) throwNullFieldException("giveawayPostId", flags);
            writeInt(giveawayPostId, stream);
        }
        if ((flags & 16384) != 0) {
            if (stargift == null) throwNullFieldException("stargift", flags);
            writeTLObject(stargift, stream);
        }
        if ((flags & 32768) != 0) {
            if (floodskipNumber == null) throwNullFieldException("floodskipNumber", flags);
            writeInt(floodskipNumber, stream);
        }
        if ((flags & 65536) != 0) {
            if (starrefCommissionPermille == null) throwNullFieldException("starrefCommissionPermille", flags);
            writeInt(starrefCommissionPermille, stream);
        }
        if ((flags & 131072) != 0) {
            if (starrefPeer == null) throwNullFieldException("starrefPeer", flags);
            writeTLObject(starrefPeer, stream);
        }
        if ((flags & 131072) != 0) {
            if (starrefAmount == null) throwNullFieldException("starrefAmount", flags);
            writeTLObject(starrefAmount, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        refund = (flags & 8) != 0;
        pending = (flags & 16) != 0;
        failed = (flags & 64) != 0;
        gift = (flags & 1024) != 0;
        reaction = (flags & 2048) != 0;
        id = readTLString(stream);
        stars = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
        date = readInt(stream);
        peer = readTLObject(stream, context, TLAbsStarsTransactionPeer.class, -1);
        title = (flags & 1) != 0 ? readTLString(stream) : null;
        description = (flags & 2) != 0 ? readTLString(stream) : null;
        photo = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        transactionDate = (flags & 32) != 0 ? readInt(stream) : null;
        transactionUrl = (flags & 32) != 0 ? readTLString(stream) : null;
        botPayload = (flags & 128) != 0 ? readTLBytes(stream, context) : null;
        msgId = (flags & 256) != 0 ? readInt(stream) : null;
        extendedMedia = (flags & 512) != 0 ? readTLVector(stream, context) : null;
        subscriptionPeriod = (flags & 4096) != 0 ? readInt(stream) : null;
        giveawayPostId = (flags & 8192) != 0 ? readInt(stream) : null;
        stargift = (flags & 16384) != 0 ? readTLObject(stream, context, TLStarGift.class, TLStarGift.CONSTRUCTOR_ID) : null;
        floodskipNumber = (flags & 32768) != 0 ? readInt(stream) : null;
        starrefCommissionPermille = (flags & 65536) != 0 ? readInt(stream) : null;
        starrefPeer = (flags & 131072) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        starrefAmount = (flags & 131072) != 0 ? readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        size += stars.computeSerializedSize();
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        if ((flags & 4) != 0) {
            if (photo == null) throwNullFieldException("photo", flags);
            size += photo.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (transactionDate == null) throwNullFieldException("transactionDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (transactionUrl == null) throwNullFieldException("transactionUrl", flags);
            size += computeTLStringSerializedSize(transactionUrl);
        }
        if ((flags & 128) != 0) {
            if (botPayload == null) throwNullFieldException("botPayload", flags);
            size += computeTLBytesSerializedSize(botPayload);
        }
        if ((flags & 256) != 0) {
            if (msgId == null) throwNullFieldException("msgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 512) != 0) {
            if (extendedMedia == null) throwNullFieldException("extendedMedia", flags);
            size += extendedMedia.computeSerializedSize();
        }
        if ((flags & 4096) != 0) {
            if (subscriptionPeriod == null) throwNullFieldException("subscriptionPeriod", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8192) != 0) {
            if (giveawayPostId == null) throwNullFieldException("giveawayPostId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16384) != 0) {
            if (stargift == null) throwNullFieldException("stargift", flags);
            size += stargift.computeSerializedSize();
        }
        if ((flags & 32768) != 0) {
            if (floodskipNumber == null) throwNullFieldException("floodskipNumber", flags);
            size += SIZE_INT32;
        }
        if ((flags & 65536) != 0) {
            if (starrefCommissionPermille == null) throwNullFieldException("starrefCommissionPermille", flags);
            size += SIZE_INT32;
        }
        if ((flags & 131072) != 0) {
            if (starrefPeer == null) throwNullFieldException("starrefPeer", flags);
            size += starrefPeer.computeSerializedSize();
        }
        if ((flags & 131072) != 0) {
            if (starrefAmount == null) throwNullFieldException("starrefAmount", flags);
            size += starrefAmount.computeSerializedSize();
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

    public boolean getRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public boolean getFailed() {
        return failed;
    }

    public void setFailed(boolean failed) {
        this.failed = failed;
    }

    public boolean getGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public boolean getReaction() {
        return reaction;
    }

    public void setReaction(boolean reaction) {
        this.reaction = reaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TLStarsAmount getStars() {
        return stars;
    }

    public void setStars(TLStarsAmount stars) {
        this.stars = stars;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsStarsTransactionPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsStarsTransactionPeer peer) {
        this.peer = peer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TLAbsWebDocument getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsWebDocument photo) {
        this.photo = photo;
    }

    public Integer getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Integer transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionUrl() {
        return transactionUrl;
    }

    public void setTransactionUrl(String transactionUrl) {
        this.transactionUrl = transactionUrl;
    }

    public TLBytes getBotPayload() {
        return botPayload;
    }

    public void setBotPayload(TLBytes botPayload) {
        this.botPayload = botPayload;
    }

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public TLVector<TLAbsMessageMedia> getExtendedMedia() {
        return extendedMedia;
    }

    public void setExtendedMedia(TLVector<TLAbsMessageMedia> extendedMedia) {
        this.extendedMedia = extendedMedia;
    }

    public Integer getSubscriptionPeriod() {
        return subscriptionPeriod;
    }

    public void setSubscriptionPeriod(Integer subscriptionPeriod) {
        this.subscriptionPeriod = subscriptionPeriod;
    }

    public Integer getGiveawayPostId() {
        return giveawayPostId;
    }

    public void setGiveawayPostId(Integer giveawayPostId) {
        this.giveawayPostId = giveawayPostId;
    }

    public TLStarGift getStargift() {
        return stargift;
    }

    public void setStargift(TLStarGift stargift) {
        this.stargift = stargift;
    }

    public Integer getFloodskipNumber() {
        return floodskipNumber;
    }

    public void setFloodskipNumber(Integer floodskipNumber) {
        this.floodskipNumber = floodskipNumber;
    }

    public Integer getStarrefCommissionPermille() {
        return starrefCommissionPermille;
    }

    public void setStarrefCommissionPermille(Integer starrefCommissionPermille) {
        this.starrefCommissionPermille = starrefCommissionPermille;
    }

    public TLAbsPeer getStarrefPeer() {
        return starrefPeer;
    }

    public void setStarrefPeer(TLAbsPeer starrefPeer) {
        this.starrefPeer = starrefPeer;
    }

    public TLStarsAmount getStarrefAmount() {
        return starrefAmount;
    }

    public void setStarrefAmount(TLStarsAmount starrefAmount) {
        this.starrefAmount = starrefAmount;
    }
}
