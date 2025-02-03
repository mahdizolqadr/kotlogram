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
public class TLUrlAuthResultRequest extends TLAbsUrlAuthResult {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean requestWriteAccess;

    protected TLAbsUser bot;

    protected String domain;

    private final String _constructor = "urlAuthResultRequest#0";

    public TLUrlAuthResultRequest() {
    }

    public TLUrlAuthResultRequest(boolean requestWriteAccess, TLAbsUser bot, String domain) {
        this.requestWriteAccess = requestWriteAccess;
        this.bot = bot;
        this.domain = domain;
    }

    private void computeFlags() {
        flags = 0;
        flags = requestWriteAccess ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(bot, stream);
        writeString(domain, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requestWriteAccess = (flags & 1) != 0;
        bot = readTLObject(stream, context, TLAbsUser.class, -1);
        domain = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += bot.computeSerializedSize();
        size += computeTLStringSerializedSize(domain);
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

    public boolean getRequestWriteAccess() {
        return requestWriteAccess;
    }

    public void setRequestWriteAccess(boolean requestWriteAccess) {
        this.requestWriteAccess = requestWriteAccess;
    }

    public TLAbsUser getBot() {
        return bot;
    }

    public void setBot(TLAbsUser bot) {
        this.bot = bot;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
