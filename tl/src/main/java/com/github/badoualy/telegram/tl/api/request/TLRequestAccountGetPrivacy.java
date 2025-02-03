package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyKey;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountGetPrivacy extends TLMethod<TLPrivacyRules> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputPrivacyKey key;

    private final String _constructor = "account.getPrivacy#0";

    public TLRequestAccountGetPrivacy() {
    }

    public TLRequestAccountGetPrivacy(TLAbsInputPrivacyKey key) {
        this.key = key;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLPrivacyRules deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPrivacyRules)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLPrivacyRules) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(key, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLObject(stream, context, TLAbsInputPrivacyKey.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += key.computeSerializedSize();
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

    public TLAbsInputPrivacyKey getKey() {
        return key;
    }

    public void setKey(TLAbsInputPrivacyKey key) {
        this.key = key;
    }
}
