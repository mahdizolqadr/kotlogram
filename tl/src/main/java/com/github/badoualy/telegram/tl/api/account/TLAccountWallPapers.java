package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.wallpaper.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;

public class TLAccountWallPapers extends TLAbsAccountWallPapers {

    public static final int CONSTRUCTOR_ID = 0xcdc3858c;

    protected long hash;

    protected TLVector<TLAbsWallPaper> wallpapers;

    private final String _constructor = "account.wallPapers#cdc3858c";

    public TLAccountWallPapers() {
    }

    public TLAccountWallPapers(long hash, TLVector<TLAbsWallPaper> wallpapers) {
        this.hash = hash;
        this.wallpapers = wallpapers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(hash, stream);
        writeTLVector(wallpapers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readLong(stream);
        wallpapers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += wallpapers.computeSerializedSize();
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
}
