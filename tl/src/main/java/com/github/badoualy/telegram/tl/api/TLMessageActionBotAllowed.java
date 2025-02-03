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
public class TLMessageActionBotAllowed extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean attachMenu;

    protected boolean fromRequest;

    protected String domain;

    protected TLAbsBotApp app;

    private final String _constructor = "messageActionBotAllowed#0";

    public TLMessageActionBotAllowed() {
    }

    public TLMessageActionBotAllowed(boolean attachMenu, boolean fromRequest, String domain, TLAbsBotApp app) {
        this.attachMenu = attachMenu;
        this.fromRequest = fromRequest;
        this.domain = domain;
        this.app = app;
    }

    private void computeFlags() {
        flags = 0;
        flags = attachMenu ? (flags | 2) : (flags & ~2);
        flags = fromRequest ? (flags | 8) : (flags & ~8);
        flags = domain != null ? (flags | 1) : (flags & ~1);
        flags = app != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (domain == null) throwNullFieldException("domain", flags);
            writeString(domain, stream);
        }
        if ((flags & 4) != 0) {
            if (app == null) throwNullFieldException("app", flags);
            writeTLObject(app, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        attachMenu = (flags & 2) != 0;
        fromRequest = (flags & 8) != 0;
        domain = (flags & 1) != 0 ? readTLString(stream) : null;
        app = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsBotApp.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (domain == null) throwNullFieldException("domain", flags);
            size += computeTLStringSerializedSize(domain);
        }
        if ((flags & 4) != 0) {
            if (app == null) throwNullFieldException("app", flags);
            size += app.computeSerializedSize();
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

    public boolean getAttachMenu() {
        return attachMenu;
    }

    public void setAttachMenu(boolean attachMenu) {
        this.attachMenu = attachMenu;
    }

    public boolean getFromRequest() {
        return fromRequest;
    }

    public void setFromRequest(boolean fromRequest) {
        this.fromRequest = fromRequest;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public TLAbsBotApp getApp() {
        return app;
    }

    public void setApp(TLAbsBotApp app) {
        this.app = app;
    }
}
