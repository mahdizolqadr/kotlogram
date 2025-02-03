package com.github.badoualy.telegram.tl.api;

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
public class TLRestrictionReason extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String platform;

    protected String reason;

    protected String text;

    private final String _constructor = "restrictionReason#0";

    public TLRestrictionReason() {
    }

    public TLRestrictionReason(String platform, String reason, String text) {
        this.platform = platform;
        this.reason = reason;
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(platform, stream);
        writeString(reason, stream);
        writeString(text, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        platform = readTLString(stream);
        reason = readTLString(stream);
        text = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(platform);
        size += computeTLStringSerializedSize(reason);
        size += computeTLStringSerializedSize(text);
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

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
