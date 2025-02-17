package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLTakeout;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountInitTakeoutSession extends TLMethod<TLTakeout> {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected boolean contacts;

    protected boolean messageUsers;

    protected boolean messageChats;

    protected boolean messageMegagroups;

    protected boolean messageChannels;

    protected boolean files;

    protected Long fileMaxSize;

    private final String _constructor = "account.initTakeoutSession#0";

    public TLRequestAccountInitTakeoutSession() {
    }

    public TLRequestAccountInitTakeoutSession(boolean contacts, boolean messageUsers, boolean messageChats, boolean messageMegagroups, boolean messageChannels, boolean files, Long fileMaxSize) {
        this.contacts = contacts;
        this.messageUsers = messageUsers;
        this.messageChats = messageChats;
        this.messageMegagroups = messageMegagroups;
        this.messageChannels = messageChannels;
        this.files = files;
        this.fileMaxSize = fileMaxSize;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLTakeout deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLTakeout)) {
            throw new IOException("Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response.getClass().getCanonicalName());
        }
        return (TLTakeout) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = contacts ? (flags | 1) : (flags & ~1);
        flags = messageUsers ? (flags | 2) : (flags & ~2);
        flags = messageChats ? (flags | 4) : (flags & ~4);
        flags = messageMegagroups ? (flags | 8) : (flags & ~8);
        flags = messageChannels ? (flags | 16) : (flags & ~16);
        flags = files ? (flags | 32) : (flags & ~32);
        flags = fileMaxSize != null ? (flags | 32) : (flags & ~32);

        // Following parameters might be forced to true by another field that updated the flags
        files = (flags & 32) != 0;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 32) != 0) {
            if (fileMaxSize == null) throwNullFieldException("fileMaxSize", flags);
            writeLong(fileMaxSize, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        contacts = (flags & 1) != 0;
        messageUsers = (flags & 2) != 0;
        messageChats = (flags & 4) != 0;
        messageMegagroups = (flags & 8) != 0;
        messageChannels = (flags & 16) != 0;
        files = (flags & 32) != 0;
        fileMaxSize = (flags & 32) != 0 ? readLong(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 32) != 0) {
            if (fileMaxSize == null) throwNullFieldException("fileMaxSize", flags);
            size += SIZE_INT64;
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

    public boolean getContacts() {
        return contacts;
    }

    public void setContacts(boolean contacts) {
        this.contacts = contacts;
    }

    public boolean getMessageUsers() {
        return messageUsers;
    }

    public void setMessageUsers(boolean messageUsers) {
        this.messageUsers = messageUsers;
    }

    public boolean getMessageChats() {
        return messageChats;
    }

    public void setMessageChats(boolean messageChats) {
        this.messageChats = messageChats;
    }

    public boolean getMessageMegagroups() {
        return messageMegagroups;
    }

    public void setMessageMegagroups(boolean messageMegagroups) {
        this.messageMegagroups = messageMegagroups;
    }

    public boolean getMessageChannels() {
        return messageChannels;
    }

    public void setMessageChannels(boolean messageChannels) {
        this.messageChannels = messageChannels;
    }

    public boolean getFiles() {
        return files;
    }

    public void setFiles(boolean files) {
        this.files = files;
    }

    public Long getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(Long fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }
}
