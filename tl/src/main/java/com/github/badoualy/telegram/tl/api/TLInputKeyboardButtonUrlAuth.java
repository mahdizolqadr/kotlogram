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
public class TLInputKeyboardButtonUrlAuth extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean requestWriteAccess;

    protected String fwdText;

    protected String url;

    protected TLAbsInputUser bot;

    private final String _constructor = "inputKeyboardButtonUrlAuth#0";

    public TLInputKeyboardButtonUrlAuth() {
    }

    public TLInputKeyboardButtonUrlAuth(boolean requestWriteAccess, String text, String fwdText, String url, TLAbsInputUser bot) {
        this.requestWriteAccess = requestWriteAccess;
        this.text = text;
        this.fwdText = fwdText;
        this.url = url;
        this.bot = bot;
    }

    private void computeFlags() {
        flags = 0;
        flags = requestWriteAccess ? (flags | 1) : (flags & ~1);
        flags = fwdText != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(text, stream);
        if ((flags & 2) != 0) {
            if (fwdText == null) throwNullFieldException("fwdText", flags);
            writeString(fwdText, stream);
        }
        writeString(url, stream);
        writeTLObject(bot, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        requestWriteAccess = (flags & 1) != 0;
        text = readTLString(stream);
        fwdText = (flags & 2) != 0 ? readTLString(stream) : null;
        url = readTLString(stream);
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(text);
        if ((flags & 2) != 0) {
            if (fwdText == null) throwNullFieldException("fwdText", flags);
            size += computeTLStringSerializedSize(fwdText);
        }
        size += computeTLStringSerializedSize(url);
        size += bot.computeSerializedSize();
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFwdText() {
        return fwdText;
    }

    public void setFwdText(String fwdText) {
        this.fwdText = fwdText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }
}
