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
public class TLInputBusinessAwayMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean offlineOnly;

    protected int shortcutId;

    protected TLAbsBusinessAwayMessageSchedule schedule;

    protected TLInputBusinessRecipients recipients;

    private final String _constructor = "inputBusinessAwayMessage#0";

    public TLInputBusinessAwayMessage() {
    }

    public TLInputBusinessAwayMessage(boolean offlineOnly, int shortcutId, TLAbsBusinessAwayMessageSchedule schedule, TLInputBusinessRecipients recipients) {
        this.offlineOnly = offlineOnly;
        this.shortcutId = shortcutId;
        this.schedule = schedule;
        this.recipients = recipients;
    }

    private void computeFlags() {
        flags = 0;
        flags = offlineOnly ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(shortcutId, stream);
        writeTLObject(schedule, stream);
        writeTLObject(recipients, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        offlineOnly = (flags & 1) != 0;
        shortcutId = readInt(stream);
        schedule = readTLObject(stream, context, TLAbsBusinessAwayMessageSchedule.class, -1);
        recipients = readTLObject(stream, context, TLInputBusinessRecipients.class, TLInputBusinessRecipients.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += schedule.computeSerializedSize();
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

    public boolean getOfflineOnly() {
        return offlineOnly;
    }

    public void setOfflineOnly(boolean offlineOnly) {
        this.offlineOnly = offlineOnly;
    }

    public int getShortcutId() {
        return shortcutId;
    }

    public void setShortcutId(int shortcutId) {
        this.shortcutId = shortcutId;
    }

    public TLAbsBusinessAwayMessageSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(TLAbsBusinessAwayMessageSchedule schedule) {
        this.schedule = schedule;
    }

    public TLInputBusinessRecipients getRecipients() {
        return recipients;
    }

    public void setRecipients(TLInputBusinessRecipients recipients) {
        this.recipients = recipients;
    }
}
