package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLMessageActionSetChatTheme extends TLAbsMessageAction {

    public static final int CONSTRUCTOR_ID = 0xaa786345;

    protected String emoticon;

    private final String _constructor = "messageActionSetChatTheme#aa786345";

    public TLMessageActionSetChatTheme() {
    }

    public TLMessageActionSetChatTheme(String emoticon) {
        this.emoticon = emoticon;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(emoticon, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emoticon = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
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

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }
}
