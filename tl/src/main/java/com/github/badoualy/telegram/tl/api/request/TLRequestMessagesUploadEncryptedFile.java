package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedFile;
import com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile;
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat;
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
public class TLRequestMessagesUploadEncryptedFile extends TLMethod<TLAbsEncryptedFile> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLInputEncryptedChat peer;

    protected TLAbsInputEncryptedFile file;

    private final String _constructor = "messages.uploadEncryptedFile#0";

    public TLRequestMessagesUploadEncryptedFile() {
    }

    public TLRequestMessagesUploadEncryptedFile(TLInputEncryptedChat peer, TLAbsInputEncryptedFile file) {
        this.peer = peer;
        this.file = file;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsEncryptedFile deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsEncryptedFile)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsEncryptedFile) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLObject(file, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLInputEncryptedChat.class, TLInputEncryptedChat.CONSTRUCTOR_ID);
        file = readTLObject(stream, context, TLAbsInputEncryptedFile.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += file.computeSerializedSize();
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

    public TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(TLInputEncryptedChat peer) {
        this.peer = peer;
    }

    public TLAbsInputEncryptedFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputEncryptedFile file) {
        this.file = file;
    }
}
