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
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLConfig extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean defaultP2pContacts;

    protected boolean preloadFeaturedStickers;

    protected boolean revokePmInbox;

    protected boolean blockedMode;

    protected boolean forceTryIpv6;

    protected int date;

    protected int expires;

    protected boolean testMode;

    protected int thisDc;

    protected TLVector<TLDcOption> dcOptions;

    protected String dcTxtDomainName;

    protected int chatSizeMax;

    protected int megagroupSizeMax;

    protected int forwardedCountMax;

    protected int onlineUpdatePeriodMs;

    protected int offlineBlurTimeoutMs;

    protected int offlineIdleTimeoutMs;

    protected int onlineCloudTimeoutMs;

    protected int notifyCloudDelayMs;

    protected int notifyDefaultDelayMs;

    protected int pushChatPeriodMs;

    protected int pushChatLimit;

    protected int editTimeLimit;

    protected int revokeTimeLimit;

    protected int revokePmTimeLimit;

    protected int ratingEDecay;

    protected int stickersRecentLimit;

    protected int channelsReadMediaPeriod;

    protected Integer tmpSessions;

    protected int callReceiveTimeoutMs;

    protected int callRingTimeoutMs;

    protected int callConnectTimeoutMs;

    protected int callPacketTimeoutMs;

    protected String meUrlPrefix;

    protected String autoupdateUrlPrefix;

    protected String gifSearchUsername;

    protected String venueSearchUsername;

    protected String imgSearchUsername;

    protected String staticMapsProvider;

    protected int captionLengthMax;

    protected int messageLengthMax;

    protected int webfileDcId;

    protected String suggestedLangCode;

    protected Integer langPackVersion;

    protected Integer baseLangPackVersion;

    protected TLAbsReaction reactionsDefault;

    protected String autologinToken;

    private final String _constructor = "config#0";

    public TLConfig() {
    }

    public TLConfig(boolean defaultP2pContacts, boolean preloadFeaturedStickers, boolean revokePmInbox, boolean blockedMode, boolean forceTryIpv6, int date, int expires, boolean testMode, int thisDc, TLVector<TLDcOption> dcOptions, String dcTxtDomainName, int chatSizeMax, int megagroupSizeMax, int forwardedCountMax, int onlineUpdatePeriodMs, int offlineBlurTimeoutMs, int offlineIdleTimeoutMs, int onlineCloudTimeoutMs, int notifyCloudDelayMs, int notifyDefaultDelayMs, int pushChatPeriodMs, int pushChatLimit, int editTimeLimit, int revokeTimeLimit, int revokePmTimeLimit, int ratingEDecay, int stickersRecentLimit, int channelsReadMediaPeriod, Integer tmpSessions, int callReceiveTimeoutMs, int callRingTimeoutMs, int callConnectTimeoutMs, int callPacketTimeoutMs, String meUrlPrefix, String autoupdateUrlPrefix, String gifSearchUsername, String venueSearchUsername, String imgSearchUsername, String staticMapsProvider, int captionLengthMax, int messageLengthMax, int webfileDcId, String suggestedLangCode, Integer langPackVersion, Integer baseLangPackVersion, TLAbsReaction reactionsDefault, String autologinToken) {
        this.defaultP2pContacts = defaultP2pContacts;
        this.preloadFeaturedStickers = preloadFeaturedStickers;
        this.revokePmInbox = revokePmInbox;
        this.blockedMode = blockedMode;
        this.forceTryIpv6 = forceTryIpv6;
        this.date = date;
        this.expires = expires;
        this.testMode = testMode;
        this.thisDc = thisDc;
        this.dcOptions = dcOptions;
        this.dcTxtDomainName = dcTxtDomainName;
        this.chatSizeMax = chatSizeMax;
        this.megagroupSizeMax = megagroupSizeMax;
        this.forwardedCountMax = forwardedCountMax;
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
        this.notifyCloudDelayMs = notifyCloudDelayMs;
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
        this.pushChatPeriodMs = pushChatPeriodMs;
        this.pushChatLimit = pushChatLimit;
        this.editTimeLimit = editTimeLimit;
        this.revokeTimeLimit = revokeTimeLimit;
        this.revokePmTimeLimit = revokePmTimeLimit;
        this.ratingEDecay = ratingEDecay;
        this.stickersRecentLimit = stickersRecentLimit;
        this.channelsReadMediaPeriod = channelsReadMediaPeriod;
        this.tmpSessions = tmpSessions;
        this.callReceiveTimeoutMs = callReceiveTimeoutMs;
        this.callRingTimeoutMs = callRingTimeoutMs;
        this.callConnectTimeoutMs = callConnectTimeoutMs;
        this.callPacketTimeoutMs = callPacketTimeoutMs;
        this.meUrlPrefix = meUrlPrefix;
        this.autoupdateUrlPrefix = autoupdateUrlPrefix;
        this.gifSearchUsername = gifSearchUsername;
        this.venueSearchUsername = venueSearchUsername;
        this.imgSearchUsername = imgSearchUsername;
        this.staticMapsProvider = staticMapsProvider;
        this.captionLengthMax = captionLengthMax;
        this.messageLengthMax = messageLengthMax;
        this.webfileDcId = webfileDcId;
        this.suggestedLangCode = suggestedLangCode;
        this.langPackVersion = langPackVersion;
        this.baseLangPackVersion = baseLangPackVersion;
        this.reactionsDefault = reactionsDefault;
        this.autologinToken = autologinToken;
    }

    private void computeFlags() {
        flags = 0;
        flags = defaultP2pContacts ? (flags | 8) : (flags & ~8);
        flags = preloadFeaturedStickers ? (flags | 16) : (flags & ~16);
        flags = revokePmInbox ? (flags | 64) : (flags & ~64);
        flags = blockedMode ? (flags | 256) : (flags & ~256);
        flags = forceTryIpv6 ? (flags | 16384) : (flags & ~16384);
        flags = tmpSessions != null ? (flags | 1) : (flags & ~1);
        flags = autoupdateUrlPrefix != null ? (flags | 128) : (flags & ~128);
        flags = gifSearchUsername != null ? (flags | 512) : (flags & ~512);
        flags = venueSearchUsername != null ? (flags | 1024) : (flags & ~1024);
        flags = imgSearchUsername != null ? (flags | 2048) : (flags & ~2048);
        flags = staticMapsProvider != null ? (flags | 4096) : (flags & ~4096);
        flags = suggestedLangCode != null ? (flags | 4) : (flags & ~4);
        flags = langPackVersion != null ? (flags | 4) : (flags & ~4);
        flags = baseLangPackVersion != null ? (flags | 4) : (flags & ~4);
        flags = reactionsDefault != null ? (flags | 32768) : (flags & ~32768);
        flags = autologinToken != null ? (flags | 65536) : (flags & ~65536);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(date, stream);
        writeInt(expires, stream);
        writeBoolean(testMode, stream);
        writeInt(thisDc, stream);
        writeTLVector(dcOptions, stream);
        writeString(dcTxtDomainName, stream);
        writeInt(chatSizeMax, stream);
        writeInt(megagroupSizeMax, stream);
        writeInt(forwardedCountMax, stream);
        writeInt(onlineUpdatePeriodMs, stream);
        writeInt(offlineBlurTimeoutMs, stream);
        writeInt(offlineIdleTimeoutMs, stream);
        writeInt(onlineCloudTimeoutMs, stream);
        writeInt(notifyCloudDelayMs, stream);
        writeInt(notifyDefaultDelayMs, stream);
        writeInt(pushChatPeriodMs, stream);
        writeInt(pushChatLimit, stream);
        writeInt(editTimeLimit, stream);
        writeInt(revokeTimeLimit, stream);
        writeInt(revokePmTimeLimit, stream);
        writeInt(ratingEDecay, stream);
        writeInt(stickersRecentLimit, stream);
        writeInt(channelsReadMediaPeriod, stream);
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            writeInt(tmpSessions, stream);
        }
        writeInt(callReceiveTimeoutMs, stream);
        writeInt(callRingTimeoutMs, stream);
        writeInt(callConnectTimeoutMs, stream);
        writeInt(callPacketTimeoutMs, stream);
        writeString(meUrlPrefix, stream);
        if ((flags & 128) != 0) {
            if (autoupdateUrlPrefix == null) throwNullFieldException("autoupdateUrlPrefix", flags);
            writeString(autoupdateUrlPrefix, stream);
        }
        if ((flags & 512) != 0) {
            if (gifSearchUsername == null) throwNullFieldException("gifSearchUsername", flags);
            writeString(gifSearchUsername, stream);
        }
        if ((flags & 1024) != 0) {
            if (venueSearchUsername == null) throwNullFieldException("venueSearchUsername", flags);
            writeString(venueSearchUsername, stream);
        }
        if ((flags & 2048) != 0) {
            if (imgSearchUsername == null) throwNullFieldException("imgSearchUsername", flags);
            writeString(imgSearchUsername, stream);
        }
        if ((flags & 4096) != 0) {
            if (staticMapsProvider == null) throwNullFieldException("staticMapsProvider", flags);
            writeString(staticMapsProvider, stream);
        }
        writeInt(captionLengthMax, stream);
        writeInt(messageLengthMax, stream);
        writeInt(webfileDcId, stream);
        if ((flags & 4) != 0) {
            if (suggestedLangCode == null) throwNullFieldException("suggestedLangCode", flags);
            writeString(suggestedLangCode, stream);
        }
        if ((flags & 4) != 0) {
            if (langPackVersion == null) throwNullFieldException("langPackVersion", flags);
            writeInt(langPackVersion, stream);
        }
        if ((flags & 4) != 0) {
            if (baseLangPackVersion == null) throwNullFieldException("baseLangPackVersion", flags);
            writeInt(baseLangPackVersion, stream);
        }
        if ((flags & 32768) != 0) {
            if (reactionsDefault == null) throwNullFieldException("reactionsDefault", flags);
            writeTLObject(reactionsDefault, stream);
        }
        if ((flags & 65536) != 0) {
            if (autologinToken == null) throwNullFieldException("autologinToken", flags);
            writeString(autologinToken, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        defaultP2pContacts = (flags & 8) != 0;
        preloadFeaturedStickers = (flags & 16) != 0;
        revokePmInbox = (flags & 64) != 0;
        blockedMode = (flags & 256) != 0;
        forceTryIpv6 = (flags & 16384) != 0;
        date = readInt(stream);
        expires = readInt(stream);
        testMode = readTLBool(stream);
        thisDc = readInt(stream);
        dcOptions = readTLVector(stream, context);
        dcTxtDomainName = readTLString(stream);
        chatSizeMax = readInt(stream);
        megagroupSizeMax = readInt(stream);
        forwardedCountMax = readInt(stream);
        onlineUpdatePeriodMs = readInt(stream);
        offlineBlurTimeoutMs = readInt(stream);
        offlineIdleTimeoutMs = readInt(stream);
        onlineCloudTimeoutMs = readInt(stream);
        notifyCloudDelayMs = readInt(stream);
        notifyDefaultDelayMs = readInt(stream);
        pushChatPeriodMs = readInt(stream);
        pushChatLimit = readInt(stream);
        editTimeLimit = readInt(stream);
        revokeTimeLimit = readInt(stream);
        revokePmTimeLimit = readInt(stream);
        ratingEDecay = readInt(stream);
        stickersRecentLimit = readInt(stream);
        channelsReadMediaPeriod = readInt(stream);
        tmpSessions = (flags & 1) != 0 ? readInt(stream) : null;
        callReceiveTimeoutMs = readInt(stream);
        callRingTimeoutMs = readInt(stream);
        callConnectTimeoutMs = readInt(stream);
        callPacketTimeoutMs = readInt(stream);
        meUrlPrefix = readTLString(stream);
        autoupdateUrlPrefix = (flags & 128) != 0 ? readTLString(stream) : null;
        gifSearchUsername = (flags & 512) != 0 ? readTLString(stream) : null;
        venueSearchUsername = (flags & 1024) != 0 ? readTLString(stream) : null;
        imgSearchUsername = (flags & 2048) != 0 ? readTLString(stream) : null;
        staticMapsProvider = (flags & 4096) != 0 ? readTLString(stream) : null;
        captionLengthMax = readInt(stream);
        messageLengthMax = readInt(stream);
        webfileDcId = readInt(stream);
        suggestedLangCode = (flags & 4) != 0 ? readTLString(stream) : null;
        langPackVersion = (flags & 4) != 0 ? readInt(stream) : null;
        baseLangPackVersion = (flags & 4) != 0 ? readInt(stream) : null;
        reactionsDefault = (flags & 32768) != 0 ? readTLObject(stream, context, TLAbsReaction.class, -1) : null;
        autologinToken = (flags & 65536) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_BOOLEAN;
        size += SIZE_INT32;
        size += dcOptions.computeSerializedSize();
        size += computeTLStringSerializedSize(dcTxtDomainName);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(meUrlPrefix);
        if ((flags & 128) != 0) {
            if (autoupdateUrlPrefix == null) throwNullFieldException("autoupdateUrlPrefix", flags);
            size += computeTLStringSerializedSize(autoupdateUrlPrefix);
        }
        if ((flags & 512) != 0) {
            if (gifSearchUsername == null) throwNullFieldException("gifSearchUsername", flags);
            size += computeTLStringSerializedSize(gifSearchUsername);
        }
        if ((flags & 1024) != 0) {
            if (venueSearchUsername == null) throwNullFieldException("venueSearchUsername", flags);
            size += computeTLStringSerializedSize(venueSearchUsername);
        }
        if ((flags & 2048) != 0) {
            if (imgSearchUsername == null) throwNullFieldException("imgSearchUsername", flags);
            size += computeTLStringSerializedSize(imgSearchUsername);
        }
        if ((flags & 4096) != 0) {
            if (staticMapsProvider == null) throwNullFieldException("staticMapsProvider", flags);
            size += computeTLStringSerializedSize(staticMapsProvider);
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (suggestedLangCode == null) throwNullFieldException("suggestedLangCode", flags);
            size += computeTLStringSerializedSize(suggestedLangCode);
        }
        if ((flags & 4) != 0) {
            if (langPackVersion == null) throwNullFieldException("langPackVersion", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (baseLangPackVersion == null) throwNullFieldException("baseLangPackVersion", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32768) != 0) {
            if (reactionsDefault == null) throwNullFieldException("reactionsDefault", flags);
            size += reactionsDefault.computeSerializedSize();
        }
        if ((flags & 65536) != 0) {
            if (autologinToken == null) throwNullFieldException("autologinToken", flags);
            size += computeTLStringSerializedSize(autologinToken);
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

    public boolean getDefaultP2pContacts() {
        return defaultP2pContacts;
    }

    public void setDefaultP2pContacts(boolean defaultP2pContacts) {
        this.defaultP2pContacts = defaultP2pContacts;
    }

    public boolean getPreloadFeaturedStickers() {
        return preloadFeaturedStickers;
    }

    public void setPreloadFeaturedStickers(boolean preloadFeaturedStickers) {
        this.preloadFeaturedStickers = preloadFeaturedStickers;
    }

    public boolean getRevokePmInbox() {
        return revokePmInbox;
    }

    public void setRevokePmInbox(boolean revokePmInbox) {
        this.revokePmInbox = revokePmInbox;
    }

    public boolean getBlockedMode() {
        return blockedMode;
    }

    public void setBlockedMode(boolean blockedMode) {
        this.blockedMode = blockedMode;
    }

    public boolean getForceTryIpv6() {
        return forceTryIpv6;
    }

    public void setForceTryIpv6(boolean forceTryIpv6) {
        this.forceTryIpv6 = forceTryIpv6;
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

    public boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int thisDc) {
        this.thisDc = thisDc;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }

    public String getDcTxtDomainName() {
        return dcTxtDomainName;
    }

    public void setDcTxtDomainName(String dcTxtDomainName) {
        this.dcTxtDomainName = dcTxtDomainName;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int chatSizeMax) {
        this.chatSizeMax = chatSizeMax;
    }

    public int getMegagroupSizeMax() {
        return megagroupSizeMax;
    }

    public void setMegagroupSizeMax(int megagroupSizeMax) {
        this.megagroupSizeMax = megagroupSizeMax;
    }

    public int getForwardedCountMax() {
        return forwardedCountMax;
    }

    public void setForwardedCountMax(int forwardedCountMax) {
        this.forwardedCountMax = forwardedCountMax;
    }

    public int getOnlineUpdatePeriodMs() {
        return onlineUpdatePeriodMs;
    }

    public void setOnlineUpdatePeriodMs(int onlineUpdatePeriodMs) {
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
    }

    public int getOfflineBlurTimeoutMs() {
        return offlineBlurTimeoutMs;
    }

    public void setOfflineBlurTimeoutMs(int offlineBlurTimeoutMs) {
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
    }

    public int getOfflineIdleTimeoutMs() {
        return offlineIdleTimeoutMs;
    }

    public void setOfflineIdleTimeoutMs(int offlineIdleTimeoutMs) {
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
    }

    public int getOnlineCloudTimeoutMs() {
        return onlineCloudTimeoutMs;
    }

    public void setOnlineCloudTimeoutMs(int onlineCloudTimeoutMs) {
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
    }

    public int getNotifyCloudDelayMs() {
        return notifyCloudDelayMs;
    }

    public void setNotifyCloudDelayMs(int notifyCloudDelayMs) {
        this.notifyCloudDelayMs = notifyCloudDelayMs;
    }

    public int getNotifyDefaultDelayMs() {
        return notifyDefaultDelayMs;
    }

    public void setNotifyDefaultDelayMs(int notifyDefaultDelayMs) {
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
    }

    public int getPushChatPeriodMs() {
        return pushChatPeriodMs;
    }

    public void setPushChatPeriodMs(int pushChatPeriodMs) {
        this.pushChatPeriodMs = pushChatPeriodMs;
    }

    public int getPushChatLimit() {
        return pushChatLimit;
    }

    public void setPushChatLimit(int pushChatLimit) {
        this.pushChatLimit = pushChatLimit;
    }

    public int getEditTimeLimit() {
        return editTimeLimit;
    }

    public void setEditTimeLimit(int editTimeLimit) {
        this.editTimeLimit = editTimeLimit;
    }

    public int getRevokeTimeLimit() {
        return revokeTimeLimit;
    }

    public void setRevokeTimeLimit(int revokeTimeLimit) {
        this.revokeTimeLimit = revokeTimeLimit;
    }

    public int getRevokePmTimeLimit() {
        return revokePmTimeLimit;
    }

    public void setRevokePmTimeLimit(int revokePmTimeLimit) {
        this.revokePmTimeLimit = revokePmTimeLimit;
    }

    public int getRatingEDecay() {
        return ratingEDecay;
    }

    public void setRatingEDecay(int ratingEDecay) {
        this.ratingEDecay = ratingEDecay;
    }

    public int getStickersRecentLimit() {
        return stickersRecentLimit;
    }

    public void setStickersRecentLimit(int stickersRecentLimit) {
        this.stickersRecentLimit = stickersRecentLimit;
    }

    public int getChannelsReadMediaPeriod() {
        return channelsReadMediaPeriod;
    }

    public void setChannelsReadMediaPeriod(int channelsReadMediaPeriod) {
        this.channelsReadMediaPeriod = channelsReadMediaPeriod;
    }

    public Integer getTmpSessions() {
        return tmpSessions;
    }

    public void setTmpSessions(Integer tmpSessions) {
        this.tmpSessions = tmpSessions;
    }

    public int getCallReceiveTimeoutMs() {
        return callReceiveTimeoutMs;
    }

    public void setCallReceiveTimeoutMs(int callReceiveTimeoutMs) {
        this.callReceiveTimeoutMs = callReceiveTimeoutMs;
    }

    public int getCallRingTimeoutMs() {
        return callRingTimeoutMs;
    }

    public void setCallRingTimeoutMs(int callRingTimeoutMs) {
        this.callRingTimeoutMs = callRingTimeoutMs;
    }

    public int getCallConnectTimeoutMs() {
        return callConnectTimeoutMs;
    }

    public void setCallConnectTimeoutMs(int callConnectTimeoutMs) {
        this.callConnectTimeoutMs = callConnectTimeoutMs;
    }

    public int getCallPacketTimeoutMs() {
        return callPacketTimeoutMs;
    }

    public void setCallPacketTimeoutMs(int callPacketTimeoutMs) {
        this.callPacketTimeoutMs = callPacketTimeoutMs;
    }

    public String getMeUrlPrefix() {
        return meUrlPrefix;
    }

    public void setMeUrlPrefix(String meUrlPrefix) {
        this.meUrlPrefix = meUrlPrefix;
    }

    public String getAutoupdateUrlPrefix() {
        return autoupdateUrlPrefix;
    }

    public void setAutoupdateUrlPrefix(String autoupdateUrlPrefix) {
        this.autoupdateUrlPrefix = autoupdateUrlPrefix;
    }

    public String getGifSearchUsername() {
        return gifSearchUsername;
    }

    public void setGifSearchUsername(String gifSearchUsername) {
        this.gifSearchUsername = gifSearchUsername;
    }

    public String getVenueSearchUsername() {
        return venueSearchUsername;
    }

    public void setVenueSearchUsername(String venueSearchUsername) {
        this.venueSearchUsername = venueSearchUsername;
    }

    public String getImgSearchUsername() {
        return imgSearchUsername;
    }

    public void setImgSearchUsername(String imgSearchUsername) {
        this.imgSearchUsername = imgSearchUsername;
    }

    public String getStaticMapsProvider() {
        return staticMapsProvider;
    }

    public void setStaticMapsProvider(String staticMapsProvider) {
        this.staticMapsProvider = staticMapsProvider;
    }

    public int getCaptionLengthMax() {
        return captionLengthMax;
    }

    public void setCaptionLengthMax(int captionLengthMax) {
        this.captionLengthMax = captionLengthMax;
    }

    public int getMessageLengthMax() {
        return messageLengthMax;
    }

    public void setMessageLengthMax(int messageLengthMax) {
        this.messageLengthMax = messageLengthMax;
    }

    public int getWebfileDcId() {
        return webfileDcId;
    }

    public void setWebfileDcId(int webfileDcId) {
        this.webfileDcId = webfileDcId;
    }

    public String getSuggestedLangCode() {
        return suggestedLangCode;
    }

    public void setSuggestedLangCode(String suggestedLangCode) {
        this.suggestedLangCode = suggestedLangCode;
    }

    public Integer getLangPackVersion() {
        return langPackVersion;
    }

    public void setLangPackVersion(Integer langPackVersion) {
        this.langPackVersion = langPackVersion;
    }

    public Integer getBaseLangPackVersion() {
        return baseLangPackVersion;
    }

    public void setBaseLangPackVersion(Integer baseLangPackVersion) {
        this.baseLangPackVersion = baseLangPackVersion;
    }

    public TLAbsReaction getReactionsDefault() {
        return reactionsDefault;
    }

    public void setReactionsDefault(TLAbsReaction reactionsDefault) {
        this.reactionsDefault = reactionsDefault;
    }

    public String getAutologinToken() {
        return autologinToken;
    }

    public void setAutologinToken(String autologinToken) {
        this.autologinToken = autologinToken;
    }
}
