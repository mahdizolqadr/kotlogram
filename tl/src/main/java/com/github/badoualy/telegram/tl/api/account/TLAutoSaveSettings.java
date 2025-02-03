package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLAutoSaveException;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLAutoSaveSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected com.github.badoualy.telegram.tl.api.TLAutoSaveSettings usersSettings;

    protected com.github.badoualy.telegram.tl.api.TLAutoSaveSettings chatsSettings;

    protected com.github.badoualy.telegram.tl.api.TLAutoSaveSettings broadcastsSettings;

    protected TLVector<TLAutoSaveException> exceptions;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "account.autoSaveSettings#0";

    public TLAutoSaveSettings() {
    }

    public TLAutoSaveSettings(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings usersSettings, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings chatsSettings, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings broadcastsSettings, TLVector<TLAutoSaveException> exceptions, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.usersSettings = usersSettings;
        this.chatsSettings = chatsSettings;
        this.broadcastsSettings = broadcastsSettings;
        this.exceptions = exceptions;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(usersSettings, stream);
        writeTLObject(chatsSettings, stream);
        writeTLObject(broadcastsSettings, stream);
        writeTLVector(exceptions, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        usersSettings = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID);
        chatsSettings = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID);
        broadcastsSettings = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.class, com.github.badoualy.telegram.tl.api.TLAutoSaveSettings.CONSTRUCTOR_ID);
        exceptions = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += usersSettings.computeSerializedSize();
        size += chatsSettings.computeSerializedSize();
        size += broadcastsSettings.computeSerializedSize();
        size += exceptions.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public com.github.badoualy.telegram.tl.api.TLAutoSaveSettings getUsersSettings() {
        return usersSettings;
    }

    public void setUsersSettings(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings usersSettings) {
        this.usersSettings = usersSettings;
    }

    public com.github.badoualy.telegram.tl.api.TLAutoSaveSettings getChatsSettings() {
        return chatsSettings;
    }

    public void setChatsSettings(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings chatsSettings) {
        this.chatsSettings = chatsSettings;
    }

    public com.github.badoualy.telegram.tl.api.TLAutoSaveSettings getBroadcastsSettings() {
        return broadcastsSettings;
    }

    public void setBroadcastsSettings(com.github.badoualy.telegram.tl.api.TLAutoSaveSettings broadcastsSettings) {
        this.broadcastsSettings = broadcastsSettings;
    }

    public TLVector<TLAutoSaveException> getExceptions() {
        return exceptions;
    }

    public void setExceptions(TLVector<TLAutoSaveException> exceptions) {
        this.exceptions = exceptions;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
