package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLRequestBotsDeletePreviewMedia extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser bot;

    protected String langCode;

    protected TLVector<TLAbsInputMedia> media;

    private final String _constructor = "bots.deletePreviewMedia#0";

    public TLRequestBotsDeletePreviewMedia() {
    }

    public TLRequestBotsDeletePreviewMedia(TLAbsInputUser bot, String langCode, TLVector<TLAbsInputMedia> media) {
        this.bot = bot;
        this.langCode = langCode;
        this.media = media;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(bot, stream);
        writeString(langCode, stream);
        writeTLVector(media, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        langCode = readTLString(stream);
        media = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += bot.computeSerializedSize();
        size += computeTLStringSerializedSize(langCode);
        size += media.computeSerializedSize();
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

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }

    public TLVector<TLAbsInputMedia> getMedia() {
        return media;
    }

    public void setMedia(TLVector<TLAbsInputMedia> media) {
        this.media = media;
    }
}
