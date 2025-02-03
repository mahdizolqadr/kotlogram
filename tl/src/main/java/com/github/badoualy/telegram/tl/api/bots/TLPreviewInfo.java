package com.github.badoualy.telegram.tl.api.bots;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLBotPreviewMedia;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLStringVector;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLPreviewInfo extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLVector<TLBotPreviewMedia> media;

    protected TLStringVector langCodes;

    private final String _constructor = "bots.previewInfo#0";

    public TLPreviewInfo() {
    }

    public TLPreviewInfo(TLVector<TLBotPreviewMedia> media, TLStringVector langCodes) {
        this.media = media;
        this.langCodes = langCodes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(media, stream);
        writeTLVector(langCodes, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        media = readTLVector(stream, context);
        langCodes = readTLStringVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += media.computeSerializedSize();
        size += langCodes.computeSerializedSize();
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

    public TLVector<TLBotPreviewMedia> getMedia() {
        return media;
    }

    public void setMedia(TLVector<TLBotPreviewMedia> media) {
        this.media = media;
    }

    public TLStringVector getLangCodes() {
        return langCodes;
    }

    public void setLangCodes(TLStringVector langCodes) {
        this.langCodes = langCodes;
    }
}
