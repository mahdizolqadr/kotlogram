package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLSponsoredMessages extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x2a3c381f;

    protected int flags;

    protected TLBytes randomId;

    protected TLAbsPeer fromId;

    protected String startParam;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    private final String _constructor = "sponsoredMessage#2a3c381f";

    public TLSponsoredMessages() {
    }

    public TLSponsoredMessages(TLBytes randomId, TLAbsPeer fromId, String startParam, String message,
                               TLVector<TLAbsMessageEntity> entities) {
        this.randomId = randomId;
        this.fromId = fromId;
        this.startParam = startParam;
        this.message = message;
        this.entities = entities;
    }

    private void computeFlags() {
        flags = 0;
        flags = startParam != null ? (flags | 1) : (flags & ~1);
        flags = entities != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLBytes(randomId, stream);
        writeTLObject(fromId, stream);
        if ((flags & 1) != 0) {
            if (startParam == null) {
                throwNullFieldException("startParam", flags);
            }
            writeString(startParam, stream);
        }
        writeString(message, stream);
        if ((flags & 2) != 0) {
            if (entities == null) {
                throwNullFieldException("entities", flags);
            }
            writeTLVector(entities, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        randomId = readTLBytes(stream, context);
        fromId = readTLObject(stream, context, TLAbsPeer.class, -1);
        startParam = (flags & 1) != 0 ? readTLString(stream) : null;
        message = readTLString(stream);
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(randomId);
        size += fromId.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (startParam == null) {
                throwNullFieldException("startParam", flags);
            }
            size += computeTLStringSerializedSize(startParam);
        }
        size += computeTLStringSerializedSize(message);
        if ((flags & 2) != 0) {
            if (entities == null) {
                throwNullFieldException("entities", flags);
            }
            size += entities.computeSerializedSize();
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

    public TLBytes getRandomId() {
        return randomId;
    }

    public void setRandomId(TLBytes randomId) {
        this.randomId = randomId;
    }

    public TLAbsPeer getFromId() {
        return fromId;
    }

    public void setFromId(TLAbsPeer fromId) {
        this.fromId = fromId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }
}
