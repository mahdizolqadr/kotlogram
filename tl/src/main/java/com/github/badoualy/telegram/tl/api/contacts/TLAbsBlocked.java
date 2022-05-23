package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLPeerBlocked;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLBlocked}: contacts.blocked#ade1591</li>
 * <li>{@link TLBlockedSlice}: contacts.blockedSlice#e1664194</li>
 * </ul>
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsBlocked extends TLObject {

    protected TLVector<TLPeerBlocked> blocked;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected TLAbsBlocked() {
    }

    protected TLAbsBlocked(TLVector<TLPeerBlocked> blocked, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.blocked = blocked;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(blocked, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        blocked = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    public TLVector<TLPeerBlocked> getBlocked() {
        return blocked;
    }

    public void setBlocked(TLVector<TLPeerBlocked> blocked) {
        this.blocked = blocked;
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
