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
public class TLUpdateMessagePoll extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected long pollId;

    protected TLPoll poll;

    protected TLPollResults results;

    private final String _constructor = "updateMessagePoll#0";

    public TLUpdateMessagePoll() {
    }

    public TLUpdateMessagePoll(long pollId, TLPoll poll, TLPollResults results) {
        this.pollId = pollId;
        this.poll = poll;
        this.results = results;
    }

    private void computeFlags() {
        flags = 0;
        flags = poll != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(pollId, stream);
        if ((flags & 1) != 0) {
            if (poll == null) throwNullFieldException("poll", flags);
            writeTLObject(poll, stream);
        }
        writeTLObject(results, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pollId = readLong(stream);
        poll = (flags & 1) != 0 ? readTLObject(stream, context, TLPoll.class, TLPoll.CONSTRUCTOR_ID) : null;
        results = readTLObject(stream, context, TLPollResults.class, TLPollResults.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 1) != 0) {
            if (poll == null) throwNullFieldException("poll", flags);
            size += poll.computeSerializedSize();
        }
        size += results.computeSerializedSize();
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

    public long getPollId() {
        return pollId;
    }

    public void setPollId(long pollId) {
        this.pollId = pollId;
    }

    public TLPoll getPoll() {
        return poll;
    }

    public void setPoll(TLPoll poll) {
        this.poll = poll;
    }

    public TLPollResults getResults() {
        return results;
    }

    public void setResults(TLPollResults results) {
        this.results = results;
    }
}
