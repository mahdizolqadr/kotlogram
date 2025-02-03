package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLUpdatePrivacy extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsPrivacyKey key;

    protected TLVector<TLAbsPrivacyRule> rules;

    private final String _constructor = "updatePrivacy#0";

    public TLUpdatePrivacy() {
    }

    public TLUpdatePrivacy(TLAbsPrivacyKey key, TLVector<TLAbsPrivacyRule> rules) {
        this.key = key;
        this.rules = rules;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(key, stream);
        writeTLVector(rules, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLObject(stream, context, TLAbsPrivacyKey.class, -1);
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

    public TLAbsPrivacyKey getKey() {
        return key;
    }

    public void setKey(TLAbsPrivacyKey key) {
        this.key = key;
    }

    public TLVector<TLAbsPrivacyRule> getRules() {
        return rules;
    }

    public void setRules(TLVector<TLAbsPrivacyRule> rules) {
        this.rules = rules;
    }
}
