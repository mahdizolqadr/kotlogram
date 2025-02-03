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
public class TLStoryReaction extends TLAbsStoryReaction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPeer peerId;

    protected int date;

    protected TLAbsReaction reaction;

    private final String _constructor = "storyReaction#0";

    public TLStoryReaction() {
    }

    public TLStoryReaction(TLAbsPeer peerId, int date, TLAbsReaction reaction) {
        this.peerId = peerId;
        this.date = date;
        this.reaction = reaction;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peerId, stream);
        writeInt(date, stream);
        writeTLObject(reaction, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peerId = readTLObject(stream, context, TLAbsPeer.class, -1);
        date = readInt(stream);
        reaction = readTLObject(stream, context, TLAbsReaction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peerId.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLAbsPeer getPeerId() {
        return peerId;
    }

    public void setPeerId(TLAbsPeer peerId) {
        this.peerId = peerId;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }
}
