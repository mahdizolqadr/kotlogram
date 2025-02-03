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
public class TLMediaAreaSuggestedReaction extends TLAbsMediaArea {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean dark;

    protected boolean flipped;

    protected TLAbsReaction reaction;

    private final String _constructor = "mediaAreaSuggestedReaction#0";

    public TLMediaAreaSuggestedReaction() {
    }

    public TLMediaAreaSuggestedReaction(boolean dark, boolean flipped, TLMediaAreaCoordinates coordinates, TLAbsReaction reaction) {
        this.dark = dark;
        this.flipped = flipped;
        this.coordinates = coordinates;
        this.reaction = reaction;
    }

    private void computeFlags() {
        flags = 0;
        flags = dark ? (flags | 1) : (flags & ~1);
        flags = flipped ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(coordinates, stream);
        writeTLObject(reaction, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        dark = (flags & 1) != 0;
        flipped = (flags & 2) != 0;
        coordinates = readTLObject(stream, context, TLMediaAreaCoordinates.class, TLMediaAreaCoordinates.CONSTRUCTOR_ID);
        reaction = readTLObject(stream, context, TLAbsReaction.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += coordinates.computeSerializedSize();
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

    public boolean getDark() {
        return dark;
    }

    public void setDark(boolean dark) {
        this.dark = dark;
    }

    public boolean getFlipped() {
        return flipped;
    }

    public void setFlipped(boolean flipped) {
        this.flipped = flipped;
    }

    public TLMediaAreaCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(TLMediaAreaCoordinates coordinates) {
        this.coordinates = coordinates;
    }

    public TLAbsReaction getReaction() {
        return reaction;
    }

    public void setReaction(TLAbsReaction reaction) {
        this.reaction = reaction;
    }
}
