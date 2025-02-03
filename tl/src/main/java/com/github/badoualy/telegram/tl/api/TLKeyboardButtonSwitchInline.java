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
public class TLKeyboardButtonSwitchInline extends TLAbsKeyboardButton {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean samePeer;

    protected String query;

    protected TLVector<TLAbsInlineQueryPeerType> peerTypes;

    private final String _constructor = "keyboardButtonSwitchInline#0";

    public TLKeyboardButtonSwitchInline() {
    }

    public TLKeyboardButtonSwitchInline(boolean samePeer, String text, String query, TLVector<TLAbsInlineQueryPeerType> peerTypes) {
        this.samePeer = samePeer;
        this.text = text;
        this.query = query;
        this.peerTypes = peerTypes;
    }

    private void computeFlags() {
        flags = 0;
        flags = samePeer ? (flags | 1) : (flags & ~1);
        flags = peerTypes != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(text, stream);
        writeString(query, stream);
        if ((flags & 2) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            writeTLVector(peerTypes, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        samePeer = (flags & 1) != 0;
        text = readTLString(stream);
        query = readTLString(stream);
        peerTypes = (flags & 2) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(text);
        size += computeTLStringSerializedSize(query);
        if ((flags & 2) != 0) {
            if (peerTypes == null) throwNullFieldException("peerTypes", flags);
            size += peerTypes.computeSerializedSize();
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

    public boolean getSamePeer() {
        return samePeer;
    }

    public void setSamePeer(boolean samePeer) {
        this.samePeer = samePeer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public TLVector<TLAbsInlineQueryPeerType> getPeerTypes() {
        return peerTypes;
    }

    public void setPeerTypes(TLVector<TLAbsInlineQueryPeerType> peerTypes) {
        this.peerTypes = peerTypes;
    }
}
