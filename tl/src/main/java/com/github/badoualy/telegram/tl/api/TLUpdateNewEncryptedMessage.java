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
public class TLUpdateNewEncryptedMessage extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsEncryptedMessage message;

    protected int qts;

    private final String _constructor = "updateNewEncryptedMessage#0";

    public TLUpdateNewEncryptedMessage() {
    }

    public TLUpdateNewEncryptedMessage(TLAbsEncryptedMessage message, int qts) {
        this.message = message;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(message, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        message = readTLObject(stream, context, TLAbsEncryptedMessage.class, -1);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += message.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLAbsEncryptedMessage getMessage() {
        return message;
    }

    public void setMessage(TLAbsEncryptedMessage message) {
        this.message = message;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
