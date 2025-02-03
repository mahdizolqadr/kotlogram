package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLEncryptedChatRequested extends TLAbsEncryptedChat {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected int flags;

    protected Integer folderId;

    protected long accessHash;

    protected int date;

    protected long adminId;

    protected long participantId;

    protected TLBytes gA;

    private final String _constructor = "encryptedChatRequested#0";

    public TLEncryptedChatRequested() {
    }

    public TLEncryptedChatRequested(Integer folderId, int id, long accessHash, int date, long adminId, long participantId, TLBytes gA) {
        this.folderId = folderId;
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.adminId = adminId;
        this.participantId = participantId;
        this.gA = gA;
    }

    private void computeFlags() {
        flags = 0;
        flags = folderId != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            writeInt(folderId, stream);
        }
        writeInt(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeLong(adminId, stream);
        writeLong(participantId, stream);
        writeTLBytes(gA, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        folderId = (flags & 1) != 0 ? readInt(stream) : null;
        id = readInt(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        adminId = readLong(stream);
        participantId = readLong(stream);
        gA = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (folderId == null) throwNullFieldException("folderId", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(gA);
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

    public Integer getFolderId() {
        return folderId;
    }

    public void setFolderId(Integer folderId) {
        this.folderId = folderId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(long participantId) {
        this.participantId = participantId;
    }

    public TLBytes getGA() {
        return gA;
    }

    public void setGA(TLBytes gA) {
        this.gA = gA;
    }
}
