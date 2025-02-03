package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLWebPageAttributeStory extends TLAbsWebPageAttribute {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPeer peer;

    protected int id;

    protected TLAbsStoryItem story;

    private final String _constructor = "webPageAttributeStory#0";

    public TLWebPageAttributeStory() {
    }

    public TLWebPageAttributeStory(TLAbsPeer peer, int id, TLAbsStoryItem story) {
        this.peer = peer;
        this.id = id;
        this.story = story;
    }

    private void computeFlags() {
        flags = 0;
        flags = story != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(id, stream);
        if ((flags & 1) != 0) {
            if (story == null) throwNullFieldException("story", flags);
            writeTLObject(story, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        id = readInt(stream);
        story = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsStoryItem.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (story == null) throwNullFieldException("story", flags);
            size += story.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLAbsStoryItem getStory() {
        return story;
    }

    public void setStory(TLAbsStoryItem story) {
        this.story = story;
    }
}
