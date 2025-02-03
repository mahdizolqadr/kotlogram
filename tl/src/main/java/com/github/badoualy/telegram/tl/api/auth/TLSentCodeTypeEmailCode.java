package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLSentCodeTypeEmailCode extends TLAbsSentCodeType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean appleSigninAllowed;

    protected boolean googleSigninAllowed;

    protected String emailPattern;

    protected int length;

    protected Integer resetAvailablePeriod;

    protected Integer resetPendingDate;

    private final String _constructor = "auth.sentCodeTypeEmailCode#0";

    public TLSentCodeTypeEmailCode() {
    }

    public TLSentCodeTypeEmailCode(boolean appleSigninAllowed, boolean googleSigninAllowed, String emailPattern, int length, Integer resetAvailablePeriod, Integer resetPendingDate) {
        this.appleSigninAllowed = appleSigninAllowed;
        this.googleSigninAllowed = googleSigninAllowed;
        this.emailPattern = emailPattern;
        this.length = length;
        this.resetAvailablePeriod = resetAvailablePeriod;
        this.resetPendingDate = resetPendingDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = appleSigninAllowed ? (flags | 1) : (flags & ~1);
        flags = googleSigninAllowed ? (flags | 2) : (flags & ~2);
        flags = resetAvailablePeriod != null ? (flags | 8) : (flags & ~8);
        flags = resetPendingDate != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(emailPattern, stream);
        writeInt(length, stream);
        if ((flags & 8) != 0) {
            if (resetAvailablePeriod == null) throwNullFieldException("resetAvailablePeriod", flags);
            writeInt(resetAvailablePeriod, stream);
        }
        if ((flags & 16) != 0) {
            if (resetPendingDate == null) throwNullFieldException("resetPendingDate", flags);
            writeInt(resetPendingDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        appleSigninAllowed = (flags & 1) != 0;
        googleSigninAllowed = (flags & 2) != 0;
        emailPattern = readTLString(stream);
        length = readInt(stream);
        resetAvailablePeriod = (flags & 8) != 0 ? readInt(stream) : null;
        resetPendingDate = (flags & 16) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(emailPattern);
        size += SIZE_INT32;
        if ((flags & 8) != 0) {
            if (resetAvailablePeriod == null) throwNullFieldException("resetAvailablePeriod", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (resetPendingDate == null) throwNullFieldException("resetPendingDate", flags);
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

    public boolean getAppleSigninAllowed() {
        return appleSigninAllowed;
    }

    public void setAppleSigninAllowed(boolean appleSigninAllowed) {
        this.appleSigninAllowed = appleSigninAllowed;
    }

    public boolean getGoogleSigninAllowed() {
        return googleSigninAllowed;
    }

    public void setGoogleSigninAllowed(boolean googleSigninAllowed) {
        this.googleSigninAllowed = googleSigninAllowed;
    }

    public String getEmailPattern() {
        return emailPattern;
    }

    public void setEmailPattern(String emailPattern) {
        this.emailPattern = emailPattern;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Integer getResetAvailablePeriod() {
        return resetAvailablePeriod;
    }

    public void setResetAvailablePeriod(Integer resetAvailablePeriod) {
        this.resetAvailablePeriod = resetAvailablePeriod;
    }

    public Integer getResetPendingDate() {
        return resetPendingDate;
    }

    public void setResetPendingDate(Integer resetPendingDate) {
        this.resetPendingDate = resetPendingDate;
    }
}
