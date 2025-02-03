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
public class TLChannelAdminLogEventActionCreateTopic extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsForumTopic topic;

    private final String _constructor = "channelAdminLogEventActionCreateTopic#0";

    public TLChannelAdminLogEventActionCreateTopic() {
    }

    public TLChannelAdminLogEventActionCreateTopic(TLAbsForumTopic topic) {
        this.topic = topic;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(topic, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        topic = readTLObject(stream, context, TLAbsForumTopic.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += topic.computeSerializedSize();
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

    public TLAbsForumTopic getTopic() {
        return topic;
    }

    public void setTopic(TLAbsForumTopic topic) {
        this.topic = topic;
    }
}
