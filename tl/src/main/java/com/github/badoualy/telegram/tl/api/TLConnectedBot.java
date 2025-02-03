package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLConnectedBot extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean canReply;

    protected long botId;

    protected TLBusinessBotRecipients recipients;

    private final String _constructor = "connectedBot#0";

    public TLConnectedBot() {
    }

    public TLConnectedBot(boolean canReply, long botId, TLBusinessBotRecipients recipients) {
        this.canReply = canReply;
        this.botId = botId;
        this.recipients = recipients;
    }

    private void computeFlags() {
        flags = 0;
        flags = canReply ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(botId, stream);
        writeTLObject(recipients, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canReply = (flags & 1) != 0;
        botId = readLong(stream);
        recipients = readTLObject(stream, context, TLBusinessBotRecipients.class, TLBusinessBotRecipients.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public long getBotId() {
        return botId;
    }

    public void setBotId(long botId) {
        this.botId = botId;
    }

    public TLBusinessBotRecipients getRecipients() {
        return recipients;
    }

    public void setRecipients(TLBusinessBotRecipients recipients) {
        this.recipients = recipients;
    }
}
