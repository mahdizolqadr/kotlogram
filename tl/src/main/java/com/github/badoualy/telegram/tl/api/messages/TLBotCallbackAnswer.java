package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLBotCallbackAnswer extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean alert;

    protected boolean hasUrl;

    protected boolean nativeUi;

    protected String message;

    protected String url;

    protected int cacheTime;

    private final String _constructor = "messages.botCallbackAnswer#0";

    public TLBotCallbackAnswer() {
    }

    public TLBotCallbackAnswer(boolean alert, boolean hasUrl, boolean nativeUi, String message, String url, int cacheTime) {
        this.alert = alert;
        this.hasUrl = hasUrl;
        this.nativeUi = nativeUi;
        this.message = message;
        this.url = url;
        this.cacheTime = cacheTime;
    }

    private void computeFlags() {
        flags = 0;
        flags = alert ? (flags | 2) : (flags & ~2);
        flags = hasUrl ? (flags | 8) : (flags & ~8);
        flags = nativeUi ? (flags | 16) : (flags & ~16);
        flags = message != null ? (flags | 1) : (flags & ~1);
        flags = url != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            writeString(message, stream);
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        writeInt(cacheTime, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        alert = (flags & 2) != 0;
        hasUrl = (flags & 8) != 0;
        nativeUi = (flags & 16) != 0;
        message = (flags & 1) != 0 ? readTLString(stream) : null;
        url = (flags & 4) != 0 ? readTLString(stream) : null;
        cacheTime = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (message == null) throwNullFieldException("message", flags);
            size += computeTLStringSerializedSize(message);
        }
        if ((flags & 4) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        size += SIZE_INT32;
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

    public boolean getAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public boolean getHasUrl() {
        return hasUrl;
    }

    public void setHasUrl(boolean hasUrl) {
        this.hasUrl = hasUrl;
    }

    public boolean getNativeUi() {
        return nativeUi;
    }

    public void setNativeUi(boolean nativeUi) {
        this.nativeUi = nativeUi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }
}
