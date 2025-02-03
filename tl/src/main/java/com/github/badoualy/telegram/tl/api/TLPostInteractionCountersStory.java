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
public class TLPostInteractionCountersStory extends TLAbsPostInteractionCounters {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int storyId;

    private final String _constructor = "postInteractionCountersStory#0";

    public TLPostInteractionCountersStory() {
    }

    public TLPostInteractionCountersStory(int storyId, int views, int forwards, int reactions) {
        this.storyId = storyId;
        this.views = views;
        this.forwards = forwards;
        this.reactions = reactions;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(storyId, stream);
        writeInt(views, stream);
        writeInt(forwards, stream);
        writeInt(reactions, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        storyId = readInt(stream);
        views = readInt(stream);
        forwards = readInt(stream);
        reactions = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getForwards() {
        return forwards;
    }

    public void setForwards(int forwards) {
        this.forwards = forwards;
    }

    public int getReactions() {
        return reactions;
    }

    public void setReactions(int reactions) {
        this.reactions = reactions;
    }
}
