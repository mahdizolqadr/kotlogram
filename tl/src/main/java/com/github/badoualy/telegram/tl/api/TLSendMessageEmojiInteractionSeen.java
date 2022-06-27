package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLSendMessageEmojiInteractionSeen extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0xb665902e;

    protected String emoticon;

    private final String _constructor = "sendMessageEmojiInteractionSeen#b665902e";

    public TLSendMessageEmojiInteractionSeen() {
    }

    public TLSendMessageEmojiInteractionSeen(String emoticon) {
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
