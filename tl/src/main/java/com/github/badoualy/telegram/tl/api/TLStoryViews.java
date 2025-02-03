package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLStoryViews extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hasViewers;

    protected int viewsCount;

    protected Integer forwardsCount;

    protected TLVector<TLReactionCount> reactions;

    protected Integer reactionsCount;

    protected TLLongVector recentViewers;

    private final String _constructor = "storyViews#0";

    public TLStoryViews() {
    }

    public TLStoryViews(boolean hasViewers, int viewsCount, Integer forwardsCount, TLVector<TLReactionCount> reactions, Integer reactionsCount, TLLongVector recentViewers) {
        this.hasViewers = hasViewers;
        this.viewsCount = viewsCount;
        this.forwardsCount = forwardsCount;
        this.reactions = reactions;
        this.reactionsCount = reactionsCount;
        this.recentViewers = recentViewers;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasViewers ? (flags | 2) : (flags & ~2);
        flags = forwardsCount != null ? (flags | 4) : (flags & ~4);
        flags = reactions != null ? (flags | 8) : (flags & ~8);
        flags = reactionsCount != null ? (flags | 16) : (flags & ~16);
        flags = recentViewers != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(viewsCount, stream);
        if ((flags & 4) != 0) {
            if (forwardsCount == null) throwNullFieldException("forwardsCount", flags);
            writeInt(forwardsCount, stream);
        }
        if ((flags & 8) != 0) {
            if (reactions == null) throwNullFieldException("reactions", flags);
            writeTLVector(reactions, stream);
        }
        if ((flags & 16) != 0) {
            if (reactionsCount == null) throwNullFieldException("reactionsCount", flags);
            writeInt(reactionsCount, stream);
        }
        if ((flags & 1) != 0) {
            if (recentViewers == null) throwNullFieldException("recentViewers", flags);
            writeTLVector(recentViewers, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasViewers = (flags & 2) != 0;
        viewsCount = readInt(stream);
        forwardsCount = (flags & 4) != 0 ? readInt(stream) : null;
        reactions = (flags & 8) != 0 ? readTLVector(stream, context) : null;
        reactionsCount = (flags & 16) != 0 ? readInt(stream) : null;
        recentViewers = (flags & 1) != 0 ? readTLLongVector(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (forwardsCount == null) throwNullFieldException("forwardsCount", flags);
            size += SIZE_INT32;
        }
        if ((flags & 8) != 0) {
            if (reactions == null) throwNullFieldException("reactions", flags);
            size += reactions.computeSerializedSize();
        }
        if ((flags & 16) != 0) {
            if (reactionsCount == null) throwNullFieldException("reactionsCount", flags);
            size += SIZE_INT32;
        }
        if ((flags & 1) != 0) {
            if (recentViewers == null) throwNullFieldException("recentViewers", flags);
            size += recentViewers.computeSerializedSize();
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

    public boolean getHasViewers() {
        return hasViewers;
    }

    public void setHasViewers(boolean hasViewers) {
        this.hasViewers = hasViewers;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Integer getForwardsCount() {
        return forwardsCount;
    }

    public void setForwardsCount(Integer forwardsCount) {
        this.forwardsCount = forwardsCount;
    }

    public TLVector<TLReactionCount> getReactions() {
        return reactions;
    }

    public void setReactions(TLVector<TLReactionCount> reactions) {
        this.reactions = reactions;
    }

    public Integer getReactionsCount() {
        return reactionsCount;
    }

    public void setReactionsCount(Integer reactionsCount) {
        this.reactionsCount = reactionsCount;
    }

    public TLLongVector getRecentViewers() {
        return recentViewers;
    }

    public void setRecentViewers(TLLongVector recentViewers) {
        this.recentViewers = recentViewers;
    }
}
