package com.github.badoualy.telegram.tl.api.account;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEmojiStatus;
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
public class TLEmojiStatuses extends TLAbsEmojiStatuses {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long hash;

    protected TLVector<TLAbsEmojiStatus> statuses;

    private final String _constructor = "account.emojiStatuses#0";

    public TLEmojiStatuses() {
    }

    public TLEmojiStatuses(long hash, TLVector<TLAbsEmojiStatus> statuses) {
        this.hash = hash;
        this.statuses = statuses;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(hash, stream);
        writeTLVector(statuses, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readLong(stream);
        statuses = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += statuses.computeSerializedSize();
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

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public TLVector<TLAbsEmojiStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(TLVector<TLAbsEmojiStatus> statuses) {
        this.statuses = statuses;
    }
}
