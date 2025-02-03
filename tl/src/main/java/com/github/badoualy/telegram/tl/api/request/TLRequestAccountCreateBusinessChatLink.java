package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLBusinessChatLink;
import com.github.badoualy.telegram.tl.api.TLInputBusinessChatLink;
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
public class TLRequestAccountCreateBusinessChatLink extends TLMethod<TLBusinessChatLink> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputBusinessChatLink link;

    private final String _constructor = "account.createBusinessChatLink#0";

    public TLRequestAccountCreateBusinessChatLink() {
    }

    public TLRequestAccountCreateBusinessChatLink(TLInputBusinessChatLink link) {
        this.link = link;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBusinessChatLink deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBusinessChatLink)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBusinessChatLink) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(link, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        link = readTLObject(stream, context, TLInputBusinessChatLink.class, TLInputBusinessChatLink.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += link.computeSerializedSize();
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

    public TLInputBusinessChatLink getLink() {
        return link;
    }

    public void setLink(TLInputBusinessChatLink link) {
        this.link = link;
    }
}
