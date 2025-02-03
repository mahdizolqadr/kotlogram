package com.github.badoualy.telegram.tl.api.payments;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLStarGift;
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
public class TLStarGifts extends TLAbsStarGifts {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int hash;

    protected TLVector<TLStarGift> gifts;

    private final String _constructor = "payments.starGifts#0";

    public TLStarGifts() {
    }

    public TLStarGifts(int hash, TLVector<TLStarGift> gifts) {
        this.hash = hash;
        this.gifts = gifts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(gifts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        gifts = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += gifts.computeSerializedSize();
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLStarGift> getGifts() {
        return gifts;
    }

    public void setGifts(TLVector<TLStarGift> gifts) {
        this.gifts = gifts;
    }
}
