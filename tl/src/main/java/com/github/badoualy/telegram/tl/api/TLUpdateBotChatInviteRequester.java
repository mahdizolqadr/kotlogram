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
public class TLUpdateBotChatInviteRequester extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPeer peer;

    protected int date;

    protected long userId;

    protected String about;

    protected TLAbsExportedChatInvite invite;

    protected int qts;

    private final String _constructor = "updateBotChatInviteRequester#0";

    public TLUpdateBotChatInviteRequester() {
    }

    public TLUpdateBotChatInviteRequester(TLAbsPeer peer, int date, long userId, String about, TLAbsExportedChatInvite invite, int qts) {
        this.peer = peer;
        this.date = date;
        this.userId = userId;
        this.about = about;
        this.invite = invite;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeInt(date, stream);
        writeLong(userId, stream);
        writeString(about, stream);
        writeTLObject(invite, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        date = readInt(stream);
        userId = readLong(stream);
        about = readTLString(stream);
        invite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(about);
        size += invite.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
