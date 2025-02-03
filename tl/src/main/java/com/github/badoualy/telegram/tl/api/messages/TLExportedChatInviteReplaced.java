package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLExportedChatInviteReplaced extends TLAbsExportedChatInvite {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite newInvite;

    private final String _constructor = "messages.exportedChatInviteReplaced#0";

    public TLExportedChatInviteReplaced() {
    }

    public TLExportedChatInviteReplaced(com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite invite, com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite newInvite, TLVector<TLAbsUser> users) {
        this.invite = invite;
        this.newInvite = newInvite;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(invite, stream);
        writeTLObject(newInvite, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        invite = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite.class, -1);
        newInvite = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite.class, -1);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += invite.computeSerializedSize();
        size += newInvite.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite getInvite() {
        return invite;
    }

    public void setInvite(com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite invite) {
        this.invite = invite;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite getNewInvite() {
        return newInvite;
    }

    public void setNewInvite(com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite newInvite) {
        this.newInvite = newInvite;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
