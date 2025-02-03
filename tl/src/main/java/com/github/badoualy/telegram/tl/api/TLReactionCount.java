package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLReactionCount extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer chosenOrder;

    protected TLAbsReaction reaction;

    protected int count;

    private final String _constructor = "reactionCount#0";

    public TLReactionCount() {
    }

    public TLReactionCount(Integer chosenOrder, TLAbsReaction reaction, int count) {
        this.chosenOrder = chosenOrder;
        this.reaction = reaction;
        this.count = count;
    }

    private void computeFlags() {
        flags = 0;
        flags = chosenOrder != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (chosenOrder == null) throwNullFieldException("chosenOrder", flags);
            writeInt(chosenOrder, stream);
        }
        writeTLObject(reaction, stream);
        writeInt(count, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chosenOrder = (flags & 1) != 0 ? readInt(stream) : null;
        reaction = readTLObject(stream, context, TLAbsReaction.class, -1);
        count = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (chosenOrder == null) throwNullFieldException("chosenOrder", flags);
            size += SIZE_INT32;
        }
        size += reaction.computeSerializedSize();
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

    public Integer getChosenOrder() {
        return chosenOrder;
    }

    public void setChosenOrder(Integer chosenOrder) {
        this.chosenOrder = chosenOrder;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
