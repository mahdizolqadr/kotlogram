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
public class TLWallPaperSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean blur;

    protected boolean motion;

    protected Integer backgroundColor;

    protected Integer secondBackgroundColor;

    protected Integer thirdBackgroundColor;

    protected Integer fourthBackgroundColor;

    protected Integer intensity;

    protected Integer rotation;

    protected String emoticon;

    private final String _constructor = "wallPaperSettings#0";

    public TLWallPaperSettings() {
    }

    public TLWallPaperSettings(boolean blur, boolean motion, Integer backgroundColor, Integer secondBackgroundColor, Integer thirdBackgroundColor, Integer fourthBackgroundColor, Integer intensity, Integer rotation, String emoticon) {
        this.blur = blur;
        this.motion = motion;
        this.backgroundColor = backgroundColor;
        this.secondBackgroundColor = secondBackgroundColor;
        this.thirdBackgroundColor = thirdBackgroundColor;
        this.fourthBackgroundColor = fourthBackgroundColor;
        this.intensity = intensity;
        this.rotation = rotation;
        this.emoticon = emoticon;
    }

    private void computeFlags() {
        flags = 0;
        flags = blur ? (flags | 2) : (flags & ~2);
        flags = motion ? (flags | 4) : (flags & ~4);
        flags = backgroundColor != null ? (flags | 1) : (flags & ~1);
        flags = secondBackgroundColor != null ? (flags | 16) : (flags & ~16);
        flags = thirdBackgroundColor != null ? (flags | 32) : (flags & ~32);
        flags = fourthBackgroundColor != null ? (flags | 64) : (flags & ~64);
        flags = intensity != null ? (flags | 8) : (flags & ~8);
        flags = rotation != null ? (flags | 16) : (flags & ~16);
        flags = emoticon != null ? (flags | 128) : (flags & ~128);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (backgroundColor == null) throwNullFieldException("backgroundColor", flags);
            writeInt(backgroundColor, stream);
        }
        if ((flags & 16) != 0) {
            if (secondBackgroundColor == null) throwNullFieldException("secondBackgroundColor", flags);
            writeInt(secondBackgroundColor, stream);
        }
        if ((flags & 32) != 0) {
            if (thirdBackgroundColor == null) throwNullFieldException("thirdBackgroundColor", flags);
            writeInt(thirdBackgroundColor, stream);
        }
        if ((flags & 64) != 0) {
            if (fourthBackgroundColor == null) throwNullFieldException("fourthBackgroundColor", flags);
            writeInt(fourthBackgroundColor, stream);
        }
        if ((flags & 8) != 0) {
            if (intensity == null) throwNullFieldException("intensity", flags);
            writeInt(intensity, stream);
        }
        if ((flags & 16) != 0) {
            if (rotation == null) throwNullFieldException("rotation", flags);
            writeInt(rotation, stream);
        }
        if ((flags & 128) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            writeString(emoticon, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        blur = (flags & 2) != 0;
        motion = (flags & 4) != 0;
        backgroundColor = (flags & 1) != 0 ? readInt(stream) : null;
        secondBackgroundColor = (flags & 16) != 0 ? readInt(stream) : null;
        thirdBackgroundColor = (flags & 32) != 0 ? readInt(stream) : null;
        fourthBackgroundColor = (flags & 64) != 0 ? readInt(stream) : null;
        intensity = (flags & 8) != 0 ? readInt(stream) : null;
        rotation = (flags & 16) != 0 ? readInt(stream) : null;
        emoticon = (flags & 128) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (backgroundColor == null) throwNullFieldException("backgroundColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (secondBackgroundColor == null) throwNullFieldException("secondBackgroundColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (thirdBackgroundColor == null) throwNullFieldException("thirdBackgroundColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (fourthBackgroundColor == null) throwNullFieldException("fourthBackgroundColor", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (intensity == null) throwNullFieldException("intensity", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (rotation == null) throwNullFieldException("rotation", flags);
            size += SIZE_INT32;
        }
        if ((flags & 128) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            size += computeTLStringSerializedSize(emoticon);
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

    public boolean getBlur() {
        return blur;
    }

    public void setBlur(boolean blur) {
        this.blur = blur;
    }

    public boolean getMotion() {
        return motion;
    }

    public void setMotion(boolean motion) {
        this.motion = motion;
    }

    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Integer getSecondBackgroundColor() {
        return secondBackgroundColor;
    }

    public void setSecondBackgroundColor(Integer secondBackgroundColor) {
        this.secondBackgroundColor = secondBackgroundColor;
    }

    public Integer getThirdBackgroundColor() {
        return thirdBackgroundColor;
    }

    public void setThirdBackgroundColor(Integer thirdBackgroundColor) {
        this.thirdBackgroundColor = thirdBackgroundColor;
    }

    public Integer getFourthBackgroundColor() {
        return fourthBackgroundColor;
    }

    public void setFourthBackgroundColor(Integer fourthBackgroundColor) {
        this.fourthBackgroundColor = fourthBackgroundColor;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Integer getRotation() {
        return rotation;
    }

    public void setRotation(Integer rotation) {
        this.rotation = rotation;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }
}
