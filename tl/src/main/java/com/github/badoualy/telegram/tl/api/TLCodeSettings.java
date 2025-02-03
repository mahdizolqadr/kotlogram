package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLCodeSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean allowFlashcall;

    protected boolean currentNumber;

    protected boolean allowAppHash;

    protected boolean allowMissedCall;

    protected boolean allowFirebase;

    protected boolean unknownNumber;

    protected TLVector<TLBytes> logoutTokens;

    protected String token;

    protected boolean appSandbox;

    private final String _constructor = "codeSettings#0";

    public TLCodeSettings() {
    }

    public TLCodeSettings(boolean allowFlashcall, boolean currentNumber, boolean allowAppHash, boolean allowMissedCall, boolean allowFirebase, boolean unknownNumber, TLVector<TLBytes> logoutTokens, String token, boolean appSandbox) {
        this.allowFlashcall = allowFlashcall;
        this.currentNumber = currentNumber;
        this.allowAppHash = allowAppHash;
        this.allowMissedCall = allowMissedCall;
        this.allowFirebase = allowFirebase;
        this.unknownNumber = unknownNumber;
        this.logoutTokens = logoutTokens;
        this.token = token;
        this.appSandbox = appSandbox;
    }

    private void computeFlags() {
        flags = 0;
        flags = allowFlashcall ? (flags | 1) : (flags & ~1);
        flags = currentNumber ? (flags | 2) : (flags & ~2);
        flags = allowAppHash ? (flags | 16) : (flags & ~16);
        flags = allowMissedCall ? (flags | 32) : (flags & ~32);
        flags = allowFirebase ? (flags | 128) : (flags & ~128);
        flags = unknownNumber ? (flags | 512) : (flags & ~512);
        flags = logoutTokens != null ? (flags | 64) : (flags & ~64);
        flags = token != null ? (flags | 256) : (flags & ~256);
        // If field is not serialized force it to false
        if (appSandbox && (flags & 256) == 0) appSandbox = false;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 64) != 0) {
            if (logoutTokens == null) throwNullFieldException("logoutTokens", flags);
            writeTLVector(logoutTokens, stream);
        }
        if ((flags & 256) != 0) {
            if (token == null) throwNullFieldException("token", flags);
            writeString(token, stream);
        }
        if ((flags & 256) != 0) {
            writeBoolean(appSandbox, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        allowFlashcall = (flags & 1) != 0;
        currentNumber = (flags & 2) != 0;
        allowAppHash = (flags & 16) != 0;
        allowMissedCall = (flags & 32) != 0;
        allowFirebase = (flags & 128) != 0;
        unknownNumber = (flags & 512) != 0;
        logoutTokens = (flags & 64) != 0 ? readTLVector(stream, context) : null;
        token = (flags & 256) != 0 ? readTLString(stream) : null;
        appSandbox = (flags & 256) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 64) != 0) {
            if (logoutTokens == null) throwNullFieldException("logoutTokens", flags);
            size += logoutTokens.computeSerializedSize();
        }
        if ((flags & 256) != 0) {
            if (token == null) throwNullFieldException("token", flags);
            size += computeTLStringSerializedSize(token);
        }
        if ((flags & 256) != 0) {
            size += SIZE_BOOLEAN;
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

    public boolean getAllowFlashcall() {
        return allowFlashcall;
    }

    public void setAllowFlashcall(boolean allowFlashcall) {
        this.allowFlashcall = allowFlashcall;
    }

    public boolean getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(boolean currentNumber) {
        this.currentNumber = currentNumber;
    }

    public boolean getAllowAppHash() {
        return allowAppHash;
    }

    public void setAllowAppHash(boolean allowAppHash) {
        this.allowAppHash = allowAppHash;
    }

    public boolean getAllowMissedCall() {
        return allowMissedCall;
    }

    public void setAllowMissedCall(boolean allowMissedCall) {
        this.allowMissedCall = allowMissedCall;
    }

    public boolean getAllowFirebase() {
        return allowFirebase;
    }

    public void setAllowFirebase(boolean allowFirebase) {
        this.allowFirebase = allowFirebase;
    }

    public boolean getUnknownNumber() {
        return unknownNumber;
    }

    public void setUnknownNumber(boolean unknownNumber) {
        this.unknownNumber = unknownNumber;
    }

    public TLVector<TLBytes> getLogoutTokens() {
        return logoutTokens;
    }

    public void setLogoutTokens(TLVector<TLBytes> logoutTokens) {
        this.logoutTokens = logoutTokens;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean getAppSandbox() {
        return appSandbox;
    }

    public void setAppSandbox(boolean appSandbox) {
        this.appSandbox = appSandbox;
    }
}
