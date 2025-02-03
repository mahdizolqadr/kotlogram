package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLInputBusinessBotRecipients;
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
public class TLRequestAccountUpdateConnectedBot extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean canReply;

    protected boolean deleted;

    protected TLAbsInputUser bot;

    protected TLInputBusinessBotRecipients recipients;

    private final String _constructor = "account.updateConnectedBot#0";

    public TLRequestAccountUpdateConnectedBot() {
    }

    public TLRequestAccountUpdateConnectedBot(boolean canReply, boolean deleted, TLAbsInputUser bot, TLInputBusinessBotRecipients recipients) {
        this.canReply = canReply;
        this.deleted = deleted;
        this.bot = bot;
        this.recipients = recipients;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = canReply ? (flags | 1) : (flags & ~1);
        flags = deleted ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(bot, stream);
        writeTLObject(recipients, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canReply = (flags & 1) != 0;
        deleted = (flags & 2) != 0;
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        recipients = readTLObject(stream, context, TLInputBusinessBotRecipients.class, TLInputBusinessBotRecipients.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += bot.computeSerializedSize();
        size += recipients.computeSerializedSize();
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

    public boolean getCanReply() {
        return canReply;
    }

    public void setCanReply(boolean canReply) {
        this.canReply = canReply;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public TLInputBusinessBotRecipients getRecipients() {
        return recipients;
    }

    public void setRecipients(TLInputBusinessBotRecipients recipients) {
        this.recipients = recipients;
    }
}
