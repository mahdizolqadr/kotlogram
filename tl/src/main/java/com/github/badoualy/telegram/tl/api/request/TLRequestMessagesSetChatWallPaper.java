package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsInputWallPaper;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLWallPaperSettings;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesSetChatWallPaper extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean forBoth;

    protected boolean revert;

    protected TLAbsInputPeer peer;

    protected TLAbsInputWallPaper wallpaper;

    protected TLWallPaperSettings settings;

    protected Integer id;

    private final String _constructor = "messages.setChatWallPaper#0";

    public TLRequestMessagesSetChatWallPaper() {
    }

    public TLRequestMessagesSetChatWallPaper(boolean forBoth, boolean revert, TLAbsInputPeer peer, TLAbsInputWallPaper wallpaper, TLWallPaperSettings settings, Integer id) {
        this.forBoth = forBoth;
        this.revert = revert;
        this.peer = peer;
        this.wallpaper = wallpaper;
        this.settings = settings;
        this.id = id;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = forBoth ? (flags | 8) : (flags & ~8);
        flags = revert ? (flags | 16) : (flags & ~16);
        flags = wallpaper != null ? (flags | 1) : (flags & ~1);
        flags = settings != null ? (flags | 4) : (flags & ~4);
        flags = id != null ? (flags | 2) : (flags & ~2);
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
        if ((flags & 4) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            writeTLObject(settings, stream);
        }
        if ((flags & 2) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            writeInt(id, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        forBoth = (flags & 8) != 0;
        revert = (flags & 16) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        wallpaper = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputWallPaper.class, -1) : null;
        settings = (flags & 4) != 0 ? readTLObject(stream, context, TLWallPaperSettings.class, TLWallPaperSettings.CONSTRUCTOR_ID) : null;
        id = (flags & 2) != 0 ? readInt(stream) : null;
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
        if ((flags & 4) != 0) {
            if (settings == null) throwNullFieldException("settings", flags);
            size += settings.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            size += SIZE_INT32;
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

    public boolean getForBoth() {
        return forBoth;
    }

    public void setForBoth(boolean forBoth) {
        this.forBoth = forBoth;
    }

    public boolean getRevert() {
        return revert;
    }

    public void setRevert(boolean revert) {
        this.revert = revert;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputWallPaper getWallpaper() {
        return wallpaper;
    }

    public void setWallpaper(TLAbsInputWallPaper wallpaper) {
        this.wallpaper = wallpaper;
    }

    public TLWallPaperSettings getSettings() {
        return settings;
    }

    public void setSettings(TLWallPaperSettings settings) {
        this.settings = settings;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
