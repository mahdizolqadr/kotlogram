package com.github.badoualy.telegram.tl.api.chatlists;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDialogFilter;
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
public class TLExportedChatlistInvite extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected TLAbsDialogFilter filter;

    protected com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite invite;

    private final String _constructor = "chatlists.exportedChatlistInvite#0";

    public TLExportedChatlistInvite() {
    }

    public TLExportedChatlistInvite(TLAbsDialogFilter filter, com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite invite) {
        this.filter = filter;
        this.invite = invite;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(filter, stream);
        writeTLObject(invite, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        filter = readTLObject(stream, context, TLAbsDialogFilter.class, -1);
        invite = readTLObject(stream, context, com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite.class, com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += filter.computeSerializedSize();
        size += invite.computeSerializedSize();
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

    public TLAbsDialogFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsDialogFilter filter) {
        this.filter = filter;
    }

    public com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite getInvite() {
        return invite;
    }

    public void setInvite(com.github.badoualy.telegram.tl.api.TLExportedChatlistInvite invite) {
        this.invite = invite;
    }
}
