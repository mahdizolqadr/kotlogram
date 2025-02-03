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
public class TLDialogFolder extends TLAbsDialog {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLFolder folder;

    protected int unreadMutedPeersCount;

    protected int unreadUnmutedPeersCount;

    protected int unreadMutedMessagesCount;

    protected int unreadUnmutedMessagesCount;

    private final String _constructor = "dialogFolder#0";

    public TLDialogFolder() {
    }

    public TLDialogFolder(boolean pinned, TLFolder folder, TLAbsPeer peer, int topMessage, int unreadMutedPeersCount, int unreadUnmutedPeersCount, int unreadMutedMessagesCount, int unreadUnmutedMessagesCount) {
        this.pinned = pinned;
        this.folder = folder;
        this.peer = peer;
        this.topMessage = topMessage;
        this.unreadMutedPeersCount = unreadMutedPeersCount;
        this.unreadUnmutedPeersCount = unreadUnmutedPeersCount;
        this.unreadMutedMessagesCount = unreadMutedMessagesCount;
        this.unreadUnmutedMessagesCount = unreadUnmutedMessagesCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(folder, stream);
        writeTLObject(peer, stream);
        writeInt(topMessage, stream);
        writeInt(unreadMutedPeersCount, stream);
        writeInt(unreadUnmutedPeersCount, stream);
        writeInt(unreadMutedMessagesCount, stream);
        writeInt(unreadUnmutedMessagesCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 4) != 0;
        folder = readTLObject(stream, context, TLFolder.class, TLFolder.CONSTRUCTOR_ID);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        topMessage = readInt(stream);
        unreadMutedPeersCount = readInt(stream);
        unreadUnmutedPeersCount = readInt(stream);
        unreadMutedMessagesCount = readInt(stream);
        unreadUnmutedMessagesCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += folder.computeSerializedSize();
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
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

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public TLFolder getFolder() {
        return folder;
    }

    public void setFolder(TLFolder folder) {
        this.folder = folder;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int topMessage) {
        this.topMessage = topMessage;
    }

    public int getUnreadMutedPeersCount() {
        return unreadMutedPeersCount;
    }

    public void setUnreadMutedPeersCount(int unreadMutedPeersCount) {
        this.unreadMutedPeersCount = unreadMutedPeersCount;
    }

    public int getUnreadUnmutedPeersCount() {
        return unreadUnmutedPeersCount;
    }

    public void setUnreadUnmutedPeersCount(int unreadUnmutedPeersCount) {
        this.unreadUnmutedPeersCount = unreadUnmutedPeersCount;
    }

    public int getUnreadMutedMessagesCount() {
        return unreadMutedMessagesCount;
    }

    public void setUnreadMutedMessagesCount(int unreadMutedMessagesCount) {
        this.unreadMutedMessagesCount = unreadMutedMessagesCount;
    }

    public int getUnreadUnmutedMessagesCount() {
        return unreadUnmutedMessagesCount;
    }

    public void setUnreadUnmutedMessagesCount(int unreadUnmutedMessagesCount) {
        this.unreadUnmutedMessagesCount = unreadUnmutedMessagesCount;
    }
}
