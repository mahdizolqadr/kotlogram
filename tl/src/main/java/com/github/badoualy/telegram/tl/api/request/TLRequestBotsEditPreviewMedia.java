package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputMedia;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.TLBotPreviewMedia;
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
public class TLRequestBotsEditPreviewMedia extends TLMethod<TLBotPreviewMedia> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser bot;

    protected String langCode;

    protected TLAbsInputMedia media;

    protected TLAbsInputMedia newMedia;

    private final String _constructor = "bots.editPreviewMedia#0";

    public TLRequestBotsEditPreviewMedia() {
    }

    public TLRequestBotsEditPreviewMedia(TLAbsInputUser bot, String langCode, TLAbsInputMedia media, TLAbsInputMedia newMedia) {
        this.bot = bot;
        this.langCode = langCode;
        this.media = media;
        this.newMedia = newMedia;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBotPreviewMedia deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBotPreviewMedia)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBotPreviewMedia) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(bot, stream);
        writeString(langCode, stream);
        writeTLObject(media, stream);
        writeTLObject(newMedia, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        bot = readTLObject(stream, context, TLAbsInputUser.class, -1);
        langCode = readTLString(stream);
        media = readTLObject(stream, context, TLAbsInputMedia.class, -1);
        newMedia = readTLObject(stream, context, TLAbsInputMedia.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += bot.computeSerializedSize();
        size += computeTLStringSerializedSize(langCode);
        size += media.computeSerializedSize();
        size += newMedia.computeSerializedSize();
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

    public TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(TLAbsInputMedia media) {
        this.media = media;
    }

    public TLAbsInputMedia getNewMedia() {
        return newMedia;
    }

    public void setNewMedia(TLAbsInputMedia newMedia) {
        this.newMedia = newMedia;
    }
}
