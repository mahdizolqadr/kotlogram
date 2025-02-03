package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPhoto;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.photos.TLPhoto;
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
public class TLRequestPhotosUpdateProfilePhoto extends TLMethod<TLPhoto> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean fallback;

    protected TLAbsInputUser bot;

    protected TLAbsInputPhoto id;

    private final String _constructor = "photos.updateProfilePhoto#0";

    public TLRequestPhotosUpdateProfilePhoto() {
    }

    public TLRequestPhotosUpdateProfilePhoto(boolean fallback, TLAbsInputUser bot, TLAbsInputPhoto id) {
        this.fallback = fallback;
        this.bot = bot;
        this.id = id;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLPhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPhoto)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLPhoto) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = fallback ? (flags | 1) : (flags & ~1);
        flags = bot != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (bot == null) throwNullFieldException("bot", flags);
            writeTLObject(bot, stream);
        }
        writeTLObject(id, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        fallback = (flags & 1) != 0;
        bot = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsInputUser.class, -1) : null;
        id = readTLObject(stream, context, TLAbsInputPhoto.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (bot == null) throwNullFieldException("bot", flags);
            size += bot.computeSerializedSize();
        }
        size += id.computeSerializedSize();
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

    public boolean getFallback() {
        return fallback;
    }

    public void setFallback(boolean fallback) {
        this.fallback = fallback;
    }

    public TLAbsInputUser getBot() {
        return bot;
    }

    public void setBot(TLAbsInputUser bot) {
        this.bot = bot;
    }

    public TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(TLAbsInputPhoto id) {
        this.id = id;
    }
}
