package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotApp;
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
public class TLBotApp extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inactive;

    protected boolean requestWriteAccess;

    protected boolean hasSettings;

    protected TLAbsBotApp app;

    private final String _constructor = "messages.botApp#0";

    public TLBotApp() {
    }

    public TLBotApp(boolean inactive, boolean requestWriteAccess, boolean hasSettings, TLAbsBotApp app) {
        this.inactive = inactive;
        this.requestWriteAccess = requestWriteAccess;
        this.hasSettings = hasSettings;
        this.app = app;
    }

    private void computeFlags() {
        flags = 0;
        flags = inactive ? (flags | 1) : (flags & ~1);
        flags = requestWriteAccess ? (flags | 2) : (flags & ~2);
        flags = hasSettings ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(app, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inactive = (flags & 1) != 0;
        requestWriteAccess = (flags & 2) != 0;
        hasSettings = (flags & 4) != 0;
        app = readTLObject(stream, context, TLAbsBotApp.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += app.computeSerializedSize();
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

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public boolean getRequestWriteAccess() {
        return requestWriteAccess;
    }

    public void setRequestWriteAccess(boolean requestWriteAccess) {
        this.requestWriteAccess = requestWriteAccess;
    }

    public boolean getHasSettings() {
        return hasSettings;
    }

    public void setHasSettings(boolean hasSettings) {
        this.hasSettings = hasSettings;
    }

    public TLAbsBotApp getApp() {
        return app;
    }

    public void setApp(TLAbsBotApp app) {
        this.app = app;
    }
}
