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
public class TLUpdateStarsBalance extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLStarsAmount balance;

    private final String _constructor = "updateStarsBalance#0";

    public TLUpdateStarsBalance() {
    }

    public TLUpdateStarsBalance(TLStarsAmount balance) {
        this.balance = balance;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(balance, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        balance = readTLObject(stream, context, TLStarsAmount.class, TLStarsAmount.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += balance.computeSerializedSize();
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

    public TLStarsAmount getBalance() {
        return balance;
    }

    public void setBalance(TLStarsAmount balance) {
        this.balance = balance;
    }
}
