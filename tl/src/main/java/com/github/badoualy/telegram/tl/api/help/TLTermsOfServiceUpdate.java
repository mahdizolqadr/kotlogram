package com.github.badoualy.telegram.tl.api.help;

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
public class TLTermsOfServiceUpdate extends TLAbsTermsOfServiceUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLTermsOfService termsOfService;

    private final String _constructor = "help.termsOfServiceUpdate#0";

    public TLTermsOfServiceUpdate() {
    }

    public TLTermsOfServiceUpdate(int expires, TLTermsOfService termsOfService) {
        this.expires = expires;
        this.termsOfService = termsOfService;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(expires, stream);
        writeTLObject(termsOfService, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        expires = readInt(stream);
        termsOfService = readTLObject(stream, context, TLTermsOfService.class, TLTermsOfService.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += termsOfService.computeSerializedSize();
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

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public TLTermsOfService getTermsOfService() {
        return termsOfService;
    }

    public void setTermsOfService(TLTermsOfService termsOfService) {
        this.termsOfService = termsOfService;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLTermsOfServiceUpdate getAsTermsOfServiceUpdate() {
        return this;
    }
}
