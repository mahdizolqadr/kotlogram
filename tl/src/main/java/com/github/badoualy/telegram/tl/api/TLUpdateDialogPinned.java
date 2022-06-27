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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateDialogPinned extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x6e6fe51c;

    protected int flags;
    protected boolean pinned;
    protected Integer folderId;
    protected TLAbsDialogPeer peer;

    private final String _constructor = "updateDialogPinned#6e6fe51c";

    public TLUpdateDialogPinned() {
    }

    public TLUpdateDialogPinned(boolean pinned, Integer folderId, TLAbsDialogPeer peer) {
        this.pinned = pinned;
        this.folderId = folderId;
        this.peer = peer;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 1) : (flags & ~1);
        flags = folderId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (folderId == null) {
                throwNullFieldException("folderId", flags);
            }
            writeInt(folderId, stream);
        }
        writeTLObject(peer, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 1) != 0;
        folderId = (flags & 2) != 0 ? readInt(stream) : null;
        peer = readTLObject(stream, context, TLAbsDialogPeer.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (folderId == null) {
                throwNullFieldException("folderId", flags);
            }
            size += SIZE_INT32;
        }
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

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public TLAbsDialogPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsDialogPeer peer) {
        this.peer = peer;
    }
}
