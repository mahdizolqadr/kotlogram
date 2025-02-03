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
public class TLUpdateDialogUnreadMark extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean unread;

    protected TLAbsDialogPeer peer;

    private final String _constructor = "updateDialogUnreadMark#0";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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

    public boolean getUnread() {
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
