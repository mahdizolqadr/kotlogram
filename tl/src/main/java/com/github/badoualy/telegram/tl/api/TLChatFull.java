package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.call.TLInputGroupCall;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatFull extends TLAbsChatFull {

    public static final int CONSTRUCTOR_ID = 0x4dbdc099;

    protected int flags;
    protected TLAbsChatParticipants participants;

    private final String _constructor = "chatFull#4dbdc099";

    public TLChatFull() {
    }

    public TLChatFull(boolean canSetUsername, boolean hasScheduled, long id, String about,
                      TLAbsChatParticipants participants, TLAbsPhoto chatPhoto, TLPeerNotifySettings notifySettings,
                      TLChatInviteExported exportedInvite, TLVector<TLBotInfo> botInfo, Integer pinnedMsgId,
                      Integer folderId, TLInputGroupCall call, Integer ttlPeriod, TLAbsPeer groupcallDefaultJoinAs,
                      String themeEmoticon) {
        this.canSetUsername = canSetUsername;
        this.hasScheduled = hasScheduled;
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
    }

    private void computeFlags() {
        flags = 0;
        flags = canSetUsername ? (flags | 128) : (flags & ~128);
        flags = hasScheduled ? (flags | 256) : (flags & ~256);
        flags = chatPhoto != null ? (flags | 4) : (flags & ~4);
        flags = exportedInvite != null ? (flags | 8192) : (flags & ~8192);
        flags = botInfo != null ? (flags | 8) : (flags & ~8);
        flags = pinnedMsgId != null ? (flags | 64) : (flags & ~64);
        flags = folderId != null ? (flags | 2048) : (flags & ~2048);
        flags = call != null ? (flags | 4096) : (flags & ~4096);
        flags = ttlPeriod != null ? (flags | 16384) : (flags & ~16384);
        flags = groupcallDefaultJoinAs != null ? (flags | 32768) : (flags & ~32768);
        flags = themeEmoticon != null ? (flags | 65536) : (flags & ~65536);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(about, stream);
        writeTLObject(participants, stream);
        if ((flags & 4) != 0) {
            if (chatPhoto == null) {
                throwNullFieldException("chatPhoto", flags);
            }
            writeTLObject(chatPhoto, stream);
        }
        writeTLObject(notifySettings, stream);
        if ((flags & 8192) != 0) {
            if (exportedInvite == null) {
                throwNullFieldException("exportedInvite", flags);
            }
            writeTLObject(exportedInvite, stream);
        }
        if ((flags & 8) != 0) {
            if (botInfo == null) {
                throwNullFieldException("botInfo", flags);
            }
            writeTLVector(botInfo, stream);
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) {
                throwNullFieldException("pinnedMsgId", flags);
            }
            writeInt(pinnedMsgId, stream);
        }
        if ((flags & 2048) != 0) {
            if (folderId == null) {
                throwNullFieldException("folderId", flags);
            }
            writeInt(folderId, stream);
        }
        if ((flags & 4096) != 0) {
            if (call == null) {
                throwNullFieldException("call", flags);
            }
            writeTLObject(call, stream);
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) {
                throwNullFieldException("ttlPeriod", flags);
            }
            writeInt(ttlPeriod, stream);
        }
        if ((flags & 32768) != 0) {
            if (groupcallDefaultJoinAs == null) {
                throwNullFieldException("groupcallDefaultJoinAs", flags);
            }
            writeTLObject(groupcallDefaultJoinAs, stream);
        }
        if ((flags & 65536) != 0) {
            if (themeEmoticon == null) {
                throwNullFieldException("themeEmoticon", flags);
            }
            writeString(themeEmoticon, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canSetUsername = (flags & 128) != 0;
        hasScheduled = (flags & 256) != 0;
        id = readLong(stream);
        about = readTLString(stream);
        participants = readTLObject(stream, context, TLAbsChatParticipants.class, -1);
        chatPhoto = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPhoto.class, -1) : null;
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
        exportedInvite = (flags & 8192) != 0 ? readTLObject(stream, context, TLChatInviteExported.class, TLChatInviteExported.CONSTRUCTOR_ID) : null;
        botInfo = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        pinnedMsgId = (flags & 64) != 0 ? readInt(stream) : null;
        folderId = (flags & 2048) != 0 ? readInt(stream) : null;
        call = (flags & 4096) != 0 ? readTLObject(stream, context, TLInputGroupCall.class, TLInputGroupCall.CONSTRUCTOR_ID) : null;
        ttlPeriod = (flags & 16384) != 0 ? readInt(stream) : null;
        groupcallDefaultJoinAs = (flags & 32768) != 0 ? readTLObject(stream, context, TLAbsPeer.class, -1) : null;
        themeEmoticon = (flags & 65536) != 0 ? readTLString(stream) : null;
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
            if (chatPhoto == null) {
                throwNullFieldException("chatPhoto", flags);
            }
            size += chatPhoto.computeSerializedSize();
        }
        size += notifySettings.computeSerializedSize();
        if ((flags & 8192) != 0) {
            if (exportedInvite == null) {
                throwNullFieldException("exportedInvite", flags);
            }
            size += exportedInvite.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (botInfo == null) {
                throwNullFieldException("botInfo", flags);
            }
            size += botInfo.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (pinnedMsgId == null) {
                throwNullFieldException("pinnedMsgId", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 2048) != 0) {
            if (folderId == null) {
                throwNullFieldException("folderId", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 4096) != 0) {
            if (call == null) {
                throwNullFieldException("call", flags);
            }
            size += call.computeSerializedSize();
        }
        if ((flags & 16384) != 0) {
            if (ttlPeriod == null) {
                throwNullFieldException("ttlPeriod", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 32768) != 0) {
            if (groupcallDefaultJoinAs == null) {
                throwNullFieldException("groupcallDefaultJoinAs", flags);
            }
            size += groupcallDefaultJoinAs.computeSerializedSize();
        }
        if ((flags & 65536) != 0) {
            if (themeEmoticon == null) {
                throwNullFieldException("themeEmoticon", flags);
            }
            size += computeTLStringSerializedSize(themeEmoticon);
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

    public TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(TLAbsChatParticipants participants) {
        this.participants = participants;
    }
}
