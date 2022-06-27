package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLChatBannedRights extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x9f120418;
    protected int flags;
    protected boolean viewMessages;
    protected boolean sendMessages;
    protected boolean sendMedia;
    protected boolean sendStickers;
    protected boolean sendGifs;
    protected boolean sendGames;
    protected boolean sendInline;
    protected boolean embedLinks;
    protected boolean sendPolls;
    protected boolean changeInfo;
    protected boolean inviteUsers;
    protected boolean pinMessages;
    protected int untilDate;

    private final String _constructor = "chatBannedRights#9f120418";

    public TLChatBannedRights() {
    }

    public TLChatBannedRights(boolean viewMessages, boolean sendMessages, boolean sendMedia,
                              boolean sendStickers, boolean sendGifs, boolean sendGames,
                              boolean sendInline, boolean embedLinks, boolean sendPolls,
                              boolean changeInfo, boolean inviteUsers, boolean pinMessages,
                              int untilDate) {
        this.viewMessages = viewMessages;
        this.sendMessages = sendMessages;
        this.sendMedia = sendMedia;
        this.sendStickers = sendStickers;
        this.sendGifs = sendGifs;
        this.sendGames = sendGames;
        this.sendInline = sendInline;
        this.embedLinks = embedLinks;
        this.sendPolls = sendPolls;
        this.changeInfo = changeInfo;
        this.inviteUsers = inviteUsers;
        this.pinMessages = pinMessages;
        this.untilDate = untilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = viewMessages ? (flags | 1) : (flags & ~1);
        flags = sendMessages ? (flags | 2) : (flags & ~2);
        flags = sendMedia ? (flags | 4) : (flags & ~4);
        flags = sendStickers ? (flags | 8) : (flags & ~8);
        flags = sendGifs ? (flags | 16) : (flags & ~16);
        flags = sendGames ? (flags | 32) : (flags & ~32);
        flags = sendInline ? (flags | 64) : (flags & ~64);
        flags = embedLinks ? (flags | 128) : (flags & ~128);
        flags = sendPolls ? (flags | 256) : (flags & ~256);
        flags = changeInfo ? (flags | 1024) : (flags & ~1024);
        flags = inviteUsers ? (flags | 32768) : (flags & ~32768);
        flags = pinMessages ? (flags | 131072) : (flags & ~131072);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeInt(untilDate, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        viewMessages = (flags & 1) != 0;
        sendMessages = (flags & 2) != 0;
        sendMedia = (flags & 4) != 0;
        sendStickers = (flags & 8) != 0;
        sendGifs = (flags & 16) != 0;
        sendGames = (flags & 32) != 0;
        sendInline = (flags & 64) != 0;
        embedLinks = (flags & 128) != 0;
        sendPolls = (flags & 256) != 0;
        changeInfo = (flags & 1024) != 0;
        inviteUsers = (flags & 32768) != 0;
        pinMessages = (flags & 131072) != 0;
        untilDate = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean isViewMessages() {
        return viewMessages;
    }

    public void setViewMessages(boolean viewMessages) {
        this.viewMessages = viewMessages;
    }

    public boolean isSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(boolean sendMessages) {
        this.sendMessages = sendMessages;
    }

    public boolean isSendMedia() {
        return sendMedia;
    }

    public void setSendMedia(boolean sendMedia) {
        this.sendMedia = sendMedia;
    }

    public boolean isSendStickers() {
        return sendStickers;
    }

    public void setSendStickers(boolean sendStickers) {
        this.sendStickers = sendStickers;
    }

    public boolean isSendGifs() {
        return sendGifs;
    }

    public void setSendGifs(boolean sendGifs) {
        this.sendGifs = sendGifs;
    }

    public boolean isSendGames() {
        return sendGames;
    }

    public void setSendGames(boolean sendGames) {
        this.sendGames = sendGames;
    }

    public boolean isSendInline() {
        return sendInline;
    }

    public void setSendInline(boolean sendInline) {
        this.sendInline = sendInline;
    }

    public boolean isEmbedLinks() {
        return embedLinks;
    }

    public void setEmbedLinks(boolean embedLinks) {
        this.embedLinks = embedLinks;
    }

    public boolean isSendPolls() {
        return sendPolls;
    }

    public void setSendPolls(boolean sendPolls) {
        this.sendPolls = sendPolls;
    }

    public boolean isChangeInfo() {
        return changeInfo;
    }

    public void setChangeInfo(boolean changeInfo) {
        this.changeInfo = changeInfo;
    }

    public boolean isInviteUsers() {
        return inviteUsers;
    }

    public void setInviteUsers(boolean inviteUsers) {
        this.inviteUsers = inviteUsers;
    }

    public boolean isPinMessages() {
        return pinMessages;
    }

    public void setPinMessages(boolean pinMessages) {
        this.pinMessages = pinMessages;
    }

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
    }
}
