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
public class TLReactionsNotifySettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsReactionNotificationsFrom messagesNotifyFrom;

    protected TLAbsReactionNotificationsFrom storiesNotifyFrom;

    protected TLAbsNotificationSound sound;

    protected boolean showPreviews;

    private final String _constructor = "reactionsNotifySettings#0";

    public TLReactionsNotifySettings() {
    }

    public TLReactionsNotifySettings(TLAbsReactionNotificationsFrom messagesNotifyFrom, TLAbsReactionNotificationsFrom storiesNotifyFrom, TLAbsNotificationSound sound, boolean showPreviews) {
        this.messagesNotifyFrom = messagesNotifyFrom;
        this.storiesNotifyFrom = storiesNotifyFrom;
        this.sound = sound;
        this.showPreviews = showPreviews;
    }

    private void computeFlags() {
        flags = 0;
        flags = messagesNotifyFrom != null ? (flags | 1) : (flags & ~1);
        flags = storiesNotifyFrom != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (messagesNotifyFrom == null) throwNullFieldException("messagesNotifyFrom", flags);
            writeTLObject(messagesNotifyFrom, stream);
        }
        if ((flags & 2) != 0) {
            if (storiesNotifyFrom == null) throwNullFieldException("storiesNotifyFrom", flags);
            writeTLObject(storiesNotifyFrom, stream);
        }
        writeTLObject(sound, stream);
        writeBoolean(showPreviews, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        messagesNotifyFrom = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsReactionNotificationsFrom.class, -1) : null;
        storiesNotifyFrom = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsReactionNotificationsFrom.class, -1) : null;
        sound = readTLObject(stream, context, TLAbsNotificationSound.class, -1);
        showPreviews = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (messagesNotifyFrom == null) throwNullFieldException("messagesNotifyFrom", flags);
            size += messagesNotifyFrom.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (storiesNotifyFrom == null) throwNullFieldException("storiesNotifyFrom", flags);
            size += storiesNotifyFrom.computeSerializedSize();
        }
        size += sound.computeSerializedSize();
        size += SIZE_BOOLEAN;
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

    public TLAbsReactionNotificationsFrom getMessagesNotifyFrom() {
        return messagesNotifyFrom;
    }

    public void setMessagesNotifyFrom(TLAbsReactionNotificationsFrom messagesNotifyFrom) {
        this.messagesNotifyFrom = messagesNotifyFrom;
    }

    public TLAbsReactionNotificationsFrom getStoriesNotifyFrom() {
        return storiesNotifyFrom;
    }

    public void setStoriesNotifyFrom(TLAbsReactionNotificationsFrom storiesNotifyFrom) {
        this.storiesNotifyFrom = storiesNotifyFrom;
    }

    public TLAbsNotificationSound getSound() {
        return sound;
    }

    public void setSound(TLAbsNotificationSound sound) {
        this.sound = sound;
    }

    public boolean getShowPreviews() {
        return showPreviews;
    }

    public void setShowPreviews(boolean showPreviews) {
        this.showPreviews = showPreviews;
    }
}
