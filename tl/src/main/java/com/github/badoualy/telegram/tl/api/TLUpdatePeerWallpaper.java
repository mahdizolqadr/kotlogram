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
public class TLUpdatePeerWallpaper extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean wallpaperOverridden;

    protected TLAbsPeer peer;

    protected TLAbsWallPaper wallpaper;

    private final String _constructor = "updatePeerWallpaper#0";

    public TLUpdatePeerWallpaper() {
    }

    public TLUpdatePeerWallpaper(boolean wallpaperOverridden, TLAbsPeer peer, TLAbsWallPaper wallpaper) {
        this.wallpaperOverridden = wallpaperOverridden;
        this.peer = peer;
        this.wallpaper = wallpaper;
    }

    private void computeFlags() {
        flags = 0;
        flags = wallpaperOverridden ? (flags | 2) : (flags & ~2);
        flags = wallpaper != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) {
            if (wallpaper == null) throwNullFieldException("wallpaper", flags);
            writeTLObject(wallpaper, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        wallpaperOverridden = (flags & 2) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        wallpaper = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsWallPaper.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (wallpaper == null) throwNullFieldException("wallpaper", flags);
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

    public boolean getWallpaperOverridden() {
        return wallpaperOverridden;
    }

    public void setWallpaperOverridden(boolean wallpaperOverridden) {
        this.wallpaperOverridden = wallpaperOverridden;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public TLAbsWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }
}
