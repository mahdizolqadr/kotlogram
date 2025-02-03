package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputCollectible;
import com.github.badoualy.telegram.tl.api.fragment.TLCollectibleInfo;
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
public class TLRequestFragmentGetCollectibleInfo extends TLMethod<TLCollectibleInfo> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputCollectible collectible;

    private final String _constructor = "fragment.getCollectibleInfo#0";

    public TLRequestFragmentGetCollectibleInfo() {
    }

    public TLRequestFragmentGetCollectibleInfo(TLAbsInputCollectible collectible) {
        this.collectible = collectible;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLCollectibleInfo deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLCollectibleInfo)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLCollectibleInfo) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(collectible, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        collectible = readTLObject(stream, context, TLAbsInputCollectible.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += collectible.computeSerializedSize();
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

    public TLAbsInputCollectible getCollectible() {
        return collectible;
    }

    public void setCollectible(TLAbsInputCollectible collectible) {
        this.collectible = collectible;
    }
}
