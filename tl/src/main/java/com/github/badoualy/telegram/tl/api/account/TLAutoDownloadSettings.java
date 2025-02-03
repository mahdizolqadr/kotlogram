package com.github.badoualy.telegram.tl.api.account;

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
public class TLAutoDownloadSettings extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings low;

    protected com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings medium;

    protected com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings high;

    private final String _constructor = "account.autoDownloadSettings#0";

    public TLAutoDownloadSettings() {
    }

    public TLAutoDownloadSettings(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings low, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings medium, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings high) {
        this.low = low;
        this.medium = medium;
        this.high = high;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(low, stream);
        writeTLObject(medium, stream);
        writeTLObject(high, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        low = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID);
        medium = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID);
        high = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.class, com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += low.computeSerializedSize();
        size += medium.computeSerializedSize();
        size += high.computeSerializedSize();
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

    public com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings getLow() {
        return low;
    }

    public void setLow(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings low) {
        this.low = low;
    }

    public com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings getMedium() {
        return medium;
    }

    public void setMedium(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings medium) {
        this.medium = medium;
    }

    public com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings getHigh() {
        return high;
    }

    public void setHigh(com.github.badoualy.telegram.tl.api.TLAutoDownloadSettings high) {
        this.high = high;
    }
}
