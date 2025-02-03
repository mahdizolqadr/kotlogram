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
public class TLChatlistInvite extends TLAbsChatlistInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String title;

    protected String emoticon;

    protected TLVector<TLAbsPeer> peers;

    private final String _constructor = "chatlists.chatlistInvite#0";

    public TLChatlistInvite() {
    }

    public TLChatlistInvite(String title, String emoticon, TLVector<TLAbsPeer> peers, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.title = title;
        this.emoticon = emoticon;
        this.peers = peers;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = emoticon != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(title, stream);
        if ((flags & 1) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            writeString(emoticon, stream);
        }
        writeTLVector(peers, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = readTLString(stream);
        emoticon = (flags & 1) != 0 ? readTLString(stream) : null;
        peers = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        if ((flags & 1) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            size += computeTLStringSerializedSize(emoticon);
        }
        size += peers.computeSerializedSize();
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public TLVector<TLAbsPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLAbsPeer> peers) {
        this.peers = peers;
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
