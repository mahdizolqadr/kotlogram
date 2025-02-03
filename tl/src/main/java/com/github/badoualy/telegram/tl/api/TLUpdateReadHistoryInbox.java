package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateReadHistoryInbox extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer folderId;

    protected TLAbsPeer peer;

    protected int maxId;

    protected int stillUnreadCount;

    protected int pts;

    protected int ptsCount;

    private final String _constructor = "updateReadHistoryInbox#0";

    public TLUpdateReadHistoryInbox() {
    }

    public TLUpdateReadHistoryInbox(Integer folderId, TLAbsPeer peer, int maxId, int stillUnreadCount, int pts, int ptsCount) {
        this.folderId = folderId;
        this.peer = peer;
        this.maxId = maxId;
        this.stillUnreadCount = stillUnreadCount;
        this.pts = pts;
        this.ptsCount = ptsCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = folderId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        writeTLObject(peer, stream);
        writeInt(maxId, stream);
        writeInt(stillUnreadCount, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        folderId = (flags & 1) != 0 ? readInt(stream) : null;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        maxId = readInt(stream);
        stillUnreadCount = readInt(stream);
        pts = readInt(stream);
        ptsCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getStillUnreadCount() {
        return stillUnreadCount;
    }

    public void setStillUnreadCount(int stillUnreadCount) {
        this.stillUnreadCount = stillUnreadCount;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }
}
