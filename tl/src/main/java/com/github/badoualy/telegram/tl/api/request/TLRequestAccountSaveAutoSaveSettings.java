package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAutoSaveSettings;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountSaveAutoSaveSettings extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean users;

    protected boolean chats;

    protected boolean broadcasts;

    protected TLAbsInputPeer peer;

    protected TLAutoSaveSettings settings;

    private final String _constructor = "account.saveAutoSaveSettings#0";

    public TLRequestAccountSaveAutoSaveSettings() {
    }

    public TLRequestAccountSaveAutoSaveSettings(boolean users, boolean chats, boolean broadcasts, TLAbsInputPeer peer, TLAutoSaveSettings settings) {
        this.users = users;
        this.chats = chats;
        this.broadcasts = broadcasts;
        this.peer = peer;
        this.settings = settings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = users ? (flags | 1) : (flags & ~1);
        flags = chats ? (flags | 2) : (flags & ~2);
        flags = broadcasts ? (flags | 4) : (flags & ~4);
        flags = peer != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 8) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        users = (flags & 1) != 0;
        chats = (flags & 2) != 0;
        broadcasts = (flags & 4) != 0;
        peer = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        settings = readTLObject(stream, context, TLAutoSaveSettings.class, TLAutoSaveSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
        }
        size += settings.computeSerializedSize();
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

    public boolean getUsers() {
        return users;
    }

    public void setUsers(boolean users) {
        this.users = users;
    }

    public boolean getChats() {
        return chats;
    }

    public void setChats(boolean chats) {
        this.chats = chats;
    }

    public boolean getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(boolean broadcasts) {
        this.broadcasts = broadcasts;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAutoSaveSettings getSettings() {
        return settings;
    }

    public void setSettings(TLAutoSaveSettings settings) {
        this.settings = settings;
    }
}
