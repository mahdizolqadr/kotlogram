package com.github.badoualy.telegram.tl.api.poll;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLPollAnswer extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x6ca9c2e9;

    protected String text;
    protected TLBytes option;

    private final String _constructor = "pollAnswer#6ca9c2e9";

    public TLPollAnswer() {
    }

    public TLPollAnswer(String text, TLBytes option) {
        this.text = text;
        this.option = option;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(text, stream);
        writeTLBytes(option, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
        option = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(text);
        size += computeTLBytesSerializedSize(option);
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TLBytes getOption() {
        return option;
    }

    public void setOption(TLBytes option) {
        this.option = option;
    }
}
