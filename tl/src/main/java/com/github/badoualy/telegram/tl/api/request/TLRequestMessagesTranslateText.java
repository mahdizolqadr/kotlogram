package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLTextWithEntities;
import com.github.badoualy.telegram.tl.api.messages.TLTranslateResult;
import com.github.badoualy.telegram.tl.core.TLIntVector;
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
public class TLRequestMessagesTranslateText extends TLMethod<TLTranslateResult> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputPeer peer;

    protected TLIntVector id;

    protected TLVector<TLTextWithEntities> text;

    protected String toLang;

    private final String _constructor = "messages.translateText#0";

    public TLRequestMessagesTranslateText() {
    }

    public TLRequestMessagesTranslateText(TLAbsInputPeer peer, TLIntVector id, TLVector<TLTextWithEntities> text, String toLang) {
        this.peer = peer;
        this.id = id;
        this.text = text;
        this.toLang = toLang;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLTranslateResult deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLTranslateResult)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLTranslateResult) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = peer != null ? (flags | 1) : (flags & ~1);
        flags = id != null ? (flags | 1) : (flags & ~1);
        flags = text != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
        if ((flags & 1) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            writeTLVector(id, stream);
        }
        if ((flags & 2) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            writeTLVector(text, stream);
        }
        writeString(toLang, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        id = (flags & 1) != 0 ? readTLIntVector(stream, context) : null;
        text = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        toLang = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
        }
        if ((flags & 1) != 0) {
            if (id == null) throwNullFieldException("id", flags);
            size += id.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (text == null) throwNullFieldException("text", flags);
            size += text.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(toLang);
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLIntVector getId() {
        return id;
    }

    public void setId(TLIntVector id) {
        this.id = id;
    }

    public TLVector<TLTextWithEntities> getText() {
        return text;
    }

    public void setText(TLVector<TLTextWithEntities> text) {
        this.text = text;
    }

    public String getToLang() {
        return toLang;
    }

    public void setToLang(String toLang) {
        this.toLang = toLang;
    }
}
