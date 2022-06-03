package com.github.badoualy.telegram.tl.api.poll;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

public class TLPollAnswerVoters extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x6ca9c2e9;

    protected int flags;
    protected boolean chosen;
    protected boolean correct;
    protected TLBytes option;
    protected int voters;

    private final String _constructor = "pollAnswer#6ca9c2e9";

    public TLPollAnswerVoters() {
    }

    public TLPollAnswerVoters(boolean chosen, boolean correct, TLBytes option, int voters) {
        this.chosen = chosen;
        this.correct = correct;
        this.option = option;
        this.voters = voters;
    }

    private void computeFlags() {
        flags = 0;
        flags = chosen ? (flags | 1) : (flags & ~1);
        flags = correct ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeTLBytes(option, stream);
        writeInt(voters, stream);
    }

    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chosen = (flags & 1) != 0;
        correct = (flags & 2) != 0;
        option = readTLBytes(stream, context);
        voters = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(option);
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

    public boolean isChosen() {
        return chosen;
    }

    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public TLBytes getOption() {
        return option;
    }

    public void setOption(TLBytes option) {
        this.option = option;
    }

    public int getVoters() {
        return voters;
    }

    public void setVoters(int voters) {
        this.voters = voters;
    }
}
