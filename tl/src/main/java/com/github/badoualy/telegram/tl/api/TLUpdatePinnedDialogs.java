package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.peer.TLAbsDialogPeer;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatePinnedDialogs extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xfa0f3ca2;

    protected int flags;
    protected Integer folderId;
    protected TLVector<TLAbsDialogPeer> order;

    private final String _constructor = "updatePinnedDialogs#fa0f3ca2";

    public TLUpdatePinnedDialogs() {
    }

    public TLUpdatePinnedDialogs(Integer folderId, TLVector<TLAbsDialogPeer> order) {
        this.folderId = folderId;
        this.order = order;
    }

    private void computeFlags() {
        flags = 0;
        flags = folderId != null ? (flags | 2) : (flags & ~2);
        flags = order != null ? (flags | 1) : (flags & ~1);
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
        if ((flags & 1) != 0) {
            if (order == null) {
                throwNullFieldException("order", flags);
            }
            writeTLVector(order, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        folderId = (flags & 2) != 0 ? readInt(stream) : null;
        order = (flags & 1) != 0 ? readTLVector(stream, context) : null;
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
        if ((flags & 1) != 0) {
            if (order == null) {
                throwNullFieldException("order", flags);
            }
            size += order.computeSerializedSize();
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

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public TLVector<TLAbsDialogPeer> getOrder() {
        return order;
    }

    public void setOrder(TLVector<TLAbsDialogPeer> order) {
        this.order = order;
    }
}
