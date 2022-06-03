package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLMessageMediaDice extends TLAbsMessageMedia {

    public static final int CONSTRUCTOR_ID = 0x3f7ee58b;

    protected int value;
    protected String emoticon;

    private final String _constructor = "messageMediaDice#3f7ee58b";

    public TLMessageMediaDice() {
    }

    public TLMessageMediaDice(int value, String emoticon) {
        this.value = value;
        this.emoticon = emoticon;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(value, stream);
        writeString(emoticon, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        value = readInt(stream);
        emoticon = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(emoticon);
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }
}
