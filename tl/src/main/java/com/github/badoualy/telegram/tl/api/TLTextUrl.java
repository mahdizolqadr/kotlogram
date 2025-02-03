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
public class TLTextUrl extends TLAbsRichText {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsRichText text;

    protected String url;

    protected long webpageId;

    private final String _constructor = "textUrl#0";

    public TLTextUrl() {
    }

    public TLTextUrl(TLAbsRichText text, String url, long webpageId) {
        this.text = text;
        this.url = url;
        this.webpageId = webpageId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(text, stream);
        writeString(url, stream);
        writeLong(webpageId, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLObject(stream, context, TLAbsRichText.class, -1);
        url = readTLString(stream);
        webpageId = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += text.computeSerializedSize();
        size += computeTLStringSerializedSize(url);
        size += SIZE_INT64;
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

    public TLAbsRichText getText() {
        return text;
    }

    public void setText(TLAbsRichText text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getWebpageId() {
        return webpageId;
    }

    public void setWebpageId(long webpageId) {
        this.webpageId = webpageId;
    }
}
