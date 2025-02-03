package com.github.badoualy.telegram.tl.api.auth;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLAuthorization extends TLAbsAuthorization {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean setupPasswordRequired;

    protected Integer otherwiseReloginDays;

    protected Integer tmpSessions;

    protected TLBytes futureAuthToken;

    protected TLAbsUser user;

    private final String _constructor = "auth.authorization#0";

    public TLAuthorization() {
    }

    public TLAuthorization(boolean setupPasswordRequired, Integer otherwiseReloginDays, Integer tmpSessions, TLBytes futureAuthToken, TLAbsUser user) {
        this.setupPasswordRequired = setupPasswordRequired;
        this.otherwiseReloginDays = otherwiseReloginDays;
        this.tmpSessions = tmpSessions;
        this.futureAuthToken = futureAuthToken;
        this.user = user;
    }

    private void computeFlags() {
        flags = 0;
        flags = setupPasswordRequired ? (flags | 2) : (flags & ~2);
        flags = otherwiseReloginDays != null ? (flags | 2) : (flags & ~2);
        flags = tmpSessions != null ? (flags | 1) : (flags & ~1);
        flags = futureAuthToken != null ? (flags | 4) : (flags & ~4);

        // Following parameters might be forced to true by another field that updated the flags
        setupPasswordRequired = (flags & 2) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (otherwiseReloginDays == null) throwNullFieldException("otherwiseReloginDays", flags);
            writeInt(otherwiseReloginDays, stream);
        }
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            writeInt(tmpSessions, stream);
        }
        if ((flags & 4) != 0) {
            if (futureAuthToken == null) throwNullFieldException("futureAuthToken", flags);
            writeTLBytes(futureAuthToken, stream);
        }
        writeTLObject(user, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        setupPasswordRequired = (flags & 2) != 0;
        otherwiseReloginDays = (flags & 2) != 0 ? readInt(stream) : null;
        tmpSessions = (flags & 1) != 0 ? readInt(stream) : null;
        futureAuthToken = (flags & 4) != 0 ? readTLBytes(stream, context) : null;
        user = readTLObject(stream, context, TLAbsUser.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (otherwiseReloginDays == null) throwNullFieldException("otherwiseReloginDays", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (futureAuthToken == null) throwNullFieldException("futureAuthToken", flags);
            size += computeTLBytesSerializedSize(futureAuthToken);
        }
        size += user.computeSerializedSize();
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

    public boolean getSetupPasswordRequired() {
        return setupPasswordRequired;
    }

    public void setSetupPasswordRequired(boolean setupPasswordRequired) {
        this.setupPasswordRequired = setupPasswordRequired;
    }

    public Integer getOtherwiseReloginDays() {
        return otherwiseReloginDays;
    }

    public void setOtherwiseReloginDays(Integer otherwiseReloginDays) {
        this.otherwiseReloginDays = otherwiseReloginDays;
    }

    public Integer getTmpSessions() {
        return tmpSessions;
    }

    public void setTmpSessions(Integer tmpSessions) {
        this.tmpSessions = tmpSessions;
    }

    public TLBytes getFutureAuthToken() {
        return futureAuthToken;
    }

    public void setFutureAuthToken(TLBytes futureAuthToken) {
        this.futureAuthToken = futureAuthToken;
    }

    public TLAbsUser getUser() {
        return user;
    }

    public void setUser(TLAbsUser user) {
        this.user = user;
    }
}
