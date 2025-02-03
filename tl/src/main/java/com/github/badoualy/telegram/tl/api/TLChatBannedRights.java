package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLChatBannedRights extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

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

    protected boolean manageTopics;

    protected boolean sendPhotos;

    protected boolean sendVideos;

    protected boolean sendRoundvideos;

    protected boolean sendAudios;

    protected boolean sendVoices;

    protected boolean sendDocs;

    protected boolean sendPlain;

    protected int untilDate;

    private final String _constructor = "chatBannedRights#0";

    public TLChatBannedRights() {
    }

    public TLChatBannedRights(boolean viewMessages, boolean sendMessages, boolean sendMedia, boolean sendStickers, boolean sendGifs, boolean sendGames, boolean sendInline, boolean embedLinks, boolean sendPolls, boolean changeInfo, boolean inviteUsers, boolean pinMessages, boolean manageTopics, boolean sendPhotos, boolean sendVideos, boolean sendRoundvideos, boolean sendAudios, boolean sendVoices, boolean sendDocs, boolean sendPlain, int untilDate) {
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
        this.manageTopics = manageTopics;
        this.sendPhotos = sendPhotos;
        this.sendVideos = sendVideos;
        this.sendRoundvideos = sendRoundvideos;
        this.sendAudios = sendAudios;
        this.sendVoices = sendVoices;
        this.sendDocs = sendDocs;
        this.sendPlain = sendPlain;
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
        flags = manageTopics ? (flags | 262144) : (flags & ~262144);
        flags = sendPhotos ? (flags | 524288) : (flags & ~524288);
        flags = sendVideos ? (flags | 1048576) : (flags & ~1048576);
        flags = sendRoundvideos ? (flags | 2097152) : (flags & ~2097152);
        flags = sendAudios ? (flags | 4194304) : (flags & ~4194304);
        flags = sendVoices ? (flags | 8388608) : (flags & ~8388608);
        flags = sendDocs ? (flags | 16777216) : (flags & ~16777216);
        flags = sendPlain ? (flags | 33554432) : (flags & ~33554432);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(untilDate, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
        manageTopics = (flags & 262144) != 0;
        sendPhotos = (flags & 524288) != 0;
        sendVideos = (flags & 1048576) != 0;
        sendRoundvideos = (flags & 2097152) != 0;
        sendAudios = (flags & 4194304) != 0;
        sendVoices = (flags & 8388608) != 0;
        sendDocs = (flags & 16777216) != 0;
        sendPlain = (flags & 33554432) != 0;
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

    public boolean getViewMessages() {
        return viewMessages;
    }

    public void setViewMessages(boolean viewMessages) {
        this.viewMessages = viewMessages;
    }

    public boolean getSendMessages() {
        return sendMessages;
    }

    public void setSendMessages(boolean sendMessages) {
        this.sendMessages = sendMessages;
    }

    public boolean getSendMedia() {
        return sendMedia;
    }

    public void setSendMedia(boolean sendMedia) {
        this.sendMedia = sendMedia;
    }

    public boolean getSendStickers() {
        return sendStickers;
    }

    public void setSendStickers(boolean sendStickers) {
        this.sendStickers = sendStickers;
    }

    public boolean getSendGifs() {
        return sendGifs;
    }

    public void setSendGifs(boolean sendGifs) {
        this.sendGifs = sendGifs;
    }

    public boolean getSendGames() {
        return sendGames;
    }

    public void setSendGames(boolean sendGames) {
        this.sendGames = sendGames;
    }

    public boolean getSendInline() {
        return sendInline;
    }

    public void setSendInline(boolean sendInline) {
        this.sendInline = sendInline;
    }

    public boolean getEmbedLinks() {
        return embedLinks;
    }

    public void setEmbedLinks(boolean embedLinks) {
        this.embedLinks = embedLinks;
    }

    public boolean getSendPolls() {
        return sendPolls;
    }

    public void setSendPolls(boolean sendPolls) {
        this.sendPolls = sendPolls;
    }

    public boolean getChangeInfo() {
        return changeInfo;
    }

    public void setChangeInfo(boolean changeInfo) {
        this.changeInfo = changeInfo;
    }

    public boolean getInviteUsers() {
        return inviteUsers;
    }

    public void setInviteUsers(boolean inviteUsers) {
        this.inviteUsers = inviteUsers;
    }

    public boolean getPinMessages() {
        return pinMessages;
    }

    public void setPinMessages(boolean pinMessages) {
        this.pinMessages = pinMessages;
    }

    public boolean getManageTopics() {
        return manageTopics;
    }

    public void setManageTopics(boolean manageTopics) {
        this.manageTopics = manageTopics;
    }

    public boolean getSendPhotos() {
        return sendPhotos;
    }

    public void setSendPhotos(boolean sendPhotos) {
        this.sendPhotos = sendPhotos;
    }

    public boolean getSendVideos() {
        return sendVideos;
    }

    public void setSendVideos(boolean sendVideos) {
        this.sendVideos = sendVideos;
    }

    public boolean getSendRoundvideos() {
        return sendRoundvideos;
    }

    public void setSendRoundvideos(boolean sendRoundvideos) {
        this.sendRoundvideos = sendRoundvideos;
    }

    public boolean getSendAudios() {
        return sendAudios;
    }

    public void setSendAudios(boolean sendAudios) {
        this.sendAudios = sendAudios;
    }

    public boolean getSendVoices() {
        return sendVoices;
    }

    public void setSendVoices(boolean sendVoices) {
        this.sendVoices = sendVoices;
    }

    public boolean getSendDocs() {
        return sendDocs;
    }

    public void setSendDocs(boolean sendDocs) {
        this.sendDocs = sendDocs;
    }

    public boolean getSendPlain() {
        return sendPlain;
    }

    public void setSendPlain(boolean sendPlain) {
        this.sendPlain = sendPlain;
    }

    public int getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(int untilDate) {
        this.untilDate = untilDate;
    }
}
