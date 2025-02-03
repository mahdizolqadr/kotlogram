package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLForumTopic extends TLAbsForumTopic {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean my;

    protected boolean closed;

    protected boolean pinned;

    protected boolean sshort;

    protected boolean hidden;

    protected int date;

    protected String title;

    protected int iconColor;

    protected Long iconEmojiId;

    protected int topMessage;

    protected int readInboxMaxId;

    protected int readOutboxMaxId;

    protected int unreadCount;

    protected int unreadMentionsCount;

    protected int unreadReactionsCount;

    protected TLAbsPeer fromId;

    protected TLPeerNotifySettings notifySettings;

    protected TLAbsDraftMessage draft;

    private final String _constructor = "forumTopic#0";

    public TLForumTopic() {
    }

    public TLForumTopic(boolean my, boolean closed, boolean pinned, boolean sshort, boolean hidden, int id, int date, String title, int iconColor, Long iconEmojiId, int topMessage, int readInboxMaxId, int readOutboxMaxId, int unreadCount, int unreadMentionsCount, int unreadReactionsCount, TLAbsPeer fromId, TLPeerNotifySettings notifySettings, TLAbsDraftMessage draft) {
        this.my = my;
        this.closed = closed;
        this.pinned = pinned;
        this.sshort = sshort;
        this.hidden = hidden;
        this.id = id;
        this.date = date;
        this.title = title;
        this.iconColor = iconColor;
        this.iconEmojiId = iconEmojiId;
        this.topMessage = topMessage;
        this.readInboxMaxId = readInboxMaxId;
        this.readOutboxMaxId = readOutboxMaxId;
        this.unreadCount = unreadCount;
        this.unreadMentionsCount = unreadMentionsCount;
        this.unreadReactionsCount = unreadReactionsCount;
        this.fromId = fromId;
        this.notifySettings = notifySettings;
        this.draft = draft;
    }

    private void computeFlags() {
        flags = 0;
        flags = my ? (flags | 2) : (flags & ~2);
        flags = closed ? (flags | 4) : (flags & ~4);
        flags = pinned ? (flags | 8) : (flags & ~8);
        flags = sshort ? (flags | 32) : (flags & ~32);
        flags = hidden ? (flags | 64) : (flags & ~64);
        flags = iconEmojiId != null ? (flags | 1) : (flags & ~1);
        flags = draft != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeInt(date, stream);
        writeString(title, stream);
        writeInt(iconColor, stream);
        if ((flags & 1) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            writeLong(iconEmojiId, stream);
        }
        writeInt(topMessage, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(readOutboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeInt(unreadMentionsCount, stream);
        writeInt(unreadReactionsCount, stream);
        writeTLObject(fromId, stream);
        writeTLObject(notifySettings, stream);
        if ((flags & 16) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            writeTLObject(draft, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        my = (flags & 2) != 0;
        closed = (flags & 4) != 0;
        pinned = (flags & 8) != 0;
        sshort = (flags & 32) != 0;
        hidden = (flags & 64) != 0;
        id = readInt(stream);
        date = readInt(stream);
        title = readTLString(stream);
        iconColor = readInt(stream);
        iconEmojiId = (flags & 1) != 0 ? readLong(stream) : null;
        topMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        readOutboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadMentionsCount = readInt(stream);
        unreadReactionsCount = readInt(stream);
        fromId = readTLObject(stream, context, TLAbsPeer.class, -1);
        notifySettings = readTLObject(stream, context, TLPeerNotifySettings.class, TLPeerNotifySettings.CONSTRUCTOR_ID);
        draft = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsDraftMessage.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (iconEmojiId == null) throwNullFieldException("iconEmojiId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += fromId.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        if ((flags & 16) != 0) {
            if (draft == null) throwNullFieldException("draft", flags);
            size += draft.computeSerializedSize();
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

    public boolean getMy() {
        return my;
    }

    public void setMy(boolean my) {
        this.my = my;
    }

    public boolean getClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean getPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public boolean getSshort() {
        return sshort;
    }

    public void setSshort(boolean sshort) {
        this.sshort = sshort;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIconColor() {
        return iconColor;
    }

    public void setIconColor(int iconColor) {
        this.iconColor = iconColor;
    }

    public Long getIconEmojiId() {
        return iconEmojiId;
    }

    public void setIconEmojiId(Long iconEmojiId) {
        this.iconEmojiId = iconEmojiId;
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

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public TLPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public TLAbsDraftMessage getDraft() {
        return draft;
    }

    public void setDraft(TLAbsDraftMessage draft) {
        this.draft = draft;
    }
}
