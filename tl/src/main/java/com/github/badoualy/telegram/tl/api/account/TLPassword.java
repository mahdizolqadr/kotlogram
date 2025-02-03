package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsPasswordKdfAlgo;
import com.github.badoualy.telegram.tl.api.TLAbsSecurePasswordKdfAlgo;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPassword extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hasRecovery;

    protected boolean hasSecureValues;

    protected boolean hasPassword;

    protected TLAbsPasswordKdfAlgo currentAlgo;

    protected TLBytes srpB;

    protected Long srpId;

    protected String hint;

    protected String emailUnconfirmedPattern;

    protected TLAbsPasswordKdfAlgo newAlgo;

    protected TLAbsSecurePasswordKdfAlgo newSecureAlgo;

    protected TLBytes secureRandom;

    protected Integer pendingResetDate;

    protected String loginEmailPattern;

    private final String _constructor = "account.password#0";

    public TLPassword() {
    }

    public TLPassword(boolean hasRecovery, boolean hasSecureValues, boolean hasPassword, TLAbsPasswordKdfAlgo currentAlgo, TLBytes srpB, Long srpId, String hint, String emailUnconfirmedPattern, TLAbsPasswordKdfAlgo newAlgo, TLAbsSecurePasswordKdfAlgo newSecureAlgo, TLBytes secureRandom, Integer pendingResetDate, String loginEmailPattern) {
        this.hasRecovery = hasRecovery;
        this.hasSecureValues = hasSecureValues;
        this.hasPassword = hasPassword;
        this.currentAlgo = currentAlgo;
        this.srpB = srpB;
        this.srpId = srpId;
        this.hint = hint;
        this.emailUnconfirmedPattern = emailUnconfirmedPattern;
        this.newAlgo = newAlgo;
        this.newSecureAlgo = newSecureAlgo;
        this.secureRandom = secureRandom;
        this.pendingResetDate = pendingResetDate;
        this.loginEmailPattern = loginEmailPattern;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasRecovery ? (flags | 1) : (flags & ~1);
        flags = hasSecureValues ? (flags | 2) : (flags & ~2);
        flags = hasPassword ? (flags | 4) : (flags & ~4);
        flags = currentAlgo != null ? (flags | 4) : (flags & ~4);
        flags = srpB != null ? (flags | 4) : (flags & ~4);
        flags = srpId != null ? (flags | 4) : (flags & ~4);
        flags = hint != null ? (flags | 8) : (flags & ~8);
        flags = emailUnconfirmedPattern != null ? (flags | 16) : (flags & ~16);
        flags = pendingResetDate != null ? (flags | 32) : (flags & ~32);
        flags = loginEmailPattern != null ? (flags | 64) : (flags & ~64);

        // Following parameters might be forced to true by another field that updated the flags
        hasPassword = (flags & 4) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (currentAlgo == null) throwNullFieldException("currentAlgo", flags);
            writeTLObject(currentAlgo, stream);
        }
        if ((flags & 4) != 0) {
            if (srpB == null) throwNullFieldException("srpB", flags);
            writeTLBytes(srpB, stream);
        }
        if ((flags & 4) != 0) {
            if (srpId == null) throwNullFieldException("srpId", flags);
            writeLong(srpId, stream);
        }
        if ((flags & 8) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            writeString(hint, stream);
        }
        if ((flags & 16) != 0) {
            if (emailUnconfirmedPattern == null) throwNullFieldException("emailUnconfirmedPattern", flags);
            writeString(emailUnconfirmedPattern, stream);
        }
        writeTLObject(newAlgo, stream);
        writeTLObject(newSecureAlgo, stream);
        writeTLBytes(secureRandom, stream);
        if ((flags & 32) != 0) {
            if (pendingResetDate == null) throwNullFieldException("pendingResetDate", flags);
            writeInt(pendingResetDate, stream);
        }
        if ((flags & 64) != 0) {
            if (loginEmailPattern == null) throwNullFieldException("loginEmailPattern", flags);
            writeString(loginEmailPattern, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasRecovery = (flags & 1) != 0;
        hasSecureValues = (flags & 2) != 0;
        hasPassword = (flags & 4) != 0;
        currentAlgo = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsPasswordKdfAlgo.class, -1) : null;
        srpB = (flags & 4) != 0 ? readTLBytes(stream, context) : null;
        srpId = (flags & 4) != 0 ? readLong(stream) : null;
        hint = (flags & 8) != 0 ? readTLString(stream) : null;
        emailUnconfirmedPattern = (flags & 16) != 0 ? readTLString(stream) : null;
        newAlgo = readTLObject(stream, context, TLAbsPasswordKdfAlgo.class, -1);
        newSecureAlgo = readTLObject(stream, context, TLAbsSecurePasswordKdfAlgo.class, -1);
        secureRandom = readTLBytes(stream, context);
        pendingResetDate = (flags & 32) != 0 ? readInt(stream) : null;
        loginEmailPattern = (flags & 64) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (currentAlgo == null) throwNullFieldException("currentAlgo", flags);
            size += currentAlgo.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (srpB == null) throwNullFieldException("srpB", flags);
            size += computeTLBytesSerializedSize(srpB);
        }
        if ((flags & 4) != 0) {
            if (srpId == null) throwNullFieldException("srpId", flags);
            size += SIZE_INT64;
        }
        if ((flags & 8) != 0) {
            if (hint == null) throwNullFieldException("hint", flags);
            size += computeTLStringSerializedSize(hint);
        }
        if ((flags & 16) != 0) {
            if (emailUnconfirmedPattern == null) throwNullFieldException("emailUnconfirmedPattern", flags);
            size += computeTLStringSerializedSize(emailUnconfirmedPattern);
        }
        size += newAlgo.computeSerializedSize();
        size += newSecureAlgo.computeSerializedSize();
        size += computeTLBytesSerializedSize(secureRandom);
        if ((flags & 32) != 0) {
            if (pendingResetDate == null) throwNullFieldException("pendingResetDate", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (loginEmailPattern == null) throwNullFieldException("loginEmailPattern", flags);
            size += computeTLStringSerializedSize(loginEmailPattern);
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

    public boolean getHasRecovery() {
        return hasRecovery;
    }

    public void setHasRecovery(boolean hasRecovery) {
        this.hasRecovery = hasRecovery;
    }

    public boolean getHasSecureValues() {
        return hasSecureValues;
    }

    public void setHasSecureValues(boolean hasSecureValues) {
        this.hasSecureValues = hasSecureValues;
    }

    public boolean getHasPassword() {
        return hasPassword;
    }

    public void setHasPassword(boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    public TLAbsPasswordKdfAlgo getCurrentAlgo() {
        return currentAlgo;
    }

    public void setCurrentAlgo(TLAbsPasswordKdfAlgo currentAlgo) {
        this.currentAlgo = currentAlgo;
    }

    public TLBytes getSrpB() {
        return srpB;
    }

    public void setSrpB(TLBytes srpB) {
        this.srpB = srpB;
    }

    public Long getSrpId() {
        return srpId;
    }

    public void setSrpId(Long srpId) {
        this.srpId = srpId;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getEmailUnconfirmedPattern() {
        return emailUnconfirmedPattern;
    }

    public void setEmailUnconfirmedPattern(String emailUnconfirmedPattern) {
        this.emailUnconfirmedPattern = emailUnconfirmedPattern;
    }

    public TLAbsPasswordKdfAlgo getNewAlgo() {
        return newAlgo;
    }

    public void setNewAlgo(TLAbsPasswordKdfAlgo newAlgo) {
        this.newAlgo = newAlgo;
    }

    public TLAbsSecurePasswordKdfAlgo getNewSecureAlgo() {
        return newSecureAlgo;
    }

    public void setNewSecureAlgo(TLAbsSecurePasswordKdfAlgo newSecureAlgo) {
        this.newSecureAlgo = newSecureAlgo;
    }

    public TLBytes getSecureRandom() {
        return secureRandom;
    }

    public void setSecureRandom(TLBytes secureRandom) {
        this.secureRandom = secureRandom;
    }

    public Integer getPendingResetDate() {
        return pendingResetDate;
    }

    public void setPendingResetDate(Integer pendingResetDate) {
        this.pendingResetDate = pendingResetDate;
    }

    public String getLoginEmailPattern() {
        return loginEmailPattern;
    }

    public void setLoginEmailPattern(String loginEmailPattern) {
        this.loginEmailPattern = loginEmailPattern;
    }
}
