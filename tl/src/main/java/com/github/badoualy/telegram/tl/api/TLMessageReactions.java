package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLMessageReactions extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean min;

    protected boolean canSeeList;

    protected boolean reactionsAsTags;

    protected TLVector<TLReactionCount> results;

    protected TLVector<TLMessagePeerReaction> recentReactions;

    protected TLVector<TLMessageReactor> topReactors;

    private final String _constructor = "messageReactions#0";

    public TLMessageReactions() {
    }

    public TLMessageReactions(boolean min, boolean canSeeList, boolean reactionsAsTags, TLVector<TLReactionCount> results, TLVector<TLMessagePeerReaction> recentReactions, TLVector<TLMessageReactor> topReactors) {
        this.min = min;
        this.canSeeList = canSeeList;
        this.reactionsAsTags = reactionsAsTags;
        this.results = results;
        this.recentReactions = recentReactions;
        this.topReactors = topReactors;
    }

    private void computeFlags() {
        flags = 0;
        flags = min ? (flags | 1) : (flags & ~1);
        flags = canSeeList ? (flags | 4) : (flags & ~4);
        flags = reactionsAsTags ? (flags | 8) : (flags & ~8);
        flags = recentReactions != null ? (flags | 2) : (flags & ~2);
        flags = topReactors != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLVector(results, stream);
        if ((flags & 2) != 0) {
            if (recentReactions == null) throwNullFieldException("recentReactions", flags);
            writeTLVector(recentReactions, stream);
        }
        if ((flags & 16) != 0) {
            if (topReactors == null) throwNullFieldException("topReactors", flags);
            writeTLVector(topReactors, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        min = (flags & 1) != 0;
        canSeeList = (flags & 4) != 0;
        reactionsAsTags = (flags & 8) != 0;
        results = readTLVector(stream, context);
        recentReactions = (flags & 2) != 0 ? readTLVector(stream, context) : null;
        topReactors = (flags & 16) != 0 ? readTLVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += results.computeSerializedSize();
        if ((flags & 2) != 0) {
            if (recentReactions == null) throwNullFieldException("recentReactions", flags);
            size += recentReactions.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (topReactors == null) throwNullFieldException("topReactors", flags);
            size += topReactors.computeSerializedSize();
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

    public boolean getMin() {
        return min;
    }

    public void setMin(boolean min) {
        this.min = min;
    }

    public boolean getCanSeeList() {
        return canSeeList;
    }

    public void setCanSeeList(boolean canSeeList) {
        this.canSeeList = canSeeList;
    }

    public boolean getReactionsAsTags() {
        return reactionsAsTags;
    }

    public void setReactionsAsTags(boolean reactionsAsTags) {
        this.reactionsAsTags = reactionsAsTags;
    }

    public TLVector<TLReactionCount> getResults() {
        return results;
    }

    public void setResults(TLVector<TLReactionCount> results) {
        this.results = results;
    }

    public TLVector<TLMessagePeerReaction> getRecentReactions() {
        return recentReactions;
    }

    public void setRecentReactions(TLVector<TLMessagePeerReaction> recentReactions) {
        this.recentReactions = recentReactions;
    }

    public TLVector<TLMessageReactor> getTopReactors() {
        return topReactors;
    }

    public void setTopReactors(TLVector<TLMessageReactor> topReactors) {
        this.topReactors = topReactors;
    }
}
