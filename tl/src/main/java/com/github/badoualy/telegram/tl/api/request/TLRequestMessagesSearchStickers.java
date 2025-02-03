package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAbsFoundStickers;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLRequestMessagesSearchStickers extends TLMethod<TLAbsFoundStickers> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean emojis;

    protected String q;

    protected String emoticon;

    protected TLStringVector langCode;

    protected int offset;

    protected int limit;

    protected long hash;

    private final String _constructor = "messages.searchStickers#0";

    public TLRequestMessagesSearchStickers() {
    }

    public TLRequestMessagesSearchStickers(boolean emojis, String q, String emoticon, TLStringVector langCode, int offset, int limit, long hash) {
        this.emojis = emojis;
        this.q = q;
        this.emoticon = emoticon;
        this.langCode = langCode;
        this.offset = offset;
        this.limit = limit;
        this.hash = hash;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsFoundStickers deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsFoundStickers)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsFoundStickers) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = emojis ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(q, stream);
        writeString(emoticon, stream);
        writeTLVector(langCode, stream);
        writeInt(offset, stream);
        writeInt(limit, stream);
        writeLong(hash, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        emojis = (flags & 1) != 0;
        q = readTLString(stream);
        emoticon = readTLString(stream);
        langCode = readTLStringVector(stream, context);
        offset = readInt(stream);
        limit = readInt(stream);
        hash = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(q);
        size += computeTLStringSerializedSize(emoticon);
        size += langCode.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public boolean getEmojis() {
        return emojis;
    }

    public void setEmojis(boolean emojis) {
        this.emojis = emojis;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public TLStringVector getLangCode() {
        return langCode;
    }

    public void setLangCode(TLStringVector langCode) {
        this.langCode = langCode;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }
}
