package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLFileHash;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLRequestUploadReuploadCdnFile extends TLMethod<TLVector<TLFileHash>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLBytes fileToken;

    protected TLBytes requestToken;

    private final String _constructor = "upload.reuploadCdnFile#0";

    public TLRequestUploadReuploadCdnFile() {
    }

    public TLRequestUploadReuploadCdnFile(TLBytes fileToken, TLBytes requestToken) {
        this.fileToken = fileToken;
        this.requestToken = requestToken;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLFileHash> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(fileToken, stream);
        writeTLBytes(requestToken, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        fileToken = readTLBytes(stream, context);
        requestToken = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(fileToken);
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

    public TLBytes getFileToken() {
        return fileToken;
    }

    public void setFileToken(TLBytes fileToken) {
        this.fileToken = fileToken;
    }

    public TLBytes getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(TLBytes requestToken) {
        this.requestToken = requestToken;
    }
}
