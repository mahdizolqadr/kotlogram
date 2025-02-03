package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMediaArea;
import com.github.badoualy.telegram.tl.api.stories.TLFoundStories;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestStoriesSearchPosts extends TLMethod<TLFoundStories> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected String hashtag;

    protected TLAbsMediaArea area;

    protected TLAbsInputPeer peer;

    protected String offset;

    protected int limit;

    private final String _constructor = "stories.searchPosts#0";

    public TLRequestStoriesSearchPosts() {
    }

    public TLRequestStoriesSearchPosts(String hashtag, TLAbsMediaArea area, TLAbsInputPeer peer, String offset, int limit) {
        this.hashtag = hashtag;
        this.area = area;
        this.peer = peer;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLFoundStories deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLFoundStories)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLFoundStories) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = hashtag != null ? (flags | 1) : (flags & ~1);
        flags = area != null ? (flags | 2) : (flags & ~2);
        flags = peer != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (hashtag == null) throwNullFieldException("hashtag", flags);
            writeString(hashtag, stream);
        }
        if ((flags & 2) != 0) {
            if (area == null) throwNullFieldException("area", flags);
            writeTLObject(area, stream);
        }
        if ((flags & 4) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            writeTLObject(peer, stream);
        }
        writeString(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hashtag = (flags & 1) != 0 ? readTLString(stream) : null;
        area = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsMediaArea.class, -1) : null;
        peer = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputPeer.class, -1) : null;
        offset = readTLString(stream);
        limit = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (hashtag == null) throwNullFieldException("hashtag", flags);
            size += computeTLStringSerializedSize(hashtag);
        }
        if ((flags & 2) != 0) {
            if (area == null) throwNullFieldException("area", flags);
            size += area.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (peer == null) throwNullFieldException("peer", flags);
            size += peer.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(offset);
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

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public TLAbsMediaArea getArea() {
        return area;
    }

    public void setArea(TLAbsMediaArea area) {
        this.area = area;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
