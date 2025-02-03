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
public class TLRequestPeerTypeUser extends TLAbsRequestPeerType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean bot;

    protected boolean premium;

    private final String _constructor = "requestPeerTypeUser#0";

    public TLRequestPeerTypeUser() {
    }

    public TLRequestPeerTypeUser(boolean bot, boolean premium) {
        this.bot = bot;
        this.premium = premium;
    }

    private void computeFlags() {
        flags = 0;
        flags = bot != null ? (flags | 1) : (flags & ~1);
        flags = premium != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            writeBoolean(bot, stream);
        }
        if ((flags & 2) != 0) {
            writeBoolean(premium, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        bot = (flags & 1) != 0 ? readTLBool(stream) : false;
        premium = (flags & 2) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 2) != 0) {
            size += SIZE_BOOLEAN;
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

    public boolean getBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public boolean getPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }
}
