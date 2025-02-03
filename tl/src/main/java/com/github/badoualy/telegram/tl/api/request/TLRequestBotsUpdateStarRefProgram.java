package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLStarRefProgram;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestBotsUpdateStarRefProgram extends TLMethod<TLStarRefProgram> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputUser bot;

    protected int commissionPermille;

    protected Integer durationMonths;

    private final String _constructor = "bots.updateStarRefProgram#0";

    public TLRequestBotsUpdateStarRefProgram() {
    }

    public TLRequestBotsUpdateStarRefProgram(TLAbsInputUser bot, int commissionPermille, Integer durationMonths) {
        this.bot = bot;
        this.commissionPermille = commissionPermille;
        this.durationMonths = durationMonths;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLStarRefProgram deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLStarRefProgram)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLStarRefProgram) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = durationMonths != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(bot, stream);
        writeInt(commissionPermille, stream);
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            writeInt(durationMonths, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        commissionPermille = readInt(stream);
        durationMonths = (flags & 1) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += bot.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (durationMonths == null) throwNullFieldException("durationMonths", flags);
            size += SIZE_INT32;
        }
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

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public int getCommissionPermille() {
        return commissionPermille;
    }

    public void setCommissionPermille(int commissionPermille) {
        this.commissionPermille = commissionPermille;
    }

    public Integer getDurationMonths() {
        return durationMonths;
    }

    public void setDurationMonths(Integer durationMonths) {
        this.durationMonths = durationMonths;
    }
}
