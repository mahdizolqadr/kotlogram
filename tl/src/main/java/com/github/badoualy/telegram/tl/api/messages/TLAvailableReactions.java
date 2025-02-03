package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAvailableReaction;
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
public class TLAvailableReactions extends TLAbsAvailableReactions {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int hash;

    protected TLVector<TLAvailableReaction> reactions;

    private final String _constructor = "messages.availableReactions#0";

    public TLAvailableReactions() {
    }

    public TLAvailableReactions(int hash, TLVector<TLAvailableReaction> reactions) {
        this.hash = hash;
        this.reactions = reactions;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(reactions, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        reactions = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLAvailableReaction> getReactions() {
        return reactions;
    }

    public void setReactions(TLVector<TLAvailableReaction> reactions) {
        this.reactions = reactions;
    }
}
