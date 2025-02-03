package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputBotApp;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLDataJSON;
import com.github.badoualy.telegram.tl.api.TLWebViewResultUrl;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestMessagesRequestAppWebView extends TLMethod<TLWebViewResultUrl> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean writeAllowed;

    protected boolean compact;

    protected boolean fullscreen;

    protected TLAbsInputPeer peer;

    protected TLAbsInputBotApp app;

    protected String startParam;

    protected TLDataJSON themeParams;

    protected String platform;

    private final String _constructor = "messages.requestAppWebView#0";

    public TLRequestMessagesRequestAppWebView() {
    }

    public TLRequestMessagesRequestAppWebView(boolean writeAllowed, boolean compact, boolean fullscreen, TLAbsInputPeer peer, TLAbsInputBotApp app, String startParam, TLDataJSON themeParams, String platform) {
        this.writeAllowed = writeAllowed;
        this.compact = compact;
        this.fullscreen = fullscreen;
        this.peer = peer;
        this.app = app;
        this.startParam = startParam;
        this.themeParams = themeParams;
        this.platform = platform;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLWebViewResultUrl deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLWebViewResultUrl)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLWebViewResultUrl) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = writeAllowed ? (flags | 1) : (flags & ~1);
        flags = compact ? (flags | 128) : (flags & ~128);
        flags = fullscreen ? (flags | 256) : (flags & ~256);
        flags = startParam != null ? (flags | 2) : (flags & ~2);
        flags = themeParams != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeTLObject(app, stream);
        if ((flags & 2) != 0) {
            if (startParam == null) throwNullFieldException("startParam", flags);
            writeString(startParam, stream);
        }
        if ((flags & 4) != 0) {
            if (themeParams == null) throwNullFieldException("themeParams", flags);
            writeTLObject(themeParams, stream);
        }
        writeString(platform, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        writeAllowed = (flags & 1) != 0;
        compact = (flags & 128) != 0;
        fullscreen = (flags & 256) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        app = readTLObject(stream, context, TLAbsInputBotApp.class, -1);
        startParam = (flags & 2) != 0 ? readTLString(stream) : null;
        themeParams = (flags & 4) != 0 ? readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID) : null;
        platform = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += app.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (startParam == null) throwNullFieldException("startParam", flags);
            size += computeTLStringSerializedSize(startParam);
        }
        if ((flags & 4) != 0) {
            if (themeParams == null) throwNullFieldException("themeParams", flags);
            size += themeParams.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(platform);
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

    public boolean getWriteAllowed() {
        return writeAllowed;
    }

    public void setWriteAllowed(boolean writeAllowed) {
        this.writeAllowed = writeAllowed;
    }

    public boolean getCompact() {
        return compact;
    }

    public void setCompact(boolean compact) {
        this.compact = compact;
    }

    public boolean getFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLAbsInputBotApp getApp() {
        return app;
    }

    public void setApp(TLAbsInputBotApp app) {
        this.app = app;
    }

    public String getStartParam() {
        return startParam;
    }

    public void setStartParam(String startParam) {
        this.startParam = startParam;
    }

    public TLDataJSON getThemeParams() {
        return themeParams;
    }

    public void setThemeParams(TLDataJSON themeParams) {
        this.themeParams = themeParams;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
}
