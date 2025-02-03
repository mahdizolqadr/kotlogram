package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLTopPeerCategoryPeers extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsTopPeerCategory category;

    protected int count;

    protected TLVector<TLTopPeer> peers;

    private final String _constructor = "topPeerCategoryPeers#0";

    public TLTopPeerCategoryPeers() {
    }

    public TLTopPeerCategoryPeers(TLAbsTopPeerCategory category, int count, TLVector<TLTopPeer> peers) {
        this.category = category;
        this.count = count;
        this.peers = peers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(category, stream);
        writeInt(count, stream);
        writeTLVector(peers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        category = readTLObject(stream, context, TLAbsTopPeerCategory.class, -1);
        count = readInt(stream);
        peers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += category.computeSerializedSize();
        size += SIZE_INT32;
        size += peers.computeSerializedSize();
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

    public TLAbsTopPeerCategory getCategory() {
        return category;
    }

    public void setCategory(TLAbsTopPeerCategory category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<TLTopPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLTopPeer> peers) {
        this.peers = peers;
    }
}
