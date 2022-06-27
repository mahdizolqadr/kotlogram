package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLMessageActionBotAllowed extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0xabe9affe;

    protected String domain;

    private final String _constructor = "messageActionBotAllowed#abe9affe";

    public TLMessageActionBotAllowed() {
    }

    public TLMessageActionBotAllowed(String domain) {
        this.domain = domain;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(domain, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        domain = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(domain);
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

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
