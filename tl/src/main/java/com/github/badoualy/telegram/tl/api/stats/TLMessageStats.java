package com.github.badoualy.telegram.tl.api.stats;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsStatsGraph;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLMessageStats extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsStatsGraph viewsGraph;

    protected TLAbsStatsGraph reactionsByEmotionGraph;

    private final String _constructor = "stats.messageStats#0";

    public TLMessageStats() {
    }

    public TLMessageStats(TLAbsStatsGraph viewsGraph, TLAbsStatsGraph reactionsByEmotionGraph) {
        this.viewsGraph = viewsGraph;
        this.reactionsByEmotionGraph = reactionsByEmotionGraph;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(viewsGraph, stream);
        writeTLObject(reactionsByEmotionGraph, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        viewsGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
        reactionsByEmotionGraph = readTLObject(stream, context, TLAbsStatsGraph.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += viewsGraph.computeSerializedSize();
        size += reactionsByEmotionGraph.computeSerializedSize();
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

    public TLAbsStatsGraph getViewsGraph() {
        return viewsGraph;
    }

    public void setViewsGraph(TLAbsStatsGraph viewsGraph) {
        this.viewsGraph = viewsGraph;
    }

    public TLAbsStatsGraph getReactionsByEmotionGraph() {
        return reactionsByEmotionGraph;
    }

    public void setReactionsByEmotionGraph(TLAbsStatsGraph reactionsByEmotionGraph) {
        this.reactionsByEmotionGraph = reactionsByEmotionGraph;
    }
}
