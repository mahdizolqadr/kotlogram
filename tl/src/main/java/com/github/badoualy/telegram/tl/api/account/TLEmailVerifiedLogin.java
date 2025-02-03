package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
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
public class TLEmailVerifiedLogin extends TLAbsEmailVerified {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsSentCode sentCode;

    private final String _constructor = "account.emailVerifiedLogin#0";

    public TLEmailVerifiedLogin() {
    }

    public TLEmailVerifiedLogin(String email, TLAbsSentCode sentCode) {
        this.email = email;
        this.sentCode = sentCode;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(email, stream);
        writeTLObject(sentCode, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        email = readTLString(stream);
        sentCode = readTLObject(stream, context, TLAbsSentCode.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(email);
        size += sentCode.computeSerializedSize();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TLAbsSentCode getSentCode() {
        return sentCode;
    }

    public void setSentCode(TLAbsSentCode sentCode) {
        this.sentCode = sentCode;
    }
}
