package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.poll.TLPoll;
import com.github.badoualy.telegram.tl.api.poll.TLPollResults;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

public class TLMessageMediaPoll extends TLAbsMessageMedia {

    public static final int CONSTRUCTOR_ID = 0x4bd6e798;

    protected TLPoll poll;
    protected TLPollResults results;

    private final String _constructor = "messageMediaPoll#4bd6e798";

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
