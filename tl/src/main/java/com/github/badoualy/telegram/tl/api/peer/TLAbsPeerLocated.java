package com.github.badoualy.telegram.tl.api.peer;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * Abstraction level for the following constructors:
 * <ul>
 * <li>{@link TLPeerLocated}: peerLocated#ca461b5d</li>
 * <li>{@link TLPeerSelfLocated}: peerSelfLocated#f8ec284b</li>
 * </ul>
 */
public abstract class TLAbsPeerLocated extends TLObject {

    protected int expires;

    protected TLAbsPeerLocated() {
    }

    protected TLAbsPeerLocated(int expires) {
        this.expires = expires;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(expires, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        expires = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        return size;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }
}
