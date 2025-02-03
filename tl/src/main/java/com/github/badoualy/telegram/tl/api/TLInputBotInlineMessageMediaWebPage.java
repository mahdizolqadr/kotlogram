package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLInputBotInlineMessageMediaWebPage extends TLAbsInputBotInlineMessage {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected boolean invertMedia;

    protected boolean forceLargeMedia;

    protected boolean forceSmallMedia;

    protected boolean optional;

    protected String message;

    protected TLVector<TLAbsMessageEntity> entities;

    protected String url;

    private final String _constructor = "inputBotInlineMessageMediaWebPage#0";

    public TLInputBotInlineMessageMediaWebPage() {
    }

    public TLInputBotInlineMessageMediaWebPage(boolean invertMedia, boolean forceLargeMedia, boolean forceSmallMedia, boolean optional, String message, TLVector<TLAbsMessageEntity> entities, String url, TLAbsReplyMarkup replyMarkup) {
        this.invertMedia = invertMedia;
        this.forceLargeMedia = forceLargeMedia;
        this.forceSmallMedia = forceSmallMedia;
        this.optional = optional;
        this.message = message;
        this.entities = entities;
        this.url = url;
        this.replyMarkup = replyMarkup;
    }

    private void computeFlags() {
        flags = 0;
        flags = invertMedia ? (flags | 8) : (flags & ~8);
        flags = forceLargeMedia ? (flags | 16) : (flags & ~16);
        flags = forceSmallMedia ? (flags | 32) : (flags & ~32);
        flags = optional ? (flags | 64) : (flags & ~64);
        flags = entities != null ? (flags | 2) : (flags & ~2);
        flags = replyMarkup != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(message, stream);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            writeTLVector(entities, stream);
        }
        writeString(url, stream);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            writeTLObject(replyMarkup, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        invertMedia = (flags & 8) != 0;
        forceLargeMedia = (flags & 16) != 0;
        forceSmallMedia = (flags & 32) != 0;
        optional = (flags & 64) != 0;
        message = readTLString(stream);
        entities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        url = readTLString(stream);
        replyMarkup = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsReplyMarkup.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(message);
        if ((flags & 2) != 0) {
            if (entities == null) throwNullFieldException("entities", flags);
            size += entities.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(url);
        if ((flags & 4) != 0) {
            if (replyMarkup == null) throwNullFieldException("replyMarkup", flags);
            size += replyMarkup.computeSerializedSize();
        }
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

    public boolean getInvertMedia() {
        return invertMedia;
    }

    public void setInvertMedia(boolean invertMedia) {
        this.invertMedia = invertMedia;
    }

    public boolean getForceLargeMedia() {
        return forceLargeMedia;
    }

    public void setForceLargeMedia(boolean forceLargeMedia) {
        this.forceLargeMedia = forceLargeMedia;
    }

    public boolean getForceSmallMedia() {
        return forceSmallMedia;
    }

    public void setForceSmallMedia(boolean forceSmallMedia) {
        this.forceSmallMedia = forceSmallMedia;
    }

    public boolean getOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TLVector<TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(TLVector<TLAbsMessageEntity> entities) {
        this.entities = entities;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(TLAbsReplyMarkup replyMarkup) {
        this.replyMarkup = replyMarkup;
    }
}
