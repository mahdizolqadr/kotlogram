package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;
import static com.github.badoualy.telegram.tl.TLObjectUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLEncryptedChat extends TLAbsEncryptedChat {
    public static final int CONSTRUCTOR_ID = 0x0;

    protected long accessHash;

    protected int date;

    protected long adminId;

    protected long participantId;

    protected TLBytes gAOrB;

    protected long keyFingerprint;

    private final String _constructor = "encryptedChat#0";

    public TLEncryptedChat() {
    }

    public TLEncryptedChat(int id, long accessHash, int date, long adminId, long participantId, TLBytes gAOrB, long keyFingerprint) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.adminId = adminId;
        this.participantId = participantId;
        this.gAOrB = gAOrB;
        this.keyFingerprint = keyFingerprint;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeLong(adminId, stream);
        writeLong(participantId, stream);
        writeTLBytes(gAOrB, stream);
        writeLong(keyFingerprint, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        adminId = readLong(stream);
        participantId = readLong(stream);
        gAOrB = readTLBytes(stream, context);
        keyFingerprint = readLong(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLBytesSerializedSize(gAOrB);
        size += SIZE_INT64;
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

    public TLBytes getGAOrB() {
        return gAOrB;
    }

    public void setGAOrB(TLBytes gAOrB) {
        this.gAOrB = gAOrB;
    }

    public long getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(long keyFingerprint) {
        this.keyFingerprint = keyFingerprint;
    }
}
