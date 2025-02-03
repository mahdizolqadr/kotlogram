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
public class TLChannelAdminLogEventActionPinTopic extends TLAbsChannelAdminLogEventAction {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLAbsForumTopic prevTopic;

    protected TLAbsForumTopic newTopic;

    private final String _constructor = "channelAdminLogEventActionPinTopic#0";

    public TLChannelAdminLogEventActionPinTopic() {
    }

    public TLChannelAdminLogEventActionPinTopic(TLAbsForumTopic prevTopic, TLAbsForumTopic newTopic) {
        this.prevTopic = prevTopic;
        this.newTopic = newTopic;
    }

    private void computeFlags() {
        flags = 0;
        flags = prevTopic != null ? (flags | 1) : (flags & ~1);
        flags = newTopic != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (prevTopic == null) throwNullFieldException("prevTopic", flags);
            writeTLObject(prevTopic, stream);
        }
        if ((flags & 2) != 0) {
            if (newTopic == null) throwNullFieldException("newTopic", flags);
            writeTLObject(newTopic, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        prevTopic = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsForumTopic.class, -1) : null;
        newTopic = (flags & 2) != 0 ? readTLObject(stream, context, TLAbsForumTopic.class, -1) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (prevTopic == null) throwNullFieldException("prevTopic", flags);
            size += prevTopic.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (newTopic == null) throwNullFieldException("newTopic", flags);
            size += newTopic.computeSerializedSize();
        }
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
