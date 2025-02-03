package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
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
public class TLDialogFilterChatlist extends TLAbsDialogFilter {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean hasMyInvites;

    protected int id;

    protected String title;

    protected String emoticon;

    protected Integer color;

    protected TLVector<TLAbsInputPeer> pinnedPeers;

    protected TLVector<TLAbsInputPeer> includePeers;

    private final String _constructor = "dialogFilterChatlist#0";

    public TLDialogFilterChatlist() {
    }

    public TLDialogFilterChatlist(boolean hasMyInvites, int id, String title, String emoticon, Integer color, TLVector<TLAbsInputPeer> pinnedPeers, TLVector<TLAbsInputPeer> includePeers) {
        this.hasMyInvites = hasMyInvites;
        this.id = id;
        this.title = title;
        this.emoticon = emoticon;
        this.color = color;
        this.pinnedPeers = pinnedPeers;
        this.includePeers = includePeers;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasMyInvites ? (flags | 67108864) : (flags & ~67108864);
        flags = emoticon != null ? (flags | 33554432) : (flags & ~33554432);
        flags = color != null ? (flags | 134217728) : (flags & ~134217728);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(title, stream);
        if ((flags & 33554432) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            writeString(emoticon, stream);
        }
        if ((flags & 134217728) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            writeInt(color, stream);
        }
        writeTLVector(pinnedPeers, stream);
        writeTLVector(includePeers, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasMyInvites = (flags & 67108864) != 0;
        id = readInt(stream);
        title = readTLString(stream);
        emoticon = (flags & 33554432) != 0 ? readTLString(stream) : null;
        color = (flags & 134217728) != 0 ? readInt(stream) : null;
        pinnedPeers = readTLVector(stream, context);
        includePeers = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(title);
        if ((flags & 33554432) != 0) {
            if (emoticon == null) throwNullFieldException("emoticon", flags);
            size += computeTLStringSerializedSize(emoticon);
        }
        if ((flags & 134217728) != 0) {
            if (color == null) throwNullFieldException("color", flags);
            size += SIZE_INT32;
        }
        size += pinnedPeers.computeSerializedSize();
        size += includePeers.computeSerializedSize();
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

    public boolean getHasMyInvites() {
        return hasMyInvites;
    }

    public void setHasMyInvites(boolean hasMyInvites) {
        this.hasMyInvites = hasMyInvites;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String emoticon) {
        this.emoticon = emoticon;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

    public TLVector<TLAbsInputPeer> getPinnedPeers() {
        return pinnedPeers;
    }

    public void setPinnedPeers(TLVector<TLAbsInputPeer> pinnedPeers) {
        this.pinnedPeers = pinnedPeers;
    }

    public TLVector<TLAbsInputPeer> getIncludePeers() {
        return includePeers;
    }

    public void setIncludePeers(TLVector<TLAbsInputPeer> includePeers) {
        this.includePeers = includePeers;
    }
}
