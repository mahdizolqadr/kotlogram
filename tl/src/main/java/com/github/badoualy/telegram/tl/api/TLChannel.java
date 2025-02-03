package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLChannel extends TLAbsChat {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean creator;

    protected boolean left;

    protected boolean broadcast;

    protected boolean verified;

    protected boolean megagroup;

    protected boolean restricted;

    protected boolean signatures;

    protected boolean min;

    protected boolean scam;

    protected boolean hasLink;

    protected boolean hasGeo;

    protected boolean slowmodeEnabled;

    protected boolean callActive;

    protected boolean callNotEmpty;

    protected boolean fake;

    protected boolean gigagroup;

    protected boolean noforwards;

    protected boolean joinToSend;

    protected boolean joinRequest;

    protected boolean forum;

    protected int flags2;

    protected boolean storiesHidden;

    protected boolean storiesHiddenMin;

    protected boolean storiesUnavailable;

    protected boolean signatureProfiles;

    protected Long accessHash;

    protected String title;

    protected String username;

    protected TLAbsChatPhoto photo;

    protected int date;

    protected TLVector<TLRestrictionReason> restrictionReason;

    protected TLChatAdminRights adminRights;

    protected TLChatBannedRights bannedRights;

    protected TLChatBannedRights defaultBannedRights;

    protected Integer participantsCount;

    protected TLVector<TLUsername> usernames;

    protected Integer storiesMaxId;

    protected TLPeerColor color;

    protected TLPeerColor profileColor;

    protected TLAbsEmojiStatus emojiStatus;

    protected Integer level;

    protected Integer subscriptionUntilDate;

    private final String _constructor = "channel#0";

    public TLChannel() {
    }

    public TLChannel(boolean creator, boolean left, boolean broadcast, boolean verified, boolean megagroup, boolean restricted, boolean signatures, boolean min, boolean scam, boolean hasLink, boolean hasGeo, boolean slowmodeEnabled, boolean callActive, boolean callNotEmpty, boolean fake, boolean gigagroup, boolean noforwards, boolean joinToSend, boolean joinRequest, boolean forum, boolean storiesHidden, boolean storiesHiddenMin, boolean storiesUnavailable, boolean signatureProfiles, long id, Long accessHash, String title, String username, TLAbsChatPhoto photo, int date, TLVector<TLRestrictionReason> restrictionReason, TLChatAdminRights adminRights, TLChatBannedRights bannedRights, TLChatBannedRights defaultBannedRights, Integer participantsCount, TLVector<TLUsername> usernames, Integer storiesMaxId, TLPeerColor color, TLPeerColor profileColor, TLAbsEmojiStatus emojiStatus, Integer level, Integer subscriptionUntilDate) {
        this.creator = creator;
        this.left = left;
        this.broadcast = broadcast;
        this.verified = verified;
        this.megagroup = megagroup;
        this.restricted = restricted;
        this.signatures = signatures;
        this.min = min;
        this.scam = scam;
        this.hasLink = hasLink;
        this.hasGeo = hasGeo;
        this.slowmodeEnabled = slowmodeEnabled;
        this.callActive = callActive;
        this.callNotEmpty = callNotEmpty;
        this.fake = fake;
        this.gigagroup = gigagroup;
        this.noforwards = noforwards;
        this.joinToSend = joinToSend;
        this.joinRequest = joinRequest;
        this.forum = forum;
        this.storiesHidden = storiesHidden;
        this.storiesHiddenMin = storiesHiddenMin;
        this.storiesUnavailable = storiesUnavailable;
        this.signatureProfiles = signatureProfiles;
        this.id = id;
        this.accessHash = accessHash;
        this.title = title;
        this.username = username;
        this.photo = photo;
        this.date = date;
        this.restrictionReason = restrictionReason;
        this.adminRights = adminRights;
        this.bannedRights = bannedRights;
        this.defaultBannedRights = defaultBannedRights;
        this.participantsCount = participantsCount;
        this.usernames = usernames;
        this.storiesMaxId = storiesMaxId;
        this.color = color;
        this.profileColor = profileColor;
        this.emojiStatus = emojiStatus;
        this.level = level;
        this.subscriptionUntilDate = subscriptionUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = left ? (flags | 4) : (flags & ~4);
        flags = broadcast ? (flags | 32) : (flags & ~32);
        flags = verified ? (flags | 128) : (flags & ~128);
        flags = megagroup ? (flags | 256) : (flags & ~256);
        flags = restricted ? (flags | 512) : (flags & ~512);
        flags = signatures ? (flags | 2048) : (flags & ~2048);
        flags = min ? (flags | 4096) : (flags & ~4096);
        flags = scam ? (flags | 524288) : (flags & ~524288);
        flags = hasLink ? (flags | 1048576) : (flags & ~1048576);
        flags = hasGeo ? (flags | 2097152) : (flags & ~2097152);
        flags = slowmodeEnabled ? (flags | 4194304) : (flags & ~4194304);
        flags = callActive ? (flags | 8388608) : (flags & ~8388608);
        flags = callNotEmpty ? (flags | 16777216) : (flags & ~16777216);
        flags = fake ? (flags | 33554432) : (flags & ~33554432);
        flags = gigagroup ? (flags | 67108864) : (flags & ~67108864);
        flags = noforwards ? (flags | 134217728) : (flags & ~134217728);
        flags = joinToSend ? (flags | 268435456) : (flags & ~268435456);
        flags = joinRequest ? (flags | 536870912) : (flags & ~536870912);
        flags = forum ? (flags | 1073741824) : (flags & ~1073741824);
        flags = accessHash != null ? (flags | 8192) : (flags & ~8192);
        flags = username != null ? (flags | 64) : (flags & ~64);
        flags = restrictionReason != null ? (flags | 512) : (flags & ~512);
        flags = adminRights != null ? (flags | 16384) : (flags & ~16384);
        flags = bannedRights != null ? (flags | 32768) : (flags & ~32768);
        flags = defaultBannedRights != null ? (flags | 262144) : (flags & ~262144);
        flags = participantsCount != null ? (flags | 131072) : (flags & ~131072);

        // Following parameters might be forced to true by another field that updated the flags
        creator = (flags & 1) != 0;
        left = (flags & 4) != 0;
        verified = (flags & 128) != 0;
        megagroup = (flags & 256) != 0;
        restricted = (flags & 512) != 0;
        signatures = (flags & 2048) != 0;
        min = (flags & 4096) != 0;
    }

    private void computeFlags2() {
        flags2 = 0;
        flags2 = storiesHidden ? (flags2 | 2) : (flags2 & ~2);
        flags2 = storiesHiddenMin ? (flags2 | 4) : (flags2 & ~4);
        flags2 = storiesUnavailable ? (flags2 | 8) : (flags2 & ~8);
        flags2 = signatureProfiles ? (flags2 | 4096) : (flags2 & ~4096);
        flags2 = usernames != null ? (flags | 1) : (flags2 & ~1);
        flags2 = storiesMaxId != null ? (flags | 16) : (flags2 & ~16);
        flags2 = color != null ? (flags | 128) : (flags2 & ~128);
        flags2 = profileColor != null ? (flags | 256) : (flags2 & ~256);
        flags2 = emojiStatus != null ? (flags | 512) : (flags2 & ~512);
        flags2 = level != null ? (flags | 1024) : (flags2 & ~1024);
        flags2 = subscriptionUntilDate != null ? (flags | 2048) : (flags2 & ~2048);

        // Following parameters might be forced to true by another field that updated the flags
        storiesHiddenMin = (flags2 & 4) != 0;
        signatureProfiles = (flags2 & 4096) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        computeFlags2();

        writeInt(flags, stream);
        writeInt(flags2, stream);
        writeLong(id, stream);
        if ((flags & 8192) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            writeLong(accessHash, stream);
        }
        writeString(title, stream);
        if ((flags & 64) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            writeString(username, stream);
        }
        writeTLObject(photo, stream);
        writeInt(date, stream);
        if ((flags & 512) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            writeTLVector(restrictionReason, stream);
        }
        if ((flags & 16384) != 0) {
            if (adminRights == null) throwNullFieldException("adminRights", flags);
            writeTLObject(adminRights, stream);
        }
        if ((flags & 32768) != 0) {
            if (bannedRights == null) throwNullFieldException("bannedRights", flags);
            writeTLObject(bannedRights, stream);
        }
        if ((flags & 262144) != 0) {
            if (defaultBannedRights == null) throwNullFieldException("defaultBannedRights", flags);
            writeTLObject(defaultBannedRights, stream);
        }
        if ((flags & 131072) != 0) {
            if (participantsCount == null) throwNullFieldException("participantsCount", flags);
            writeInt(participantsCount, stream);
        }
        if ((flags2 & 1) != 0) {
            if (usernames == null) throwNullFieldException("usernames", flags2);
            writeTLVector(usernames, stream);
        }
        if ((flags2 & 16) != 0) {
            if (storiesMaxId == null) throwNullFieldException("storiesMaxId", flags2);
            writeInt(storiesMaxId, stream);
        }
        if ((flags2 & 128) != 0) {
            if (color == null) throwNullFieldException("color", flags2);
            writeTLObject(color, stream);
        }
        if ((flags2 & 256) != 0) {
            if (profileColor == null) throwNullFieldException("profileColor", flags2);
            writeTLObject(profileColor, stream);
        }
        if ((flags2 & 512) != 0) {
            if (emojiStatus == null) throwNullFieldException("emojiStatus", flags2);
            writeTLObject(emojiStatus, stream);
        }
        if ((flags2 & 1024) != 0) {
            if (level == null) throwNullFieldException("level", flags2);
            writeInt(level, stream);
        }
        if ((flags2 & 2048) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags2);
            writeInt(subscriptionUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        left = (flags & 4) != 0;
        broadcast = (flags & 32) != 0;
        verified = (flags & 128) != 0;
        megagroup = (flags & 256) != 0;
        restricted = (flags & 512) != 0;
        signatures = (flags & 2048) != 0;
        min = (flags & 4096) != 0;
        scam = (flags & 524288) != 0;
        hasLink = (flags & 1048576) != 0;
        hasGeo = (flags & 2097152) != 0;
        slowmodeEnabled = (flags & 4194304) != 0;
        callActive = (flags & 8388608) != 0;
        callNotEmpty = (flags & 16777216) != 0;
        fake = (flags & 33554432) != 0;
        gigagroup = (flags & 67108864) != 0;
        noforwards = (flags & 134217728) != 0;
        joinToSend = (flags & 268435456) != 0;
        joinRequest = (flags & 536870912) != 0;
        forum = (flags & 1073741824) != 0;
        flags2 = readInt(stream);
        storiesHidden = (flags2 & 2) != 0;
        storiesHiddenMin = (flags2 & 4) != 0;
        storiesUnavailable = (flags2 & 8) != 0;
        signatureProfiles = (flags2 & 4096) != 0;
        id = readLong(stream);
        accessHash = (flags & 8192) != 0 ? readLong(stream) : null;
        title = readTLString(stream);
        username = (flags & 64) != 0 ? readTLString(stream) : null;
        photo = readTLObject(stream, context, TLAbsChatPhoto.class, -1);
        date = readInt(stream);
        restrictionReason = (flags & 512) != 0 ? readTLVector(stream, context) : null;
        adminRights = (flags & 16384) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
        bannedRights = (flags & 32768) != 0 ? readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID) : null;
        defaultBannedRights = (flags & 262144) != 0 ? readTLObject(stream, context, TLChatBannedRights.class, TLChatBannedRights.CONSTRUCTOR_ID) : null;
        participantsCount = (flags & 131072) != 0 ? readInt(stream) : null;
        usernames = (flags2 & 1) != 0 ? readTLVector(stream, context) : null;
        storiesMaxId = (flags2 & 16) != 0 ? readInt(stream) : null;
        color = (flags2 & 128) != 0 ? readTLObject(stream, context, TLPeerColor.class, TLPeerColor.CONSTRUCTOR_ID) : null;
        profileColor = (flags2 & 256) != 0 ? readTLObject(stream, context, TLPeerColor.class, TLPeerColor.CONSTRUCTOR_ID) : null;
        emojiStatus = (flags2 & 512) != 0 ? readTLObject(stream, context, TLAbsEmojiStatus.class, -1) : null;
        level = (flags2 & 1024) != 0 ? readInt(stream) : null;
        subscriptionUntilDate = (flags2 & 2048) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        computeFlags2();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 8192) != 0) {
            if (accessHash == null) throwNullFieldException("accessHash", flags);
            size += SIZE_INT64;
        }
        size += computeTLStringSerializedSize(title);
        if ((flags & 64) != 0) {
            if (username == null) throwNullFieldException("username", flags);
            size += computeTLStringSerializedSize(username);
        }
        size += photo.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 512) != 0) {
            if (restrictionReason == null) throwNullFieldException("restrictionReason", flags);
            size += restrictionReason.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (adminRights == null) throwNullFieldException("adminRights", flags);
            size += adminRights.computeSerializedSize();
        }
        if ((flags & 32768) != 0) {
            if (bannedRights == null) throwNullFieldException("bannedRights", flags);
            size += bannedRights.computeSerializedSize();
        }
        if ((flags & 262144) != 0) {
            if (defaultBannedRights == null) throwNullFieldException("defaultBannedRights", flags);
            size += defaultBannedRights.computeSerializedSize();
        }
        if ((flags & 131072) != 0) {
            if (participantsCount == null) throwNullFieldException("participantsCount", flags);
            size += SIZE_INT32;
        }
        if ((flags2 & 1) != 0) {
            if (usernames == null) throwNullFieldException("usernames", flags2);
            size += usernames.computeSerializedSize();
        }
        if ((flags2 & 16) != 0) {
            if (storiesMaxId == null) throwNullFieldException("storiesMaxId", flags2);
            size += SIZE_INT32;
        }
        if ((flags2 & 128) != 0) {
            if (color == null) throwNullFieldException("color", flags2);
            size += color.computeSerializedSize();
        }
        if ((flags2 & 256) != 0) {
            if (profileColor == null) throwNullFieldException("profileColor", flags2);
            size += profileColor.computeSerializedSize();
        }
        if ((flags2 & 512) != 0) {
            if (emojiStatus == null) throwNullFieldException("emojiStatus", flags2);
            size += emojiStatus.computeSerializedSize();
        }
        if ((flags2 & 1024) != 0) {
            if (level == null) throwNullFieldException("level", flags2);
            size += SIZE_INT32;
        }
        if ((flags2 & 2048) != 0) {
            if (subscriptionUntilDate == null) throwNullFieldException("subscriptionUntilDate", flags2);
            size += SIZE_INT32;
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

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean megagroup) {
        this.megagroup = megagroup;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public boolean getSignatures() {
        return signatures;
    }

    public void setSignatures(boolean signatures) {
        this.signatures = signatures;
    }

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getScam() {
        return scam;
    }

    public void setScam(boolean scam) {
        this.scam = scam;
    }

    public boolean getHasLink() {
        return hasLink;
    }

    public void setHasLink(boolean hasLink) {
        this.hasLink = hasLink;
    }

    public boolean getHasGeo() {
        return hasGeo;
    }

    public void setHasGeo(boolean hasGeo) {
        this.hasGeo = hasGeo;
    }

    public boolean getSlowmodeEnabled() {
        return slowmodeEnabled;
    }

    public void setSlowmodeEnabled(boolean slowmodeEnabled) {
        this.slowmodeEnabled = slowmodeEnabled;
    }

    public boolean getCallActive() {
        return callActive;
    }

    public void setCallActive(boolean callActive) {
        this.callActive = callActive;
    }

    public boolean getCallNotEmpty() {
        return callNotEmpty;
    }

    public void setCallNotEmpty(boolean callNotEmpty) {
        this.callNotEmpty = callNotEmpty;
    }

    public boolean getFake() {
        return fake;
    }

    public void setFake(boolean fake) {
        this.fake = fake;
    }

    public boolean getGigagroup() {
        return gigagroup;
    }

    public void setGigagroup(boolean gigagroup) {
        this.gigagroup = gigagroup;
    }

    public boolean getNoforwards() {
        return noforwards;
    }

    public void setNoforwards(boolean noforwards) {
        this.noforwards = noforwards;
    }

    public boolean getJoinToSend() {
        return joinToSend;
    }

    public void setJoinToSend(boolean joinToSend) {
        this.joinToSend = joinToSend;
    }

    public boolean getJoinRequest() {
        return joinRequest;
    }

    public void setJoinRequest(boolean joinRequest) {
        this.joinRequest = joinRequest;
    }

    public boolean getForum() {
        return forum;
    }

    public void setForum(boolean forum) {
        this.forum = forum;
    }

    public boolean getStoriesHidden() {
        return storiesHidden;
    }

    public void setStoriesHidden(boolean storiesHidden) {
        this.storiesHidden = storiesHidden;
    }

    public boolean getStoriesHiddenMin() {
        return storiesHiddenMin;
    }

    public void setStoriesHiddenMin(boolean storiesHiddenMin) {
        this.storiesHiddenMin = storiesHiddenMin;
    }

    public boolean getStoriesUnavailable() {
        return storiesUnavailable;
    }

    public void setStoriesUnavailable(boolean storiesUnavailable) {
        this.storiesUnavailable = storiesUnavailable;
    }

    public boolean getSignatureProfiles() {
        return signatureProfiles;
    }

    public void setSignatureProfiles(boolean signatureProfiles) {
        this.signatureProfiles = signatureProfiles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(Long accessHash) {
        this.accessHash = accessHash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsChatPhoto photo) {
        this.photo = photo;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLVector<TLRestrictionReason> getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(TLVector<TLRestrictionReason> restrictionReason) {
        this.restrictionReason = restrictionReason;
    }

    public TLChatAdminRights getAdminRights() {
        return adminRights;
    }

    public void setAdminRights(TLChatAdminRights adminRights) {
        this.adminRights = adminRights;
    }

    public TLChatBannedRights getBannedRights() {
        return bannedRights;
    }

    public void setBannedRights(TLChatBannedRights bannedRights) {
        this.bannedRights = bannedRights;
    }

    public TLChatBannedRights getDefaultBannedRights() {
        return defaultBannedRights;
    }

    public void setDefaultBannedRights(TLChatBannedRights defaultBannedRights) {
        this.defaultBannedRights = defaultBannedRights;
    }

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public TLVector<TLUsername> getUsernames() {
        return usernames;
    }

    public void setUsernames(TLVector<TLUsername> usernames) {
        this.usernames = usernames;
    }

    public Integer getStoriesMaxId() {
        return storiesMaxId;
    }

    public void setStoriesMaxId(Integer storiesMaxId) {
        this.storiesMaxId = storiesMaxId;
    }

    public TLPeerColor getColor() {
        return color;
    }

    public void setColor(TLPeerColor color) {
        this.color = color;
    }

    public TLPeerColor getProfileColor() {
        return profileColor;
    }

    public void setProfileColor(TLPeerColor profileColor) {
        this.profileColor = profileColor;
    }

    public TLAbsEmojiStatus getEmojiStatus() {
        return emojiStatus;
    }

    public void setEmojiStatus(TLAbsEmojiStatus emojiStatus) {
        this.emojiStatus = emojiStatus;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSubscriptionUntilDate() {
        return subscriptionUntilDate;
    }

    public void setSubscriptionUntilDate(Integer subscriptionUntilDate) {
        this.subscriptionUntilDate = subscriptionUntilDate;
    }
}
