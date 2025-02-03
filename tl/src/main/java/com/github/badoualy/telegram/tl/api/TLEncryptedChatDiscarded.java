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
public class TLEncryptedChatDiscarded extends TLAbsEncryptedChat {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean historyDeleted;

    private final String _constructor = "encryptedChatDiscarded#0";

    public TLEncryptedChatDiscarded() {
    }

    public TLEncryptedChatDiscarded(boolean historyDeleted, int id) {
        this.historyDeleted = historyDeleted;
        this.id = id;
    }

    private void computeFlags() {
        flags = 0;
        flags = historyDeleted ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        historyDeleted = (flags & 1) != 0;
        id = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
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

    public boolean getHistoryDeleted() {
        return historyDeleted;
    }

    public void setHistoryDeleted(boolean historyDeleted) {
        this.historyDeleted = historyDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
