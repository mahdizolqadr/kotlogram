package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLRequestMessagesToggleStickerSets extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean uninstall;

    protected boolean archive;

    protected boolean unarchive;

    protected TLVector<TLAbsInputStickerSet> stickersets;

    private final String _constructor = "messages.toggleStickerSets#0";

    public TLRequestMessagesToggleStickerSets() {
    }

    public TLRequestMessagesToggleStickerSets(boolean uninstall, boolean archive, boolean unarchive, TLVector<TLAbsInputStickerSet> stickersets) {
        this.uninstall = uninstall;
        this.archive = archive;
        this.unarchive = unarchive;
        this.stickersets = stickersets;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = uninstall ? (flags | 1) : (flags & ~1);
        flags = archive ? (flags | 2) : (flags & ~2);
        flags = unarchive ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(stickersets, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        uninstall = (flags & 1) != 0;
        archive = (flags & 2) != 0;
        unarchive = (flags & 4) != 0;
        stickersets = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += stickersets.computeSerializedSize();
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

    public boolean getUninstall() {
        return uninstall;
    }

    public void setUninstall(boolean uninstall) {
        this.uninstall = uninstall;
    }

    public boolean getArchive() {
        return archive;
    }

    public void setArchive(boolean archive) {
        this.archive = archive;
    }

    public boolean getUnarchive() {
        return unarchive;
    }

    public void setUnarchive(boolean unarchive) {
        this.unarchive = unarchive;
    }

    public TLVector<TLAbsInputStickerSet> getStickersets() {
        return stickersets;
    }

    public void setStickersets(TLVector<TLAbsInputStickerSet> stickersets) {
        this.stickersets = stickersets;
    }
}
