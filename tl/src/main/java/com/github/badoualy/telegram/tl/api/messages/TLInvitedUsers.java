package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLMissingInvitee;
import com.github.badoualy.telegram.tl.core.TLObject;
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
public class TLInvitedUsers extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsUpdates updates;

    protected TLVector<TLMissingInvitee> missingInvitees;

    private final String _constructor = "messages.invitedUsers#0";

    public TLInvitedUsers() {
    }

    public TLInvitedUsers(TLAbsUpdates updates, TLVector<TLMissingInvitee> missingInvitees) {
        this.updates = updates;
        this.missingInvitees = missingInvitees;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(updates, stream);
        writeTLVector(missingInvitees, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        updates = readTLObject(stream, context, TLAbsUpdates.class, -1);
        missingInvitees = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += updates.computeSerializedSize();
        size += missingInvitees.computeSerializedSize();
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

    public TLAbsUpdates getUpdates() {
        return updates;
    }

    public void setUpdates(TLAbsUpdates updates) {
        this.updates = updates;
    }

    public TLVector<TLMissingInvitee> getMissingInvitees() {
        return missingInvitees;
    }

    public void setMissingInvitees(TLVector<TLMissingInvitee> missingInvitees) {
        this.missingInvitees = missingInvitees;
    }
}
