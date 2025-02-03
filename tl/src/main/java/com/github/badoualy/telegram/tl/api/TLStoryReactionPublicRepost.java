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
public class TLStoryReactionPublicRepost extends TLAbsStoryReaction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPeer peerId;

    protected TLAbsStoryItem story;

    private final String _constructor = "storyReactionPublicRepost#0";

    public TLStoryReactionPublicRepost() {
    }

    public TLStoryReactionPublicRepost(TLAbsPeer peerId, TLAbsStoryItem story) {
        this.peerId = peerId;
        this.story = story;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peerId, stream);
        writeTLObject(story, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        story = readTLObject(stream, context, TLAbsStoryItem.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peerId.computeSerializedSize();
        size += story.computeSerializedSize();
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

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public TLAbsStoryItem getStory() {
        return story;
    }

    public void setStory(TLAbsStoryItem story) {
        this.story = story;
    }
}
