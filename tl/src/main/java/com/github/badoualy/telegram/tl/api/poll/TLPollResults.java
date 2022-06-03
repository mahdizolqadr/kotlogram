package com.github.badoualy.telegram.tl.api.poll;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsMessageEntity;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLPollResults extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xdcb82ea3;

    protected int flags;
    protected boolean min;
    protected TLVector<TLPollAnswerVoters> results;
    protected Integer totalVoters;
    protected TLLongVector recentVoters;
    protected String solution;
    protected TLVector<TLAbsMessageEntity> solutionEntities;

    private final String _constructor = "pollResults#dcb82ea3";

    public TLPollResults() {
    }

    public TLPollResults(boolean min, TLVector<TLPollAnswerVoters> results, Integer totalVoters,
                         TLLongVector recentVoters, String solution, TLVector<TLAbsMessageEntity> solutionEntities) {
        this.min = min;
        this.results = results;
        this.totalVoters = totalVoters;
        this.recentVoters = recentVoters;
        this.solution = solution;
        this.solutionEntities = solutionEntities;
    }

    private void computeFlags() {
        flags = 0;
        flags = min ? (flags | 1) : (flags & ~1);
        flags = results != null ? (flags | 2) : (flags & ~2);
        flags = totalVoters != null ? (flags | 4) : (flags & ~4);
        flags = recentVoters != null ? (flags | 8) : (flags & ~8);
        flags = solution != null ? (flags | 16) : (flags & ~16);
        flags = solutionEntities != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (results == null) {
                throwNullFieldException("results", flags);
            }
            writeTLVector(results, stream);
        }
        if ((flags & 4) != 0) {
            if (totalVoters == null) {
                throwNullFieldException("totalVoters", flags);
            }
            writeInt(totalVoters, stream);
        }
        if ((flags & 8) != 0) {
            if (recentVoters == null) {
                throwNullFieldException("recentVoters", flags);
            }
            writeTLVector(recentVoters, stream);
        }
        if ((flags & 16) != 0) {
            if (solution == null) {
                throwNullFieldException("solution", flags);
            }
            writeString(solution, stream);
            if (solutionEntities == null) {
                throwNullFieldException("solutionEntities", flags);
            }
            writeTLVector(solutionEntities, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        min = (flags & 1) != 0;
        results = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        totalVoters = (flags & 4) != 0 ? readInt(stream) : null;
        recentVoters = (flags & 8) != 0 ? readTLLongVector(stream, context) : null;
        solution = (flags & 16) != 0 ? readTLString(stream) : null;
        solutionEntities = (flags & 16) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (results == null) {
                throwNullFieldException("results", flags);
            }
            size += results.computeSerializedSize();
        }
        if ((flags & 4) != 0) {
            if (totalVoters == null) {
                throwNullFieldException("totalVoters", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (recentVoters == null) {
                throwNullFieldException("recentVoters", flags);
            }
            size += recentVoters.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (solution == null) {
                throwNullFieldException("solution", flags);
            }
            size += computeTLStringSerializedSize(solution);
            if (solutionEntities == null) {
                throwNullFieldException("solutionEntities", flags);
            }
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

    public boolean isMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public TLVector<TLPollAnswerVoters> getResults() {
        return results;
    }

    public void setResults(TLVector<TLPollAnswerVoters> results) {
        this.results = results;
    }

    public Integer getTotalVoters() {
        return totalVoters;
    }

    public void setTotalVoters(Integer totalVoters) {
        this.totalVoters = totalVoters;
    }

    public TLLongVector getRecentVoters() {
        return recentVoters;
    }

    public void setRecentVoters(TLLongVector recentVoters) {
        this.recentVoters = recentVoters;
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
