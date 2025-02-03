package com.github.badoualy.telegram.tl.api.upload;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLCdnFileReuploadNeeded extends TLAbsCdnFile {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes requestToken;

    private final String _constructor = "upload.cdnFileReuploadNeeded#0";

    public TLCdnFileReuploadNeeded() {
    }

    public TLCdnFileReuploadNeeded(TLBytes requestToken) {
        this.requestToken = requestToken;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(requestToken, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        requestToken = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(requestToken);
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

    public TLBytes getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(TLBytes requestToken) {
        this.requestToken = requestToken;
    }
}
