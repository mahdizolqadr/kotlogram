package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
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
public class TLStickerKeyword extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long documentId;

    protected TLStringVector keyword;

    private final String _constructor = "stickerKeyword#0";

    public TLStickerKeyword() {
    }

    public TLStickerKeyword(long documentId, TLStringVector keyword) {
        this.documentId = documentId;
        this.keyword = keyword;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(documentId, stream);
        writeTLVector(keyword, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        documentId = readLong(stream);
        keyword = readTLStringVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += keyword.computeSerializedSize();
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

    public TLStringVector getKeyword() {
        return keyword;
    }

    public void setKeyword(TLStringVector keyword) {
        this.keyword = keyword;
    }
}
