package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.contacts.TLAbsTopPeers;
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
public class TLRequestContactsGetTopPeers extends TLMethod<TLAbsTopPeers> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean correspondents;

    protected boolean botsPm;

    protected boolean botsInline;

    protected boolean phoneCalls;

    protected boolean forwardUsers;

    protected boolean forwardChats;

    protected boolean groups;

    protected boolean channels;

    protected boolean botsApp;

    protected int offset;

    protected int limit;

    protected long hash;

    private final String _constructor = "contacts.getTopPeers#0";

    public TLRequestContactsGetTopPeers() {
    }

    public TLRequestContactsGetTopPeers(boolean correspondents, boolean botsPm, boolean botsInline, boolean phoneCalls, boolean forwardUsers, boolean forwardChats, boolean groups, boolean channels, boolean botsApp, int offset, int limit, long hash) {
        this.correspondents = correspondents;
        this.botsPm = botsPm;
        this.botsInline = botsInline;
        this.phoneCalls = phoneCalls;
        this.forwardUsers = forwardUsers;
        this.forwardChats = forwardChats;
        this.groups = groups;
        this.channels = channels;
        this.botsApp = botsApp;
        this.offset = offset;
        this.limit = limit;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsTopPeers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsTopPeers)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsTopPeers) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = correspondents ? (flags | 1) : (flags & ~1);
        flags = botsPm ? (flags | 2) : (flags & ~2);
        flags = botsInline ? (flags | 4) : (flags & ~4);
        flags = phoneCalls ? (flags | 8) : (flags & ~8);
        flags = forwardUsers ? (flags | 16) : (flags & ~16);
        flags = forwardChats ? (flags | 32) : (flags & ~32);
        flags = groups ? (flags | 1024) : (flags & ~1024);
        flags = channels ? (flags | 32768) : (flags & ~32768);
        flags = botsApp ? (flags | 65536) : (flags & ~65536);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(offset, stream);
        writeInt(limit, stream);
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        correspondents = (flags & 1) != 0;
        botsPm = (flags & 2) != 0;
        botsInline = (flags & 4) != 0;
        phoneCalls = (flags & 8) != 0;
        forwardUsers = (flags & 16) != 0;
        forwardChats = (flags & 32) != 0;
        groups = (flags & 1024) != 0;
        channels = (flags & 32768) != 0;
        botsApp = (flags & 65536) != 0;
        offset = readInt(stream);
        limit = readInt(stream);
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public boolean getCorrespondents() {
        return correspondents;
    }

    public void setCorrespondents(boolean correspondents) {
        this.correspondents = correspondents;
    }

    public boolean getBotsPm() {
        return botsPm;
    }

    public void setBotsPm(boolean botsPm) {
        this.botsPm = botsPm;
    }

    public boolean getBotsInline() {
        return botsInline;
    }

    public void setBotsInline(boolean botsInline) {
        this.botsInline = botsInline;
    }

    public boolean getPhoneCalls() {
        return phoneCalls;
    }

    public void setPhoneCalls(boolean phoneCalls) {
        this.phoneCalls = phoneCalls;
    }

    public boolean getForwardUsers() {
        return forwardUsers;
    }

    public void setForwardUsers(boolean forwardUsers) {
        this.forwardUsers = forwardUsers;
    }

    public boolean getForwardChats() {
        return forwardChats;
    }

    public void setForwardChats(boolean forwardChats) {
        this.forwardChats = forwardChats;
    }

    public boolean getGroups() {
        return groups;
    }

    public void setGroups(boolean groups) {
        this.groups = groups;
    }

    public boolean getChannels() {
        return channels;
    }

    public void setChannels(boolean channels) {
        this.channels = channels;
    }

    public boolean getBotsApp() {
        return botsApp;
    }

    public void setBotsApp(boolean botsApp) {
        this.botsApp = botsApp;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
