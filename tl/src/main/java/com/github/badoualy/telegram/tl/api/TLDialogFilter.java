package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLDialogFilter extends TLAbsDialogFilter {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean contacts;

    protected boolean nonContacts;

    protected boolean groups;

    protected boolean broadcasts;

    protected boolean bots;

    protected boolean excludeMuted;

    protected boolean excludeRead;

    protected boolean excludeArchived;

    protected int id;

    protected String title;

    protected String emoticon;

    protected Integer color;

    protected TLVector<TLAbsInputPeer> pinnedPeers;

    protected TLVector<TLAbsInputPeer> includePeers;

    protected TLVector<TLAbsInputPeer> excludePeers;

    private final String _constructor = "dialogFilter#0";

    public TLDialogFilter() {
    }

    public TLDialogFilter(boolean contacts, boolean nonContacts, boolean groups, boolean broadcasts, boolean bots, boolean excludeMuted, boolean excludeRead, boolean excludeArchived, int id, String title, String emoticon, Integer color, TLVector<TLAbsInputPeer> pinnedPeers, TLVector<TLAbsInputPeer> includePeers, TLVector<TLAbsInputPeer> excludePeers) {
        this.contacts = contacts;
        this.nonContacts = nonContacts;
        this.groups = groups;
        this.broadcasts = broadcasts;
        this.bots = bots;
        this.excludeMuted = excludeMuted;
        this.excludeRead = excludeRead;
        this.excludeArchived = excludeArchived;
        this.id = id;
        this.title = title;
        this.emoticon = emoticon;
        this.color = color;
        this.pinnedPeers = pinnedPeers;
        this.includePeers = includePeers;
        this.excludePeers = excludePeers;
    }

    private void computeFlags() {
        flags = 0;
        flags = contacts ? (flags | 1) : (flags & ~1);
        flags = nonContacts ? (flags | 2) : (flags & ~2);
        flags = groups ? (flags | 4) : (flags & ~4);
        flags = broadcasts ? (flags | 8) : (flags & ~8);
        flags = bots ? (flags | 16) : (flags & ~16);
        flags = excludeMuted ? (flags | 2048) : (flags & ~2048);
        flags = excludeRead ? (flags | 4096) : (flags & ~4096);
        flags = excludeArchived ? (flags | 8192) : (flags & ~8192);
        flags = emoticon != null ? (flags | 33554432) : (flags & ~33554432);
        flags = color != null ? (flags | 134217728) : (flags & ~134217728);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(title, stream);
        if ((flags & 33554432) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            writeString(emoticon, stream);
        }
        if ((flags & 134217728) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            writeInt(color, stream);
        }
        writeTLVector(pinnedPeers, stream);
        writeTLVector(includePeers, stream);
        writeTLVector(excludePeers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        contacts = (flags & 1) != 0;
        nonContacts = (flags & 2) != 0;
        groups = (flags & 4) != 0;
        broadcasts = (flags & 8) != 0;
        bots = (flags & 16) != 0;
        excludeMuted = (flags & 2048) != 0;
        excludeRead = (flags & 4096) != 0;
        excludeArchived = (flags & 8192) != 0;
        id = readInt(stream);
        title = readTLString(stream);
        emoticon = (flags & 33554432) != 0 ? readTLString(stream) : null;
        color = (flags & 134217728) != 0 ? readInt(stream) : null;
        pinnedPeers = readTLVector(stream, context);
        includePeers = readTLVector(stream, context);
        excludePeers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        if ((flags & 33554432) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            size += computeTLStringSerializedSize(emoticon);
        }
        if ((flags & 134217728) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            size += SIZE_INT32;
        }
        size += pinnedPeers.computeSerializedSize();
        size += includePeers.computeSerializedSize();
        size += excludePeers.computeSerializedSize();
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

    public boolean getContacts() {
        return contacts;
    }

    public void setContacts(boolean contacts) {
        this.contacts = contacts;
    }

    public boolean getNonContacts() {
        return nonContacts;
    }

    public void setNonContacts(boolean nonContacts) {
        this.nonContacts = nonContacts;
    }

    public boolean getGroups() {
        return groups;
    }

    public void setGroups(boolean groups) {
        this.groups = groups;
    }

    public boolean getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(boolean broadcasts) {
        this.broadcasts = broadcasts;
    }

    public boolean getBots() {
        return bots;
    }

    public void setBots(boolean bots) {
        this.bots = bots;
    }

    public boolean getExcludeMuted() {
        return excludeMuted;
    }

    public void setExcludeMuted(boolean excludeMuted) {
        this.excludeMuted = excludeMuted;
    }

    public boolean getExcludeRead() {
        return excludeRead;
    }

    public void setExcludeRead(boolean excludeRead) {
        this.excludeRead = excludeRead;
    }

    public boolean getExcludeArchived() {
        return excludeArchived;
    }

    public void setExcludeArchived(boolean excludeArchived) {
        this.excludeArchived = excludeArchived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public TLVector<TLAbsInputPeer> getPinnedPeers() {
        return pinnedPeers;
    }

    public void setPinnedPeers(TLVector<TLAbsInputPeer> pinnedPeers) {
        this.pinnedPeers = pinnedPeers;
    }

    public TLVector<TLAbsInputPeer> getIncludePeers() {
        return includePeers;
    }

    public void setIncludePeers(TLVector<TLAbsInputPeer> includePeers) {
        this.includePeers = includePeers;
    }

    public TLVector<TLAbsInputPeer> getExcludePeers() {
        return excludePeers;
    }

    public void setExcludePeers(TLVector<TLAbsInputPeer> excludePeers) {
        this.excludePeers = excludePeers;
    }
}
