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
public class TLExportedChatlistInvite extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String title;

    protected String url;

    protected TLVector<TLAbsPeer> peers;

    private final String _constructor = "exportedChatlistInvite#0";

    public TLExportedChatlistInvite() {
    }

    public TLExportedChatlistInvite(String title, String url, TLVector<TLAbsPeer> peers) {
        this.title = title;
        this.url = url;
        this.peers = peers;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        writeString(title, stream);
        writeString(url, stream);
        writeTLVector(peers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        title = readTLString(stream);
        url = readTLString(stream);
        peers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        size += computeTLStringSerializedSize(url);
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLVector<TLAbsPeer> getPeers() {
        return peers;
    }

    public void setPeers(TLVector<TLAbsPeer> peers) {
        this.peers = peers;
    }
}
