package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.api.TLAvailableEffect;
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
public class TLAvailableEffects extends TLAbsAvailableEffects {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int hash;

    protected TLVector<TLAvailableEffect> effects;

    protected TLVector<TLAbsDocument> documents;

    private final String _constructor = "messages.availableEffects#0";

    public TLAvailableEffects() {
    }

    public TLAvailableEffects(int hash, TLVector<TLAvailableEffect> effects, TLVector<TLAbsDocument> documents) {
        this.hash = hash;
        this.effects = effects;
        this.documents = documents;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(hash, stream);
        writeTLVector(effects, stream);
        writeTLVector(documents, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readInt(stream);
        effects = readTLVector(stream, context);
        documents = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += effects.computeSerializedSize();
        size += documents.computeSerializedSize();
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

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    public TLVector<TLAvailableEffect> getEffects() {
        return effects;
    }

    public void setEffects(TLVector<TLAvailableEffect> effects) {
        this.effects = effects;
    }

    public TLVector<TLAbsDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(TLVector<TLAbsDocument> documents) {
        this.documents = documents;
    }
}
