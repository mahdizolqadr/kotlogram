package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.theme.TLAbsBaseTheme;
import com.github.badoualy.telegram.tl.api.wallpaper.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLThemeSettings extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xfa58b6d4;

    protected int flags;
    protected boolean messageColorsAnimated;
    protected TLAbsBaseTheme baseTheme;
    protected int accentColor;
    protected Integer outboxAccentColor;
    protected TLIntVector messageColors;

    protected TLAbsWallPaper wallpaper;

    private final String _constructor = "themeSettings#fa58b6d4";

    TLThemeSettings() {
    }

    TLThemeSettings(boolean messageColorsAnimated, TLAbsBaseTheme baseTheme, int accentColor, Integer outboxAccentColor,
                    TLIntVector messageColors, TLAbsWallPaper wallpaper) {
        this.messageColorsAnimated = messageColorsAnimated;
        this.baseTheme = baseTheme;
        this.accentColor = accentColor;
        this.outboxAccentColor = outboxAccentColor;
        this.messageColors = messageColors;
        this.wallpaper = wallpaper;
    }

    private void computeFlags() {
        flags = 0;
        flags = messageColorsAnimated ? (flags | 4) : (flags & ~4);
        flags = outboxAccentColor != null ? (flags | 8) : (flags & ~8);
        flags = messageColors != null ? (flags | 1) : (flags & ~1);
        flags = wallpaper != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLObject(baseTheme, stream);
        writeInt(accentColor, stream);
        if ((flags & 8) != 0) {
            if (outboxAccentColor == null) {
                throwNullFieldException("outboxAccentColor", flags);
            }
            writeInt(outboxAccentColor, stream);
        }
        if ((flags & 1) != 0) {
            if (messageColors == null) {
                throwNullFieldException("messageColors", flags);
            }
            writeTLVector(messageColors, stream);
        }
        if ((flags & 2) != 0) {
            if (wallpaper == null) {
                throwNullFieldException("wallpaper", flags);
            }
            writeTLObject(wallpaper, stream);
        }
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        messageColorsAnimated = (flags & 4) != 0;
        baseTheme = readTLObject(stream, context, TLAbsBaseTheme.class, -1);
        accentColor = readInt(stream);
        outboxAccentColor = (flags & 8) != 0 ? readInt(stream) : null;
        messageColors = (flags & 1) != 0 ? readTLIntVector(stream, context) : null;
        wallpaper = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsWallPaper.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += baseTheme.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (outboxAccentColor == null) {
                throwNullFieldException("outboxAccentColor", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (messageColors == null) {
                throwNullFieldException("messageColors", flags);
            }
            size += messageColors.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (wallpaper == null) {
                throwNullFieldException("wallpaper", flags);
            }
            size += wallpaper.computeSerializedSize();
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

    public boolean isMessageColorsAnimated() {
        return messageColorsAnimated;
    }

    public void setMessageColorsAnimated(boolean messageColorsAnimated) {
        this.messageColorsAnimated = messageColorsAnimated;
    }

    public TLAbsBaseTheme getBaseTheme() {
        return baseTheme;
    }

    public void setBaseTheme(TLAbsBaseTheme baseTheme) {
        this.baseTheme = baseTheme;
    }

    public int getAccentColor() {
        return accentColor;
    }

    public void setAccentColor(int accentColor) {
        this.accentColor = accentColor;
    }

    public Integer getOutboxAccentColor() {
        return outboxAccentColor;
    }

    public void setOutboxAccentColor(Integer outboxAccentColor) {
        this.outboxAccentColor = outboxAccentColor;
    }

    public TLIntVector getMessageColors() {
        return messageColors;
    }

    public void setMessageColors(TLIntVector messageColors) {
        this.messageColors = messageColors;
    }

    public TLAbsWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
