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
public class TLMessageActionSetChatWallPaper extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean same;

    protected boolean forBoth;

    protected TLAbsWallPaper wallpaper;

    private final String _constructor = "messageActionSetChatWallPaper#0";

    public TLMessageActionSetChatWallPaper() {
    }

    public TLMessageActionSetChatWallPaper(boolean same, boolean forBoth, TLAbsWallPaper wallpaper) {
        this.same = same;
        this.forBoth = forBoth;
        this.wallpaper = wallpaper;
    }

    private void computeFlags() {
        flags = 0;
        flags = same ? (flags | 1) : (flags & ~1);
        flags = forBoth ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(wallpaper, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        same = (flags & 1) != 0;
        forBoth = (flags & 2) != 0;
        wallpaper = readTLObject(stream, context, TLAbsWallPaper.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += wallpaper.computeSerializedSize();
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

    public boolean getSame() {
        return same;
    }

    public void setSame(boolean same) {
        this.same = same;
    }

    public boolean getForBoth() {
        return forBoth;
    }

    public void setForBoth(boolean forBoth) {
        this.forBoth = forBoth;
    }

    public TLAbsWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
