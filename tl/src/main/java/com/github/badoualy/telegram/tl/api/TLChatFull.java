package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
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
public class TLChatFull extends TLAbsChatFull {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean canSetUsername;

    protected boolean hasScheduled;

    protected boolean translationsDisabled;

    protected TLAbsChatParticipants participants;

    protected TLAbsPhoto chatPhoto;

    protected TLAbsExportedChatInvite exportedInvite;

    protected TLVector<TLBotInfo> botInfo;

    protected Integer pinnedMsgId;

    protected TLInputGroupCall call;

    protected Integer ttlPeriod;

    protected TLAbsPeer groupcallDefaultJoinAs;

    protected String themeEmoticon;

    protected Integer requestsPending;

    protected TLLongVector recentRequesters;

    protected TLAbsChatReactions availableReactions;

    protected Integer reactionsLimit;

    private final String _constructor = "chatFull#0";

    public TLChatFull() {
    }

    public TLChatFull(boolean canSetUsername, boolean hasScheduled, boolean translationsDisabled, long id, String about, TLAbsChatParticipants participants, TLAbsPhoto chatPhoto, TLPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLBotInfo> botInfo, Integer pinnedMsgId, Integer folderId, TLInputGroupCall call, Integer ttlPeriod, TLAbsPeer groupcallDefaultJoinAs, String themeEmoticon, Integer requestsPending, TLLongVector recentRequesters, TLAbsChatReactions availableReactions, Integer reactionsLimit) {
        this.canSetUsername = canSetUsername;
        this.hasScheduled = hasScheduled;
        this.translationsDisabled = translationsDisabled;
        this.id = id;
        this.about = about;
        this.participants = participants;
        this.chatPhoto = chatPhoto;
        this.notifySettings = notifySettings;
        this.exportedInvite = exportedInvite;
        this.botInfo = botInfo;
        this.pinnedMsgId = pinnedMsgId;
        this.folderId = folderId;
        this.call = call;
        this.ttlPeriod = ttlPeriod;
        this.groupcallDefaultJoinAs = groupcallDefaultJoinAs;
        this.themeEmoticon = themeEmoticon;
        this.requestsPending = requestsPending;
        this.recentRequesters = recentRequesters;
        this.availableReactions = availableReactions;
        this.reactionsLimit = reactionsLimit;
    }

