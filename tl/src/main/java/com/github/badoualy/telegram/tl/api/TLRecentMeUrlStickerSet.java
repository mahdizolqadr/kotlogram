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
public class TLRecentMeUrlStickerSet extends TLAbsRecentMeUrl {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsStickerSetCovered set;

    private final String _constructor = "recentMeUrlStickerSet#0";

    public TLRecentMeUrlStickerSet() {
    }

    public TLRecentMeUrlStickerSet(String url, TLAbsStickerSetCovered set) {
        this.url = url;
        this.set = set;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(url, stream);
        writeTLObject(set, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        set = readTLObject(stream, context, TLAbsStickerSetCovered.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(url);
        size += set.computeSerializedSize();
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

    public TLAbsStickerSetCovered getSet() {
        return set;
    }

    public void setSet(TLAbsStickerSetCovered set) {
        this.set = set;
    }
}
