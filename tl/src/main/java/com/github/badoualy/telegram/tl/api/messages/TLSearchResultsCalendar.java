package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLSearchResultsCalendarPeriod;
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
public class TLSearchResultsCalendar extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean inexact;

    protected int count;

    protected int minDate;

    protected int minMsgId;

    protected Integer offsetIdOffset;

    protected TLVector<TLSearchResultsCalendarPeriod> periods;

    protected TLVector<TLAbsMessage> messages;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "messages.searchResultsCalendar#0";

    public TLSearchResultsCalendar() {
    }

    public TLSearchResultsCalendar(boolean inexact, int count, int minDate, int minMsgId, Integer offsetIdOffset, TLVector<TLSearchResultsCalendarPeriod> periods, TLVector<TLAbsMessage> messages, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this.inexact = inexact;
        this.count = count;
        this.minDate = minDate;
        this.minMsgId = minMsgId;
        this.offsetIdOffset = offsetIdOffset;
        this.periods = periods;
        this.messages = messages;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = inexact ? (flags | 1) : (flags & ~1);
        flags = offsetIdOffset != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(count, stream);
        writeInt(minDate, stream);
        writeInt(minMsgId, stream);
        if ((flags & 2) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            writeInt(offsetIdOffset, stream);
        }
        writeTLVector(periods, stream);
        writeTLVector(messages, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        inexact = (flags & 1) != 0;
        count = readInt(stream);
        minDate = readInt(stream);
        minMsgId = readInt(stream);
        offsetIdOffset = (flags & 2) != 0 ? readInt(stream) : null;
        periods = readTLVector(stream, context);
        messages = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (offsetIdOffset == null) throwNullFieldException("offsetIdOffset", flags);
            size += SIZE_INT32;
        }
        size += periods.computeSerializedSize();
        size += messages.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
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

    public boolean getInexact() {
        return inexact;
    }

    public void setInexact(boolean inexact) {
        this.inexact = inexact;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int minDate) {
        this.minDate = minDate;
    }

    public int getMinMsgId() {
        return minMsgId;
    }

    public void setMinMsgId(int minMsgId) {
        this.minMsgId = minMsgId;
    }

    public Integer getOffsetIdOffset() {
        return offsetIdOffset;
    }

    public void setOffsetIdOffset(Integer offsetIdOffset) {
        this.offsetIdOffset = offsetIdOffset;
    }

    public TLVector<TLSearchResultsCalendarPeriod> getPeriods() {
        return periods;
    }

    public void setPeriods(TLVector<TLSearchResultsCalendarPeriod> periods) {
        this.periods = periods;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
