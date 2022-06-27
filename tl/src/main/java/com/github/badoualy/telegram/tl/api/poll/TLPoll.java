package com.github.badoualy.telegram.tl.api.poll;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

public class TLPoll extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x86e18161;

    protected long id;
    protected int flags;
    protected boolean closed;
    protected boolean publicVoters;
    protected boolean multipleChoice;
    protected boolean quiz;
    protected String question;
    protected TLVector<TLPollAnswer> answers;
    protected Integer closePeriod;
    protected Integer closeDate;

    private final String _constructor = "poll#86e18161";

    public TLPoll() {
    }

    public TLPoll(long id, boolean closed, boolean publicVoters, boolean multipleChoice, boolean quiz, String question,
                  TLVector<TLPollAnswer> answers, Integer closePeriod, Integer closeDate) {
        this.id = id;
        this.closed = closed;
        this.publicVoters = publicVoters;
        this.multipleChoice = multipleChoice;
        this.quiz = quiz;
        this.question = question;
        this.answers = answers;
        this.closePeriod = closePeriod;
        this.closeDate = closeDate;
    }

    private void computeFlags() {
        flags = 0;
        flags = closed ? (flags | 1) : (flags & ~1);
        flags = publicVoters ? (flags | 2) : (flags & ~2);
        flags = multipleChoice ? (flags | 4) : (flags & ~4);
        flags = quiz ? (flags | 8) : (flags & ~8);
        flags = closePeriod != null ? (flags | 16) : (flags & ~16);
        flags = closeDate != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();
        writeInt(flags, stream);
        writeString(question, stream);
        writeTLVector(answers, stream);
        if ((flags & 16) != 0) {
            if (closePeriod == null) {
                throwNullFieldException("closePeriod", flags);
            }
            writeInt(closePeriod, stream);
        }
        if ((flags & 32) != 0) {
            if (closeDate == null) {
                throwNullFieldException("closeDate", flags);
            }
            writeInt(closeDate, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        closed = (flags & 1) != 0;
        publicVoters = (flags & 2) != 0;
        multipleChoice = (flags & 4) != 0;
        quiz = (flags & 8) != 0;
        question = readTLString(stream);
        answers = readTLVector(stream, context);
        closePeriod = (flags & 16) != 0 ? readInt(stream) : null;
        closeDate = (flags & 32) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(question);
        size += answers.computeSerializedSize();
        if ((flags & 16) != 0) {
            if (closePeriod == null) {
                throwNullFieldException("closePeriod", flags);
            }
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (closeDate == null) {
                throwNullFieldException("closeDate", flags);
            }
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isPublicVoters() {
        return publicVoters;
    }

    public void setPublicVoters(boolean publicVoters) {
        this.publicVoters = publicVoters;
    }

    public boolean isMultipleChoice() {
        return multipleChoice;
    }

    public void setMultipleChoice(boolean multipleChoice) {
        this.multipleChoice = multipleChoice;
    }

    public boolean isQuiz() {
        return quiz;
    }

    public void setQuiz(boolean quiz) {
        this.quiz = quiz;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public TLVector<TLPollAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(TLVector<TLPollAnswer> answers) {
        this.answers = answers;
    }

    public Integer getClosePeriod() {
        return closePeriod;
    }

    public void setClosePeriod(Integer closePeriod) {
        this.closePeriod = closePeriod;
    }

    public Integer getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Integer closeDate) {
        this.closeDate = closeDate;
    }
}
