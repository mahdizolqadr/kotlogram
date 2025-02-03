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
public class TLChatReactionsSome extends TLAbsChatReactions {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLAbsReaction> reactions;

    private final String _constructor = "chatReactionsSome#0";

    public TLChatReactionsSome() {
    }

    public TLChatReactionsSome(TLVector<TLAbsReaction> reactions) {
        this.reactions = reactions;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(reactions, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        reactions = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += reactions.computeSerializedSize();
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

    public TLVector<TLAbsReaction> getReactions() {
        return reactions;
    }

    public void setReactions(TLVector<TLAbsReaction> reactions) {
        this.reactions = reactions;
    }
}
