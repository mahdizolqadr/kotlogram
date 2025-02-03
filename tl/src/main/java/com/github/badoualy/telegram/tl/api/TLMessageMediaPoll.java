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
public class TLMessageMediaPoll extends TLAbsMessageMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLPoll poll;

    protected TLPollResults results;

    private final String _constructor = "messageMediaPoll#0";

    public TLMessageMediaPoll() {
    }

    public TLMessageMediaPoll(TLPoll poll, TLPollResults results) {
        this.poll = poll;
        this.results = results;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(poll, stream);
        writeTLObject(results, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        poll = readTLObject(stream, context, TLPoll.class, TLPoll.CONSTRUCTOR_ID);
        results = readTLObject(stream, context, TLPollResults.class, TLPollResults.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += poll.computeSerializedSize();
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
