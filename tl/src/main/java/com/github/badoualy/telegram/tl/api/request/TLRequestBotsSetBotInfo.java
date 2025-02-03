package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.core.TLBool;
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
public class TLRequestBotsSetBotInfo extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsInputUser bot;

    protected String langCode;

    protected String name;

    protected String about;

    protected String description;

    private final String _constructor = "bots.setBotInfo#0";

    public TLRequestBotsSetBotInfo() {
    }

    public TLRequestBotsSetBotInfo(TLAbsInputUser bot, String langCode, String name, String about, String description) {
        this.bot = bot;
        this.langCode = langCode;
        this.name = name;
        this.about = about;
        this.description = description;
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

    private void computeFlags() {
        flags = 0;
        flags = bot != null ? (flags | 4) : (flags & ~4);
        flags = name != null ? (flags | 8) : (flags & ~8);
        flags = about != null ? (flags | 1) : (flags & ~1);
        flags = description != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 4) != 0) {
            if (bot == null) throwNullFieldException("bot", flags);
            writeTLObject(bot, stream);
        }
        writeString(langCode, stream);
        if ((flags & 8) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            writeString(name, stream);
        }
        if ((flags & 1) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            writeString(about, stream);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        bot = (flags & 4) != 0 ? readTLObject(stream, context, TLAbsInputUser.class, -1) : null;
        langCode = readTLString(stream);
        name = (flags & 8) != 0 ? readTLString(stream) : null;
        about = (flags & 1) != 0 ? readTLString(stream) : null;
        description = (flags & 2) != 0 ? readTLString(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (bot == null) throwNullFieldException("bot", flags);
            size += bot.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(langCode);
        if ((flags & 8) != 0) {
            if (name == null) throwNullFieldException("name", flags);
            size += computeTLStringSerializedSize(name);
        }
        if ((flags & 1) != 0) {
            if (about == null) throwNullFieldException("about", flags);
            size += computeTLStringSerializedSize(about);
        }
        if ((flags & 2) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
