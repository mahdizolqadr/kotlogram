package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLInputSecureValue extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsSecureValueType type;

    protected TLSecureData data;

    protected TLAbsInputSecureFile frontSide;

    protected TLAbsInputSecureFile reverseSide;

    protected TLAbsInputSecureFile selfie;

    protected TLVector<TLAbsInputSecureFile> translation;

    protected TLVector<TLAbsInputSecureFile> files;

    protected TLAbsSecurePlainData plainData;

    private final String _constructor = "inputSecureValue#0";

    public TLInputSecureValue() {
    }

    public TLInputSecureValue(TLAbsSecureValueType type, TLSecureData data, TLAbsInputSecureFile frontSide, TLAbsInputSecureFile reverseSide, TLAbsInputSecureFile selfie, TLVector<TLAbsInputSecureFile> translation, TLVector<TLAbsInputSecureFile> files, TLAbsSecurePlainData plainData) {
        this.type = type;
        this.data = data;
        this.frontSide = frontSide;
        this.reverseSide = reverseSide;
        this.selfie = selfie;
        this.translation = translation;
        this.files = files;
        this.plainData = plainData;
    }

    private void computeFlags() {
        flags = 0;
        flags = data != null ? (flags | 1) : (flags & ~1);
        flags = frontSide != null ? (flags | 2) : (flags & ~2);
        flags = reverseSide != null ? (flags | 4) : (flags & ~4);
        flags = selfie != null ? (flags | 8) : (flags & ~8);
        flags = translation != null ? (flags | 64) : (flags & ~64);
        flags = files != null ? (flags | 16) : (flags & ~16);
        flags = plainData != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(type, stream);
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            writeTLObject(data, stream);
        }
        if ((flags & 2) != 0) {
            if (frontSide == null) throwNullFieldException("frontSide", flags);
            writeTLObject(frontSide, stream);
        }
        if ((flags & 4) != 0) {
            if (reverseSide == null) throwNullFieldException("reverseSide", flags);
            writeTLObject(reverseSide, stream);
        }
        if ((flags & 8) != 0) {
            if (selfie == null) throwNullFieldException("selfie", flags);
            writeTLObject(selfie, stream);
        }
        if ((flags & 64) != 0) {
            if (translation == null) throwNullFieldException("translation", flags);
            writeTLVector(translation, stream);
        }
        if ((flags & 16) != 0) {
            if (files == null) throwNullFieldException("files", flags);
            writeTLVector(files, stream);
        }
        if ((flags & 32) != 0) {
            if (plainData == null) throwNullFieldException("plainData", flags);
            writeTLObject(plainData, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        type = readTLObject(stream, context, TLAbsSecureValueType.class, -1);
        data = (flags & 1) != 0 ? readTLObject(stream, context, TLSecureData.class, TLSecureData.CONSTRUCTOR_ID) : null;
        frontSide = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputSecureFile.class, -1) : null;
        reverseSide = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputSecureFile.class, -1) : null;
        selfie = (flags & 8) != 0 ? readTLObject(stream, context, TLAbsInputSecureFile.class, -1) : null;
        translation = (flags & 64) != 0 ? readTLVector(stream, context) : null;
        files = (flags & 16) != 0 ? readTLVector(stream, context) : null;
        plainData = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsSecurePlainData.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += type.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (data == null) throwNullFieldException("data", flags);
            size += data.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (frontSide == null) throwNullFieldException("frontSide", flags);
            size += frontSide.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (reverseSide == null) throwNullFieldException("reverseSide", flags);
            size += reverseSide.computeSerializedSize();
        }
        if ((flags & 8) != 0) {
            if (selfie == null) throwNullFieldException("selfie", flags);
            size += selfie.computeSerializedSize();
        }
        if ((flags & 64) != 0) {
            if (translation == null) throwNullFieldException("translation", flags);
            size += translation.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (files == null) throwNullFieldException("files", flags);
            size += files.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (plainData == null) throwNullFieldException("plainData", flags);
            size += plainData.computeSerializedSize();
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

    public TLAbsSecureValueType getType() {
        return type;
    }

    public void setType(TLAbsSecureValueType type) {
        this.type = type;
    }

    public TLSecureData getData() {
        return data;
    }

    public void setData(TLSecureData data) {
        this.data = data;
    }

    public TLAbsInputSecureFile getFrontSide() {
        return frontSide;
    }

    public void setFrontSide(TLAbsInputSecureFile frontSide) {
        this.frontSide = frontSide;
    }

    public TLAbsInputSecureFile getReverseSide() {
        return reverseSide;
    }

    public void setReverseSide(TLAbsInputSecureFile reverseSide) {
        this.reverseSide = reverseSide;
    }

    public TLAbsInputSecureFile getSelfie() {
        return selfie;
    }

    public void setSelfie(TLAbsInputSecureFile selfie) {
        this.selfie = selfie;
    }

    public TLVector<TLAbsInputSecureFile> getTranslation() {
        return translation;
    }

    public void setTranslation(TLVector<TLAbsInputSecureFile> translation) {
        this.translation = translation;
    }

    public TLVector<TLAbsInputSecureFile> getFiles() {
        return files;
    }

    public void setFiles(TLVector<TLAbsInputSecureFile> files) {
        this.files = files;
    }

    public TLAbsSecurePlainData getPlainData() {
        return plainData;
    }

    public void setPlainData(TLAbsSecurePlainData plainData) {
        this.plainData = plainData;
    }
}
