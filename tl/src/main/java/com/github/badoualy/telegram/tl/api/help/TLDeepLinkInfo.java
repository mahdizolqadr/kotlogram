package com.github.badoualy.telegram.tl.api.help;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
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
public class TLDeepLinkInfo extends TLAbsDeepLinkInfo {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean updateApp;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    private final String _constructor = "help.deepLinkInfo#0";

    public TLDeepLinkInfo() {
    }

    public TLDeepLinkInfo(boolean updateApp, String message, TLVector<TLAbsMessageEntity> entities) {
        this.updateApp = updateApp;
        this.message = message;
        this.entities = entities;
    }

    private void computeFlags() {
        flags = 0;
        flags = updateApp ? (flags | 1) : (flags & ~1);
        flags = entities != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(message, stream);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        updateApp = (flags & 1) != 0;
        message = readTLString(stream);
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
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

    public boolean getUpdateApp() {
        return updateApp;
    }

    public void setUpdateApp(boolean updateApp) {
        this.updateApp = updateApp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLDeepLinkInfo getAsDeepLinkInfo() {
        return this;
    }
}
