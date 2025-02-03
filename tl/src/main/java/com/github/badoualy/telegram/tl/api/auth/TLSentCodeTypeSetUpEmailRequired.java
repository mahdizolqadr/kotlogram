package com.github.badoualy.telegram.tl.api.auth;

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
public class TLSentCodeTypeSetUpEmailRequired extends TLAbsSentCodeType {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean appleSigninAllowed;

    protected boolean googleSigninAllowed;

    private final String _constructor = "auth.sentCodeTypeSetUpEmailRequired#0";

    public TLSentCodeTypeSetUpEmailRequired() {
    }

    public TLSentCodeTypeSetUpEmailRequired(boolean appleSigninAllowed, boolean googleSigninAllowed) {
        this.appleSigninAllowed = appleSigninAllowed;
        this.googleSigninAllowed = googleSigninAllowed;
    }

    private void computeFlags() {
        flags = 0;
        flags = appleSigninAllowed ? (flags | 1) : (flags & ~1);
        flags = googleSigninAllowed ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        appleSigninAllowed = (flags & 1) != 0;
        googleSigninAllowed = (flags & 2) != 0;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
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
}
