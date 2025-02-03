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
public class TLMessageActionGiveawayResults extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean stars;

    protected int winnersCount;

    protected int unclaimedCount;

    private final String _constructor = "messageActionGiveawayResults#0";

    public TLMessageActionGiveawayResults() {
    }

    public TLMessageActionGiveawayResults(boolean stars, int winnersCount, int unclaimedCount) {
        this.stars = stars;
        this.winnersCount = winnersCount;
        this.unclaimedCount = unclaimedCount;
    }

    private void computeFlags() {
        flags = 0;
        flags = stars ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(winnersCount, stream);
        writeInt(unclaimedCount, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        stars = (flags & 1) != 0;
        winnersCount = readInt(stream);
        unclaimedCount = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getStars() {
        return stars;
    }

    public void setStars(boolean stars) {
        this.stars = stars;
    }

    public int getWinnersCount() {
        return winnersCount;
    }

    public void setWinnersCount(int winnersCount) {
        this.winnersCount = winnersCount;
    }

    public int getUnclaimedCount() {
        return unclaimedCount;
    }

    public void setUnclaimedCount(int unclaimedCount) {
        this.unclaimedCount = unclaimedCount;
    }
}
