package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLTranscribedAudio extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean pending;

    protected long transcriptionId;

    protected String text;

    protected Integer trialRemainsNum;

    protected Integer trialRemainsUntilDate;

    private final String _constructor = "messages.transcribedAudio#0";

    public TLTranscribedAudio() {
    }

    public TLTranscribedAudio(boolean pending, long transcriptionId, String text, Integer trialRemainsNum, Integer trialRemainsUntilDate) {
        this.pending = pending;
        this.transcriptionId = transcriptionId;
        this.text = text;
        this.trialRemainsNum = trialRemainsNum;
        this.trialRemainsUntilDate = trialRemainsUntilDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = pending ? (flags | 1) : (flags & ~1);
        flags = trialRemainsNum != null ? (flags | 2) : (flags & ~2);
        flags = trialRemainsUntilDate != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(transcriptionId, stream);
        writeString(text, stream);
        if ((flags & 2) != 0) {
            if (trialRemainsNum == null) throwNullFieldException("trialRemainsNum", flags);
            writeInt(trialRemainsNum, stream);
        }
        if ((flags & 2) != 0) {
            if (trialRemainsUntilDate == null) throwNullFieldException("trialRemainsUntilDate", flags);
            writeInt(trialRemainsUntilDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pending = (flags & 1) != 0;
        transcriptionId = readLong(stream);
        text = readTLString(stream);
        trialRemainsNum = (flags & 2) != 0 ? readInt(stream) : null;
        trialRemainsUntilDate = (flags & 2) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(text);
        if ((flags & 2) != 0) {
            if (trialRemainsNum == null) throwNullFieldException("trialRemainsNum", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (trialRemainsUntilDate == null) throwNullFieldException("trialRemainsUntilDate", flags);
            size += SIZE_INT32;
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

    public boolean getPending() {
        return pending;
    }

    public void setPending(boolean pending) {
        this.pending = pending;
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

    public Integer getTrialRemainsNum() {
        return trialRemainsNum;
    }

    public void setTrialRemainsNum(Integer trialRemainsNum) {
        this.trialRemainsNum = trialRemainsNum;
    }

    public Integer getTrialRemainsUntilDate() {
        return trialRemainsUntilDate;
    }

    public void setTrialRemainsUntilDate(Integer trialRemainsUntilDate) {
        this.trialRemainsUntilDate = trialRemainsUntilDate;
    }
}
