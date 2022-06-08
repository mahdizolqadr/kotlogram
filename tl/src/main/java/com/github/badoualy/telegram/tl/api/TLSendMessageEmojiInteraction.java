package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLSendMessageEmojiInteraction extends TLAbsSendMessageAction {

    public static final int CONSTRUCTOR_ID = 0x25972bcb;

    protected String emoticon;
    protected int msgId;
    protected TLDataJSON interaction;

    private final String _constructor = "sendMessageEmojiInteraction#25972bcb";

    public TLSendMessageEmojiInteraction() {
    }

    public TLSendMessageEmojiInteraction(String emoticon, int msgId, TLDataJSON interaction) {
        this.emoticon = emoticon;
        this.msgId = msgId;
        this.interaction = interaction;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(emoticon, stream);
        writeInt(msgId, stream);
        writeTLObject(interaction, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emoticon = readTLString(stream);
        msgId = readInt(stream);
        interaction = readTLObject(stream, context, TLDataJSON.class, TLDataJSON.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(emoticon);
        size += SIZE_INT32;
        size += interaction.computeSerializedSize();
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

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public TLDataJSON getInteraction() {
        return interaction;
    }

    public void setInteraction(TLDataJSON interaction) {
        this.interaction = interaction;
    }
}
