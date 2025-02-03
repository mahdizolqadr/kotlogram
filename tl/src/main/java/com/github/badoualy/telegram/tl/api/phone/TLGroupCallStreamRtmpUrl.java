package com.github.badoualy.telegram.tl.api.phone;

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
public class TLGroupCallStreamRtmpUrl extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String url;

    protected String key;

    private final String _constructor = "phone.groupCallStreamRtmpUrl#0";

    public TLGroupCallStreamRtmpUrl() {
    }

    public TLGroupCallStreamRtmpUrl(String url, String key) {
        this.url = url;
        this.key = key;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(url, stream);
        writeString(key, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        key = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(url);
        size += computeTLStringSerializedSize(key);
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
