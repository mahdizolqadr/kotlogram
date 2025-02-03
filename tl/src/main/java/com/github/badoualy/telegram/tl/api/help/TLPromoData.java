package com.github.badoualy.telegram.tl.api.help;

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
public class TLPromoData extends TLAbsPromoData {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean proxy;

    protected TLAbsPeer peer;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected String psaType;

    protected String psaMessage;

    private final String _constructor = "help.promoData#0";

    public TLPromoData() {
    }

    public TLPromoData(boolean proxy, int expires, TLAbsPeer peer, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, String psaType, String psaMessage) {
        this.proxy = proxy;
        this.expires = expires;
        this.peer = peer;
        this.chats = chats;
        this.users = users;
        this.psaType = psaType;
        this.psaMessage = psaMessage;
    }

    private void computeFlags() {
        flags = 0;
        flags = proxy ? (flags | 1) : (flags & ~1);
        flags = psaType != null ? (flags | 2) : (flags & ~2);
        flags = psaMessage != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(expires, stream);
        writeTLObject(peer, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        if ((flags & 2) != 0) {
            if (psaType == null) throwNullFieldException("psaType", flags);
            writeString(psaType, stream);
        }
        if ((flags & 4) != 0) {
            if (psaMessage == null) throwNullFieldException("psaMessage", flags);
            writeString(psaMessage, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        proxy = (flags & 1) != 0;
        expires = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        psaType = (flags & 2) != 0 ? readTLString(stream) : null;
        psaMessage = (flags & 4) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (psaType == null) throwNullFieldException("psaType", flags);
            size += computeTLStringSerializedSize(psaType);
        }
        if ((flags & 4) != 0) {
            if (psaMessage == null) throwNullFieldException("psaMessage", flags);
            size += computeTLStringSerializedSize(psaMessage);
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

    public boolean getProxy() {
        return proxy;
    }

    public void setProxy(boolean proxy) {
        this.proxy = proxy;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
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

    public String getPsaType() {
        return psaType;
    }

    public void setPsaType(String psaType) {
        this.psaType = psaType;
    }

    public String getPsaMessage() {
        return psaMessage;
    }

    public void setPsaMessage(String psaMessage) {
        this.psaMessage = psaMessage;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLPromoData getAsPromoData() {
        return this;
    }
}
