package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotCommandScope;
import com.github.badoualy.telegram.tl.api.TLBotCommand;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestBotsGetBotCommands extends TLMethod<TLVector<TLBotCommand>> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsBotCommandScope scope;

    protected String langCode;

    private final String _constructor = "bots.getBotCommands#0";

    public TLRequestBotsGetBotCommands() {
    }

    public TLRequestBotsGetBotCommands(TLAbsBotCommandScope scope, String langCode) {
        this.scope = scope;
        this.langCode = langCode;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLVector<TLBotCommand> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        return readTLVector(stream, context);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(scope, stream);
        writeString(langCode, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        scope = readTLObject(stream, context, TLAbsBotCommandScope.class, -1);
        langCode = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += scope.computeSerializedSize();
        size += computeTLStringSerializedSize(langCode);
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

    public TLAbsBotCommandScope getScope() {
        return scope;
    }

    public void setScope(TLAbsBotCommandScope scope) {
        this.scope = scope;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
