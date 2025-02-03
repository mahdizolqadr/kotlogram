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
public class TLBusinessGreetingMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int shortcutId;

    protected TLBusinessRecipients recipients;

    protected int noActivityDays;

    private final String _constructor = "businessGreetingMessage#0";

    public TLBusinessGreetingMessage() {
    }

    public TLBusinessGreetingMessage(int shortcutId, TLBusinessRecipients recipients, int noActivityDays) {
        this.shortcutId = shortcutId;
        this.recipients = recipients;
        this.noActivityDays = noActivityDays;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(shortcutId, stream);
        writeTLObject(recipients, stream);
        writeInt(noActivityDays, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        shortcutId = readInt(stream);
        recipients = readTLObject(stream, context, TLBusinessRecipients.class, TLBusinessRecipients.CONSTRUCTOR_ID);
        noActivityDays = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += recipients.computeSerializedSize();
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

    public int getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(int shortcutId) {
        this.shortcutId = shortcutId;
    }

    public TLBusinessRecipients getRecipients() {
        return recipients;
    }

    public void setRecipients(TLBusinessRecipients recipients) {
        this.recipients = recipients;
    }

    public int getNoActivityDays() {
        return noActivityDays;
    }

    public void setNoActivityDays(int noActivityDays) {
        this.noActivityDays = noActivityDays;
    }
}
