package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
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
public class TLRequestMessagesRequestSimpleWebView extends TLMethod<TLWebViewResultUrl> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean fromSwitchWebview;

    protected boolean fromSideMenu;

    protected boolean compact;

    protected boolean fullscreen;

    protected TLAbsInputUser bot;

    protected String url;

    protected String startParam;

    protected TLDataJSON themeParams;

    protected String platform;

    private final String _constructor = "messages.requestSimpleWebView#0";

    public TLRequestMessagesRequestSimpleWebView() {
    }

    public TLRequestMessagesRequestSimpleWebView(boolean fromSwitchWebview, boolean fromSideMenu, boolean compact, boolean fullscreen, TLAbsInputUser bot, String url, String startParam, TLDataJSON themeParams, String platform) {
        this.fromSwitchWebview = fromSwitchWebview;
        this.fromSideMenu = fromSideMenu;
        this.compact = compact;
        this.fullscreen = fullscreen;
        this.bot = bot;
        this.url = url;
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
        flags = fromSwitchWebview ? (flags | 2) : (flags & ~2);
        flags = fromSideMenu ? (flags | 4) : (flags & ~4);
        flags = compact ? (flags | 128) : (flags & ~128);
        flags = fullscreen ? (flags | 256) : (flags & ~256);
        flags = url != null ? (flags | 8) : (flags & ~8);
        flags = startParam != null ? (flags | 16) : (flags & ~16);
        flags = themeParams != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(bot, stream);
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 16) != 0) {
            if (startParam == null) throwNullFieldException("startParam", flags);
            writeString(startParam, stream);
        }
        if ((flags & 1) != 0) {
            if (themeParams == null) throwNullFieldException("themeParams", flags);
            writeTLObject(themeParams, stream);
        }
        writeString(platform, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        fromSwitchWebview = (flags & 2) != 0;
        fromSideMenu = (flags & 4) != 0;
        compact = (flags & 128) != 0;
        fullscreen = (flags & 256) != 0;
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        url = (flags & 8) != 0 ? readTLString(stream) : null;
        startParam = (flags & 16) != 0 ? readTLString(stream) : null;
        themeParams = (flags & 1) != 0 ? readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID) : null;
        platform = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += bot.computeSerializedSize();
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 16) != 0) {
            if (startParam == null) throwNullFieldException("startParam", flags);
            size += computeTLStringSerializedSize(startParam);
        }
        if ((flags & 1) != 0) {
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

    public boolean getFromSwitchWebview() {
        return fromSwitchWebview;
    }

    public void setFromSwitchWebview(boolean fromSwitchWebview) {
        this.fromSwitchWebview = fromSwitchWebview;
    }

    public boolean getFromSideMenu() {
        return fromSideMenu;
    }

    public void setFromSideMenu(boolean fromSideMenu) {
        this.fromSideMenu = fromSideMenu;
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

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
