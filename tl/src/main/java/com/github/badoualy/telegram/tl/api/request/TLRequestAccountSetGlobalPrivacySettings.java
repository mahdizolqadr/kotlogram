package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLGlobalPrivacySettings;
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
public class TLRequestAccountSetGlobalPrivacySettings extends TLMethod<TLGlobalPrivacySettings> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLGlobalPrivacySettings settings;

    private final String _constructor = "account.setGlobalPrivacySettings#0";

    public TLRequestAccountSetGlobalPrivacySettings() {
    }

    public TLRequestAccountSetGlobalPrivacySettings(TLGlobalPrivacySettings settings) {
        this.settings = settings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLGlobalPrivacySettings deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLGlobalPrivacySettings)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLGlobalPrivacySettings) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        settings = readTLObject(stream, context, TLGlobalPrivacySettings.class, TLGlobalPrivacySettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += settings.computeSerializedSize();
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

    public TLGlobalPrivacySettings getSettings() {
        return settings;
    }

    public void setSettings(TLGlobalPrivacySettings settings) {
        this.settings = settings;
    }
}