    private void computeFlags() {
        flags = 0;
        flags = canSetUsername ? (flags | 128) : (flags & ~128);
        flags = hasScheduled ? (flags | 256) : (flags & ~256);
        flags = translationsDisabled ? (flags | 524288) : (flags & ~524288);
        flags = chatPhoto != null ? (flags | 4) : (flags & ~4);
        flags = exportedInvite != null ? (flags | 8192) : (flags & ~8192);
        flags = botInfo != null ? (flags | 8) : (flags & ~8);
        flags = pinnedMsgId != null ? (flags | 64) : (flags & ~64);
        flags = folderId != null ? (flags | 2048) : (flags & ~2048);
        flags = call != null ? (flags | 4096) : (flags & ~4096);
        flags = ttlPeriod != null ? (flags | 16384) : (flags & ~16384);
        flags = groupcallDefaultJoinAs != null ? (flags | 32768) : (flags & ~32768);
        flags = themeEmoticon != null ? (flags | 65536) : (flags & ~65536);
        flags = requestsPending != null ? (flags | 131072) : (flags & ~131072);
        flags = recentRequesters != null ? (flags | 131072) : (flags & ~131072);
        flags = availableReactions != null ? (flags | 262144) : (flags & ~262144);
        flags = reactionsLimit != null ? (flags | 1048576) : (flags & ~1048576);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(about, stream);
        writeTLObject(participants, stream);
        if ((flags & 4) != 0) {
            if (chatPhoto == null) throwNullFieldException("chatPhoto", flags);
            writeTLObject(chatPhoto, stream);
        }
        writeTLObject(notifySettings, stream);
        if ((flags & 8192) != 0) {
            if (exportedInvite == null) throwNullFieldException("exportedInvite", flags);
            writeTLObject(exportedInvite, stream);
        }
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            writeTLVector(botInfo, stream);
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            writeInt(pinnedMsgId, stream);
        }
        if ((flags & 2048) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        if ((flags & 4096) != 0) {
            if (call == null) throwNullFieldException("call", flags);
            writeTLObject(call, stream);
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
        if ((flags & 32768) != 0) {
            if (groupcallDefaultJoinAs == null) throwNullFieldException("groupcallDefaultJoinAs", flags);
            writeTLObject(groupcallDefaultJoinAs, stream);
        }
        if ((flags & 65536) != 0) {
            if (themeEmoticon == null) throwNullFieldException("themeEmoticon", flags);
            writeString(themeEmoticon, stream);
        }
        if ((flags & 131072) != 0) {
            if (requestsPending == null) throwNullFieldException("requestsPending", flags);
            writeInt(requestsPending, stream);
        }
        if ((flags & 131072) != 0) {
            if (recentRequesters == null) throwNullFieldException("recentRequesters", flags);
            writeTLVector(recentRequesters, stream);
        }
        if ((flags & 262144) != 0) {
            if (availableReactions == null) throwNullFieldException("availableReactions", flags);
            writeTLObject(availableReactions, stream);
        }
        if ((flags & 1048576) != 0) {
            if (reactionsLimit == null) throwNullFieldException("reactionsLimit", flags);
            writeInt(reactionsLimit, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canSetUsername = (flags & 128) != 0;
        hasScheduled = (flags & 256) != 0;
        translationsDisabled = (flags & 524288) != 0;
        id = readLong(stream);
        about = readTLString(stream);
        participants = readTLObject(stream, context, TLAbsChatParticipants.class, -1);
        chatPhoto = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
        exportedInvite = (flags & 8192) != 0 ? readTLObject(stream, context, TLAbsExportedChatInvite.class, -1) : null;
        botInfo = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        pinnedMsgId = (flags & 64) != 0 ? readInt(stream) : null;
        folderId = (flags & 2048) != 0 ? readInt(stream) : null;
        call = (flags & 4096) != 0 ? readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID) : null;
        ttlPeriod = (flags & 16384) != 0 ? readInt(stream) : null;
        groupcallDefaultJoinAs = (flags & 32768) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        themeEmoticon = (flags & 65536) != 0 ? readTLString(stream) : null;
        requestsPending = (flags & 131072) != 0 ? readInt(stream) : null;
        recentRequesters = (flags & 131072) != 0 ? readTLLongVector(stream, context) : null;
        availableReactions = (flags & 262144) != 0 ? readTLObject(stream, context, TLAbsChatReactions.class, -1) : null;
        reactionsLimit = (flags & 1048576) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(about);
        size += participants.computeSerializedSize();
        if ((flags & 4) != 0) {
            if (chatPhoto == null) throwNullFieldException("chatPhoto", flags);
            size += chatPhoto.computeSerializedSize();
        }
        size += notifySettings.computeSerializedSize();
        if ((flags & 8192) != 0) {
            if (exportedInvite == null) throwNullFieldException("exportedInvite", flags);
            size += exportedInvite.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (botInfo == null) throwNullFieldException("botInfo", flags);
            size += botInfo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2048) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4096) != 0) {
            if (call == null) throwNullFieldException("call", flags);
            size += call.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32768) != 0) {
            if (groupcallDefaultJoinAs == null) throwNullFieldException("groupcallDefaultJoinAs", flags);
            size += groupcallDefaultJoinAs.computeSerializedSize();
        }
        if ((flags & 65536) != 0) {
            if (themeEmoticon == null) throwNullFieldException("themeEmoticon", flags);
            size += computeTLStringSerializedSize(themeEmoticon);
        }
        if ((flags & 131072) != 0) {
            if (requestsPending == null) throwNullFieldException("requestsPending", flags);
            size += SIZE_INT32;
        }
        if ((flags & 131072) != 0) {
            if (recentRequesters == null) throwNullFieldException("recentRequesters", flags);
            size += recentRequesters.computeSerializedSize();
        }
        if ((flags & 262144) != 0) {
            if (availableReactions == null) throwNullFieldException("availableReactions", flags);
            size += availableReactions.computeSerializedSize();
        }
        if ((flags & 1048576) != 0) {
            if (reactionsLimit == null) throwNullFieldException("reactionsLimit", flags);
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

    public boolean getCanSetUsername() {
        return canSetUsername;
    }

    public void setCanSetUsername(boolean canSetUsername) {
        this.canSetUsername = canSetUsername;
    }

    public boolean getHasScheduled() {
        return hasScheduled;
    }

    public void setHasScheduled(boolean hasScheduled) {
        this.hasScheduled = hasScheduled;
    }

    public boolean getTranslationsDisabled() {
        return translationsDisabled;
    }

    public void setTranslationsDisabled(boolean translationsDisabled) {
        this.translationsDisabled = translationsDisabled;
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

    public TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(TLAbsChatParticipants participants) {
        this.participants = participants;
    }

    public TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(TLAbsPhoto chatPhoto) {
        this.chatPhoto = chatPhoto;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public TLAbsExportedChatInvite getExportedInvite() {
        return exportedInvite;
    }

    public void setExportedInvite(TLAbsExportedChatInvite exportedInvite) {
        this.exportedInvite = exportedInvite;
    }

    public TLVector<TLBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLVector<TLBotInfo> botInfo) {
        this.botInfo = botInfo;
    }

    public Integer getPinnedMsgId() {
        return pinnedMsgId;
    }

    public void setPinnedMsgId(Integer pinnedMsgId) {
        this.pinnedMsgId = pinnedMsgId;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public TLInputGroupCall getCall() {
        return call;
    }

    public void setCall(TLInputGroupCall call) {
        this.call = call;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }

    public TLAbsPeer getGroupcallDefaultJoinAs() {
        return groupcallDefaultJoinAs;
    }

    public void setGroupcallDefaultJoinAs(TLAbsPeer groupcallDefaultJoinAs) {
        this.groupcallDefaultJoinAs = groupcallDefaultJoinAs;
    }

    public String getThemeEmoticon() {
        return themeEmoticon;
    }

    public void setThemeEmoticon(String themeEmoticon) {
        this.themeEmoticon = themeEmoticon;
    }

    public Integer getRequestsPending() {
        return requestsPending;
    }

    public void setRequestsPending(Integer requestsPending) {
        this.requestsPending = requestsPending;
    }

    public TLLongVector getRecentRequesters() {
        return recentRequesters;
    }

    public void setRecentRequesters(TLLongVector recentRequesters) {
        this.recentRequesters = recentRequesters;
    }

    public TLAbsChatReactions getAvailableReactions() {
        return availableReactions;
    }

    public void setAvailableReactions(TLAbsChatReactions availableReactions) {
        this.availableReactions = availableReactions;
    }

    public Integer getReactionsLimit() {
        return reactionsLimit;
    }

    public void setReactionsLimit(Integer reactionsLimit) {
        this.reactionsLimit = reactionsLimit;
    }
}
