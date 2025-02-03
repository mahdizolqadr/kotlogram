package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.messages.TLInvitedUsers;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestChannelsInviteToChannel extends TLMethod<TLInvitedUsers> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputChannel channel;

    protected TLVector<TLAbsInputUser> users;

    private final String _constructor = "channels.inviteToChannel#0";

    public TLRequestChannelsInviteToChannel() {
    }

    public TLRequestChannelsInviteToChannel(TLAbsInputChannel channel, TLVector<TLAbsInputUser> users) {
        this.channel = channel;
        this.users = users;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLInvitedUsers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLInvitedUsers)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLInvitedUsers) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(channel, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        channel = readTLObject(stream, context, TLAbsInputChannel.class, -1);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += channel.computeSerializedSize();
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

    public TLAbsInputChannel getChannel() {
        return channel;
    }

    public void setChannel(TLAbsInputChannel channel) {
        this.channel = channel;
    }

    public TLVector<TLAbsInputUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsInputUser> users) {
        this.users = users;
    }
}
