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
public class TLUpdateNewStoryReaction extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int storyId;

    protected TLAbsPeer peer;

    protected TLAbsReaction reaction;

    private final String _constructor = "updateNewStoryReaction#0";

    public TLUpdateNewStoryReaction() {
    }

    public TLUpdateNewStoryReaction(int storyId, TLAbsPeer peer, TLAbsReaction reaction) {
        this.storyId = storyId;
        this.peer = peer;
        this.reaction = reaction;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(storyId, stream);
        writeTLObject(peer, stream);
        writeTLObject(reaction, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        storyId = readInt(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        reaction = readTLObject(stream, context, TLAbsReaction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += reaction.computeSerializedSize();
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }
}
