package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTermsOfService extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean popup;

    protected TLDataJSON id;

    protected String text;

    protected TLVector<TLAbsMessageEntity> entities;

    protected Integer minAgeConfirm;

    private final String _constructor = "help.termsOfService#0";

    public TLTermsOfService() {
    }

    public TLTermsOfService(boolean popup, TLDataJSON id, String text, TLVector<TLAbsMessageEntity> entities, Integer minAgeConfirm) {
        this.popup = popup;
        this.id = id;
        this.text = text;
        this.entities = entities;
        this.minAgeConfirm = minAgeConfirm;
    }

    private void computeFlags() {
        flags = 0;
        flags = popup ? (flags | 1) : (flags & ~1);
        flags = minAgeConfirm != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(id, stream);
        writeString(text, stream);
        writeTLVector(entities, stream);
        if ((flags & 2) != 0) {
            if (minAgeConfirm == null) throwNullFieldException("minAgeConfirm", flags);
            writeInt(minAgeConfirm, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        popup = (flags & 1) != 0;
        id = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
        text = readTLString(stream);
        entities = readTLVector(stream, context);
        minAgeConfirm = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += id.computeSerializedSize();
        size += computeTLStringSerializedSize(text);
        size += entities.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (minAgeConfirm == null) throwNullFieldException("minAgeConfirm", flags);
            size += SIZE_INT32;
        }
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

    public boolean getPopup() {
        return popup;
    }

    public void setPopup(boolean popup) {
        this.popup = popup;
    }

    public TLDataJSON getId() {
        return id;
    }

    public void setId(TLDataJSON id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public Integer getMinAgeConfirm() {
        return minAgeConfirm;
    }

    public void setMinAgeConfirm(Integer minAgeConfirm) {
        this.minAgeConfirm = minAgeConfirm;
    }
}
