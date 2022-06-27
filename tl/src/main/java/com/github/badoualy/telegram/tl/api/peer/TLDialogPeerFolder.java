package com.github.badoualy.telegram.tl.api.peer;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

public class TLDialogPeerFolder extends TLAbsDialogPeer {

    public static final int CONSTRUCTOR_ID = 0x514519e2;

    protected int folderId;

    private final String _constructor = "dialogPeerFolder#514519e2";

    public TLDialogPeerFolder() {
    }

    public TLDialogPeerFolder(int folderId) {
        this.folderId = folderId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(folderId, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        folderId = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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

    public int getFolderId() {
        return folderId;
    }

    public void setFolderId(int folderId) {
        this.folderId = folderId;
    }
}
