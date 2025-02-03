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
public class TLPeerNotifySettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean showPreviews;

    protected boolean silent;

    protected Integer muteUntil;

    protected TLAbsNotificationSound iosSound;

    protected TLAbsNotificationSound androidSound;

    protected TLAbsNotificationSound otherSound;

    protected boolean storiesMuted;

    protected boolean storiesHideSender;

    protected TLAbsNotificationSound storiesIosSound;

    protected TLAbsNotificationSound storiesAndroidSound;

    protected TLAbsNotificationSound storiesOtherSound;

    private final String _constructor = "peerNotifySettings#0";

    public TLPeerNotifySettings() {
    }

    public TLPeerNotifySettings(boolean showPreviews, boolean silent, Integer muteUntil, TLAbsNotificationSound iosSound, TLAbsNotificationSound androidSound, TLAbsNotificationSound otherSound, boolean storiesMuted, boolean storiesHideSender, TLAbsNotificationSound storiesIosSound, TLAbsNotificationSound storiesAndroidSound, TLAbsNotificationSound storiesOtherSound) {
        this.showPreviews = showPreviews;
        this.silent = silent;
        this.muteUntil = muteUntil;
        this.iosSound = iosSound;
        this.androidSound = androidSound;
        this.otherSound = otherSound;
        this.storiesMuted = storiesMuted;
        this.storiesHideSender = storiesHideSender;
        this.storiesIosSound = storiesIosSound;
        this.storiesAndroidSound = storiesAndroidSound;
        this.storiesOtherSound = storiesOtherSound;
    }

    private void computeFlags() {
        flags = 0;
        flags = showPreviews != null ? (flags | 1) : (flags & ~1);
        flags = silent != null ? (flags | 2) : (flags & ~2);
        flags = muteUntil != null ? (flags | 4) : (flags & ~4);
        flags = iosSound != null ? (flags | 8) : (flags & ~8);
        flags = androidSound != null ? (flags | 16) : (flags & ~16);
        flags = otherSound != null ? (flags | 32) : (flags & ~32);
        flags = storiesMuted != null ? (flags | 64) : (flags & ~64);
        flags = storiesHideSender != null ? (flags | 128) : (flags & ~128);
        flags = storiesIosSound != null ? (flags | 256) : (flags & ~256);
        flags = storiesAndroidSound != null ? (flags | 512) : (flags & ~512);
        flags = storiesOtherSound != null ? (flags | 1024) : (flags & ~1024);
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
            if (iosSound == null) throwNullFieldException("iosSound", flags);
            writeTLObject(iosSound, stream);
        }
        if ((flags & 16) != 0) {
            if (androidSound == null) throwNullFieldException("androidSound", flags);
            writeTLObject(androidSound, stream);
        }
        if ((flags & 32) != 0) {
            if (otherSound == null) throwNullFieldException("otherSound", flags);
            writeTLObject(otherSound, stream);
        }
        if ((flags & 64) != 0) {
            writeBoolean(storiesMuted, stream);
        }
        if ((flags & 128) != 0) {
            writeBoolean(storiesHideSender, stream);
        }
        if ((flags & 256) != 0) {
            if (storiesIosSound == null) throwNullFieldException("storiesIosSound", flags);
            writeTLObject(storiesIosSound, stream);
        }
        if ((flags & 512) != 0) {
            if (storiesAndroidSound == null) throwNullFieldException("storiesAndroidSound", flags);
            writeTLObject(storiesAndroidSound, stream);
        }
        if ((flags & 1024) != 0) {
            if (storiesOtherSound == null) throwNullFieldException("storiesOtherSound", flags);
            writeTLObject(storiesOtherSound, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        showPreviews = (flags & 1) != 0 ? readTLBool(stream) : false;
        silent = (flags & 2) != 0 ? readTLBool(stream) : false;
        muteUntil = (flags & 4) != 0 ? readInt(stream) : null;
        iosSound = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        androidSound = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        otherSound = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        storiesMuted = (flags & 64) != 0 ? readTLBool(stream) : false;
        storiesHideSender = (flags & 128) != 0 ? readTLBool(stream) : false;
        storiesIosSound = (flags & 256) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        storiesAndroidSound = (flags & 512) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
        storiesOtherSound = (flags & 1024) != 0 ? readTLObject(stream, context, TLAbsNotificationSound.class, -1) : null;
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
            if (iosSound == null) throwNullFieldException("iosSound", flags);
            size += iosSound.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (androidSound == null) throwNullFieldException("androidSound", flags);
            size += androidSound.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (otherSound == null) throwNullFieldException("otherSound", flags);
            size += otherSound.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 128) != 0) {
            size += SIZE_BOOLEAN;
        }
        if ((flags & 256) != 0) {
            if (storiesIosSound == null) throwNullFieldException("storiesIosSound", flags);
            size += storiesIosSound.computeSerializedSize();
        }
        if ((flags & 512) != 0) {
            if (storiesAndroidSound == null) throwNullFieldException("storiesAndroidSound", flags);
            size += storiesAndroidSound.computeSerializedSize();
        }
        if ((flags & 1024) != 0) {
            if (storiesOtherSound == null) throwNullFieldException("storiesOtherSound", flags);
            size += storiesOtherSound.computeSerializedSize();
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

    public TLAbsNotificationSound getIosSound() {
        return iosSound;
    }

    public void setIosSound(TLAbsNotificationSound iosSound) {
        this.iosSound = iosSound;
    }

    public TLAbsNotificationSound getAndroidSound() {
        return androidSound;
    }

    public void setAndroidSound(TLAbsNotificationSound androidSound) {
        this.androidSound = androidSound;
    }

    public TLAbsNotificationSound getOtherSound() {
        return otherSound;
    }

    public void setOtherSound(TLAbsNotificationSound otherSound) {
        this.otherSound = otherSound;
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

    public TLAbsNotificationSound getStoriesIosSound() {
        return storiesIosSound;
    }

    public void setStoriesIosSound(TLAbsNotificationSound storiesIosSound) {
        this.storiesIosSound = storiesIosSound;
    }

    public TLAbsNotificationSound getStoriesAndroidSound() {
        return storiesAndroidSound;
    }

    public void setStoriesAndroidSound(TLAbsNotificationSound storiesAndroidSound) {
        this.storiesAndroidSound = storiesAndroidSound;
    }

    public TLAbsNotificationSound getStoriesOtherSound() {
        return storiesOtherSound;
    }

    public void setStoriesOtherSound(TLAbsNotificationSound storiesOtherSound) {
        this.storiesOtherSound = storiesOtherSound;
    }
}
