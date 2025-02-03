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
public class TLUpdateEncryptedMessagesRead extends TLAbsUpdate {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int chatId;

    protected int maxDate;

    protected int date;

    private final String _constructor = "updateEncryptedMessagesRead#0";

    public TLUpdateEncryptedMessagesRead() {
    }

    public TLUpdateEncryptedMessagesRead(int chatId, int maxDate, int date) {
        this.chatId = chatId;
        this.maxDate = maxDate;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeInt(maxDate, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        maxDate = readInt(stream);
        date = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int maxDate) {
        this.maxDate = maxDate;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
