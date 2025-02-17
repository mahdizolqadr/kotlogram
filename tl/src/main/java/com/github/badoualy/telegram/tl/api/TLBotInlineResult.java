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
public class TLBotInlineResult extends TLAbsBotInlineResult {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String title;

    protected String description;

    protected String url;

    protected TLAbsWebDocument thumb;

    protected TLAbsWebDocument content;

    private final String _constructor = "botInlineResult#0";

    public TLBotInlineResult() {
    }

    public TLBotInlineResult(String id, String type, String title, String description, String url, TLAbsWebDocument thumb, TLAbsWebDocument content, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumb = thumb;
        this.content = content;
        this.sendMessage = sendMessage;
    }

    private void computeFlags() {
        flags = 0;
        flags = title != null ? (flags | 2) : (flags & ~2);
        flags = description != null ? (flags | 4) : (flags & ~4);
        flags = url != null ? (flags | 8) : (flags & ~8);
        flags = thumb != null ? (flags | 16) : (flags & ~16);
        flags = content != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        writeString(type, stream);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 4) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 16) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            writeTLObject(thumb, stream);
        }
        if ((flags & 32) != 0) {
            if (content == null) throwNullFieldException("content", flags);
            writeTLObject(content, stream);
        }
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readTLString(stream);
        type = readTLString(stream);
        title = (flags & 2) != 0 ? readTLString(stream) : null;
        description = (flags & 4) != 0 ? readTLString(stream) : null;
        url = (flags & 8) != 0 ? readTLString(stream) : null;
        thumb = (flags & 16) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        content = (flags & 32) != 0 ? readTLObject(stream, context, TLAbsWebDocument.class, -1) : null;
        sendMessage = readTLObject(stream, context, TLAbsBotInlineMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(type);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 4) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 16) != 0) {
            if (thumb == null) throwNullFieldException("thumb", flags);
            size += thumb.computeSerializedSize();
        }
        if ((flags & 32) != 0) {
            if (content == null) throwNullFieldException("content", flags);
            size += content.computeSerializedSize();
        }
        size += sendMessage.computeSerializedSize();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsWebDocument getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsWebDocument thumb) {
        this.thumb = thumb;
    }

    public TLAbsWebDocument getContent() {
        return content;
    }

    public void setContent(TLAbsWebDocument content) {
        this.content = content;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
