package com.github.badoualy.telegram.tl.api.bots;

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
public class TLBotInfo extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String name;

    protected String about;

    protected String description;

    private final String _constructor = "bots.botInfo#0";

    public TLBotInfo() {
    }

    public TLBotInfo(String name, String about, String description) {
        this.name = name;
        this.about = about;
        this.description = description;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(name, stream);
        writeString(about, stream);
        writeString(description, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        name = readTLString(stream);
        about = readTLString(stream);
        description = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(name);
        size += computeTLStringSerializedSize(about);
        size += computeTLStringSerializedSize(description);
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
