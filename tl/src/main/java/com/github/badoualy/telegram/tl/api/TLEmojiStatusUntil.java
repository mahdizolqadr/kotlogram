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
public class TLEmojiStatusUntil extends TLAbsEmojiStatus {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long documentId;

    protected int until;

    private final String _constructor = "emojiStatusUntil#0";

    public TLEmojiStatusUntil() {
    }

    public TLEmojiStatusUntil(long documentId, int until) {
        this.documentId = documentId;
        this.until = until;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(documentId, stream);
        writeInt(until, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        documentId = readLong(stream);
        until = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
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

    public long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(long documentId) {
        this.documentId = documentId;
    }

    public int getUntil() {
        return until;
    }

    public void setUntil(int until) {
        this.until = until;
    }
}
