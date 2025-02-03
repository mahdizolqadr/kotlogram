package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyKey;
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestAccountSetPrivacy extends TLMethod<TLPrivacyRules> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputPrivacyKey key;

    protected TLVector<TLAbsInputPrivacyRule> rules;

    private final String _constructor = "account.setPrivacy#0";

    public TLRequestAccountSetPrivacy() {
    }

    public TLRequestAccountSetPrivacy(TLAbsInputPrivacyKey key, TLVector<TLAbsInputPrivacyRule> rules) {
        this.key = key;
        this.rules = rules;
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
        writeTLVector(rules, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLObject(stream, context, TLAbsInputPrivacyKey.class, -1);
        rules = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += key.computeSerializedSize();
        size += rules.computeSerializedSize();
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

    public TLVector<TLAbsInputPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<TLAbsInputPrivacyRule> rules) {
        this.rules = rules;
    }
}
