package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile;
import com.github.badoualy.telegram.tl.api.TLInputEncryptedChat;
import com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLRequestMessagesSendEncryptedFile extends TLMethod<TLAbsSentEncryptedMessage> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean silent;

    protected TLInputEncryptedChat peer;

    protected long randomId;

    protected TLBytes data;

    protected TLAbsInputEncryptedFile file;

    private final String _constructor = "messages.sendEncryptedFile#0";

    public TLRequestMessagesSendEncryptedFile() {
    }

    public TLRequestMessagesSendEncryptedFile(boolean silent, TLInputEncryptedChat peer, long randomId, TLBytes data, TLAbsInputEncryptedFile file) {
        this.silent = silent;
        this.peer = peer;
        this.randomId = randomId;
        this.data = data;
        this.file = file;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsSentEncryptedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsSentEncryptedMessage)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLAbsSentEncryptedMessage) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = silent ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeLong(randomId, stream);
        writeTLBytes(data, stream);
        writeTLObject(file, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        silent = (flags & 1) != 0;
        peer = readTLObject(stream, context, TLInputEncryptedChat.class, TLInputEncryptedChat.CONSTRUCTOR_ID);
        randomId = readLong(stream);
        data = readTLBytes(stream, context);
        file = readTLObject(stream, context, TLAbsInputEncryptedFile.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(data);
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

    public boolean getSilent() {
        return silent;
    }

    public void setSilent(boolean silent) {
        this.silent = silent;
    }

    public TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(TLInputEncryptedChat peer) {
        this.peer = peer;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes data) {
        this.data = data;
    }

    public TLAbsInputEncryptedFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputEncryptedFile file) {
        this.file = file;
    }
}
