package com.github.badoualy.telegram.tl.api.chatlists;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
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
public class TLChatlistInviteAlready extends TLAbsChatlistInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int filterId;

    protected TLVector<TLAbsPeer> missingPeers;

    protected TLVector<TLAbsPeer> alreadyPeers;

    private final String _constructor = "chatlists.chatlistInviteAlready#0";

    public TLChatlistInviteAlready() {
    }

    public TLChatlistInviteAlready(int filterId, TLVector<TLAbsPeer> missingPeers, TLVector<TLAbsPeer> alreadyPeers, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.filterId = filterId;
        this.missingPeers = missingPeers;
        this.alreadyPeers = alreadyPeers;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(filterId, stream);
        writeTLVector(missingPeers, stream);
        writeTLVector(alreadyPeers, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        filterId = readInt(stream);
        missingPeers = readTLVector(stream, context);
        alreadyPeers = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += missingPeers.computeSerializedSize();
        size += alreadyPeers.computeSerializedSize();
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

    public int getFilterId() {
        return filterId;
    }

    public void setFilterId(int filterId) {
        this.filterId = filterId;
    }

    public TLVector<TLAbsPeer> getMissingPeers() {
        return missingPeers;
    }

    public void setMissingPeers(TLVector<TLAbsPeer> missingPeers) {
        this.missingPeers = missingPeers;
    }

    public TLVector<TLAbsPeer> getAlreadyPeers() {
        return alreadyPeers;
    }

    public void setAlreadyPeers(TLVector<TLAbsPeer> alreadyPeers) {
        this.alreadyPeers = alreadyPeers;
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
