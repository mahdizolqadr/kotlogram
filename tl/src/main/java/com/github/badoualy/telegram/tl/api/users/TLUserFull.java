package com.github.badoualy.telegram.tl.api.users;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLUserFull extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected com.github.badoualy.telegram.tl.api.TLUserFull fullUser;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "users.userFull#0";

    public TLUserFull() {
    }

    public TLUserFull(com.github.badoualy.telegram.tl.api.TLUserFull fullUser, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.fullUser = fullUser;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(fullUser, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        fullUser = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLUserFull.class, com.github.badoualy.telegram.tl.api.TLUserFull.CONSTRUCTOR_ID);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += fullUser.computeSerializedSize();
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

    public com.github.badoualy.telegram.tl.api.TLUserFull getFullUser() {
        return fullUser;
    }

    public void setFullUser(com.github.badoualy.telegram.tl.api.TLUserFull fullUser) {
        this.fullUser = fullUser;
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
