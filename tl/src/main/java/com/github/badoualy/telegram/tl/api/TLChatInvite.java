package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLChatInvite extends TLAbsChatInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean channel;

    protected boolean broadcast;

    protected boolean _public;

    protected boolean megagroup;

    protected boolean requestNeeded;

    protected boolean verified;

    protected boolean scam;

    protected boolean fake;

    protected boolean canRefulfillSubscription;

    protected String title;

    protected String about;

    protected TLAbsPhoto photo;

    protected int participantsCount;

    protected TLVector<TLAbsUser> participants;

    protected int color;

    protected TLStarsSubscriptionPricing subscriptionPricing;

    protected Long subscriptionFormId;

    private final String _constructor = "chatInvite#0";

    public TLChatInvite() {
    }

    public TLChatInvite(boolean channel, boolean broadcast, boolean _public, boolean megagroup, boolean requestNeeded, boolean verified, boolean scam, boolean fake, boolean canRefulfillSubscription, String title, String about, TLAbsPhoto photo, int participantsCount, TLVector<TLAbsUser> participants, int color, TLStarsSubscriptionPricing subscriptionPricing, Long subscriptionFormId) {
        this.channel = channel;
        this.broadcast = broadcast;
        this._public = _public;
        this.megagroup = megagroup;
        this.requestNeeded = requestNeeded;
        this.verified = verified;
        this.scam = scam;
        this.fake = fake;
        this.canRefulfillSubscription = canRefulfillSubscription;
        this.title = title;
        this.about = about;
        this.photo = photo;
        this.participantsCount = participantsCount;
        this.participants = participants;
        this.color = color;
        this.subscriptionPricing = subscriptionPricing;
        this.subscriptionFormId = subscriptionFormId;
    }

    private void computeFlags() {
        flags = 0;
        flags = channel ? (flags | 1) : (flags & ~1);
        flags = broadcast ? (flags | 2) : (flags & ~2);
        flags = _public ? (flags | 4) : (flags & ~4);
        flags = megagroup ? (flags | 8) : (flags & ~8);
        flags = requestNeeded ? (flags | 64) : (flags & ~64);
        flags = verified ? (flags | 128) : (flags & ~128);
        flags = scam ? (flags | 256) : (flags & ~256);
        flags = fake ? (flags | 512) : (flags & ~512);
        flags = canRefulfillSubscription ? (flags | 2048) : (flags & ~2048);
        flags = about != null ? (flags | 32) : (flags & ~32);
        flags = participants != null ? (flags | 16) : (flags & ~16);
        flags = subscriptionPricing != null ? (flags | 1024) : (flags & ~1024);
        flags = subscriptionFormId != null ? (flags | 4096) : (flags & ~4096);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        if ((flags & 32) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        writeTLObject(photo, stream);
        writeInt(participantsCount, stream);
        if ((flags & 16) != 0) {
            if (participants == null) throwNullFieldException("participants", flags);
            writeTLVector(participants, stream);
        }
        writeInt(color, stream);
        if ((flags & 1024) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            writeTLObject(subscriptionPricing, stream);
        }
        if ((flags & 4096) != 0) {
            if (subscriptionFormId == null) throwNullFieldException("subscriptionFormId", flags);
            writeLong(subscriptionFormId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        channel = (flags & 1) != 0;
        broadcast = (flags & 2) != 0;
        _public = (flags & 4) != 0;
        megagroup = (flags & 8) != 0;
        requestNeeded = (flags & 64) != 0;
        verified = (flags & 128) != 0;
        scam = (flags & 256) != 0;
        fake = (flags & 512) != 0;
        canRefulfillSubscription = (flags & 2048) != 0;
        title = readTLString(stream);
        about = (flags & 32) != 0 ? readTLString(stream) : null;
        photo = readTLObject(stream, context, TLAbsPhoto.class, -1);
        participantsCount = readInt(stream);
        participants = (flags & 16) != 0 ? readTLVector(stream, context) : null;
        color = readInt(stream);
        subscriptionPricing = (flags & 1024) != 0 ? readTLObject(stream, context, TLStarsSubscriptionPricing.class, TLStarsSubscriptionPricing.CONSTRUCTOR_ID) : null;
        subscriptionFormId = (flags & 4096) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        if ((flags & 32) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 16) != 0) {
            if (participants == null) throwNullFieldException("participants", flags);
            size += participants.computeSerializedSize();
        }
        size += SIZE_INT32;
        if ((flags & 1024) != 0) {
            if (subscriptionPricing == null) throwNullFieldException("subscriptionPricing", flags);
            size += subscriptionPricing.computeSerializedSize();
        }
        if ((flags & 4096) != 0) {
            if (subscriptionFormId == null) throwNullFieldException("subscriptionFormId", flags);
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

    public boolean getChannel() {
        return channel;
    }

    public void setChannel(boolean channel) {
        this.channel = channel;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean getPublic() {
        return _public;
    }

    public void setPublic(boolean _public) {
        this._public = _public;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean megagroup) {
        this.megagroup = megagroup;
    }

    public boolean getRequestNeeded() {
        return requestNeeded;
    }

    public void setRequestNeeded(boolean requestNeeded) {
        this.requestNeeded = requestNeeded;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getScam() {
        return scam;
    }

    public void setScam(boolean scam) {
        this.scam = scam;
    }

    public boolean getFake() {
        return fake;
    }

    public void setFake(boolean fake) {
        this.fake = fake;
    }

    public boolean getCanRefulfillSubscription() {
        return canRefulfillSubscription;
    }

    public void setCanRefulfillSubscription(boolean canRefulfillSubscription) {
        this.canRefulfillSubscription = canRefulfillSubscription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public TLVector<TLAbsUser> getParticipants() {
        return participants;
    }

    public void setParticipants(TLVector<TLAbsUser> participants) {
        this.participants = participants;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public TLStarsSubscriptionPricing getSubscriptionPricing() {
        return subscriptionPricing;
    }

    public void setSubscriptionPricing(TLStarsSubscriptionPricing subscriptionPricing) {
        this.subscriptionPricing = subscriptionPricing;
    }

    public Long getSubscriptionFormId() {
        return subscriptionFormId;
    }

    public void setSubscriptionFormId(Long subscriptionFormId) {
        this.subscriptionFormId = subscriptionFormId;
    }
}
