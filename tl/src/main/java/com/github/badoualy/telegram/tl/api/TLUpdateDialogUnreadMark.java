package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.peer.TLAbsDialogPeer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLUpdateDialogUnreadMark extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xe16459c3;

    protected int flags;
    protected boolean unread;
    protected TLAbsDialogPeer peer;

    private final String _constructor = "updateDialogUnreadMark#e16459c3";

    public TLUpdateDialogUnreadMark() {
    }

    public TLUpdateDialogUnreadMark(boolean unread, TLAbsDialogPeer peer) {
        this.unread = unread;
        this.peer = peer;
    }

    private void computeFlags() {
        flags = 0;
        flags = unread ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(peer, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        unread = (flags & 1) != 0;
        peer = readTLObject(stream, context, TLAbsDialogPeer.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
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

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }

    public TLAbsDialogPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsDialogPeer peer) {
        this.peer = peer;
    }
}
