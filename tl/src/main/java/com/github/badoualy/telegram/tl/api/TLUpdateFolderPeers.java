package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdateFolderPeers extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLFolderPeer> folderPeers;

    protected int pts;

    protected int ptsCount;

    private final String _constructor = "updateFolderPeers#0";

    public TLUpdateFolderPeers() {
    }

    public TLUpdateFolderPeers(TLVector<TLFolderPeer> folderPeers, int pts, int ptsCount) {
        this.folderPeers = folderPeers;
        this.pts = pts;
        this.ptsCount = ptsCount;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(folderPeers, stream);
        writeInt(pts, stream);
        writeInt(ptsCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        folderPeers = readTLVector(stream, context);
        pts = readInt(stream);
        ptsCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += folderPeers.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public TLVector<TLFolderPeer> getFolderPeers() {
        return folderPeers;
    }

    public void setFolderPeers(TLVector<TLFolderPeer> folderPeers) {
        this.folderPeers = folderPeers;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int ptsCount) {
        this.ptsCount = ptsCount;
    }
}
