package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLUpdateMessagePollVote extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long pollId;

    protected TLAbsPeer peer;

    protected TLVector<TLBytes> options;

    protected int qts;

    private final String _constructor = "updateMessagePollVote#0";

    public TLUpdateMessagePollVote() {
    }

    public TLUpdateMessagePollVote(long pollId, TLAbsPeer peer, TLVector<TLBytes> options, int qts) {
        this.pollId = pollId;
        this.peer = peer;
        this.options = options;
        this.qts = qts;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(pollId, stream);
        writeTLObject(peer, stream);
        writeTLVector(options, stream);
        writeInt(qts, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        pollId = readLong(stream);
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        options = readTLVector(stream, context);
        qts = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += peer.computeSerializedSize();
        size += options.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public TLVector<TLBytes> getOptions() {
        return options;
    }

    public void setOptions(TLVector<TLBytes> options) {
        this.options = options;
    }

    public int getQts() {
        return qts;
    }

    public void setQts(int qts) {
        this.qts = qts;
    }
}
