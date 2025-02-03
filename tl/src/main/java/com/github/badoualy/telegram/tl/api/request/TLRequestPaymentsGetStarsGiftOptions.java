package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLStarsGiftOption;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestPaymentsGetStarsGiftOptions extends TLMethod<TLVector<TLStarsGiftOption>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputUser userId;

    private final String _constructor = "payments.getStarsGiftOptions#0";

    public TLRequestPaymentsGetStarsGiftOptions() {
    }

    public TLRequestPaymentsGetStarsGiftOptions(TLAbsInputUser userId) {
        this.userId = userId;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLStarsGiftOption> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    private void computeFlags() {
        flags = 0;
        flags = userId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            writeTLObject(userId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        userId = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsInputUser.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (userId == null) throwNullFieldException("userId", flags);
            size += userId.computeSerializedSize();
        }
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

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }
}
