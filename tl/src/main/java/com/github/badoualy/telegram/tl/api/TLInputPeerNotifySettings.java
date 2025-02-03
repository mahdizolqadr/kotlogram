package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPeerNotifySettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean showPreviews;

    protected boolean silent;

    protected Integer muteUntil;

    protected TLAbsNotificationSound sound;

    protected boolean storiesMuted;

    protected boolean storiesHideSender;

    protected TLAbsNotificationSound storiesSound;

    private final String _constructor = "inputPeerNotifySettings#0";

    public TLInputPeerNotifySettings() {
    }

    public TLInputPeerNotifySettings(boolean showPreviews, boolean silent, Integer muteUntil, TLAbsNotificationSound sound, boolean storiesMuted, boolean storiesHideSender, TLAbsNotificationSound storiesSound) {
        this.showPreviews = showPreviews;
        this.silent = silent;
        this.muteUntil = muteUntil;
        this.sound = sound;
        this.storiesMuted = storiesMuted;
        this.storiesHideSender = storiesHideSender;
        this.storiesSound = storiesSound;
    }

    private void computeFlags() {
        flags = 0;
        flags = showPreviews != null ? (flags | 1) : (flags & ~1);
        flags = silent != null ? (flags | 2) : (flags & ~2);
        flags = muteUntil != null ? (flags | 4) : (flags & ~4);
        flags = sound != null ? (flags | 8) : (flags & ~8);
        flags = storiesMuted != null ? (flags | 64) : (flags & ~64);
        flags = storiesHideSender != null ? (flags | 128) : (flags & ~128);
        flags = storiesSound != null ? (flags | 256) : (flags & ~256);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            writeBoolean(showPreviews, stream);
        }
        if ((flags & 2) != 0) {
            writeBoolean(silent, stream);
        }
        if ((flags & 4) != 0) {
            if (muteUntil == null) throwNullFieldException("muteUntil", flags);
            writeInt(muteUntil, stream);
        }
        if ((flags & 8) != 0) {
            if (sound == null) throwNullFieldException("sound", flags);
            writeTLObject(sound, stream);
        }
        if ((flags & 64) != 0) {
            writeBoolean(storiesMuted, stream);
        }
        if ((flags & 128) != 0) {
            writeBoolean(storiesHideSender, stream);
        }
        if ((flags & 256) != 0) {
            if (storiesSound == null) throwNullFieldException("storiesSound", flags);
            writeTLObject(storiesSound, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        showPreviews = (flags & 1) != 0 ? readTLBool(stream) : false;
        silent = (flags & 2) != 0 ? readTLBool(stream) : false;
        muteUntil = (flags & 4) != 0 ? readInt(stream) : null;
        sound = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        storiesMuted = (flags & 64) != 0 ? readTLBool(stream) : false;
        storiesHideSender = (flags & 128) != 0 ? readTLBool(stream) : false;
        storiesSound = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
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
        if ((flags & 4) != 0) {
            if (muteUntil == null) throwNullFieldException("muteUntil", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (sound == null) throwNullFieldException("sound", flags);
            size += sound.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 128) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 256) != 0) {
            if (storiesSound == null) throwNullFieldException("storiesSound", flags);
            size += storiesSound.computeSerializedSize();
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

    public boolean getShowPreviews() {
        return showPreviews;
    }

    public void setShowPreviews(boolean showPreviews) {
        this.showPreviews = showPreviews;
    }

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public Integer getMuteUntil() {
        return muteUntil;
    }

    public void setMuteUntil(Integer muteUntil) {
        this.muteUntil = muteUntil;
    }

    public TLAbsNotificationSound getSound() {
        return sound;
    }

    public void setSound(TLAbsNotificationSound sound) {
        this.sound = sound;
    }

    public boolean getStoriesMuted() {
        return storiesMuted;
    }

    public void setStoriesMuted(boolean storiesMuted) {
        this.storiesMuted = storiesMuted;
    }

    public boolean getStoriesHideSender() {
        return storiesHideSender;
    }

    public void setStoriesHideSender(boolean storiesHideSender) {
        this.storiesHideSender = storiesHideSender;
    }

    public TLAbsNotificationSound getStoriesSound() {
        return storiesSound;
    }

    public void setStoriesSound(TLAbsNotificationSound storiesSound) {
        this.storiesSound = storiesSound;
    }
}
