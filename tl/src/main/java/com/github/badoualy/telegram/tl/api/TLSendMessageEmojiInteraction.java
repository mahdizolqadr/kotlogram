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
public class TLSendMessageEmojiInteraction extends TLAbsSendMessageAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected String emoticon;

    protected int msgId;

    protected TLDataJSON interaction;

    private final String _constructor = "sendMessageEmojiInteraction#0";

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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
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
