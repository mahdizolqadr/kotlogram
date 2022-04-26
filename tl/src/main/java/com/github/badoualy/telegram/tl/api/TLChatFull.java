package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */

//TODO: field set is incomplete, @see <a href ="https://core.telegram.org/constructor/chatFull">
public class TLChatFull extends TLAbsChatFull {

    public static final int CONSTRUCTOR_ID = 0x4dbdc099;

    protected int flags;

    protected boolean canSetUsername;

    protected boolean hasScheduled;

    protected String about;

    protected TLAbsChatParticipants participants;

    protected TLAbsPhoto chatPhoto;

    protected TLAbsPeerNotifySettings notifySettings;

    protected TLAbsExportedChatInvite exportedInvite;

    protected TLVector<TLBotInfo> botInfo;

    protected Integer pinnedMsgId;

    protected Integer folderId;

    protected Integer ttlPeriod;

    protected String themeEmotion;

    private final String _constructor = "chatFull#4dbdc099";

    public TLChatFull() {
    }

    public TLChatFull(int id, TLAbsChatParticipants participants, TLAbsPhoto chatPhoto, TLAbsPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLBotInfo> botInfo) {
        this.id = id;
        this.participants = participants;
        this.chatPhoto = chatPhoto;
        this.notifySettings = notifySettings;
        this.exportedInvite = exportedInvite;
        this.botInfo = botInfo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeTLObject(participants, stream);
        writeTLObject(chatPhoto, stream);
        writeTLObject(notifySettings, stream);
        writeTLObject(exportedInvite, stream);
        writeTLVector(botInfo, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        flags = readInt(stream);
        canSetUsername = (flags & 128) != 0;
        hasScheduled = (flags & 256) != 0;

        id = readLong(stream);
        about = readTLString(stream);

        participants = readTLObject(stream, context, TLAbsChatParticipants.class, -1);
        if ((flags & 4) != 0) {
            chatPhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
        }
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        if ((flags & 8192) != 0) {
            exportedInvite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        }

        if ((flags & 8) != 0) {
            int magic = readInt(stream);
            if (magic != 0x1cb5c415) {
                return;
            }
            botInfo = readTLVector(stream, context);
        }
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;

        size += SIZE_INT32;
        size += participants.computeSerializedSize();
        size += chatPhoto.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        size += exportedInvite.computeSerializedSize();
        size += botInfo.computeSerializedSize();
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
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
}
