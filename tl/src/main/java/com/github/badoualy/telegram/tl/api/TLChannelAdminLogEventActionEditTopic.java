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
public class TLChannelAdminLogEventActionEditTopic extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsForumTopic prevTopic;

    protected TLAbsForumTopic newTopic;

    private final String _constructor = "channelAdminLogEventActionEditTopic#0";

    public TLChannelAdminLogEventActionEditTopic() {
    }

    public TLChannelAdminLogEventActionEditTopic(TLAbsForumTopic prevTopic, TLAbsForumTopic newTopic) {
        this.prevTopic = prevTopic;
        this.newTopic = newTopic;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(prevTopic, stream);
        writeTLObject(newTopic, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        prevTopic = readTLObject(stream, context, TLAbsForumTopic.class, -1);
        newTopic = readTLObject(stream, context, TLAbsForumTopic.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += prevTopic.computeSerializedSize();
        size += newTopic.computeSerializedSize();
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

    public TLAbsForumTopic getPrevTopic() {
        return prevTopic;
    }

    public void setPrevTopic(TLAbsForumTopic prevTopic) {
        this.prevTopic = prevTopic;
    }

    public TLAbsForumTopic getNewTopic() {
        return newTopic;
    }

    public void setNewTopic(TLAbsForumTopic newTopic) {
        this.newTopic = newTopic;
    }
}
