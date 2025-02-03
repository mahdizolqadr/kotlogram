package com.github.badoualy.telegram.tl.api.smsjobs;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLEligibleToJoin extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String termsUrl;

    protected int monthlySentSms;

    private final String _constructor = "smsjobs.eligibleToJoin#0";

    public TLEligibleToJoin() {
    }

    public TLEligibleToJoin(String termsUrl, int monthlySentSms) {
        this.termsUrl = termsUrl;
        this.monthlySentSms = monthlySentSms;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(termsUrl, stream);
        writeInt(monthlySentSms, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        termsUrl = readTLString(stream);
        monthlySentSms = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(termsUrl);
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

    public String getTermsUrl() {
        return termsUrl;
    }

    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    public int getMonthlySentSms() {
        return monthlySentSms;
    }

    public void setMonthlySentSms(int monthlySentSms) {
        this.monthlySentSms = monthlySentSms;
    }
}
