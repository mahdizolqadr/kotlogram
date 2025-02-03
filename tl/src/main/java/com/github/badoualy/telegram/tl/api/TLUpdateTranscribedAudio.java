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
public class TLUpdateTranscribedAudio extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean pending;

    protected TLAbsPeer peer;

    protected int msgId;

    protected long transcriptionId;

    protected String text;

    private final String _constructor = "updateTranscribedAudio#0";

    public TLUpdateTranscribedAudio() {
    }

    public TLUpdateTranscribedAudio(boolean pending, TLAbsPeer peer, int msgId, long transcriptionId, String text) {
        this.pending = pending;
        this.peer = peer;
        this.msgId = msgId;
        this.transcriptionId = transcriptionId;
        this.text = text;
    }

    private void computeFlags() {
        flags = 0;
        flags = pending ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        writeInt(msgId, stream);
        writeLong(transcriptionId, stream);
        writeString(text, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pending = (flags & 1) != 0;
        peer = readTLObject(stream, context, TLAbsPeer.class, -1);
        msgId = readInt(stream);
        transcriptionId = readLong(stream);
        text = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(text);
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

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
    }

    public TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsPeer peer) {
        this.peer = peer;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public long getTranscriptionId() {
        return transcriptionId;
    }

    public void setTranscriptionId(long transcriptionId) {
        this.transcriptionId = transcriptionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
