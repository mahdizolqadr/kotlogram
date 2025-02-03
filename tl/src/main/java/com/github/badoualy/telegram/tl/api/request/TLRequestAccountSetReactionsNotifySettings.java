package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLReactionsNotifySettings;
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
public class TLRequestAccountSetReactionsNotifySettings extends TLMethod<TLReactionsNotifySettings> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLReactionsNotifySettings settings;

    private final String _constructor = "account.setReactionsNotifySettings#0";

    public TLRequestAccountSetReactionsNotifySettings() {
    }

    public TLRequestAccountSetReactionsNotifySettings(TLReactionsNotifySettings settings) {
        this.settings = settings;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLReactionsNotifySettings deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLReactionsNotifySettings)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLReactionsNotifySettings) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(settings, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        settings = readTLObject(stream, context, TLReactionsNotifySettings.class, TLReactionsNotifySettings.CONSTRUCTOR_ID);
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

    public TLReactionsNotifySettings getSettings() {
        return settings;
    }

    public void setSettings(TLReactionsNotifySettings settings) {
        this.settings = settings;
    }
}
