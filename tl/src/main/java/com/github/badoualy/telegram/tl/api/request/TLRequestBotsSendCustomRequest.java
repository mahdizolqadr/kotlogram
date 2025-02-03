package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
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
public class TLRequestBotsSendCustomRequest extends TLMethod<TLDataJSON> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String customMethod;

    protected TLDataJSON params;

    private final String _constructor = "bots.sendCustomRequest#0";

    public TLRequestBotsSendCustomRequest() {
    }

    public TLRequestBotsSendCustomRequest(String customMethod, TLDataJSON params) {
        this.customMethod = customMethod;
        this.params = params;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLDataJSON deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLDataJSON)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLDataJSON) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(customMethod, stream);
        writeTLObject(params, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        customMethod = readTLString(stream);
        params = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(customMethod);
        size += params.computeSerializedSize();
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

    public String getCustomMethod() {
        return customMethod;
    }

    public void setCustomMethod(String customMethod) {
        this.customMethod = customMethod;
    }

    public TLDataJSON getParams() {
        return params;
    }

    public void setParams(TLDataJSON params) {
        this.params = params;
    }
}
