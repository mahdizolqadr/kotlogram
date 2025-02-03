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
public class TLDialog extends TLAbsDialog {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean unreadMark;

    protected boolean viewForumAsMessages;

    protected int readInboxMaxId;

    protected int readOutboxMaxId;

    protected int unreadCount;

    protected int unreadMentionsCount;

    protected int unreadReactionsCount;

    protected TLPeerNotifySettings notifySettings;

    protected Integer pts;

    protected TLAbsDraftMessage draft;

    protected Integer folderId;

    protected Integer ttlPeriod;

    private final String _constructor = "dialog#0";

    public TLDialog() {
    }

    public TLDialog(boolean pinned, boolean unreadMark, boolean viewForumAsMessages, TLAbsPeer peer, int topMessage, int readInboxMaxId, int readOutboxMaxId, int unreadCount, int unreadMentionsCount, int unreadReactionsCount, TLPeerNotifySettings notifySettings, Integer pts, TLAbsDraftMessage draft, Integer folderId, Integer ttlPeriod) {
        this.pinned = pinned;
        this.unreadMark = unreadMark;
        this.viewForumAsMessages = viewForumAsMessages;
        this.peer = peer;
        this.topMessage = topMessage;
        this.readInboxMaxId = readInboxMaxId;
        this.readOutboxMaxId = readOutboxMaxId;
        this.unreadCount = unreadCount;
        this.unreadMentionsCount = unreadMentionsCount;
        this.unreadReactionsCount = unreadReactionsCount;
        this.notifySettings = notifySettings;
        this.pts = pts;
        this.draft = draft;
        this.folderId = folderId;
        this.ttlPeriod = ttlPeriod;
    }

    private void computeFlags() {
        flags = 0;
        flags = pinned ? (flags | 4) : (flags & ~4);
        flags = unreadMark ? (flags | 8) : (flags & ~8);
        flags = viewForumAsMessages ? (flags | 64) : (flags & ~64);
        flags = pts != null ? (flags | 1) : (flags & ~1);
        flags = draft != null ? (flags | 2) : (flags & ~2);
        flags = folderId != null ? (flags | 16) : (flags & ~16);
        flags = ttlPeriod != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(topMessage, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(readOutboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeInt(unreadMentionsCount, stream);
        writeInt(unreadReactionsCount, stream);
        writeTLObject(notifySettings, stream);
        if ((flags & 1) != 0) {
            if (pts == null) throwNullFieldException("pts", flags);
            writeInt(pts, stream);
        }
        if ((flags & 2) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            writeTLObject(draft, stream);
        }
        if ((flags & 16) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        if ((flags & 32) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            writeInt(ttlPeriod, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pinned = (flags & 4) != 0;
        unreadMark = (flags & 8) != 0;
        viewForumAsMessages = (flags & 64) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        topMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        readOutboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadMentionsCount = readInt(stream);
        unreadReactionsCount = readInt(stream);
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
        pts = (flags & 1) != 0 ? readInt(stream) : null;
        draft = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsDraftMessage.class, -1) : null;
        folderId = (flags & 16) != 0 ? readInt(stream) : null;
        ttlPeriod = (flags & 32) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += notifySettings.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (pts == null) throwNullFieldException("pts", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            size += draft.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (ttlPeriod == null) throwNullFieldException("ttlPeriod", flags);
            size += SIZE_INT32;
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

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean getUnreadMark() {
        return unreadMark;
    }

    public void setUnreadMark(boolean unreadMark) {
        this.unreadMark = unreadMark;
    }

    public boolean getViewForumAsMessages() {
        return viewForumAsMessages;
    }

    public void setViewForumAsMessages(boolean viewForumAsMessages) {
        this.viewForumAsMessages = viewForumAsMessages;
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

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getReadOutboxMaxId() {
        return readOutboxMaxId;
    }

    public void setReadOutboxMaxId(int readOutboxMaxId) {
        this.readOutboxMaxId = readOutboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getUnreadMentionsCount() {
        return unreadMentionsCount;
    }

    public void setUnreadMentionsCount(int unreadMentionsCount) {
        this.unreadMentionsCount = unreadMentionsCount;
    }

    public int getUnreadReactionsCount() {
        return unreadReactionsCount;
    }

    public void setUnreadReactionsCount(int unreadReactionsCount) {
        this.unreadReactionsCount = unreadReactionsCount;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public Integer getPts() {
        return pts;
    }

    public void setPts(Integer pts) {
        this.pts = pts;
    }

    public TLAbsDraftMessage getDraft() {
        return draft;
    }

    public void setDraft(TLAbsDraftMessage draft) {
        this.draft = draft;
    }

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public Integer getTtlPeriod() {
        return ttlPeriod;
    }

    public void setTtlPeriod(Integer ttlPeriod) {
        this.ttlPeriod = ttlPeriod;
    }
}
