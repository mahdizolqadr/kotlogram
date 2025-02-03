package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputCheckPasswordSRP;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.payments.TLStarsRevenueWithdrawalUrl;
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
public class TLRequestPaymentsGetStarsRevenueWithdrawalUrl extends TLMethod<TLStarsRevenueWithdrawalUrl> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputPeer peer;

    protected long stars;

    protected TLAbsInputCheckPasswordSRP password;

    private final String _constructor = "payments.getStarsRevenueWithdrawalUrl#0";

    public TLRequestPaymentsGetStarsRevenueWithdrawalUrl() {
    }

    public TLRequestPaymentsGetStarsRevenueWithdrawalUrl(TLAbsInputPeer peer, long stars, TLAbsInputCheckPasswordSRP password) {
        this.peer = peer;
        this.stars = stars;
        this.password = password;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLStarsRevenueWithdrawalUrl deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLStarsRevenueWithdrawalUrl)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLStarsRevenueWithdrawalUrl) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeLong(stars, stream);
        writeTLObject(password, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        stars = readLong(stream);
        password = readTLObject(stream, context, TLAbsInputCheckPasswordSRP.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += SIZE_INT64;
        size += password.computeSerializedSize();
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

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public long getStars() {
        return stars;
    }

    public void setStars(long stars) {
        this.stars = stars;
    }

    public TLAbsInputCheckPasswordSRP getPassword() {
        return password;
    }

    public void setPassword(TLAbsInputCheckPasswordSRP password) {
        this.password = password;
    }
}
