package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLRequestPeerTypeChat extends TLAbsRequestPeerType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean creator;

    protected boolean botParticipant;

    protected boolean hasUsername;

    protected boolean forum;

    protected TLChatAdminRights userAdminRights;

    protected TLChatAdminRights botAdminRights;

    private final String _constructor = "requestPeerTypeChat#0";

    public TLRequestPeerTypeChat() {
    }

    public TLRequestPeerTypeChat(boolean creator, boolean botParticipant, boolean hasUsername, boolean forum, TLChatAdminRights userAdminRights, TLChatAdminRights botAdminRights) {
        this.creator = creator;
        this.botParticipant = botParticipant;
        this.hasUsername = hasUsername;
        this.forum = forum;
        this.userAdminRights = userAdminRights;
        this.botAdminRights = botAdminRights;
    }

    private void computeFlags() {
        flags = 0;
        flags = creator ? (flags | 1) : (flags & ~1);
        flags = botParticipant ? (flags | 32) : (flags & ~32);
        flags = hasUsername != null ? (flags | 8) : (flags & ~8);
        flags = forum != null ? (flags | 16) : (flags & ~16);
        flags = userAdminRights != null ? (flags | 2) : (flags & ~2);
        flags = botAdminRights != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            writeBoolean(hasUsername, stream);
        }
        if ((flags & 16) != 0) {
            writeBoolean(forum, stream);
        }
        if ((flags & 2) != 0) {
            if (userAdminRights == null) throwNullFieldException("userAdminRights", flags);
            writeTLObject(userAdminRights, stream);
        }
        if ((flags & 4) != 0) {
            if (botAdminRights == null) throwNullFieldException("botAdminRights", flags);
            writeTLObject(botAdminRights, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        creator = (flags & 1) != 0;
        botParticipant = (flags & 32) != 0;
        hasUsername = (flags & 8) != 0 ? readTLBool(stream) : false;
        forum = (flags & 16) != 0 ? readTLBool(stream) : false;
        userAdminRights = (flags & 2) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
        botAdminRights = (flags & 4) != 0 ? readTLObject(stream, context, TLChatAdminRights.class, TLChatAdminRights.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 16) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 2) != 0) {
            if (userAdminRights == null) throwNullFieldException("userAdminRights", flags);
            size += userAdminRights.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (botAdminRights == null) throwNullFieldException("botAdminRights", flags);
            size += botAdminRights.computeSerializedSize();
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

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean getBotParticipant() {
        return botParticipant;
    }

    public void setBotParticipant(boolean botParticipant) {
        this.botParticipant = botParticipant;
    }

    public boolean getHasUsername() {
        return hasUsername;
    }

    public void setHasUsername(boolean hasUsername) {
        this.hasUsername = hasUsername;
    }

    public boolean getForum() {
        return forum;
    }

    public void setForum(boolean forum) {
        this.forum = forum;
    }

    public TLChatAdminRights getUserAdminRights() {
        return userAdminRights;
    }

    public void setUserAdminRights(TLChatAdminRights userAdminRights) {
        this.userAdminRights = userAdminRights;
    }

    public TLChatAdminRights getBotAdminRights() {
        return botAdminRights;
    }

    public void setBotAdminRights(TLChatAdminRights botAdminRights) {
        this.botAdminRights = botAdminRights;
    }
}
