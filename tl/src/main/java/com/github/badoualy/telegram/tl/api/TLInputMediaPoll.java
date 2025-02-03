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
public class TLInputMediaPoll extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected TLPoll poll;

    protected TLVector<TLBytes> correctAnswers;

    protected String solution;

    protected TLVector<TLAbsMessageEntity> solutionEntities;

    private final String _constructor = "inputMediaPoll#0";

    public TLInputMediaPoll() {
    }

    public TLInputMediaPoll(TLPoll poll, TLVector<TLBytes> correctAnswers, String solution, TLVector<TLAbsMessageEntity> solutionEntities) {
        this.poll = poll;
        this.correctAnswers = correctAnswers;
        this.solution = solution;
        this.solutionEntities = solutionEntities;
    }

    private void computeFlags() {
        flags = 0;
        flags = correctAnswers != null ? (flags | 1) : (flags & ~1);
        flags = solution != null ? (flags | 2) : (flags & ~2);
        flags = solutionEntities != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(poll, stream);
        if ((flags & 1) != 0) {
            if (correctAnswers == null) throwNullFieldException("correctAnswers", flags);
            writeTLVector(correctAnswers, stream);
        }
        if ((flags & 2) != 0) {
            if (solution == null) throwNullFieldException("solution", flags);
            writeString(solution, stream);
        }
        if ((flags & 2) != 0) {
            if (solutionEntities == null) throwNullFieldException("solutionEntities", flags);
            writeTLVector(solutionEntities, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        poll = readTLObject(stream, context, TLPoll.class, TLPoll.CONSTRUCTOR_ID);
        correctAnswers = (flags & 1) != 0 ? readTLVector(stream, context) : null;
        solution = (flags & 2) != 0 ? readTLString(stream) : null;
        solutionEntities = (flags & 2) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += poll.computeSerializedSize();
        if ((flags & 1) != 0) {
            if (correctAnswers == null) throwNullFieldException("correctAnswers", flags);
            size += correctAnswers.computeSerializedSize();
        }
        if ((flags & 2) != 0) {
            if (solution == null) throwNullFieldException("solution", flags);
            size += computeTLStringSerializedSize(solution);
        }
        if ((flags & 2) != 0) {
            if (solutionEntities == null) throwNullFieldException("solutionEntities", flags);
            size += solutionEntities.computeSerializedSize();
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

    public TLPoll getPoll() {
        return poll;
    }

    public void setPoll(TLPoll poll) {
        this.poll = poll;
    }

    public TLVector<TLBytes> getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(TLVector<TLBytes> correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public TLVector<TLAbsMessageEntity> getSolutionEntities() {
        return solutionEntities;
    }

    public void setSolutionEntities(TLVector<TLAbsMessageEntity> solutionEntities) {
        this.solutionEntities = solutionEntities;
    }
}
