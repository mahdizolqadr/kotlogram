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
public class TLChatAdminRights extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean changeInfo;

    protected boolean postMessages;

    protected boolean editMessages;

    protected boolean deleteMessages;

    protected boolean banUsers;

    protected boolean inviteUsers;

    protected boolean pinMessages;

    protected boolean addAdmins;

    protected boolean anonymous;

    protected boolean manageCall;

    protected boolean other;

    protected boolean manageTopics;

    protected boolean postStories;

    protected boolean editStories;

    protected boolean deleteStories;

    private final String _constructor = "chatAdminRights#0";

    public TLChatAdminRights() {
    }

    public TLChatAdminRights(boolean changeInfo, boolean postMessages, boolean editMessages, boolean deleteMessages, boolean banUsers, boolean inviteUsers, boolean pinMessages, boolean addAdmins, boolean anonymous, boolean manageCall, boolean other, boolean manageTopics, boolean postStories, boolean editStories, boolean deleteStories) {
        this.changeInfo = changeInfo;
        this.postMessages = postMessages;
        this.editMessages = editMessages;
        this.deleteMessages = deleteMessages;
        this.banUsers = banUsers;
        this.inviteUsers = inviteUsers;
        this.pinMessages = pinMessages;
        this.addAdmins = addAdmins;
        this.anonymous = anonymous;
        this.manageCall = manageCall;
        this.other = other;
        this.manageTopics = manageTopics;
        this.postStories = postStories;
        this.editStories = editStories;
        this.deleteStories = deleteStories;
    }

    private void computeFlags() {
        flags = 0;
        flags = changeInfo ? (flags | 1) : (flags & ~1);
        flags = postMessages ? (flags | 2) : (flags & ~2);
        flags = editMessages ? (flags | 4) : (flags & ~4);
        flags = deleteMessages ? (flags | 8) : (flags & ~8);
        flags = banUsers ? (flags | 16) : (flags & ~16);
        flags = inviteUsers ? (flags | 32) : (flags & ~32);
        flags = pinMessages ? (flags | 128) : (flags & ~128);
        flags = addAdmins ? (flags | 512) : (flags & ~512);
        flags = anonymous ? (flags | 1024) : (flags & ~1024);
        flags = manageCall ? (flags | 2048) : (flags & ~2048);
        flags = other ? (flags | 4096) : (flags & ~4096);
        flags = manageTopics ? (flags | 8192) : (flags & ~8192);
        flags = postStories ? (flags | 16384) : (flags & ~16384);
        flags = editStories ? (flags | 32768) : (flags & ~32768);
        flags = deleteStories ? (flags | 65536) : (flags & ~65536);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        changeInfo = (flags & 1) != 0;
        postMessages = (flags & 2) != 0;
        editMessages = (flags & 4) != 0;
        deleteMessages = (flags & 8) != 0;
        banUsers = (flags & 16) != 0;
        inviteUsers = (flags & 32) != 0;
        pinMessages = (flags & 128) != 0;
        addAdmins = (flags & 512) != 0;
        anonymous = (flags & 1024) != 0;
        manageCall = (flags & 2048) != 0;
        other = (flags & 4096) != 0;
        manageTopics = (flags & 8192) != 0;
        postStories = (flags & 16384) != 0;
        editStories = (flags & 32768) != 0;
        deleteStories = (flags & 65536) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getChangeInfo() {
        return changeInfo;
    }

    public void setChangeInfo(boolean changeInfo) {
        this.changeInfo = changeInfo;
    }

    public boolean getPostMessages() {
        return postMessages;
    }

    public void setPostMessages(boolean postMessages) {
        this.postMessages = postMessages;
    }

    public boolean getEditMessages() {
        return editMessages;
    }

    public void setEditMessages(boolean editMessages) {
        this.editMessages = editMessages;
    }

    public boolean getDeleteMessages() {
        return deleteMessages;
    }

    public void setDeleteMessages(boolean deleteMessages) {
        this.deleteMessages = deleteMessages;
    }

    public boolean getBanUsers() {
        return banUsers;
    }

    public void setBanUsers(boolean banUsers) {
        this.banUsers = banUsers;
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

    public boolean getAddAdmins() {
        return addAdmins;
    }

    public void setAddAdmins(boolean addAdmins) {
        this.addAdmins = addAdmins;
    }

    public boolean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(boolean anonymous) {
        this.anonymous = anonymous;
    }

    public boolean getManageCall() {
        return manageCall;
    }

    public void setManageCall(boolean manageCall) {
        this.manageCall = manageCall;
    }

    public boolean getOther() {
        return other;
    }

    public void setOther(boolean other) {
        this.other = other;
    }

    public boolean getManageTopics() {
        return manageTopics;
    }

    public void setManageTopics(boolean manageTopics) {
        this.manageTopics = manageTopics;
    }

    public boolean getPostStories() {
        return postStories;
    }

    public void setPostStories(boolean postStories) {
        this.postStories = postStories;
    }

    public boolean getEditStories() {
        return editStories;
    }

    public void setEditStories(boolean editStories) {
        this.editStories = editStories;
    }

    public boolean getDeleteStories() {
        return deleteStories;
    }

    public void setDeleteStories(boolean deleteStories) {
        this.deleteStories = deleteStories;
    }
}
