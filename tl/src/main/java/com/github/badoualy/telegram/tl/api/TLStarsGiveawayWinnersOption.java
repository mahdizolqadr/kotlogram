package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLStarsGiveawayWinnersOption extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean ddefault;

    protected int users;

    protected long perUserStars;

    private final String _constructor = "starsGiveawayWinnersOption#0";

    public TLStarsGiveawayWinnersOption() {
    }

    public TLStarsGiveawayWinnersOption(boolean ddefault, int users, long perUserStars) {
        this.ddefault = ddefault;
        this.users = users;
        this.perUserStars = perUserStars;
    }

    private void computeFlags() {
        flags = 0;
        flags = ddefault ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(users, stream);
        writeLong(perUserStars, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        ddefault = (flags & 1) != 0;
        users = readInt(stream);
        perUserStars = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT64;
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

    public boolean getDdefault() {
        return ddefault;
    }

    public void setDdefault(boolean ddefault) {
        this.ddefault = ddefault;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public long getPerUserStars() {
        return perUserStars;
    }

    public void setPerUserStars(long perUserStars) {
        this.perUserStars = perUserStars;
    }
}
