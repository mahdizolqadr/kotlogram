package com.github.badoualy.telegram.tl.api;

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
public class TLInputInvoicePremiumGiftCode extends TLAbsInputInvoice {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputStorePaymentPurpose purpose;

    protected TLPremiumGiftCodeOption option;

    private final String _constructor = "inputInvoicePremiumGiftCode#0";

    public TLInputInvoicePremiumGiftCode() {
    }

    public TLInputInvoicePremiumGiftCode(TLAbsInputStorePaymentPurpose purpose, TLPremiumGiftCodeOption option) {
        this.purpose = purpose;
        this.option = option;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(purpose, stream);
        writeTLObject(option, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        purpose = readTLObject(stream, context, TLAbsInputStorePaymentPurpose.class, -1);
        option = readTLObject(stream, context, TLPremiumGiftCodeOption.class, TLPremiumGiftCodeOption.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += purpose.computeSerializedSize();
        size += option.computeSerializedSize();
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

    public TLAbsInputStorePaymentPurpose getPurpose() {
        return purpose;
    }

    public void setPurpose(TLAbsInputStorePaymentPurpose purpose) {
        this.purpose = purpose;
    }

    public TLPremiumGiftCodeOption getOption() {
        return option;
    }

    public void setOption(TLPremiumGiftCodeOption option) {
        this.option = option;
    }
}
