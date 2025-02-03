package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsEmojiStatus;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
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
public class TLRequestBotsUpdateUserEmojiStatus extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsInputUser userId;

    protected TLAbsEmojiStatus emojiStatus;

    private final String _constructor = "bots.updateUserEmojiStatus#0";

    public TLRequestBotsUpdateUserEmojiStatus() {
    }

    public TLRequestBotsUpdateUserEmojiStatus(TLAbsInputUser userId, TLAbsEmojiStatus emojiStatus) {
        this.userId = userId;
        this.emojiStatus = emojiStatus;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(userId, stream);
        writeTLObject(emojiStatus, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = readTLObject(stream, context, TLAbsInputUser.class, -1);
        emojiStatus = readTLObject(stream, context, TLAbsEmojiStatus.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += userId.computeSerializedSize();
        size += emojiStatus.computeSerializedSize();
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

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public TLAbsEmojiStatus getEmojiStatus() {
        return emojiStatus;
    }

    public void setEmojiStatus(TLAbsEmojiStatus emojiStatus) {
        this.emojiStatus = emojiStatus;
    }
}
