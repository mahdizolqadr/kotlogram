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
public class TLMissingInvitee extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean premiumWouldAllowInvite;

    protected boolean premiumRequiredForPm;

    protected long userId;

    private final String _constructor = "missingInvitee#0";

    public TLMissingInvitee() {
    }

    public TLMissingInvitee(boolean premiumWouldAllowInvite, boolean premiumRequiredForPm, long userId) {
        this.premiumWouldAllowInvite = premiumWouldAllowInvite;
        this.premiumRequiredForPm = premiumRequiredForPm;
        this.userId = userId;
    }

    private void computeFlags() {
        flags = 0;
        flags = premiumWouldAllowInvite ? (flags | 1) : (flags & ~1);
        flags = premiumRequiredForPm ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(userId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        premiumWouldAllowInvite = (flags & 1) != 0;
        premiumRequiredForPm = (flags & 2) != 0;
        userId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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

    public boolean getPremiumWouldAllowInvite() {
        return premiumWouldAllowInvite;
    }

    public void setPremiumWouldAllowInvite(boolean premiumWouldAllowInvite) {
        this.premiumWouldAllowInvite = premiumWouldAllowInvite;
    }

    public boolean getPremiumRequiredForPm() {
        return premiumRequiredForPm;
    }

    public void setPremiumRequiredForPm(boolean premiumRequiredForPm) {
        this.premiumRequiredForPm = premiumRequiredForPm;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
