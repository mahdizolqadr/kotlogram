package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUserFull extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean blocked;

    protected boolean phoneCallsAvailable;

    protected boolean phoneCallsPrivate;

    protected boolean canPinMessage;

    protected boolean hasScheduled;

    protected boolean videoCallsAvailable;

    protected boolean voiceMessagesForbidden;

    protected boolean translationsDisabled;

    protected boolean storiesPinnedAvailable;

    protected boolean blockedMyStoriesFrom;

    protected boolean wallpaperOverridden;

    protected boolean contactRequirePremium;

    protected boolean readDatesPrivate;

    protected int flags2;

    protected boolean sponsoredEnabled;

    protected boolean canViewRevenue;

    protected boolean botCanManageEmojiStatus;

    protected long id;

    protected String about;

    protected TLPeerSettings settings;

    protected TLAbsPhoto personalPhoto;

    protected TLAbsPhoto profilePhoto;

    protected TLAbsPhoto fallbackPhoto;

    protected TLPeerNotifySettings notifySettings;

    protected TLBotInfo botInfo;

    protected Integer pinnedMsgId;

    protected int commonChatsCount;

    protected Integer folderId;

    protected Integer ttlPeriod;

    protected String themeEmoticon;

    protected String privateForwardName;

    protected TLChatAdminRights botGroupAdminRights;

    protected TLChatAdminRights botBroadcastAdminRights;

    protected TLVector<TLPremiumGiftOption> premiumGifts;

    protected TLAbsWallPaper wallpaper;

    protected TLPeerStories stories;

    protected TLBusinessWorkHours businessWorkHours;

    protected TLBusinessLocation businessLocation;

    protected TLBusinessGreetingMessage businessGreetingMessage;

    protected TLBusinessAwayMessage businessAwayMessage;

    protected TLBusinessIntro businessIntro;

    protected TLBirthday birthday;

    protected Long personalChannelId;

    protected Integer personalChannelMessage;

    protected Integer stargiftsCount;

    protected TLStarRefProgram starrefProgram;

    private final String _constructor = "userFull#0";

    public TLUserFull() {
    }

    public TLUserFull(boolean blocked, boolean phoneCallsAvailable, boolean phoneCallsPrivate, boolean canPinMessage, boolean hasScheduled, boolean videoCallsAvailable, boolean voiceMessagesForbidden, boolean translationsDisabled, boolean storiesPinnedAvailable, boolean blockedMyStoriesFrom, boolean wallpaperOverridden, boolean contactRequirePremium, boolean readDatesPrivate, boolean sponsoredEnabled, boolean canViewRevenue, boolean botCanManageEmojiStatus, long id, String about, TLPeerSettings settings, TLAbsPhoto personalPhoto, TLAbsPhoto profilePhoto, TLAbsPhoto fallbackPhoto, TLPeerNotifySettings notifySettings, TLBotInfo botInfo, Integer pinnedMsgId, int commonChatsCount, Integer folderId, Integer ttlPeriod, String themeEmoticon, String privateForwardName, TLChatAdminRights botGroupAdminRights, TLChatAdminRights botBroadcastAdminRights, TLVector<TLPremiumGiftOption> premiumGifts, TLAbsWallPaper wallpaper, TLPeerStories stories, TLBusinessWorkHours businessWorkHours, TLBusinessLocation businessLocation, TLBusinessGreetingMessage businessGreetingMessage, TLBusinessAwayMessage businessAwayMessage, TLBusinessIntro businessIntro, TLBirthday birthday, Long personalChannelId, Integer personalChannelMessage, Integer stargiftsCount, TLStarRefProgram starrefProgram) {
        this.blocked = blocked;
        this.phoneCallsAvailable = phoneCallsAvailable;
        this.phoneCallsPrivate = phoneCallsPrivate;
        this.canPinMessage = canPinMessage;
        this.hasScheduled = hasScheduled;
        this.videoCallsAvailable = videoCallsAvailable;
        this.voiceMessagesForbidden = voiceMessagesForbidden;
        this.translationsDisabled = translationsDisabled;
        this.storiesPinnedAvailable = storiesPinnedAvailable;
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
        this.wallpaperOverridden = wallpaperOverridden;
        this.contactRequirePremium = contactRequirePremium;
        this.readDatesPrivate = readDatesPrivate;
        this.sponsoredEnabled = sponsoredEnabled;
        this.canViewRevenue = canViewRevenue;
        this.botCanManageEmojiStatus = botCanManageEmojiStatus;
        this.id = id;
        this.about = about;
        this.settings = settings;
        this.personalPhoto = personalPhoto;
        this.profilePhoto = profilePhoto;
        this.fallbackPhoto = fallbackPhoto;
        this.notifySettings = notifySettings;
        this.botInfo = botInfo;
        this.pinnedMsgId = pinnedMsgId;
        this.commonChatsCount = commonChatsCount;
        this.folderId = folderId;
        this.ttlPeriod = ttlPeriod;
        this.themeEmoticon = themeEmoticon;
        this.privateForwardName = privateForwardName;
        this.botGroupAdminRights = botGroupAdminRights;
        this.botBroadcastAdminRights = botBroadcastAdminRights;
        this.premiumGifts = premiumGifts;
        this.wallpaper = wallpaper;
        this.stories = stories;
        this.businessWorkHours = businessWorkHours;
        this.businessLocation = businessLocation;
        this.businessGreetingMessage = businessGreetingMessage;
        this.businessAwayMessage = businessAwayMessage;
        this.businessIntro = businessIntro;
        this.birthday = birthday;
        this.personalChannelId = personalChannelId;
        this.personalChannelMessage = personalChannelMessage;
        this.stargiftsCount = stargiftsCount;
        this.starrefProgram = starrefProgram;
    }

    private void computeFlags() {
        flags = 0;
        flags = blocked ? (flags | 1) : (flags & ~1);
        flags = phoneCallsAvailable ? (flags | 16) : (flags & ~16);
        flags = phoneCallsPrivate ? (flags | 32) : (flags & ~32);
        flags = canPinMessage ? (flags | 128) : (flags & ~128);
        flags = hasScheduled ? (flags | 4096) : (flags & ~4096);
        flags = videoCallsAvailable ? (flags | 8192) : (flags & ~8192);
        flags = voiceMessagesForbidden ? (flags | 1048576) : (flags & ~1048576);
        flags = translationsDisabled ? (flags | 8388608) : (flags & ~8388608);
        flags = storiesPinnedAvailable ? (flags | 67108864) : (flags & ~67108864);
        flags = blockedMyStoriesFrom ? (flags | 134217728) : (flags & ~134217728);
        flags = wallpaperOverridden ? (flags | 268435456) : (flags & ~268435456);
        flags = contactRequirePremium ? (flags | 536870912) : (flags & ~536870912);
        flags = readDatesPrivate ? (flags | 1073741824) : (flags & ~1073741824);
        flags = about != null ? (flags | 2) : (flags & ~2);
        flags = personalPhoto != null ? (flags | 2097152) : (flags & ~2097152);
        flags = profilePhoto != null ? (flags | 4) : (flags & ~4);
        flags = fallbackPhoto != null ? (flags | 4194304) : (flags & ~4194304);
        flags = botInfo != null ? (flags | 8) : (flags & ~8);
        flags = pinnedMsgId != null ? (flags | 64) : (flags & ~64);
        flags = folderId != null ? (flags | 2048) : (flags & ~2048);
        flags = ttlPeriod != null ? (flags | 16384) : (flags & ~16384);
        flags = themeEmoticon != null ? (flags | 32768) : (flags & ~32768);
        flags = privateForwardName != null ? (flags | 65536) : (flags & ~65536);
        flags = botGroupAdminRights != null ? (flags | 131072) : (flags & ~131072);
        flags = botBroadcastAdminRights != null ? (flags | 262144) : (flags & ~262144);
        flags = premiumGifts != null ? (flags | 524288) : (flags & ~524288);
        flags = wallpaper != null ? (flags | 16777216) : (flags & ~16777216);
        flags = stories != null ? (flags | 33554432) : (flags & ~33554432);

        // Following parameters might be forced to true by another field that updated the flags
        blocked = (flags & 1) != 0;
        phoneCallsAvailable = (flags & 16) != 0;
        phoneCallsPrivate = (flags & 32) != 0;
        canPinMessage = (flags & 128) != 0;
    }

    private void computeFlags2() {
        flags2 = 0;
        flags2 = sponsoredEnabled ? (flags2 | 128) : (flags2 & ~128);
        flags2 = canViewRevenue ? (flags2 | 512) : (flags2 & ~512);
        flags2 = botCanManageEmojiStatus ? (flags2 | 1024) : (flags2 & ~1024);
        flags2 = businessWorkHours != null ? (flags | 1) : (flags2 & ~1);
        flags2 = businessLocation != null ? (flags | 2) : (flags2 & ~2);
        flags2 = businessGreetingMessage != null ? (flags | 4) : (flags2 & ~4);
        flags2 = businessAwayMessage != null ? (flags | 8) : (flags2 & ~8);
        flags2 = businessIntro != null ? (flags | 16) : (flags2 & ~16);
        flags2 = birthday != null ? (flags | 32) : (flags2 & ~32);
        flags2 = personalChannelId != null ? (flags | 64) : (flags2 & ~64);
        flags2 = personalChannelMessage != null ? (flags | 64) : (flags2 & ~64);
        flags2 = stargiftsCount != null ? (flags | 256) : (flags2 & ~256);
        flags2 = starrefProgram != null ? (flags | 2048) : (flags2 & ~2048);

        // Following parameters might be forced to true by another field that updated the flags
        sponsoredEnabled = (flags2 & 128) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        computeFlags2();

        writeInt(flags, stream);
        writeInt(flags2, stream);
        writeLong(id, stream);
        if ((flags & 2) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        writeTLObject(settings, stream);
        if ((flags & 2097152) != 0) {
            if (personalPhoto == null) throwNullFieldException("personalPhoto", flags);
            writeTLObject(personalPhoto, stream);
        }
        if ((flags & 4) != 0) {
            if (profilePhoto == null) throwNullFieldException("profilePhoto", flags);
            writeTLObject(profilePhoto, stream);
        }
        if ((flags & 4194304) != 0) {
            if (fallbackPhoto == null) throwNullFieldException("fallbackPhoto", flags);
            writeTLObject(fallbackPhoto, stream);
        }
        writeTLObject(notifySettings, stream);
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            writeTLObject(botInfo, stream);
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            writeInt(pinnedMsgId, stream);
        }
        writeInt(commonChatsCount, stream);
        if ((flags & 2048) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
        if ((flags & 32768) != 0) {
            if (themeEmoticon == null) throwNullFieldException("themeEmoticon", flags);
            writeString(themeEmoticon, stream);
        }
        if ((flags & 65536) != 0) {
            if (privateForwardName == null) throwNullFieldException("privateForwardName", flags);
            writeString(privateForwardName, stream);
        }
        if ((flags & 131072) != 0) {
            if (botGroupAdminRights == null) throwNullFieldException("botGroupAdminRights", flags);
            writeTLObject(botGroupAdminRights, stream);
        }
        if ((flags & 262144) != 0) {
            if (botBroadcastAdminRights == null) throwNullFieldException("botBroadcastAdminRights", flags);
            writeTLObject(botBroadcastAdminRights, stream);
        }
        if ((flags & 524288) != 0) {
            if (premiumGifts == null) throwNullFieldException("premiumGifts", flags);
            writeTLVector(premiumGifts, stream);
        }
        if ((flags & 16777216) != 0) {
            if (wallpaper == null) throwNullFieldException("wallpaper", flags);
            writeTLObject(wallpaper, stream);
        }
        if ((flags & 33554432) != 0) {
            if (stories == null) throwNullFieldException("stories", flags);
            writeTLObject(stories, stream);
        }
        if ((flags2 & 1) != 0) {
            if (businessWorkHours == null) throwNullFieldException("businessWorkHours", flags2);
            writeTLObject(businessWorkHours, stream);
        }
        if ((flags2 & 2) != 0) {
            if (businessLocation == null) throwNullFieldException("businessLocation", flags2);
            writeTLObject(businessLocation, stream);
        }
        if ((flags2 & 4) != 0) {
            if (businessGreetingMessage == null) throwNullFieldException("businessGreetingMessage", flags2);
            writeTLObject(businessGreetingMessage, stream);
        }
        if ((flags2 & 8) != 0) {
            if (businessAwayMessage == null) throwNullFieldException("businessAwayMessage", flags2);
            writeTLObject(businessAwayMessage, stream);
        }
        if ((flags2 & 16) != 0) {
            if (businessIntro == null) throwNullFieldException("businessIntro", flags2);
            writeTLObject(businessIntro, stream);
        }
        if ((flags2 & 32) != 0) {
            if (birthday == null) throwNullFieldException("birthday", flags2);
            writeTLObject(birthday, stream);
        }
        if ((flags2 & 64) != 0) {
            if (personalChannelId == null) throwNullFieldException("personalChannelId", flags2);
            writeLong(personalChannelId, stream);
        }
        if ((flags2 & 64) != 0) {
            if (personalChannelMessage == null) throwNullFieldException("personalChannelMessage", flags2);
            writeInt(personalChannelMessage, stream);
        }
        if ((flags2 & 256) != 0) {
            if (stargiftsCount == null) throwNullFieldException("stargiftsCount", flags2);
            writeInt(stargiftsCount, stream);
        }
        if ((flags2 & 2048) != 0) {
            if (starrefProgram == null) throwNullFieldException("starrefProgram", flags2);
            writeTLObject(starrefProgram, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blocked = (flags & 1) != 0;
        phoneCallsAvailable = (flags & 16) != 0;
        phoneCallsPrivate = (flags & 32) != 0;
        canPinMessage = (flags & 128) != 0;
        hasScheduled = (flags & 4096) != 0;
        videoCallsAvailable = (flags & 8192) != 0;
        voiceMessagesForbidden = (flags & 1048576) != 0;
        translationsDisabled = (flags & 8388608) != 0;
        storiesPinnedAvailable = (flags & 67108864) != 0;
        blockedMyStoriesFrom = (flags & 134217728) != 0;
        wallpaperOverridden = (flags & 268435456) != 0;
        contactRequirePremium = (flags & 536870912) != 0;
        readDatesPrivate = (flags & 1073741824) != 0;
        flags2 = readInt(stream);
        sponsoredEnabled = (flags2 & 128) != 0;
        canViewRevenue = (flags2 & 512) != 0;
        botCanManageEmojiStatus = (flags2 & 1024) != 0;
        id = readLong(stream);
        about = (flags & 2) != 0 ? readTLString(stream) : null;
        settings = readTLObject(stream, context, TLPeerSettings.class, TLPeerSettings.CONSTRUCTOR_ID);
        personalPhoto = (flags & 2097152) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        profilePhoto = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        fallbackPhoto = (flags & 4194304) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
        botInfo = (flags & 8) != 0 ? readTLObject(stream, context, TLBotInfo.class, TLBotInfo.CONSTRUCTOR_ID) : null;
        pinnedMsgId = (flags & 64) != 0 ? readInt(stream) : null;
        commonChatsCount = readInt(stream);
        folderId = (flags & 2048) != 0 ? readInt(stream) : null;
        ttlPeriod = (flags & 16384) != 0 ? readInt(stream) : null;
        themeEmoticon = (flags & 32768) != 0 ? readTLString(stream) : null;
        privateForwardName = (flags & 65536) != 0 ? readTLString(stream) : null;
        botGroupAdminRights = (flags & 131072) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
        botBroadcastAdminRights = (flags & 262144) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
        premiumGifts = (flags & 524288) != 0 ? readTLVector(stream, context) : null;
        wallpaper = (flags & 16777216) != 0 ? readTLObject(stream, context, TLAbsWallPaper.class, -1) : null;
        stories = (flags & 33554432) != 0 ? readTLObject(stream, context, TLPeerStories.class, TLPeerStories.CONSTRUCTOR_ID) : null;
        businessWorkHours = (flags2 & 1) != 0 ? readTLObject(stream, context, TLBusinessWorkHours.class, TLBusinessWorkHours.CONSTRUCTOR_ID) : null;
        businessLocation = (flags2 & 2) != 0 ? readTLObject(stream, context, TLBusinessLocation.class, TLBusinessLocation.CONSTRUCTOR_ID) : null;
        businessGreetingMessage = (flags2 & 4) != 0 ? readTLObject(stream, context, TLBusinessGreetingMessage.class, TLBusinessGreetingMessage.CONSTRUCTOR_ID) : null;
        businessAwayMessage = (flags2 & 8) != 0 ? readTLObject(stream, context, TLBusinessAwayMessage.class, TLBusinessAwayMessage.CONSTRUCTOR_ID) : null;
        businessIntro = (flags2 & 16) != 0 ? readTLObject(stream, context, TLBusinessIntro.class, TLBusinessIntro.CONSTRUCTOR_ID) : null;
        birthday = (flags2 & 32) != 0 ? readTLObject(stream, context, TLBirthday.class, TLBirthday.CONSTRUCTOR_ID) : null;
        personalChannelId = (flags2 & 64) != 0 ? readLong(stream) : null;
        personalChannelMessage = (flags2 & 64) != 0 ? readInt(stream) : null;
        stargiftsCount = (flags2 & 256) != 0 ? readInt(stream) : null;
        starrefProgram = (flags2 & 2048) != 0 ? readTLObject(stream, context, TLStarRefProgram.class, TLStarRefProgram.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        computeFlags2();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        size += settings.computeSerializedSize();
        if ((flags & 2097152) != 0) {
            if (personalPhoto == null) throwNullFieldException("personalPhoto", flags);
            size += personalPhoto.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (profilePhoto == null) throwNullFieldException("profilePhoto", flags);
            size += profilePhoto.computeSerializedSize();
        }
        if ((flags & 4194304) != 0) {
            if (fallbackPhoto == null) throwNullFieldException("fallbackPhoto", flags);
            size += fallbackPhoto.computeSerializedSize();
        }
        size += notifySettings.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            size += botInfo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        if ((flags & 2048) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32768) != 0) {
            if (themeEmoticon == null) throwNullFieldException("themeEmoticon", flags);
            size += computeTLStringSerializedSize(themeEmoticon);
        }
        if ((flags & 65536) != 0) {
            if (privateForwardName == null) throwNullFieldException("privateForwardName", flags);
            size += computeTLStringSerializedSize(privateForwardName);
        }
        if ((flags & 131072) != 0) {
            if (botGroupAdminRights == null) throwNullFieldException("botGroupAdminRights", flags);
            size += botGroupAdminRights.computeSerializedSize();
        }
        if ((flags & 262144) != 0) {
            if (botBroadcastAdminRights == null) throwNullFieldException("botBroadcastAdminRights", flags);
            size += botBroadcastAdminRights.computeSerializedSize();
        }
        if ((flags & 524288) != 0) {
            if (premiumGifts == null) throwNullFieldException("premiumGifts", flags);
            size += premiumGifts.computeSerializedSize();
        }
        if ((flags & 16777216) != 0) {
            if (wallpaper == null) throwNullFieldException("wallpaper", flags);
            size += wallpaper.computeSerializedSize();
        }
        if ((flags & 33554432) != 0) {
            if (stories == null) throwNullFieldException("stories", flags);
            size += stories.computeSerializedSize();
        }
        if ((flags2 & 1) != 0) {
            if (businessWorkHours == null) throwNullFieldException("businessWorkHours", flags2);
            size += businessWorkHours.computeSerializedSize();
        }
        if ((flags2 & 2) != 0) {
            if (businessLocation == null) throwNullFieldException("businessLocation", flags2);
            size += businessLocation.computeSerializedSize();
        }
        if ((flags2 & 4) != 0) {
            if (businessGreetingMessage == null) throwNullFieldException("businessGreetingMessage", flags2);
            size += businessGreetingMessage.computeSerializedSize();
        }
        if ((flags2 & 8) != 0) {
            if (businessAwayMessage == null) throwNullFieldException("businessAwayMessage", flags2);
            size += businessAwayMessage.computeSerializedSize();
        }
        if ((flags2 & 16) != 0) {
            if (businessIntro == null) throwNullFieldException("businessIntro", flags2);
            size += businessIntro.computeSerializedSize();
        }
        if ((flags2 & 32) != 0) {
            if (birthday == null) throwNullFieldException("birthday", flags2);
            size += birthday.computeSerializedSize();
        }
        if ((flags2 & 64) != 0) {
            if (personalChannelId == null) throwNullFieldException("personalChannelId", flags2);
            size += SIZE_INT64;
        }
        if ((flags2 & 64) != 0) {
            if (personalChannelMessage == null) throwNullFieldException("personalChannelMessage", flags2);
            size += SIZE_INT32;
        }
        if ((flags2 & 256) != 0) {
            if (stargiftsCount == null) throwNullFieldException("stargiftsCount", flags2);
            size += SIZE_INT32;
        }
        if ((flags2 & 2048) != 0) {
            if (starrefProgram == null) throwNullFieldException("starrefProgram", flags2);
            size += starrefProgram.computeSerializedSize();
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

    public boolean getBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public boolean getPhoneCallsAvailable() {
        return phoneCallsAvailable;
    }

    public void setPhoneCallsAvailable(boolean phoneCallsAvailable) {
        this.phoneCallsAvailable = phoneCallsAvailable;
    }

    public boolean getPhoneCallsPrivate() {
        return phoneCallsPrivate;
    }

    public void setPhoneCallsPrivate(boolean phoneCallsPrivate) {
        this.phoneCallsPrivate = phoneCallsPrivate;
    }

    public boolean getCanPinMessage() {
        return canPinMessage;
    }

    public void setCanPinMessage(boolean canPinMessage) {
        this.canPinMessage = canPinMessage;
    }

    public boolean getHasScheduled() {
        return hasScheduled;
    }

    public void setHasScheduled(boolean hasScheduled) {
        this.hasScheduled = hasScheduled;
    }

    public boolean getVideoCallsAvailable() {
        return videoCallsAvailable;
    }

    public void setVideoCallsAvailable(boolean videoCallsAvailable) {
        this.videoCallsAvailable = videoCallsAvailable;
    }

    public boolean getVoiceMessagesForbidden() {
        return voiceMessagesForbidden;
    }

    public void setVoiceMessagesForbidden(boolean voiceMessagesForbidden) {
        this.voiceMessagesForbidden = voiceMessagesForbidden;
    }

    public boolean getTranslationsDisabled() {
        return translationsDisabled;
    }

    public void setTranslationsDisabled(boolean translationsDisabled) {
        this.translationsDisabled = translationsDisabled;
    }

    public boolean getStoriesPinnedAvailable() {
        return storiesPinnedAvailable;
    }

    public void setStoriesPinnedAvailable(boolean storiesPinnedAvailable) {
        this.storiesPinnedAvailable = storiesPinnedAvailable;
    }

    public boolean getBlockedMyStoriesFrom() {
        return blockedMyStoriesFrom;
    }

    public void setBlockedMyStoriesFrom(boolean blockedMyStoriesFrom) {
        this.blockedMyStoriesFrom = blockedMyStoriesFrom;
    }

    public boolean getWallpaperOverridden() {
        return wallpaperOverridden;
    }

    public void setWallpaperOverridden(boolean wallpaperOverridden) {
        this.wallpaperOverridden = wallpaperOverridden;
    }

    public boolean getContactRequirePremium() {
        return contactRequirePremium;
    }

    public void setContactRequirePremium(boolean contactRequirePremium) {
        this.contactRequirePremium = contactRequirePremium;
    }

    public boolean getReadDatesPrivate() {
        return readDatesPrivate;
    }

    public void setReadDatesPrivate(boolean readDatesPrivate) {
        this.readDatesPrivate = readDatesPrivate;
    }

    public boolean getSponsoredEnabled() {
        return sponsoredEnabled;
    }

    public void setSponsoredEnabled(boolean sponsoredEnabled) {
        this.sponsoredEnabled = sponsoredEnabled;
    }

    public boolean getCanViewRevenue() {
        return canViewRevenue;
    }

    public void setCanViewRevenue(boolean canViewRevenue) {
        this.canViewRevenue = canViewRevenue;
    }

    public boolean getBotCanManageEmojiStatus() {
        return botCanManageEmojiStatus;
    }

    public void setBotCanManageEmojiStatus(boolean botCanManageEmojiStatus) {
        this.botCanManageEmojiStatus = botCanManageEmojiStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public TLPeerSettings getSettings() {
        return settings;
    }

    public void setSettings(TLPeerSettings settings) {
        this.settings = settings;
    }

    public TLAbsPhoto getPersonalPhoto() {
        return personalPhoto;
    }

    public void setPersonalPhoto(TLAbsPhoto personalPhoto) {
        this.personalPhoto = personalPhoto;
    }

    public TLAbsPhoto getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(TLAbsPhoto profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public TLAbsPhoto getFallbackPhoto() {
        return fallbackPhoto;
    }

    public void setFallbackPhoto(TLAbsPhoto fallbackPhoto) {
        this.fallbackPhoto = fallbackPhoto;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public TLBotInfo getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLBotInfo botInfo) {
        this.botInfo = botInfo;
    }

    public Integer getPinnedMsgId() {
        return pinnedMsgId;
    }

    public void setPinnedMsgId(Integer pinnedMsgId) {
        this.pinnedMsgId = pinnedMsgId;
    }

    public int getCommonChatsCount() {
        return commonChatsCount;
    }

    public void setCommonChatsCount(int commonChatsCount) {
        this.commonChatsCount = commonChatsCount;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }

    public String getThemeEmoticon() {
        return themeEmoticon;
    }

    public void setThemeEmoticon(String themeEmoticon) {
        this.themeEmoticon = themeEmoticon;
    }

    public String getPrivateForwardName() {
        return privateForwardName;
    }

    public void setPrivateForwardName(String privateForwardName) {
        this.privateForwardName = privateForwardName;
    }

    public TLChatAdminRights getBotGroupAdminRights() {
        return botGroupAdminRights;
    }

    public void setBotGroupAdminRights(TLChatAdminRights botGroupAdminRights) {
        this.botGroupAdminRights = botGroupAdminRights;
    }

    public TLChatAdminRights getBotBroadcastAdminRights() {
        return botBroadcastAdminRights;
    }

    public void setBotBroadcastAdminRights(TLChatAdminRights botBroadcastAdminRights) {
        this.botBroadcastAdminRights = botBroadcastAdminRights;
    }

    public TLVector<TLPremiumGiftOption> getPremiumGifts() {
        return premiumGifts;
    }

    public void setPremiumGifts(TLVector<TLPremiumGiftOption> premiumGifts) {
        this.premiumGifts = premiumGifts;
    }

    public TLAbsWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    public TLPeerStories getStories() {
        return stories;
    }

    public void setStories(TLPeerStories stories) {
        this.stories = stories;
    }

    public TLBusinessWorkHours getBusinessWorkHours() {
        return businessWorkHours;
    }

    public void setBusinessWorkHours(TLBusinessWorkHours businessWorkHours) {
        this.businessWorkHours = businessWorkHours;
    }

    public TLBusinessLocation getBusinessLocation() {
        return businessLocation;
    }

    public void setBusinessLocation(TLBusinessLocation businessLocation) {
        this.businessLocation = businessLocation;
    }

    public TLBusinessGreetingMessage getBusinessGreetingMessage() {
        return businessGreetingMessage;
    }

    public void setBusinessGreetingMessage(TLBusinessGreetingMessage businessGreetingMessage) {
        this.businessGreetingMessage = businessGreetingMessage;
    }

    public TLBusinessAwayMessage getBusinessAwayMessage() {
        return businessAwayMessage;
    }

    public void setBusinessAwayMessage(TLBusinessAwayMessage businessAwayMessage) {
        this.businessAwayMessage = businessAwayMessage;
    }

    public TLBusinessIntro getBusinessIntro() {
        return businessIntro;
    }

    public void setBusinessIntro(TLBusinessIntro businessIntro) {
        this.businessIntro = businessIntro;
    }

    public TLBirthday getBirthday() {
        return birthday;
    }

    public void setBirthday(TLBirthday birthday) {
        this.birthday = birthday;
    }

    public Long getPersonalChannelId() {
        return personalChannelId;
    }

    public void setPersonalChannelId(Long personalChannelId) {
        this.personalChannelId = personalChannelId;
    }

    public Integer getPersonalChannelMessage() {
        return personalChannelMessage;
    }

    public void setPersonalChannelMessage(Integer personalChannelMessage) {
        this.personalChannelMessage = personalChannelMessage;
    }

    public Integer getStargiftsCount() {
        return stargiftsCount;
    }

    public void setStargiftsCount(Integer stargiftsCount) {
        this.stargiftsCount = stargiftsCount;
    }

    public TLStarRefProgram getStarrefProgram() {
        return starrefProgram;
    }

    public void setStarrefProgram(TLStarRefProgram starrefProgram) {
        this.starrefProgram = starrefProgram;
    }
}
